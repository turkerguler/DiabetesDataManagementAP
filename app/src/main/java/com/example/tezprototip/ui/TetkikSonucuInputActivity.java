package com.example.tezprototip.ui;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.example.tezprototip.GeciciStatic;
import com.example.tezprototip.R;
import com.example.tezprototip.viewmodel.TezViewModel;
import com.example.tezprototip.model.TetkikSonucu;

import java.util.Date;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class TetkikSonucuInputActivity extends AppCompatActivity {
    private EditText et_sonuc;
    private Button bt;
    private TezViewModel mTezViewModel;
    private String tetkik= GeciciStatic.mTetkik;
    private int muayene_id=GeciciStatic.muayene_id;
    private int tetkik_talep_id=GeciciStatic.tetkik_talep_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tetkik_sonucu_input);
        et_sonuc=(EditText)findViewById(R.id.tetkik_sonucu_input_sonuc);
        bt=(Button)findViewById((R.id.tetkik_sonucu_button));
        mTezViewModel = ViewModelProviders.of(this).get(TezViewModel.class);
    }

    public void tetkikSonucuOnClick(View view) {
        Date date=new Date();
        String st=et_sonuc.getText().toString();
        TetkikSonucu ts=new TetkikSonucu(date,tetkik,st,muayene_id,tetkik_talep_id);
        mTezViewModel.insertTetkikSonucu(ts);

    }
}
