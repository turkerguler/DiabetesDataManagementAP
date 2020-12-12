package com.example.tezprototip.db;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.tezprototip.model.Muayene;

import java.util.List;

@Dao
public interface MuayeneDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertMuayene(Muayene muayene);
    @Query("SELECT * FROM muayene")
    LiveData<List<Muayene>> loadAllMuayene();
    @Query("SELECT * FROM muayene WHERE HASTA_TC=:HASTA_TC ORDER BY TARIH ASC")
    LiveData<List<Muayene>> findMuayeneForUser(final int HASTA_TC);
    @Query("SELECT * FROM muayene WHERE DOCTOR_ID=:DOCTOR_ID")
    LiveData<List<Muayene>> findMuayeneForDoctor(final int DOCTOR_ID);
    @Update
    void updateMuayene(Muayene... muayene);
}
