package com.iroselle.MaterialTool.bukkit.Config;

import com.iroselle.MaterialTool.bukkit.util.YamlLoader;
import org.bukkit.configuration.file.FileConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractConfig {

    public static Map<String, FileConfiguration> cfgs = new HashMap<>();

    private final File file;
    private final String name;
    private FileConfiguration cfg;

    public AbstractConfig(String name, File file) {
        this.name = name;
        this.file = file;
        this.reload();
        this.onReload();
    }

    public void remove() {
        cfgs.remove(this.name);
    }

    public String getName() {
        return name;
    }

    public FileConfiguration getCfg() {
        return cfg;
    }

    public File getFile() {
        return file;
    }

    public void reload() {
        this.cfg = YamlLoader.loadConfiguration(this.file);
    }

    public void save() {
        try {
            this.cfg.save(this.file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    abstract public void onReload();

    public static void removeCfg(String name) {
        cfgs.remove(name);
    }
}
