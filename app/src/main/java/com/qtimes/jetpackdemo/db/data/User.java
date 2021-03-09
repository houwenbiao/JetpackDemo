/**
 * Created with JackHou
 * Date: 2021/3/1
 * Time: 14:47
 * Description:用户表
 */

package com.qtimes.jetpackdemo.db.data;

import com.qtimes.jetpackdemo.db.enums.UserState;

import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "user", indices = {@Index(value = "user_account", unique = true)})
public class User {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private Long id;

    @ColumnInfo(name = "user_account")
    private String account;

    @ColumnInfo(name = "user_name")
    private String name;

    @ColumnInfo(name = "user_password")
    private String password;

    @Embedded
    private Address address;

    @ColumnInfo(name = "user_state", defaultValue = "-1")
    private int state;

    public User(String account, String name, String password) {
        this.account = account;
        this.name = name;
        this.password = password;
        this.state = UserState.RESOLVE.getStateId();
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", address=" + address +
                ", state=" + state +
                '}';
    }
}
