package com.example.tezprototip.ui;


import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.example.tezprototip.GeciciStatic;
import com.example.tezprototip.R;
import com.example.tezprototip.viewmodel.TezViewModel;
import com.example.tezprototip.model.Doctor;
import com.example.tezprototip.model.Muayene;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MuayeneActivity extends AppCompatActivity {
    public TezViewModel mTezViewModel;

    private Spinner spinner_sikayet,spinner_doctor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muayene);

        mTezViewModel = ViewModelProviders.of(this).get(TezViewModel.class);
        List<Doctor> doctorList = mTezViewModel.getAllDoctors();
        ArrayAdapter<Doctor> dataAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item,doctorList);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_doctor = findViewById(R.id.spinner_doctor);
        spinner_doctor.setAdapter(dataAdapter);


        spinner_sikayet = (Spinner) findViewById(R.id.spinner_sikayet);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinner_sikayet, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_sikayet.setAdapter(adapter);
    }

    public void muayeneKayitonClick(View view) {
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
        Date date=new Date();
        float agirlik=0;
        float boy=0;
        int nabız=0;
        Method method= null;
        try {
            method = spinner_doctor.getSelectedItem().getClass().getMethod("getmDOCTOR_ID");

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        assert method != null;
        int doctor_id= 0;
        try {
            doctor_id = (Integer)method.invoke(spinner_doctor.getSelectedItem());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        int id= GeciciStatic.id;
        Muayene m=new Muayene(null,null,sikayet,date,agirlik,boy,nabız,doctor_id,id);
        mTezViewModel.insertMuayene(m);
    }
}
