package com.example.tezprototip.db;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.tezprototip.model.TetkikTalep;

import java.util.List;

@Dao
public interface TetkikTalepDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertTetkikTalep(TetkikTalep tetkiktalep);
    @Query("SELECT * FROM tetkiktalep WHERE MUAYENE_ID=(SELECT MUAYENE_ID FROM muayene WHERE HASTA_TC=:HASTA_TC)")
    LiveData<List<TetkikTalep>> findTetkikForUser(final int HASTA_TC);
}
