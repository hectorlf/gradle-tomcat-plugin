package com.hectorlopezfernandez.gradle.plugin.tomcat;

public class TomcatRunnerPluginExtension {

	private String tomcatVersion;
	private String explodedWarDir;

	public String getTomcatVersion() {
		return tomcatVersion;
	}
	public void setTomcatVersion(String tomcatVersion) {
		this.tomcatVersion = tomcatVersion;
	}
	public String getExplodedWarDir() {
		return explodedWarDir;
	}
	public void setExplodedWarDir(String explodedWarDir) {
		this.explodedWarDir = explodedWarDir;
	}

}