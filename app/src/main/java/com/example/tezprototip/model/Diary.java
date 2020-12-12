package com.example.tezprototip.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import java.util.Date;

@Entity(tableName = "diaries",indices = {@Index("mTC")},foreignKeys = @ForeignKey(entity = User.class,
                                                            parentColumns = "TC",
                                                            childColumns = "mTC"))
public class Diary {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name="GUNLUK_ID")
    public int mGUNLUK_ID;
    @NonNull
    @ColumnInfo(name="mTC")
    public int mTC;
    @ColumnInfo(name="TARIH")
    public Date mTARIH;
    // @ColumnInfo(name="SAAT")
    // public Time mSAAT;
    @ColumnInfo(name="CODE")
    public int mCode;
    @ColumnInfo(name="VALUE")
    public int mVALUE;
    @Ignore
    public Diary() {
    }

    public Diary(final int mTC, Date mTARIH, int mCode, int mVALUE) {

        this.mTC = mTC;
        this.mTARIH = mTARIH;
        //this.mSAAT = mSAAT;
        this.mCode = mCode;
        this.mVALUE = mVALUE;
    }

}
