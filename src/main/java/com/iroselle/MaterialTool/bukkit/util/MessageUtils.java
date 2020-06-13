package com.iroselle.MaterialTool.bukkit.util;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;

public class MessageUtils {

    public static void console(String string) {
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&',string));
    }

    public static void sendMessage(CommandSender sender, String string) {
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&',string));
    }

    public static void loader(Runnable runnable, String name) {
        loader(Bukkit.getConsoleSender(),runnable,name,"Loading");
    }

    public static void loader(Runnable runnable, String name, String type) {
        loader(Bukkit.getConsoleSender(),runnable,name,type);
    }

    public static void loader(CommandSender sender, Runnable runnable, String name, String type) {
        long l = System.currentTimeMillis();
        runnable.run();
        MessageUtils.console("&3[MTool] &7"+type+" "+name+" &2successful&7, Time: "+ msReplace(System.currentTimeMillis() - l));
    }

    private static String msReplace(long l) {
        int ms = Math.round(l * 1000);
        if (ms < 100) {
            return "&2"+ms+"ms";
        } else if (ms < 300) {
            return "&6"+ms+"ms";
        } else {
            return "&4"+ms+"ms";
        }
    }

}
