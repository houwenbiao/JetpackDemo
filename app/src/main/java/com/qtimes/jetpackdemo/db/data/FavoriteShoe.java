/**
 * Created with JackHou
 * Date: 2021/3/2
 * Time: 8:58
 * Description:
 */

package com.qtimes.jetpackdemo.db.data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "fav_shoe",
        foreignKeys = {
                @ForeignKey(entity = User.class, parentColumns = "id", childColumns = "user_id"),
                @ForeignKey(entity = Shoe.class, parentColumns = "id", childColumns = "shoe_id")},
        indices = {@Index("shoe_id"), @Index("user_id")})
public class FavoriteShoe {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private Long id;

    @ColumnInfo(name = "shoe_id")
    private Long shoeId;//鞋子id

    @ColumnInfo(name = "user_id")
    private Long userId;//用户id

    @ColumnInfo(name = "fav_data")
    private String data;//创建日期

    public FavoriteShoe(Long shoeId, Long userId, String data) {
        this.shoeId = shoeId;
        this.userId = userId;
        this.data = data;
    }

    public Long getShoeId() {
        return shoeId;
    }

    public void setShoeId(Long shoeId) {
        this.shoeId = shoeId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
