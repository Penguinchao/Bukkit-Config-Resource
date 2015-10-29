package com.penguinchao.configtest;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class ConfigFile {
	//Replace all references to "ConfigTest" with the name of your main class.
	private ConfigTest main;
	private String fileName;
	private File file;
	private FileConfiguration config;
	public ConfigFile(String filePath, ConfigTest passedMain){
		main = passedMain;
		fileName = filePath;
		file = new File(main.getDataFolder(), fileName);
		try{
			main.saveResource(fileName, false);
		}catch (Exception e){
			e.printStackTrace();
		}
		config = new YamlConfiguration();
		loadYamls();
	}
	public void finalize(){
		saveYamls();
	}
	public FileConfiguration getConfig(){
		return config;
	}
	private void loadYamls(){
		try{
			config.load(file);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	private void saveYamls(){
		try{
			config.save(file);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}