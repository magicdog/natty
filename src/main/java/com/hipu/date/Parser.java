package com.hipu.date;

import com.hipu.date.generated.DateLexer;
import com.hipu.date.generated.DateParser;
import com.hipu.date.generated.DateWalker;
import com.hipu.date.generated.TreeRewrite;
import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.antlr.runtime.tree.Tree;
import org.joda.time.DateTime;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 */
public class Parser {
	
//	private TimeZone _defaultTimeZone;
	
	// shelton: add Construct function with Date parameter
	
	private DateTime _defaultDate = null;

	private static final Logger _logger = Logger
			.getLogger("com.hipu.date");

	/**
	 * Creates a new parser using the g iven time zone as the default
	 * 
	 * @param defaultTimeZone
	 */
//	public Parser(TimeZone defaultTimeZone) {
//		_defaultTimeZone = defaultTimeZone;
//	}

	/**
	 * Creates a new parser with no explicit default time zone (default will be
	 * US/Eastern)
	 */
	public Parser() {
	}
	
	public Parser(DateTime date) {
		_defaultDate = date;
	}
	
	public void setDate(DateTime date) {
		_defaultDate = date;
	}
	
	public List<DateGroup> parse(String value) {
		return parse(value, null);
	}

	/**
	 * Parses the given input value for one or more groups of date alternatives
	 * 
	 * @param value
	 * @return
	 */
	public List<DateGroup> parse(String value, DateTime date) {
		// lex the input value to obtain our global token stream
		if (value == null)
			return null;
		ANTLRInputStream input = null;
		try {
			input = new ANTLRNoCaseInputStream(new ByteArrayInputStream(value
					.trim().getBytes()));
		} catch (IOException e) {
			_logger.log(Level.SEVERE, "could not lex input", e);
		}
		DateLexer lexer = new DateLexer(input);

		// collect all sub-token streams that may include date information
		// 一个tokensteam一条日期记录。
		List<TokenStream> streams = collectTokenStreams(new CommonTokenStream(
				lexer));
		// and parse each of them
		List<DateGroup> groups = new ArrayList<DateGroup>();
		
		for (TokenStream stream : streams) {
			List<Token> tokens = ((HipuTokenSource) stream.getTokenSource()).getTokens();
			
			StringBuilder tokenString = new StringBuilder();
			for (Token token : ((HipuTokenSource) stream.getTokenSource()).getTokens()) {
				tokenString.append(DateParser.tokenNames[token.getType()]);
				tokenString.append(" ");
			}
//			System.out.println("valid date stream: " + tokenString.toString());
			DateGroup group = singleParse(stream, date);
//			System.out.println(group.getDates().get(0));
			
			while ((group == null || group.getDates().size() == 0)
					&& tokens != null && tokens.size() > 0) {
				if (tokensType(tokens) == 3) {
					//all the tokens are number, we set token = null
					break;
				}
				if (group == null || group.getDates().size() == 0) {
					// if we're down to only two tokens in our token stream, we
					// can't continue
					if (tokens.size() <= 3) {
						tokens.clear();
					}
					// otherwise, we have two options:
					else {

						// 1. Continuously remove tokens from the end of the
						// stream and re-parse. This will
						// recover from the case of an extaneous token at the
						// end of the token stream.
						// For example: 'june 20th on'
					
						
						List<Token> endRemovedTokens = new ArrayList<Token>(tokens);
						while ((group == null || group.getDates().isEmpty()) && endRemovedTokens.size() > 4) {
							//delete the continuous number 
							if (DateParser.tokenNames[endRemovedTokens.get(endRemovedTokens.size()-1).getType()].contains("INT"))
								while (	endRemovedTokens.size() >= 1 && 
										DateParser.tokenNames[endRemovedTokens.get(endRemovedTokens.size()-1).getType()].contains("INT")) {
									endRemovedTokens.remove(endRemovedTokens.size()-1);
								} 
							else
								endRemovedTokens = endRemovedTokens.subList(0, endRemovedTokens.size() - 1);
							if (endRemovedTokens.size()<3 || endRemovedTokens.get(endRemovedTokens.size()-1).getType() == DateParser.COLON) 
								break;
							cleanupGroup(endRemovedTokens);
//							tokenString = new StringBuilder();
//							for (Token token : endRemovedTokens) {
//								tokenString.append(DateParser.tokenNames[token.getType()]);
//								tokenString.append(" ");
//							}
//							System.out.println("end "+tokenString.toString());
//							
							TokenStream newStream = new CommonTokenStream(new HipuTokenSource(endRemovedTokens));
							group = singleParse(newStream, date);
							if (tokensType(endRemovedTokens) == 2) {
								//all the tokens are number, we set token = null
								tokens = null;
								break;
							}
						}

						// 2. Continuously look for another possible starting
						// point in the token
						// stream and re-parse.
						
						if ((group == null || group.getDates().isEmpty()) && tokens != null && tokens.size() > 0) {
							boolean isNumber= DateParser.tokenNames[tokens.get(0).getType()].contains("INT");
							tokens = tokens.subList(1, tokens.size());
							Iterator<Token> iter = tokens.iterator();
//							int state = 0;
//							if (tokensType(tokens) == 1) {
//								//if tokens has slash, we slpit the token by slash
//								while (iter.hasNext()) {
//									Token token = iter.next();
//									if (token.getType() != DateParser.SLASH) {
//										//example:12212/2323/2323
//										if (state == 0)
//											//means first non-slash token
//											iter.remove();
//										if (state == 1) {
//											//the first non-slash token following slash
//											state = 0;
//											if (DateParser.FOLLOW_empty_in_parse186.member(token.getType())) {
//												break;
//											}
//										}
//									} else {
//										state = 1;
//										iter.remove();
//									}
//								}
//							} else {
							
								while (iter.hasNext()) {
									// procee 525-3050-2-12
									Token token = iter.next();
									if (DateParser.tokenNames[tokens.get(0).getType()].contains("INT") && isNumber) {
										iter.remove();
										continue;
									}
									isNumber = DateParser.tokenNames[tokens.get(0).getType()].contains("INT");
									if (!DateParser.FOLLOW_empty_in_parse186
											.member(token.getType())) {
										iter.remove();
									} else
										break;
								}
//							}
							cleanupGroup(tokens);
							
//							tokenString = new StringBuilder();
//							for (Token token : tokens) {
//								tokenString.append(DateParser.tokenNames[token.getType()]);
//								tokenString.append(" ");
//							}
//							System.out.println("new "+tokenString.toString());
							
							TokenStream newStream = new CommonTokenStream(
									new HipuTokenSource(tokens));
							group = singleParse(newStream, date);
						}
					}
				}
			}
			// if a group with some date(s) was found, we add it
			if (group != null && group.getDates().size() > 0) {
				groups.add(group);
//				System.out.println("valid date stream: " + tokenString.toString());
//				System.out.println(group.getDates().get(0));
				
			}

		}
		return groups;
	}
	
