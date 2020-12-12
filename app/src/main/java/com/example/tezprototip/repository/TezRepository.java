package com.example.tezprototip.repository;

import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.tezprototip.db.TezRoomDatabase;
import com.example.tezprototip.db.DiaryDao;
import com.example.tezprototip.db.DoctorDao;
import com.example.tezprototip.db.MuayeneDao;
import com.example.tezprototip.db.TetkikSonucuDao;
import com.example.tezprototip.db.TetkikTalepDao;
import com.example.tezprototip.db.UserDao;
import com.example.tezprototip.model.Diary;
import com.example.tezprototip.model.Doctor;
import com.example.tezprototip.model.Muayene;
import com.example.tezprototip.model.TetkikSonucu;
import com.example.tezprototip.model.TetkikTalep;
import com.example.tezprototip.model.User;
import com.example.tezprototip.network.ApiServices;

import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.inject.Inject;

import io.reactivex.Maybe;

public class TezRepository {
    private DiaryDao mDiaryDao;
    private UserDao mUserDao;
    private DoctorDao mDoctorDao;
    private MuayeneDao mMuayeneDao;
    private TetkikTalepDao mTetkikTalepDao;
    private TetkikSonucuDao mTetkikSonucuDao;
    private TezRoomDatabase db;
    private ApiServices apiServices;

    @Inject
    public TezRepository(DiaryDao diaryDao, UserDao userDao, DoctorDao doctorDao, MuayeneDao muayeneDao, TetkikTalepDao tetkikTalepDao, TetkikSonucuDao tetkikSonucuDao, ApiServices apiServices) {
        //db = TezRoomDatabase.getDatabase(application);
        mUserDao = userDao;
        mDiaryDao = diaryDao;
        mDoctorDao = doctorDao;
        mMuayeneDao = muayeneDao;
        mTetkikTalepDao = tetkikTalepDao;
        mTetkikSonucuDao = tetkikSonucuDao;
        this.apiServices = apiServices;
    }

     public LiveData<List<Diary>> findDiaryForUser(final int TC){return mDiaryDao.findDiaryForUser(TC);}
     public LiveData<List<TetkikTalep>> findTetkikForUser(final int TC){return mTetkikTalepDao.findTetkikForUser(TC);}
     public LiveData<List<Muayene>> findMuayeneForUser(final int TC){return mMuayeneDao.findMuayeneForUser(TC);}
     public LiveData<List<Muayene>> findMuayeneForDoctor(final int DOCTOR_ID){return mMuayeneDao.findMuayeneForDoctor(DOCTOR_ID);}
     //Check User if Exist RxJava on Login Activity onSubscribeOn
     public Maybe<User> getMfindById(final int TC,final int pass){return mUserDao.mfindById(TC,pass);}
     //Check Doctor if Exist RXJava on Login Activity onSubscribeOn
     public Maybe<Doctor> getDoctorfindById(final int DOKTOR_ID, final int pass){return mDoctorDao.getDoctorfindById(DOKTOR_ID,pass);}

     //Load Doctors to SPINNER
     public List<Doctor> getAllDoctors()throws ExecutionException, InterruptedException{return new GetDoctorsAsyncTask(mDoctorDao).execute().get();}
    private class GetDoctorsAsyncTask extends AsyncTask<Void, Void,List<Doctor>>
    {
        private DoctorDao mAsyncTaskDao;


        GetDoctorsAsyncTask(DoctorDao dao) {
            mAsyncTaskDao = dao;
        }
        @Override
        protected List<Doctor> doInBackground(Void... url) {
            return mDoctorDao.getAllDoctors();
        }
    }
     //Delete All Diaries START
     public void deleteAllDiariesById(final int TC)  {
        new deleteAllDiariesAsyncTask(mDiaryDao).execute(TC);
    }
     private static class deleteAllDiariesAsyncTask extends AsyncTask<Integer, Void, Void> {
        private DiaryDao mAsyncTaskDao;

        deleteAllDiariesAsyncTask(DiaryDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(Integer... TC) {
            mAsyncTaskDao.deleteAllDiariesById(TC[0]);
            return null;
        }
    }
    //Delete All Diaries FINISH
    //Delete Specific Diary START
    public void deleteDiary(Diary diary)  {
        new deleteDiarySpecificAsyncTask(mDiaryDao).execute(diary);
    }
    private static class deleteDiarySpecificAsyncTask extends AsyncTask<Diary, Void, Void> {
        private DiaryDao mAsyncTaskDao;

