package com.example.tezprototip.ui;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.tezprototip.GeciciStatic;
import com.example.tezprototip.R;
import com.example.tezprototip.viewmodel.TezViewModel;
import com.example.tezprototip.model.Diary;
import com.example.tezprototip.ui.fragments.DatePickerFragment;
import com.example.tezprototip.ui.fragments.TimePickerFragment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Date;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class NewDiaryActivity extends AppCompatActivity {
    public TezViewModel mTezViewModel;
    int mCode;
    String name;
    private int id;
    private EditText editText;
    Spinner spinner;
    DialogFragment newDateFragment = new DatePickerFragment();
    DialogFragment newTimeFragment = new TimePickerFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_diary);
        editText=(EditText)findViewById(R.id.new_diary_et);
        spinner = (Spinner) findViewById(R.id.spinner);
        id= GeciciStatic.id;
        TextView saat_et=(TextView)findViewById(R.id.saat_et);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.diary_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        mTezViewModel = ViewModelProviders.of(this).get(TezViewModel.class);
        //Assets START





    }

    private int myYear;
    private int myMounth;
    private int myDay;
    public void onDateSet(int i,int i1, int i2) {
        myYear=i;
        myMounth=i1;
        myDay=i2;
    }
    private int myHour;
    private int myMinute;
    public void onTimeSet(int i,int i1){
        myHour=i;
        myMinute=i1;
    }
    public void kaydetOnClick(View view) {

        name=spinner.getSelectedItem().toString();
        switch (name) {
            case "Regular insulin dose":
                mCode=33;
                break;
            case "NPH insulin dose":
                mCode=34;
                break;
            case "UltraLente insulin dose":
                mCode=35;
                break;
            case "Unspecified blood glucose measurement":
                mCode=57;
                break;
            case "Pre-breakfast blood glucose measurement":
                mCode=58;
                break;
            case "Post-breakfast blood glucose measurement":
                mCode=59;
                break;
            case "Pre-lunch blood glucose measurement":
                mCode=60;
                break;
            case "Post-lunch blood glucose measurement":
                mCode=61;
                break;
            case "Pre-supper blood glucose measurement":
                mCode=62;
                break;
            case "Post-supper blood glucose measurement":
                mCode=63;
                break;
            case "Pre-snack blood glucose measurement":
                mCode=64;
                break;
            case "Hypoglycemic symptoms":
                mCode=65;
                break;
            case "Typical meal ingestion":
                mCode=66;
                break;
            case "More-than-usual meal ingestion":
                mCode=67;
                break;
            case "Less-than-usual meal ingestion":
                mCode=68;
                break;
            case "Typical exercise activity":
                mCode=69;
                break;
            case "More-than-usual exercise activity":
                mCode=70;
                break;
            case "Less-than-usual exercise activity":
                mCode=71;
                break;
            case "Unspecified special event":
                mCode=72;
                break;

        }
        int mValue=Integer.parseInt(editText.getText().toString());
        Date mDate = new Date(myYear, myMounth, myDay, myHour, myMinute,00);
    try {
        Diary d = new Diary(id, mDate, mCode, mValue);
        mTezViewModel.insertDiary(d);
    }catch (IllegalArgumentException e){
        e.printStackTrace();
    }
    }

    public void showDatePickerDialog(View view) {

        newDateFragment.show(getSupportFragmentManager(), "datePicker");

    }

    public void showTimePickerDialog(View view) {
        newTimeFragment.show(getSupportFragmentManager(), "timePicker");

    }

    public String getTxtFile(String fileName)
    {
        BufferedReader reader = null;
        InputStream inputStream = null;
        StringBuilder builder = new StringBuilder();

        try{
            inputStream = getAssets().open(fileName);
            reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;

            while((line = reader.readLine()) != null)
            {
                String[] split = line.split("[\t\\-|:]");

                int myYear=0,myMounth=0,myDay=0,myHour=0,myMinute=0,myCode=0,myValue=0;
                for (int i=0;i<split.length;i++){
                    Log.d("TAG","value "+i+ ": "+split[i]);
                    switch (i){
                        case 0:
                            myDay=Integer.parseInt(split[i]);
                            break;
                        case 1:
                            myMounth=Integer.parseInt(split[i]);
                            break;
                        case 2:
                            myYear=Integer.parseInt(split[i]);
                            break;
                        case 3:
                            myHour=Integer.parseInt(split[i]);
                            break;
                        case 4:
                            myMinute=Integer.parseInt(split[i]);
                            break;
                        case 5:
                            myCode=Integer.parseInt(split[i]);
                            break;
                        case 6:
                            myValue=Integer.parseInt(split[i]);
                            break;
                    }

                }

                Date date=new Date(myYear,myMounth,myDay,myHour,myMinute,00);
                Diary diary=new Diary(2,date,myCode,myValue);
                mTezViewModel.insertDiary(diary);

                Log.i("TAG", line);
                builder.append(line);
                builder.append("\n");
            }
        } catch (IOException ioe){
            ioe.printStackTrace();
        } finally {

            if(inputStream != null)
            {
                try {
                    inputStream.close();
                } catch (IOException ioe){
                    ioe.printStackTrace();
                }
            }

            if(reader != null)
            {
                try {
                    reader.close();
                } catch (IOException ioe)
                {
                    ioe.printStackTrace();
                }
            }
        }
        Log.i("TAG", "builder.toString(): " + builder.toString());
        return builder.toString();
    }






}
