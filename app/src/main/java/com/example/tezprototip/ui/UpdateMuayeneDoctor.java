package com.example.tezprototip.ui;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.example.tezprototip.GeciciStatic;
import com.example.tezprototip.R;
import com.example.tezprototip.viewmodel.TezViewModel;
import com.example.tezprototip.model.Muayene;

import java.util.Date;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class UpdateMuayeneDoctor extends AppCompatActivity {
    private int muayene_id= GeciciStatic.muayene_id,
    doctor_id=GeciciStatic.doctor_id,id=GeciciStatic.id;
    private TezViewModel mTezViewModel;
    private Spinner spinner_sikayet;
    private EditText txt_ana_tani,txt_ek_tani,txt_agirlik,txt_boy,txt_nabiz;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_muayene_doctor);
        txt_ana_tani=(EditText)findViewById(R.id.update_muayene_ana_tani);
        txt_ek_tani=(EditText)findViewById(R.id.update_muayene_ek_tani);
        txt_agirlik=(EditText)findViewById(R.id.update_muayene_agirlik);
        txt_boy=(EditText)findViewById(R.id.update_muayene_boy);
        txt_nabiz=(EditText)findViewById(R.id.update_muayene_nabiz);
        mTezViewModel = ViewModelProviders.of(this).get(TezViewModel.class);

        spinner_sikayet = (Spinner) findViewById(R.id.spinner_sikayet2);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinner_sikayet, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_sikayet.setAdapter(adapter);

    }

    public void muayeneGuncelleOnClick(View view) {
        String sikayet=spinner_sikayet.getSelectedItem().toString();
        switch(sikayet){
            case "POLIÜRI": sikayet="POLIÜRI";break;
            case "POLIFAJI": sikayet="POLIFAJI";break;
            case "VAJINIT": sikayet="VAJINIT";break;
            case "KARIN AĞRISI": sikayet="KARIN AĞRISI";break;
            case "KABIZLIK": sikayet="KABIZLIK";break;
            case "POLIDIPSI": sikayet="POLIDIPSI";break;
            case "KILO KAYBI": sikayet="KILO KAYBI";break;
            case "HALSIZLIK": sikayet="HALSIZLIK";break;
            case "GECE IDRAR KAÇIRMA / NOKTÜRI": sikayet="GECE IDRAR KAÇIRMA / NOKTÜRI";break;
            case "MANTAR ENFEKSIYONU": sikayet="MANTAR ENFEKSIYONU";break;
            case "KUSMA": sikayet="KUSMA";break;
            case "SOLUNUM SIKINTISI": sikayet="SOLUNUM SIKINTISI";break;
        }
        String ana_tani=txt_ana_tani.getText().toString();
        String ek_tani=txt_ek_tani.getText().toString();
        Date date=new Date();
        float agirlik=Float.parseFloat(txt_agirlik.getText().toString());
        float boy=Float.parseFloat(txt_boy.getText().toString());
        int nabiz=Integer.parseInt(txt_nabiz.getText().toString());
        Muayene m=new Muayene(muayene_id,ana_tani,ek_tani,sikayet,date,agirlik,boy,nabiz,doctor_id,id);
        mTezViewModel.updateMuayene(m);
        Intent intent=new Intent(this, DoctorActivity.class);
        startActivity(intent);
    }
}
