package com.example.tezprototip.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.tezprototip.R;
import com.example.tezprototip.model.TetkikTalep;

import java.util.List;

public class IstenenTetkiklerListAdapter extends RecyclerView.Adapter<IstenenTetkiklerListAdapter.TetkikViewHolder> {
    private final LayoutInflater mInflater;
    private List<TetkikTalep> mTetkikTalep; // Cached copy of words

    public IstenenTetkiklerListAdapter(Context context) { mInflater = LayoutInflater.from(context); }

    public TetkikTalep getTetkikTalepAtPosition (int position) {
        return mTetkikTalep.get(position);
    }
    @Override
    public TetkikViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new TetkikViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TetkikViewHolder holder, int position) {
        if (mTetkikTalep != null) {
            TetkikTalep current = mTetkikTalep.get(position);



            holder.tetkikItemView.setText("Muayene : "+current.mMUAYENE_ID+ "İstenen Tetkik : "+current.mTETKIK+ "Tarih : "+current.mTARIH);
        } else {
            // Covers the case of data not being ready yet.
            holder.tetkikItemView.setText("No diaries");
        }
    }

    public void setmTetkikTalep(List<TetkikTalep> tetkikTaleps){
        mTetkikTalep = tetkikTaleps;
        notifyDataSetChanged();
    }

    // getItemCount() is called many times, and when it is first called,
    // mWords has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (mTetkikTalep != null)
            return mTetkikTalep.size();
        else return 0;
    }

    class TetkikViewHolder extends RecyclerView.ViewHolder {
        private final TextView tetkikItemView;


        private TetkikViewHolder(View itemView) {
            super(itemView);
            tetkikItemView = itemView.findViewById(R.id.textView);

        }
    }
}
