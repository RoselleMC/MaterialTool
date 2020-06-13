package com.iroselle.MaterialTool.bukkit.Config;

import com.iroselle.MaterialTool.bukkit.ToolMain;
import org.bukkit.configuration.file.FileConfiguration;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Config extends AbstractConfig {

    public String OPTIONS_UNKNOWNS_MATERIAL;

    public Config() {
        super("config", new File(ToolMain.instance.getDataFolder(),"config.yml"));
    }

    @Override
    public void onReload() {
        this.OPTIONS_UNKNOWNS_MATERIAL = getCfg().getString("Options.Unknowns-Material");
    }
}
