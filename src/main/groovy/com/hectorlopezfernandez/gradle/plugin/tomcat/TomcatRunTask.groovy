package com.hectorlopezfernandez.gradle.plugin.tomcat;

import org.gradle.api.plugins.WarPlugin
import org.gradle.api.tasks.JavaExec;

class TomcatRunTask extends JavaExec {

	String explodedWarDir;
	String contextPath;
	int httpPort = 8080;
	int httpsPort = 8443;

	TomcatRunTask() {
		group = TomcatRunnerPlugin.TOMCAT_RUNNER_GROUP
		outputs.upToDateWhen { false }
	}

	@Override
	void exec() {
		System.out.println("exec()");
		super.exec();
	}

}