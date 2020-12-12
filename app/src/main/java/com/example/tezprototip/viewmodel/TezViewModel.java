package com.example.tezprototip.viewmodel;

import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.tezprototip.model.Diary;
import com.example.tezprototip.model.Doctor;
import com.example.tezprototip.model.Muayene;
import com.example.tezprototip.model.TetkikSonucu;
import com.example.tezprototip.model.TetkikTalep;
import com.example.tezprototip.model.User;
import com.example.tezprototip.repository.TezRepository;

import java.util.List;
import java.util.concurrent.ExecutionException;

import io.reactivex.Maybe;

public class  TezViewModel extends ViewModel {
    private TezRepository mRepository;

    @ViewModelInject
    public TezViewModel (TezRepository repository) {
        mRepository = repository;
    }

    public LiveData<List<Diary>> findDiaryForUser(final int TC){return mRepository.findDiaryForUser(TC);}
    public LiveData<List<TetkikTalep>> findTetkikForUser(final int TC){return mRepository.findTetkikForUser(TC);}
    public LiveData<List<Muayene>> findMuayeneForUser(final int TC){return mRepository.findMuayeneForUser(TC);}
    public LiveData<List<Muayene>> findMuayeneForDoctor(final int DOCTOR_ID){return mRepository.findMuayeneForDoctor(DOCTOR_ID);}
    public List<Doctor> getAllDoctors(){
        try {
            return mRepository.getAllDoctors();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
    //Check User if Exist RxJava on Login Activity onSubscribeOn
    public Maybe<User> getMfindById(final int TC,final int pass){return mRepository.getMfindById(TC,pass);}
    //Check User if Exist RxJava on Login Activity onSubscribeOn
    public Maybe<Doctor> getDoctorfindById(final int DOKTOR_ID, final int pass){return mRepository.getDoctorfindById(DOKTOR_ID,pass);}

    public void deleteAllDiariesById(final int TC) {mRepository.deleteAllDiariesById(TC);}
    public void deleteDiary(Diary diary) {mRepository.deleteDiary(diary);}
    public void insertUser(User user) { mRepository.insertUser(user); }
    public void insertDiary(Diary diary){mRepository.insertDiary(diary);}
    public void insertDoctor(Doctor doctor){mRepository.insertDoctor(doctor);}
    public void insertMuayene(Muayene muayene){mRepository.insertMuayene(muayene);}
    public void updateMuayene(Muayene muayene){mRepository.updateMuayene(muayene);}
    public void insertTetkikTalep(TetkikTalep tetkikTalep){mRepository.insertTetkikTalep(tetkikTalep);}
    public void insertTetkikSonucu(TetkikSonucu tetkikSonucu){mRepository.insertTetkikSonucu(tetkikSonucu);}
}
