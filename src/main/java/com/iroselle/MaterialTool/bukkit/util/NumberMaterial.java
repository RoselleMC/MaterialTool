package com.iroselle.MaterialTool.bukkit.util;

public class NumberMaterial {

    private final int id;
    private final int data;

    public NumberMaterial(int id, int data) {
        this.id = id;
        this.data = data;
    }

    public NumberMaterial(int id) {
        this.id = id;
        this.data = 0;
    }

    public NumberMaterial(NumberMaterial nm) {
        this.id = nm.getId();
        this.data = nm.getData();
    }

    public int getId() {
        return id;
    }

    public int getData() {
        return data;
    }
}