	//return 2 : all the token is number
	//return 3 : contain continuous dash,12-23-5-8
	//return 0 : normal;
	public int tokensType(List<Token> list) {
		if ( list == null )
			return 0;
		int numberCount = 0;
		int dashCount = 0;
		for (Token token : list) {
			if (DateParser.tokenNames[token.getType()].contains("INT") || token.getType() == DateParser.COMMA) {
				numberCount++;
			}
			if (token.getType() == DateParser.DASH) {
				dashCount++;
			}
		}
		if (dashCount >= 3) {
			return 3;
		}
		if (numberCount == list.size())
			return 2;
		return 0;
	}
	
	/**
	 * Parses the token stream for a SINGLE date time alternative. This method
	 * assumes that the entire token stream represents date and or time
	 * information (no extraneous tokens)
	 * 
	 * @param stream
	 * @return
	 */
	private DateGroup singleParse(TokenStream stream, DateTime dateTime) {

		StringBuilder tokenString = new StringBuilder();
		for (Token token : ((HipuTokenSource) stream.getTokenSource())
				.getTokens()) {
			tokenString.append(DateParser.tokenNames[token.getType()]);
			tokenString.append(" ");
		}
		_logger.fine("sub-token stream: " + tokenString.toString());
//		System.out.println(tokenString.toString());
		DateGroup group = null;
		try {
			// parse
			ParseListener listener = new ParseListener();
			DateParser parser = new DateParser(stream, listener);
			DateParser.parse_return parseReturn = parser.parse();

			Tree tree = (Tree) parseReturn.getTree();

			if (tree == null)
				return group;
			_logger.fine("AST: " + tree.toStringTree());
			

			// we only continue if a meaningful syntax tree has been built
			if (tree.getChildCount() > 0) {

				// rewrite the tree (temporary fix for
				// http://www.antlr.org/jira/browse/ANTLR-427)
				CommonTreeNodeStream nodes = new CommonTreeNodeStream(tree);
				TreeRewrite s = new TreeRewrite(nodes);
				tree = (CommonTree) s.downup(tree);
//				System.out.println(tree.toStringTree());

//				Map<String, List<ParseLocation> > locations = listener.getLocations();
//				for (String str : locations.keySet()) {
//					for (ParseLocation location : locations.get(str)) {
//						System.out.print(location.getRuleName()+" ");
//					}
//					System.out.println();
//				}

				// and walk it
				nodes = new CommonTreeNodeStream(tree);
				nodes.setTokenStream(stream);
				DateWalker walker = new DateWalker(nodes);
//				walker.getState().setDefaultTimeZone(_defaultTimeZone);
			    walker.getState().setDefaultDate(dateTime == null ? _defaultDate : dateTime );
				walker.parse();

				// run through the results and append the parse information
				group = walker.getState().getDateGroup();
//			    group = new DateGroup();
//			    group.addDate(new Date());
				ParseLocation location = listener.getDateGroupLocation();
				if (location != null) {
					group.setLine(location.getLine());
					group.setText(location.getText());
					group.setPosition(location.getStart());
					group.setSyntaxTree(tree);
					group.setParseLocations(listener.getLocations());
				}
			}

		} catch (Exception e) {
			_logger.log(Level.SEVERE, "Could not parse input", e);
		}

		return group;
	}

