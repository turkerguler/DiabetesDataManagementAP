package com.example.tezprototip.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "muayene",indices = {@Index(value=("HASTA_TC")),@Index(value = ("DOCTOR_ID"))},
                                                                                 foreignKeys = {@ForeignKey(entity = User.class,
                                                                                         parentColumns = "TC",
                                                                                      childColumns = "HASTA_TC") ,
                                                                                        @ForeignKey(entity = Doctor.class,
                                                                                        parentColumns ="DOCTOR_ID",
                                                                                        childColumns = "DOCTOR_ID")})
public class Muayene {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "MUAYENE_ID")
    public int mMUAYENE_ID;
    @ColumnInfo(name="ANA_TANI")
    public String mANA_TANI;
    @ColumnInfo(name="EK_TANI")
    public String mEK_TANI;
    @ColumnInfo(name="SIKAYET")
    public String mSIKAYET;
    @ColumnInfo(name="TARIH")
    public Date mTARIH;
    @ColumnInfo(name="AGIRLIK")
    public float mAGIRLIK;
    @ColumnInfo(name="BOY")
    public float mBOY;
    @ColumnInfo(name="NABIZ")
    public int mNABIZ;
    @ColumnInfo(name="DOCTOR_ID")
    public int mDOCTOR_ID;
    @ColumnInfo(name="HASTA_TC")
    public int mHASTA_TC;
    @Ignore
    public Muayene() {
    }
    @Ignore
    public Muayene(int mMUAYENE_ID, String mANA_TANI, String mEK_TANI, String mSIKAYET, Date mTARIH, float mAGIRLIK, float mBOY, int mNABIZ,int mDOCTOR_ID, int mHASTA_TC) {
        this.mMUAYENE_ID = mMUAYENE_ID;
        this.mANA_TANI = mANA_TANI;
        this.mEK_TANI = mEK_TANI;
        this.mSIKAYET = mSIKAYET;
        this.mTARIH = mTARIH;
        this.mAGIRLIK = mAGIRLIK;
        this.mBOY = mBOY;
        this.mNABIZ = mNABIZ;
        this.mDOCTOR_ID = mDOCTOR_ID;
        this.mHASTA_TC = mHASTA_TC;
    }

    public Muayene(String mANA_TANI, String mEK_TANI, String mSIKAYET, Date mTARIH, float mAGIRLIK, float mBOY, int mNABIZ, int mDOCTOR_ID, int mHASTA_TC) {

        this.mANA_TANI = mANA_TANI;
        this.mEK_TANI = mEK_TANI;
        this.mSIKAYET = mSIKAYET;
        this.mTARIH=mTARIH;
        this.mAGIRLIK = mAGIRLIK;
        this.mBOY = mBOY;
        this.mNABIZ = mNABIZ;
        this.mDOCTOR_ID = mDOCTOR_ID;
        this.mHASTA_TC = mHASTA_TC;
    }
}
