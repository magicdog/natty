package com.joestelmach.natty.service;

import java.net.URL;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.mortbay.jetty.Connector;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.handler.ResourceHandler;
import org.mortbay.jetty.nio.SelectChannelConnector;
import org.mortbay.jetty.servlet.Context;
import org.mortbay.jetty.servlet.ServletHolder;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;

/**
 * @author weijian
 * Date : 2012-11-26 15:48
 */
public class DateParserService implements Runnable{
    private static final Logger LOG = Logger.getLogger(DateParserService.class);

    @Parameter(description="Help", names={"--help","-help"})
    private boolean help = false;
    
    @Parameter(description="Service Host", names="-h")
    private String host  = "localhost";

    @Parameter(description="Port Number", names="-p")
    private int port = 8082;

    /**
     * @Fields:mainThread:main process
     */
    

    public DateParserService(Configuration config){
    }

    public void run() {
    	Server server = new Server();
    	Connector conn = new SelectChannelConnector();
        conn.setHost(host);
        conn.setPort(port);
        server.setConnectors(new Connector[] { conn });
        
        Context root = new Context(server, "/service", Context.SESSIONS);
        
        root.addServlet(new ServletHolder(new DateParserServlet()), "/parse");
        

        Context pages = new Context(server, "/", Context.SESSIONS);
        ResourceHandler handler = new ResourceHandler();
//        System.out.println(org.mortbay.resource.JarResource.newClassPathResource("/resource").getURL());
        handler.setBaseResource(org.mortbay.resource.JarResource.newClassPathResource("/resource"));
        handler.setCacheControl("max-age=5");
        pages.setHandler(handler);

        
        try {
            server.start();
            server.join();
        } catch (Exception e) {
            LOG.fatal("", e);
        }

    }
    
    public void stop() {
    }

    /**
     * @param args
     */
    public static void main(String[] args) throws ConfigurationException {

        URL url = DateParserService.class.getResource("/log4j.properties");
        if ( url == null ) {
            url =  DateParserService.class.getResource("/conf/log4j.properties");
        }
        PropertyConfigurator.configure(url);
        
        Configuration config = new PropertiesConfiguration();

        DateParserService service = new DateParserService(config);
        JCommander commander = new JCommander(service);
        try {
            commander.parse(args);
        } catch (ParameterException e) {
            LOG.error(e.getMessage());
            commander.usage();
        }
        if ( service.help ){
            commander.usage();
        }else{
            service.run();
        }
    }
}