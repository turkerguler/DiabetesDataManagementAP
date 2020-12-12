package com.example.tezprototip.ui;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.example.tezprototip.R;
import com.example.tezprototip.viewmodel.TezViewModel;
import com.example.tezprototip.model.User;

import java.util.Date;

public class SingUpActivity extends AppCompatActivity {

    private EditText id_et;
    private EditText pass_et;
    private EditText name_et;
    private EditText surname_et;
    private DatePicker mDate;
    private EditText gender_et;
    private TezViewModel mTezViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up);
        id_et=(EditText)findViewById(R.id.sign_up_tc);
        pass_et=(EditText)findViewById(R.id.sign_up_pass);
        name_et=(EditText)findViewById(R.id.sign_up_name);
        surname_et=(EditText)findViewById(R.id.sign_up_surname);

        gender_et=(EditText)findViewById(R.id.sign_up_gender);
        mTezViewModel = ViewModelProviders.of(this).get(TezViewModel.class);


    }

    public void signUp(View view) {
        if (TextUtils.isEmpty(id_et.getText())) {
            Toast.makeText(this, "hata", Toast.LENGTH_SHORT).show();
        } else {
            int id=Integer.parseInt(id_et.getText().toString());
            int pass=Integer.parseInt(pass_et.getText().toString());
            String name=name_et.getText().toString();
            String surname=surname_et.getText().toString();
            Date date=new Date();
            String gender=gender_et.getText().toString();
            User user=new User(id,pass,name,surname,date,gender);
            mTezViewModel.insertUser(user);

            /*
            OkHttpClient client = new OkHttpClient();
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://127.0.0.1")
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
            ApiServices service = retrofit.create(ApiServices.class);
            Call<User> call = service.insertUser(user.mTC,user.mSIFRE,user.mAD,user.mSOYAD,user.mDOGUM_TARIHI,user.mCINSIYET);
            call.enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {
                    Toast.makeText(SingUpActivity.this, "response"+response, Toast.LENGTH_LONG).show();
                }
                @Override
                public void onFailure(Call<User> call, Throwable t) {
                    Log.i("Hello",""+t);
                    Toast.makeText(SingUpActivity.this, "Throwable"+t, Toast.LENGTH_LONG).show();
                }
            });

            */
            //Intent it=new Intent(this, LoginActivity.class);
           // startActivity(it);
        }
    }
}
