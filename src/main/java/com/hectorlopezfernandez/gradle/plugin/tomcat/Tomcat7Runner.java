package com.hectorlopezfernandez.gradle.plugin.tomcat;

import org.apache.catalina.Context;
import org.apache.catalina.loader.WebappLoader;
import org.apache.catalina.startup.Tomcat;

public class Tomcat7Runner {

	public static void main(String[] args) {
		Parameters params = new Parameters(args);
		
		System.out.println("Starting up the server...");
		Tomcat server = new Tomcat();
		server.enableNaming();
		server.setPort(params.httpPort);
		server.setBaseDir(params.baseDir);
		try {
			Context context = server.addWebapp(params.contextPath, params.explodedWarDir);
			context.setLoader(new WebappLoader());
			//Tomcat.initWebappDefaults(context);
			server.start();
			
			// wait for user to teardown
			System.out.println("Server started. Press any key to shutdown...");
			System.in.read();
			System.out.println("Shutting down the server...");
			
			server.stop();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private static class Parameters {

		public int httpPort = 8080;
		public int httpsPort = 8443;
		public String baseDir;
		public String contextPath = "";
		public String explodedWarDir;

		public Parameters(String[] args) {
			if (args != null) {
				for (String arg : args) {
					System.out.println(arg);
				}
			}
		}

	}

}