/**
 * Created with JackHou
 * Date: 2021/3/2
 * Time: 9:24
 * Description:
 */

package com.qtimes.jetpackdemo.db.dao;

import com.qtimes.jetpackdemo.db.data.Shoe;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface ShoeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertShoe(Shoe shoe);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertShoes(List<Shoe> shoes);

    @Delete
    void deleteShoe(Shoe shoe);

    @Delete
    void deleteShoes(List<Shoe> shoes);

    @Update
    void updateShoe(Shoe shoe);

    @Update
    void updateShoes(List<Shoe> shoes);

    @Query("SELECT * FROM shoe WHERE id=:id")
    Shoe findShoeById(long id);

    @Query("SELECT * FROM SHOE WHERE shoe_brand=:brand")
    List<Shoe> findShoesByBrand(String brand);

    @Query("SELECT * FROM SHOE WHERE shoe_name LIKE :name ORDER BY shoe_brand ASC")
    List<Shoe> findShoesByName(String name);

    @Query("SELECT * FROM SHOE")
    List<Shoe> getAllShoes();
}
