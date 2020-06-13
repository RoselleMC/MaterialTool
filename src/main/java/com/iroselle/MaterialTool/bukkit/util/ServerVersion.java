package com.iroselle.MaterialTool.bukkit.util;

import org.bukkit.Bukkit;

import java.util.Arrays;

public enum ServerVersion {
    v1_8_R3,
    v1_9_R2,
    v1_10_R1,
    v1_11_R1,
    v1_12_R1,
    v1_13_R2,
    v1_14_R1,
    v1_15_R1,
    UNKNOWN
    ;

    ServerVersion() {

    }

    private static final String stringVersion = Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];

    public static String getStringVersion() {
        return stringVersion;
    }

    public static int getNumberVersion() {
        return Integer.parseInt(Bukkit.getVersion());
    }

    public static ServerVersion getVersion() {
        return Arrays.stream(ServerVersion.values()).filter(v -> v.name().equals(stringVersion)).findFirst().orElse(ServerVersion.UNKNOWN);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
