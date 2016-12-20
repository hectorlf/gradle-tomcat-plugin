package com.hectorlopezfernandez.gradle.plugin.tomcat;

import java.util.HashMap;
import java.util.Map;

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
			
			// tomcat stop
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
			assert args != null;
			Map<String,String> params = new HashMap<>(args.length * 2);
			for (int i = 0; i < args.length; i++) {
				// arguments come in pairs, strip the first "--"
				String arg = args[i].substring(2);
				// next element should be the value, but check to be sure
				String value = "";
				if (i < args.length && !args[i+1].startsWith("--")) {
					i++;
					value = args[i];
				}
				// store pair
				params.put(arg, value);
				//System.out.println(arg + ":" + value);
			}
			contextPath = params.containsKey("contextPath") ? params.get("contextPath") : contextPath;
			explodedWarDir = params.containsKey("explodedWarDir") ? params.get("explodedWarDir") : explodedWarDir;
			httpPort = params.containsKey("httpPort") ? Integer.parseInt(params.get("httpPort")) : httpPort;
			httpsPort = params.containsKey("httpsPort") ? Integer.parseInt(params.get("httpsPort")) : httpsPort;
		}

	}

}