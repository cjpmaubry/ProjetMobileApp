package com.modildev.mytestapplication1;

public class Warehouse {
    private int warehouseID;
    private String address;
    private String name;

    public Warehouse(int warehouseID, String address, String name) {
        this.warehouseID = warehouseID;
        this.address = address;
        this.name = name;
    }

    public Warehouse(String address, String name) {
        this.address = address;
        this.name = name;
    }

    public int getWarehouseID() {
        return warehouseID;
    }

    public void setWarehouseID(int warehouseID) {
        this.warehouseID = warehouseID;
    }

    public String getaddress() {
        return address;
    }

    public void setaddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String displayAll(){
        String str = warehouseID + "; " + address + " ;" + name;
        return str;
    }
}
