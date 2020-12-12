package com.example.tezprototip.db;


import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.tezprototip.Converter;
import com.example.tezprototip.model.Diary;
import com.example.tezprototip.model.Doctor;
import com.example.tezprototip.model.Muayene;
import com.example.tezprototip.model.TetkikSonucu;
import com.example.tezprototip.model.TetkikTalep;
import com.example.tezprototip.model.User;

@Database(entities = {User.class, Diary.class, Doctor.class, Muayene.class, TetkikTalep.class, TetkikSonucu.class},
        version =14,exportSchema = false)
@TypeConverters({Converter.class})
public abstract class TezRoomDatabase extends RoomDatabase {
    public abstract UserDao userDao();
    public abstract DiaryDao diaryDao();
    public abstract DoctorDao doctorDao();
    public abstract MuayeneDao muayeneDao();
    public abstract TetkikTalepDao tetkiktalepDao();
    public abstract TetkikSonucuDao tetkiksonucuDao();
   // private static TezRoomDatabase INSTANCE;
/*
    public static TezRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (TezRoomDatabase.class) {
                if (INSTANCE == null) {
                    // Create database here
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            TezRoomDatabase.class, "tez_database")
                            .fallbackToDestructiveMigration().addCallback(sRoomDatabaseCallback).build();
                }
            }
        }
        return INSTANCE;
    }
    private static RoomDatabase.Callback sRoomDatabaseCallback =
            new RoomDatabase.Callback(){

                @Override
                public void onOpen (@NonNull SupportSQLiteDatabase db){
                    super.onOpen(db);
                    new PopulateDbAsync(INSTANCE).execute();
                }
            };
    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final UserDao mDao;


        PopulateDbAsync(TezRoomDatabase db) {
            mDao = db.userDao();
        }

        @Override
        protected Void doInBackground(final Void... params) {
            // Start the app with a clean database every time.
            // Not needed if you only populate the database
            // when it is first created



            return null;
        }
    }

 */
}
