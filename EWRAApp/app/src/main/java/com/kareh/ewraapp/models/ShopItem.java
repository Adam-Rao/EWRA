package com.kareh.ewraapp.models;

public class ShopItem {
    private int imageResouce;
    private String cardText;
    public ShopItem(){

    }

    public ShopItem(int imageResouce, String cardText) {
        this.imageResouce = imageResouce;
        this.cardText = cardText;
    }

    public int getImageResouce() {
        return imageResouce;
    }

    public void setImageResouce(int imageResouce) {
        this.imageResouce = imageResouce;
    }

    public String getCardText() {
        return cardText;
    }

    public void setCardText(String cardText) {
        this.cardText = cardText;
    }
}
