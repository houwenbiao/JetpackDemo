/**
 * Created with JackHou
 * Date: 2021/3/2
 * Time: 9:51
 * Description:
 */

package com.qtimes.jetpackdemo.db.dao;

import com.qtimes.jetpackdemo.db.bean.FavoriteShoe;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface FavoriteShoeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertFavShoe(FavoriteShoe favoriteShoe);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertFavShoes(List<FavoriteShoe> favoriteShoes);

    @Update
    void updateFavShoe(FavoriteShoe favoriteShoe);

    @Delete
    void deleteFavShoe(FavoriteShoe favoriteShoe);

    @Query("SELECT * FROM FAV_SHOE WHERE user_id =:userId")
    List<FavoriteShoe> findFavShoeByUserId(long userId);
}
