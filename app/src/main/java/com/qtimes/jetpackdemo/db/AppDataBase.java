/**
 * Created with JackHou
 * Date: 2021/3/2
 * Time: 9:34
 * Description:
 */

package com.qtimes.jetpackdemo.db;

import android.content.Context;
import android.util.Log;

import com.qtimes.jetpackdemo.db.dao.FavoriteShoeDao;
import com.qtimes.jetpackdemo.db.dao.ShoeDao;
import com.qtimes.jetpackdemo.db.dao.UserDao;
import com.qtimes.jetpackdemo.db.data.FavoriteShoe;
import com.qtimes.jetpackdemo.db.data.Shoe;
import com.qtimes.jetpackdemo.db.data.User;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {User.class, Shoe.class, FavoriteShoe.class}, version = 3, exportSchema = false)
public abstract class AppDataBase extends RoomDatabase {
    private static final String TAG = "AppDataBase";

    private static AppDataBase instance;

    public abstract UserDao getUserDao();

    public abstract ShoeDao getShoeDao();

    public abstract FavoriteShoeDao favoriteShoeDao();

    static final Migration MIGRATION_2_3 = new Migration(2, 3) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
//            database.execSQL("drop index index_user_user_account");
            database.execSQL("create unique index index_user_account on user(user_account)");
        }
    };

    public static AppDataBase getInstance(Context context) {

        if (instance == null) {
            synchronized (AppDataBase.class) {
                if (instance == null) {
                    instance = buildDatabase(context);
                }
            }
        }
        return instance;
    }

    private static AppDataBase buildDatabase(Context context) {
        return Room.databaseBuilder(context, AppDataBase.class, "jetpack_demo_db")
                .addCallback(new Callback() {
                    @Override
                    public void onCreate(@NonNull SupportSQLiteDatabase db) {
                        super.onCreate(db);
                        Log.d(TAG, "jetpack_demo_db created");
                    }
                }).addMigrations(MIGRATION_2_3)
                .allowMainThreadQueries().build();
    }
}