	/**
	 * Scans the given token global token stream for a list of sub-token streams
	 * representing those portions of the global stream that may contain date
	 * time information
	 * 
	 * @param stream
	 * @return
	 */
	
	private List<TokenStream> collectTokenStreams(TokenStream stream) {

		// walk through the token stream and build a collection
		// of sub token streams that represent possible date locations
		List<Token> currentGroup = null;
		List<TokenStream> groups = new ArrayList<TokenStream>();
		Token currentToken;
		StringBuilder tokenString = new StringBuilder();
		//record the wrod and unkonwn char
		int wordTokenCount = 0;

		while ((currentToken = stream.getTokenSource().nextToken()).getType() != DateLexer.EOF) {
			if (_logger.getLevel() != null
					&& _logger.getLevel().intValue() <= Level.FINE.intValue()) {
				tokenString.append(DateParser.tokenNames[currentToken.getType()]);
				tokenString.append(" ");
			}
//			System.out.print(DateParser.tokenNames[currentToken.getType()]+" ");
			
			// we're currently NOT collecting for a possible date group
			if (currentGroup == null) {
				// ignore white space in-between possible rules
				if (currentToken.getType() != DateLexer.WHITE_SPACE
						&& currentToken.getType() != DateLexer.WORD) {
					// if the token is a possible date start token, we start a
					// new collection
					if (DateParser.FOLLOW_empty_in_parse186.member(currentToken
							.getType())) {
						currentGroup = new ArrayList<Token>();
						currentGroup.add(currentToken);
					}
				}
			}
			// we're currently collecting
			else {
				// shelton : we use the following rules to split and combine the stram. 
				// 1.we ignored '(',')' and the day of week. The day of week can not give us explicit date.
				// 2.we will combine the stream if the account of unkonwn and word tokens between them less than 4.
				// such as : 1989-9-3 updated at 12:0, we will combine the stream to 1989-9-3 12:0.
				switch (currentToken.getType()) {
				case DateLexer.UNKNOWN: {
					if (currentGroup.size() > 0) {
						cleanupGroup(currentGroup);
						groups.add(new CommonTokenStream(new HipuTokenSource(
								currentGroup)));
						wordTokenCount = 0;
						currentGroup = null;
					}
					break;
				}
				case DateLexer.WORD: 
				// 
				{
					cleanupGroup(currentGroup);
					if (wordTokenCount > 4 && currentGroup.size() > 0) {
						cleanupGroup(currentGroup);
						groups.add(new CommonTokenStream(new HipuTokenSource(
								currentGroup)));
						wordTokenCount = 0;
						currentGroup = null;
					}
					break;
				}
				case DateLexer.LEFT_PARENTHESIS:
				case DateLexer.MONDAY:
				case DateLexer.THURSDAY:
				case DateLexer.WEDNESDAY:
				case DateLexer.TUESDAY:
				case DateLexer.FRIDAY:
				case DateLexer.SATURDAY:
				case DateLexer.SUNDAY:
				case DateLexer.RIGHT_PARENTHESIS: {
					break;
				}
				default:
					currentGroup.add(currentToken);
					break;
				}
			}

			// record the unknown and word count
			if (currentToken.getType() == DateLexer.UNKNOWN
					|| currentToken.getType() == DateLexer.WORD)
				wordTokenCount = wordTokenCount > 5 ? 5 : (wordTokenCount + 1);
		}
//		System.out.println();
		if (currentGroup != null) {
			cleanupGroup(currentGroup);
			groups.add(new CommonTokenStream(new HipuTokenSource(
					currentGroup)));
		}

		_logger.fine("global token stream: " + tokenString.toString());
		
		return groups;
	}
	
