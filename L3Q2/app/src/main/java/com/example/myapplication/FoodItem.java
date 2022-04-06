package com.example.myapplication;

import java.io.Serializable;

public class FoodItem implements Serializable {
     String ItemName;
     int ItemImageId,ItemQuantity;
     float ItemCost;

    public  FoodItem(String mItemName,int mItemImageId,int mItemCost){
        this.ItemName = mItemName;
        this.ItemImageId = mItemImageId;
        this.ItemQuantity = 0;
        this.ItemCost = mItemCost;
    }

    public String getItemName(){
        return ItemName;
    }

    public float getItemCost(){
        return ItemCost;
    }

    public int getItemImage(){
        return ItemImageId;
    }

    public int getItemQuantity(){
        return ItemQuantity;
    }

    void incrementQuantity(){
        this.ItemQuantity++;
    }

    void decrementQuantity(){
        if(this.ItemQuantity>0)
            this.ItemQuantity--;
    }
}
