package com.hectorlopezfernandez.gradle.plugin.tomcat;

import org.apache.catalina.Context;
import org.apache.catalina.loader.WebappLoader;
import org.apache.catalina.startup.Tomcat;

public class Tomcat7Runner {

	public static void main(String[] args) {
		Tomcat server = new Tomcat();
		server.enableNaming();
		server.setBaseDir("d:/tomcat-temp");
		try {
			Context context = server.addWebapp("/test", "d:/tomcat-webapp");
			context.setLoader(new WebappLoader());
			//server.initWebappDefaults("/test");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		try {
			server.init();
			server.start();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		try {
			Thread.sleep(20000);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		try {
			server.stop();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}