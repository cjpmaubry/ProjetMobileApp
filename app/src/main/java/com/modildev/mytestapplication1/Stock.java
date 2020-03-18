package com.modildev.mytestapplication1;

public class Stock {
    private int id;
    private String type;
    private int warehouseID;
    private double quantity;

    public Stock(int id, String type, int warehouseID, int quantity) {
        super();
        this.id = id;
        this.type = type;
        this.warehouseID = warehouseID;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getWarehouseID() {
        return warehouseID;
    }

    public void setWarehouseID(int warehouseID) {
        this.warehouseID = warehouseID;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
}