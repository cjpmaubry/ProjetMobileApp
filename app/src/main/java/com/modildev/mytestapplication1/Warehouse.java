package com.modildev.mytestapplication1;

public class Warehouse {
    private int warehouseID;
    private String adress;
    private String name;

    public Warehouse(int warehouseID, String adress, String name) {
        this.warehouseID = warehouseID;
        this.adress = adress;
        this.name = name;
    }

    public int getWarehouseID() {
        return warehouseID;
    }

    public void setWarehouseID(int warehouseID) {
        this.warehouseID = warehouseID;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
