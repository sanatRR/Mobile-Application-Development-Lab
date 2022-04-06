package com.example.myapplication;

import java.io.Serializable;

public class FoodItem implements Serializable {
     String ItemName;
     int ItemImageId;
     boolean ItemSelected;
     float ItemCost;
     static boolean isConfirmed;

    public  FoodItem(String mItemName,int mItemImageId,int mItemCost){
        this.ItemName = mItemName;
        this.ItemImageId = mItemImageId;
        this.ItemSelected = false;
        this.ItemCost = mItemCost;
    }

    static {
        isConfirmed = false;
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

    public boolean isItemSelected(){
        return this.ItemSelected;
    }

    public void selectItem(){
        this.ItemSelected = true;
    }

    public void unSelectItem(){
        this.ItemSelected = false;
    }
}
