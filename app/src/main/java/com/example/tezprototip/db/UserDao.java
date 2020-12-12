package com.example.tezprototip.db;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.tezprototip.model.User;

import java.util.List;

import io.reactivex.Maybe;

@Dao
public interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertUser(User... users);
    @Query("SELECT * FROM users")
    LiveData<List<User>> loadAllUsers();
    @Query("DELETE FROM users")
    void deleteAll();
    @Query("SELECT * FROM users where TC = :TC and SIFRE=:pass")
    Maybe<User> mfindById(int TC, int pass);
}
