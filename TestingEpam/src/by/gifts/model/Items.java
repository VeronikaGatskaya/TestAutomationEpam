package by.gifts.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Items {
    private int giftId;
    private double itemWeight;
    private String itemName;

    public Items() {
    }

    public Items(int giftId, double itemWeight, String itemName) {
        this.giftId = giftId;
        this.itemWeight = itemWeight;
        this.itemName = itemName;
    }

    public Items(double itemWeight, String itemName) {
        this.itemWeight = itemWeight;
        this.itemName = itemName;
    }

    @Id
    @Column(name = "GiftID")
    public int getGiftId() {
        return giftId;
    }

    public void setGiftId(int giftId) {
        this.giftId = giftId;
    }

    @Basic
    @Column(name = "ItemWeight")
    public double getItemWeight() {
        return itemWeight;
    }

    public void setItemWeight(double itemWeight) {
        this.itemWeight = itemWeight;
    }

    @Basic
    @Column(name = "ItemName")
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}
