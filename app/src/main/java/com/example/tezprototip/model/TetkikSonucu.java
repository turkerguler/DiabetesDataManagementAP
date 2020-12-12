package com.example.tezprototip.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "tetkiksonucu",indices = {@Index(value="MUAYENE_ID")},foreignKeys = {@ForeignKey(entity = Muayene.class,
                                                                                        parentColumns = "MUAYENE_ID",
                                                                                        childColumns = "MUAYENE_ID")})
public class TetkikSonucu {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "TETKIK_SONUC_ID")
    public int mTETKIK_SONUC_ID;
    @ColumnInfo(name="TETKIK_SONUC_TARIH")
    public Date mTETKIK_SONUC_TARIH;
    @ColumnInfo(name="TETKIK")
    public String mTETKIK;
    @ColumnInfo(name="TETKIK_SONUCU")
    public String mTETKIK_SONUCU;
    @ColumnInfo(name="MUAYENE_ID")
    public int mMUAYENE_ID;
    @ColumnInfo(name="TETKIKTALEP_ID")
    public int mTETKIK_TALEP_ID;
    @Ignore
    public TetkikSonucu() {
    }
    @Ignore
    public TetkikSonucu(int mTETKIK_SONUC_ID, Date mTETKIK_SONUC_TARIH, String mTETKIK, String mTETKIK_SONUCU, int mMUAYENE_ID,int mTETKIK_TALEP_ID) {
        this.mTETKIK_SONUC_ID = mTETKIK_SONUC_ID;
        this.mTETKIK_SONUC_TARIH = mTETKIK_SONUC_TARIH;
        this.mTETKIK = mTETKIK;
        this.mTETKIK_SONUCU = mTETKIK_SONUCU;
        this.mMUAYENE_ID = mMUAYENE_ID;
        this.mTETKIK_TALEP_ID=mTETKIK_TALEP_ID;
    }

    public TetkikSonucu(Date mTETKIK_SONUC_TARIH, String mTETKIK, String mTETKIK_SONUCU, int mMUAYENE_ID,int mTETKIK_TALEP_ID) {
        this.mTETKIK_SONUC_TARIH = mTETKIK_SONUC_TARIH;
        this.mTETKIK = mTETKIK;
        this.mTETKIK_SONUCU = mTETKIK_SONUCU;
        this.mMUAYENE_ID = mMUAYENE_ID;
        this.mTETKIK_TALEP_ID=mTETKIK_TALEP_ID;
    }
}
