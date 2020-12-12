package com.example.tezprototip.db;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.tezprototip.model.Doctor;

import java.util.List;

import io.reactivex.Maybe;
@Dao
public interface DoctorDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertDoctor(Doctor doctor);
    @Query("SELECT * FROM doctors")
    List<Doctor> getAllDoctors();
    @Query("DELETE FROM doctors")
    void deleteAllDoctors();
    @Query("SELECT * FROM doctors where DOCTOR_ID = :DOCTOR_ID and SIFRE=:pass")
    Maybe<Doctor> getDoctorfindById(int DOCTOR_ID, int pass);

}
