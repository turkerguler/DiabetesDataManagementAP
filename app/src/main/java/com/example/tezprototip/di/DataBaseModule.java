package com.example.tezprototip.di;

import android.app.Application;

import androidx.room.Room;

import com.example.tezprototip.db.DiaryDao;
import com.example.tezprototip.db.DoctorDao;
import com.example.tezprototip.db.MuayeneDao;
import com.example.tezprototip.db.TetkikSonucuDao;
import com.example.tezprototip.db.TetkikTalepDao;
import com.example.tezprototip.db.TezRoomDatabase;
import com.example.tezprototip.db.UserDao;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;

@Module
@InstallIn(ApplicationComponent.class)
public class DataBaseModule {

    @Provides
    @Singleton
    public static TezRoomDatabase provideTezRoomDatabase(Application application) {
        return Room.databaseBuilder(application,TezRoomDatabase.class,"tez_database")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build();
    }
    @Provides
    @Singleton
    public static UserDao provideUserDao(TezRoomDatabase tezRoomDatabase) {
        return tezRoomDatabase.userDao();
    }
    @Provides
    @Singleton
    public static DiaryDao provideDiaryDao(TezRoomDatabase tezRoomDatabase) {
        return tezRoomDatabase.diaryDao();
    }
    @Provides
    @Singleton
    public static DoctorDao provideDoctorDao(TezRoomDatabase tezRoomDatabase) {
        return tezRoomDatabase.doctorDao();
    }
    @Provides
    @Singleton
    public static MuayeneDao provideMuayeneDao(TezRoomDatabase tezRoomDatabase) {
        return tezRoomDatabase.muayeneDao();
    }
    @Provides
    @Singleton
    public static TetkikTalepDao provideTetkikTalepDao(TezRoomDatabase tezRoomDatabase) {
        return tezRoomDatabase.tetkiktalepDao();
    }
    @Provides
    @Singleton
    public static TetkikSonucuDao provideTetkikSonucuDao(TezRoomDatabase tezRoomDatabase) {
        return tezRoomDatabase.tetkiksonucuDao();
    }
}
