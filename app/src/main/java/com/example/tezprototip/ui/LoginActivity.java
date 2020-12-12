package com.example.tezprototip.ui;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.example.tezprototip.GeciciStatic;
import com.example.tezprototip.R;
import com.example.tezprototip.model.Doctor;
import com.example.tezprototip.model.User;
import com.example.tezprototip.viewmodel.TezViewModel;

import java.util.Date;

import dagger.hilt.android.AndroidEntryPoint;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableMaybeObserver;
import io.reactivex.schedulers.Schedulers;
@AndroidEntryPoint
public class LoginActivity extends AppCompatActivity {
    private EditText id_et;
    private EditText pass_et;
    private TezViewModel mTezViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mTezViewModel = ViewModelProviders.of(this).get(TezViewModel.class);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        id_et=(EditText)findViewById(R.id.login_id_et);
        pass_et=(EditText)findViewById(R.id.login_pass_et);
        Date date=new Date();

        Doctor d =new Doctor(1,2,"Uzman","Ahmet","Galip");
        Doctor c =new Doctor(2,3,"Uzman","Yeter","Bicer");
        User u=new User(1,2,"ahmet","galip",date,"erkek");
        mTezViewModel.insertDoctor(d);
        mTezViewModel.insertDoctor(c);
    }

    public void signUpClick(View view) {
        Intent it=new Intent(this, SingUpActivity.class);
        startActivity(it);
    }

    //Check if user exist
    public void signIn(View view) {

        final int id=Integer.parseInt(id_et.getText().toString());
        int pass=Integer.parseInt(pass_et.getText().toString());
        final Context context=this;
        mTezViewModel.getMfindById(id,pass).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableMaybeObserver<User>() {
                     boolean var;

                    @Override
                    public void onComplete() {
                        Log.d("BULUNAMADI","BULUNAMADI");

                    }

                    @Override
                    public void onSuccess(User user) {
                        GeciciStatic.id=id;
                        Intent it=new Intent(context, MainDiaryActivity.class);
                        startActivity(it);
                        Log.d("BULUNDU","BULUNDU");

                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }
                });

    }

    public void doctorLoginClick(View view) {
        final int doctor_id=Integer.parseInt(id_et.getText().toString());
        int doctor_pass=Integer.parseInt(pass_et.getText().toString());
        final Context context=this;
        mTezViewModel.getDoctorfindById(doctor_id,doctor_pass).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableMaybeObserver<Doctor>() {
                    boolean var;

                    @Override
                    public void onComplete() {
                        Log.d("BULUNAMADI","BULUNAMADI");

                    }

                    @Override
                    public void onSuccess(Doctor doctor) {
                        GeciciStatic.doctor_id=doctor_id;
                        Intent it=new Intent(context, DoctorActivity.class);
                        startActivity(it);
                        Log.d("DOCTORBULUNDU","DOCTORBULUNDU");

                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }
                });
    }
}
