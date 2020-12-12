package com.example.tezprototip.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tezprototip.R;
import com.example.tezprototip.model.Muayene;

import java.util.List;

public class MuayeneListAdapter extends RecyclerView.Adapter<MuayeneListAdapter.MuayeneViewHolder> {
    private final LayoutInflater mInflater;
    private List<Muayene> mMuayene;

    public MuayeneListAdapter(Context context) { mInflater = LayoutInflater.from(context); }

    public Muayene getMuayeneAtPosition (int position) {
        return mMuayene.get(position);
    }
    @Override
    public MuayeneViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new MuayeneViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MuayeneViewHolder holder, int position) {
           if(mMuayene!=null) {
               Muayene current = mMuayene.get(position);

               holder.muayeneItemView.setText("Ana Tanı :"+current.mANA_TANI+"Ek Tanı: "+current.mEK_TANI+"Şikayet: "+current.mSIKAYET+
                       "Tarih; "+ current.mTARIH+
                       "Hasta TC:"+current.mHASTA_TC);
           }
    }

    public void setmMuayene(List<Muayene> muayenes){
        mMuayene = muayenes;
        notifyDataSetChanged();
    }

    // getItemCount() is called many times, and when it is first called,
    // mWords has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (mMuayene != null)
            return mMuayene.size();
        else return 0;
    }

    class MuayeneViewHolder extends RecyclerView.ViewHolder {
        private final TextView muayeneItemView;


        private MuayeneViewHolder(View itemView) {
            super(itemView);
            muayeneItemView = itemView.findViewById(R.id.textView);

        }
    }
}
