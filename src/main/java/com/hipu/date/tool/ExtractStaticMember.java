package com.hipu.date.tool;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ExtractStaticMember {
	// shelton : extract static member from DateParser.java to resolve the follow limits:
	// static member initializer over the  65536 limits.
	public static void extract() {
		String base = System.clearProperty("user.dir")+"/src/main/java/com/hipu/date/";
		try {
			String destFile = base+"generated/IStaticMember.java";
			String oriFile = base+"generated/DateParser.java";
			File temp = File.createTempFile("parser", "p");
			File file = new File(destFile);System.out.println(file.getAbsolutePath());
			if (!file.exists())
				file.createNewFile();
			
			System.out.println(destFile);
			BufferedWriter writer = new BufferedWriter(new FileWriter(destFile));
			BufferedWriter writer2 = new BufferedWriter(new FileWriter(temp.getAbsolutePath()));
			BufferedReader reader = new BufferedReader(new FileReader(oriFile));
			writer.write("package com.hipu.date.generated;\n\npublic interface IStaticMember {\n");
			String line;
			while ( (line=reader.readLine()) != null) {
				if (line.contains("public class DateParser extends DebugParser")){
					line = line.substring(0, line.lastIndexOf("{")) + "implements IStaticMember {";
					writer2.write(line+'\n');
					continue;
				}
				if (line.contains("_transitionS = {")) {
					writer.write(line+'\n');
					while ( (line=reader.readLine()) != null ) {
						if (!line.contains("}"))
							writer.write(line+'\n');
						else{
							writer.write("};\n");
							break;
						}
					}
				}
				else {
					writer2.write(line+'\n');
				}
			}
			writer.write("\n}");
			reader.close();
			writer.close();
			writer2.close();
			new File(oriFile).delete();
			temp.renameTo(new File(oriFile));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main (String args[]) {
		ExtractStaticMember.extract();
	}
}
