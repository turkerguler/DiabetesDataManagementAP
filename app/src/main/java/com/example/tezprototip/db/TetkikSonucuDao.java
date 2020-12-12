package com.example.tezprototip.db;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;

import com.example.tezprototip.model.TetkikSonucu;

@Dao
public interface TetkikSonucuDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertTetkikSonucu(TetkikSonucu tetkikSonucu);
}
