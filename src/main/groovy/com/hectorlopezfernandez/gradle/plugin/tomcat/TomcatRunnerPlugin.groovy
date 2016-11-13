package com.hectorlopezfernandez.gradle.plugin.tomcat;

import org.gradle.api.Plugin
import org.gradle.api.Project

class TomcatRunnerPlugin implements Plugin<Project> {

	static final String TOMCAT_RUNNER_GROUP = "Tomcat runner"

	@Override
	void apply(Project project) {
		// configuration for tomcat server libs
		project.configurations.create("tomcatRunner").setDescription("Tomcat server dependencies")
		// tomcatRun task conventions
		project.tasks.withType(TomcatRunTask.class).all { TomcatRunTask task ->
			task.conventionMapping.map("contextPath") { project.archivesBaseName }
		}
		// tomcatRun task definition
		project.tasks.create("tomcatRun", TomcatRunTask.class).setDescription("Starts the embedded tomcat with the specified configuration")
	}

}