package com.example.tezprototip.model;


import androidx.room.*;

import java.util.Date;

@Entity(tableName = "users")
public class User {
    @PrimaryKey
    @ColumnInfo(name = "TC")
    public int mTC;
    @ColumnInfo(name = "SIFRE")
    public int mSIFRE;
    @ColumnInfo(name = "AD")
    public String mAD;
    @ColumnInfo(name = "SOYAD")
    public String mSOYAD;
    @ColumnInfo(name = "DOGUM_TARIHI")
    public Date mDOGUM_TARIHI;
    @ColumnInfo(name ="CINSIYET")
    public String mCINSIYET;
    @Ignore
    public User() {
    }

    public User(int mTC, int mSIFRE, String mAD, String mSOYAD,Date mDOGUM_TARIHI, String mCINSIYET) {
        this.mTC = mTC;
        this.mSIFRE = mSIFRE;
        this.mAD = mAD;
        this.mSOYAD = mSOYAD;
        this.mDOGUM_TARIHI = mDOGUM_TARIHI;
        this.mCINSIYET = mCINSIYET;
    }
}