	public void optimizeToken() {
		
	}
	
	/**
	 * Removes unwanted tokens from the given token group
	 * 
	 * @param group
	 */
	private void cleanupGroup(List<Token> group) {

		// remove contiguous white space
		Iterator<Token> iter = group.iterator();
		Token previousToken = null;
		while (iter.hasNext()) {
			Token token = iter.next();
			if (previousToken != null
					&& previousToken.getType() == DateParser.WHITE_SPACE) {
				if (token.getType() == DateParser.WHITE_SPACE) {
					iter.remove();
				}
			}
			previousToken = token;
		}

		// remove leading white space
		if (group.size() > 0) {
			Token firstToken = group.get(0);
			if (firstToken.getType() == DateParser.WHITE_SPACE) {
				group.remove(firstToken);
			}
		}

		// and trailing white space
		if (group.size() > 0) {
			Token lastToken = group.get(group.size() - 1);
			if (lastToken.getType() == DateParser.WHITE_SPACE) {
				group.remove(lastToken);
			}
			lastToken = group.get(group.size() - 1);
			if (lastToken.getType() == DateParser.AT) {
				group.remove(lastToken);
			}
		}
	}

	public static void main(String args[]) {
		Parser parser = new Parser();
		// List<DateGroup> dateGroup=
		// parser.parse("2009-03-10 9:00 to 11:00 | we can do a lot");
		List<DateGroup> dateGroup = parser.parse("2009-03-10",null);
		for (DateGroup dg : dateGroup) {
			Map<String, List<ParseLocation>> ml = dg.getParseLocations();
			for (String str : ml.keySet()) {
				List<ParseLocation> lp = ml.get(str);
				for (ParseLocation location : lp) {
					System.out.println(location.getText() + "\t"
							+ location.getRuleName());
				}
			}
		}
	}
}
