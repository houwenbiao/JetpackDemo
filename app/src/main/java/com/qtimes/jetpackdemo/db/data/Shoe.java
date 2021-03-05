/**
 * Created with JackHou
 * Date: 2021/3/1
 * Time: 14:59
 * Description:
 */

package com.qtimes.jetpackdemo.db.data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "shoe")
public class Shoe {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private Long id;

    @ColumnInfo(name = "shoe_name")
    private String name;

    @ColumnInfo(name = "shoe_desc")
    private String desc;//描述

    @ColumnInfo(name = "shoe_price")
    private float price;//价格

    @ColumnInfo(name = "shoe_brand")
    private String brand;//品牌

    @ColumnInfo(name = "shoe_imgUrl")
    private String imgUrl;

    public Shoe(String name, String desc, float price, String brand, String imgUrl) {
        this.name = name;
        this.desc = desc;
        this.price = price;
        this.brand = brand;
        this.imgUrl = imgUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

