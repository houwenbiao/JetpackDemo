/**
 * Created with JackHou
 * Date: 2021/3/2
 * Time: 9:39
 * Description:
 */

package com.qtimes.jetpackdemo.db.dao;

import com.qtimes.jetpackdemo.db.data.User;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Long registerUser(User user);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    int updateUser(User user);

    @Delete
    void deleteUser(User user);

    @Query("SELECT * FROM USER WHERE id =:id")
    User findUserById(long id);

    @Query("SELECT * FROM USER WHERE user_account =:account")
    User findUserByAccount(String account);

    @Query("select * from user where user_state == 1")
    User findLoginUser();
}
