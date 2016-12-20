package com.hectorlopezfernandez.gradle.plugin.tomcat;

import org.gradle.api.plugins.WarPlugin
import org.gradle.api.tasks.JavaExec;

class TomcatRunTask extends JavaExec {

	String explodedWarDir
	String contextPath
	int httpPort = 8080
	int httpsPort = 8443

	TomcatRunTask() {
		group = TomcatRunnerPlugin.TOMCAT_RUNNER_GROUP
		outputs.upToDateWhen { false }
	}

	@Override
	void exec() {
		// set Tomcat7Runner as the main application
		main = 'com.hectorlopezfernandez.gradle.plugin.tomcat.Tomcat7Runner'
		// set arguments
		args '--explodedWarDir'; args explodedWarDir
		args '--contextPath'; args contextPath
		args '--httpPort'; args httpPort
		args '--httpsPort'; args httpsPort
		// execute
		System.out.println("exec()")
		super.exec()
	}

}