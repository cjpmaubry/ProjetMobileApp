package com.modildev.mytestapplication1;

public class Warehouse {
    private int warehouseID;
    private String name;

    public Warehouse(int warehouseID, String name) {
        this.warehouseID = warehouseID;
        this.name = name;
    }

    public Warehouse(String name) {
        this.name = name;
    }

    public int getWarehouseID() {
        return warehouseID;
    }

    public void setWarehouseID(int warehouseID) {
        this.warehouseID = warehouseID;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String displayAll(){
        String str = warehouseID + " ;" + name;
        return str;
    }
}
