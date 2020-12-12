package com.example.tezprototip.model;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName ="tetkiktalep",indices = {@Index(value=("MUAYENE_ID"))},foreignKeys = {@ForeignKey(entity = Muayene.class,
                                                                                        parentColumns = "MUAYENE_ID",
                                                                                        childColumns = "MUAYENE_ID")})
public class TetkikTalep {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name="TETKIKTALEP_ID")
    public int mTETKIKTALEP_ID;
    @ColumnInfo(name="TETKIK")
    public String mTETKIK;
    @ColumnInfo(name="TARIH")
    public Date mTARIH;
    @ColumnInfo(name = "MUAYENE_ID")
    public int mMUAYENE_ID;
    @Ignore
    public TetkikTalep() {
    }
    @Ignore
    public TetkikTalep(int mTETKIKTALEP_ID, String mTETKIK,Date mTARIH, int mMUAYENE_ID) {
        this.mTETKIKTALEP_ID = mTETKIKTALEP_ID;
        this.mTETKIK = mTETKIK;
        this.mTARIH=mTARIH;
        this.mMUAYENE_ID = mMUAYENE_ID;
    }

    public TetkikTalep(String mTETKIK,Date mTARIH, int mMUAYENE_ID) {
        this.mTETKIK = mTETKIK;
        this.mTARIH=mTARIH;
        this.mMUAYENE_ID = mMUAYENE_ID;
    }
}
