package com.canteen.canteenbackend.models.pojos;

public class CartItem {
    private String itemName;
    private int quantity;
    private int price;
    private String canteenName;

    public CartItem(String itemName, int quantity, int price, String canteenName) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
        this.canteenName = canteenName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCanteenName() {
        return canteenName;
    }

    public void setCanteenName(String canteenName) {
        this.canteenName = canteenName;
    }
}
