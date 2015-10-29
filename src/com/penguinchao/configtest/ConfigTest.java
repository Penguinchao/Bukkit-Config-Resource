package com.penguinchao.configtest;

import org.bukkit.plugin.java.JavaPlugin;

public class ConfigTest extends JavaPlugin {
	public ConfigFile somethingImportant;
	public ConfigFile somethingVeryDumb;
	
	@Override
	public void onEnable(){
		//Create Objects
		//First argument is the name of your yaml (including parent folders inside plugin directory)
		//Second argument is the reference to your main class. When creating from the main class (recommended), just use "this."
		somethingImportant = new ConfigFile("important.yml", this);
		somethingVeryDumb = new ConfigFile("dumb.yml", this);
		//Pull messages from Objects
		getLogger().info(getConfig().getString("message"));
		getLogger().info(somethingImportant.getConfig().getString("message"));
		getLogger().info(somethingVeryDumb.getConfig().getString("message"));
	}
}