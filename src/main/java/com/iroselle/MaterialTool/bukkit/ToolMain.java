package com.iroselle.MaterialTool.bukkit;

import com.alibaba.fastjson.JSONObject;
import com.iroselle.MaterialTool.bukkit.Config.AbstractConfig;
import com.iroselle.MaterialTool.bukkit.Config.Config;
import com.iroselle.MaterialTool.bukkit.util.MessageUtils;
import com.iroselle.MaterialTool.bukkit.util.ServerVersion;
import org.apache.commons.io.IOUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class ToolMain extends JavaPlugin {

    public static ToolMain instance;

    public static JSONObject jsonObject;
    public static File datafolder;
    public static Config config;

    @Override
    public void onLoad() {
        MessageUtils.console(" ");
        MessageUtils.console(" &2 _ _ _  ________  __   _    ");
        MessageUtils.console(" &2' ) ) )   /  / ')/ ')_//&7    MaterialTool&f V"+getDescription().getVersion()+"&a Loading...");
        MessageUtils.console(" &2 / / / --/  /  //  / /  &7    Server Version:&b "+ ServerVersion.getNumberVersion());
        MessageUtils.console(" &2/ ' (_(_/  (__/(__/ /___    ");
        MessageUtils.console(" ");
        if (ServerVersion.getVersion() == ServerVersion.UNKNOWN) {
            MessageUtils.console("&3[MTool] &eThis running server version &c"+ServerVersion.getNumberVersion() +"&e not supported by us!");
            MessageUtils.console("&3[MTool] &eIf you think it's a false report, please&b https://github.com/RoselleMC/MaterialTool/issues &ereport problems!");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Bukkit.getPluginManager().disablePlugin(this);
            return;
        }
        instance = this;
        datafolder = instance.getDataFolder();

        MessageUtils.loader(() -> {
            try {
                jsonObject = JSONObject.parseObject(IOUtils.toString(instance.getResource("toLegacyID.json"), StandardCharsets.UTF_8));
            } catch (IOException e) {
                e.printStackTrace();
            }
        },"Material Data");
    }

    @Override
    public void onEnable() {
        MessageUtils.loader(() -> {
            config = new Config();
        },"Config");

        MessageUtils.loader(() -> {

        },"Commands","Register");
    }

    @Override
    public void onDisable() {
        MessageUtils.console("&3[MTool] &cPlugins disabling...");
    }



}
