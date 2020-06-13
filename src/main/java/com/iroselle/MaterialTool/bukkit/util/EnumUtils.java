package com.iroselle.MaterialTool.bukkit.util;

public class EnumUtils {

    public static <E extends Enum<E>> boolean isValidEnum(final Class<E> e, final String value) {
        if (value == null) {
            return false;
        } else {
            try {
                Enum.valueOf(e, value);
                return true;
            } catch (IllegalArgumentException x) {
                return false;
            }
        }
    }
}