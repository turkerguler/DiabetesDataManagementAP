package com.example.tezprototip.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "doctors")
public class Doctor {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "DOCTOR_ID")
    public int mDOCTOR_ID;
    @ColumnInfo(name="SIFRE")
    public int mSIFRE;
    @ColumnInfo(name="TYPE")
    public String mTYPE;
    @ColumnInfo(name = "AD")
    public String mAD;
    @ColumnInfo(name="SOYAD")
    public String mSOYAD;

    public int getmDOCTOR_ID() {
        return mDOCTOR_ID;
    }

    public String getmAD() {
        return mAD +mSOYAD;
    }

    @Ignore
    public Doctor() {
    }

    public Doctor(int mDOCTOR_ID,int mSIFRE, String mTYPE, String mAD, String mSOYAD) {
        this.mDOCTOR_ID = mDOCTOR_ID;
        this.mSIFRE=mSIFRE;
        this.mTYPE = mTYPE;
        this.mAD = mAD;
        this.mSOYAD = mSOYAD;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "mAD='" + mAD + '\'' +
                ", mSOYAD='" + mSOYAD + '\'' +
                '}';
    }
}
