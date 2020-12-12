package com.example.tezprototip.db;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.tezprototip.model.Diary;

import java.util.List;

@Dao
public interface DiaryDao {
    @Insert
    void insertDiary(Diary diary);

    @Update
    void updateDiary(Diary diary);


    @Delete
    void deleteDiary(Diary diary);

    @Query("DELETE FROM diaries WHERE mTC=:TC")
    void deleteAllDiariesById(final int TC);

    @Query("SELECT * FROM diaries WHERE mTC=:TC ORDER BY TARIH ASC")
    LiveData<List<Diary>> findDiaryForUser(final int TC);
}
