package com.example.tezprototip.ui;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tezprototip.GeciciStatic;
import com.example.tezprototip.R;
import com.example.tezprototip.adapter.IstenenTetkiklerListAdapter;
import com.example.tezprototip.model.TetkikTalep;
import com.example.tezprototip.viewmodel.TezViewModel;

import java.util.List;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class IstenenTetkiklerUser extends AppCompatActivity {
    private TezViewModel mTezViewModel;
    private int id=GeciciStatic.id;
    Context context=this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_istenen_tetkikler_user);
        RecyclerView recyclerView = findViewById(R.id.recyclerviewtetkik);
        mTezViewModel = ViewModelProviders.of(this).get(TezViewModel.class);

        final IstenenTetkiklerListAdapter adapter = new IstenenTetkiklerListAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mTezViewModel.findTetkikForUser(id).observe(this, new Observer<List<TetkikTalep>>() {
            @Override
            public void onChanged(@Nullable final List<TetkikTalep> tetkikTaleps) {
                // Update the cached copy of the words in the adapter.
                adapter.setmTetkikTalep(tetkikTaleps);
            }
        });
        ItemTouchHelper helperUpdate = new ItemTouchHelper(
                new ItemTouchHelper.SimpleCallback(0,
                        ItemTouchHelper.LEFT ) {

                    @Override
                    public boolean onMove(RecyclerView recyclerView,
                                          RecyclerView.ViewHolder viewHolder,
                                          RecyclerView.ViewHolder target) {
                        return false;
                    }

                    @Override
                    public void onSwiped(RecyclerView.ViewHolder viewHolder,
                                         int direction) {
                        int position = viewHolder.getAdapterPosition();


                        TetkikTalep myTetkik = adapter.getTetkikTalepAtPosition(position);

                        GeciciStatic.muayene_id=myTetkik.mMUAYENE_ID;
                        GeciciStatic.tetkik_talep_id=myTetkik.mTETKIKTALEP_ID;
                        GeciciStatic.mTetkik=myTetkik.mTETKIK;

                        // Delete the word
                        //mTezViewModel.deleteDiary(myMuayene);
                        Intent intent=new Intent(context, TetkikSonucuInputActivity.class);

                        startActivity(intent);
                    }


                });

        helperUpdate.attachToRecyclerView(recyclerView);
    }
}