        deleteDiarySpecificAsyncTask(DiaryDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Diary... params) {
            mAsyncTaskDao.deleteDiary(params[0]);
            return null;
        }
    }
    //Delete Specific Diary FINISH
    //Insert Diary START
    public void insertDiary(Diary diary){new insertDiaryAsyncTask(mDiaryDao).execute(diary);}
    private static class insertDiaryAsyncTask extends AsyncTask<Diary,Void,User>{
        private DiaryDao mDao;
        insertDiaryAsyncTask(DiaryDao dao2){mDao=dao2;}

        @Override
        protected User doInBackground(Diary... diaries) {
            mDao.insertDiary(diaries[0]);
            return null;
        }
    }
    //Insert Diary FINISH

    //Insert User START
    public void insertUser(User user) {
        new insertAsyncTask(mUserDao).execute(user);
    }
    private static class insertAsyncTask extends AsyncTask<User, Void, Void> {
        private UserDao mAsyncTaskDao;
        insertAsyncTask(UserDao dao) {
            mAsyncTaskDao = dao;
        }
        @Override
        protected Void doInBackground(final User... params) {
            mAsyncTaskDao.insertUser(params);
            return null;
        }
    }
    //Insert User FINISH
    //Insert Doctor START
    public void insertDoctor(Doctor doctor){new insertDoctorAsyncTask(mDoctorDao).execute(doctor);}
    private static class insertDoctorAsyncTask extends AsyncTask<Doctor,Void,Void>{
        private DoctorDao mDao;
        insertDoctorAsyncTask(DoctorDao dao){mDao=dao;}

        @Override
        protected Void doInBackground(Doctor... params) {
            mDao.insertDoctor(params[0]);
            return null;
        }
    }
    //Insert Doctor FINISH
    //Insert Muayene START
    public void insertMuayene(Muayene muayene) { new insertMuayeneAsyncTask(mMuayeneDao).execute(muayene);
    }
    private static class insertMuayeneAsyncTask extends AsyncTask<Muayene, Void, Void> {
        private MuayeneDao mAsyncTaskDao;
        insertMuayeneAsyncTask(MuayeneDao dao) {
            mAsyncTaskDao = dao;
        }
        @Override
        protected Void doInBackground(final Muayene... params) {
            mAsyncTaskDao.insertMuayene(params[0]);
            return null;
        }
    }
    //Insert Muayene FINISH
    public void updateMuayene(Muayene... muayenes){new updateMuayeneAsyncTask(mMuayeneDao).execute(muayenes);}
    private static class updateMuayeneAsyncTask extends AsyncTask<Muayene,Void,Muayene>{
        private MuayeneDao mAsyncTaskDao;
        updateMuayeneAsyncTask(MuayeneDao dao){mAsyncTaskDao=dao;}
        @Override
            protected Muayene doInBackground(final Muayene... muayenes){
            mAsyncTaskDao.updateMuayene(muayenes[0]);
            return  muayenes[0];
        }
    }
    //Insert TetkikTalep START
    public void insertTetkikTalep(TetkikTalep tetkikTalep){new insertTetkikTalepAsyncTask(mTetkikTalepDao).execute(tetkikTalep);}
    private static class insertTetkikTalepAsyncTask extends AsyncTask<TetkikTalep,Void,Void>{
        private TetkikTalepDao mDao;
        insertTetkikTalepAsyncTask(TetkikTalepDao dao2){mDao=dao2;}

        @Override
        protected Void doInBackground(TetkikTalep... tetkikTaleps) {
            mDao.insertTetkikTalep(tetkikTaleps[0]);
            return null;
        }
    }
    //Insert TetkikTalep FINISH

    //Insert User START
    public void insertTetkikSonucu(TetkikSonucu tetkikSonucu) {
        new insertTetkikSonucuAsyncTask(mTetkikSonucuDao).execute(tetkikSonucu);
    }
    private static class insertTetkikSonucuAsyncTask extends AsyncTask<TetkikSonucu, Void, Void> {
        private TetkikSonucuDao mAsyncTaskDao;
        insertTetkikSonucuAsyncTask(TetkikSonucuDao dao) {
            mAsyncTaskDao = dao;
        }
        @Override
        protected Void doInBackground(final TetkikSonucu... params) {
            mAsyncTaskDao.insertTetkikSonucu(params[0]);
            return null;
        }
    }
    //Insert User FINISH
}
