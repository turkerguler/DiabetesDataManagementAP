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
import com.example.tezprototip.model.TetkikTalep;

import java.util.Date;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class TetkikTalepActivity extends AppCompatActivity {
    private EditText et_tetkik;
    private Button button;
    private TezViewModel mTezViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tetkik_talep);
        et_tetkik=(EditText)findViewById(R.id.tetkik_talep);
        button=(Button)findViewById(R.id.tetkik_talep_button);
        mTezViewModel = ViewModelProviders.of(this).get(TezViewModel.class);
    }

    public void tetkikTalepOnClick(View view) {
        String tetkik=et_tetkik.getText().toString();
        Date date=new Date();
        TetkikTalep tetkikTalep=new TetkikTalep(tetkik,date, GeciciStatic.muayene_id);
        mTezViewModel.insertTetkikTalep(tetkikTalep);
    }
}
