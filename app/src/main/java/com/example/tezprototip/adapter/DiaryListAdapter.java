package com.example.tezprototip.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.tezprototip.R;
import com.example.tezprototip.model.Diary;

import java.util.List;

public class DiaryListAdapter extends RecyclerView.Adapter<DiaryListAdapter.DiaryViewHolder> {
    private final LayoutInflater mInflater;
    private List<Diary> mDiary; // Cached copy of words

    public DiaryListAdapter(Context context) { mInflater = LayoutInflater.from(context); }

    public Diary getDiaryAtPosition (int position) {
        return mDiary.get(position);
    }
    @Override
    public DiaryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new DiaryViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(DiaryViewHolder holder, int position) {
        if (mDiary != null) {
            Diary current = mDiary.get(position);
            String myCode="BOS METIN";
            switch(current.mCode){
                case 33:
                    myCode="Regular insulin dose";
                    break;
                case 34:
                    myCode="NPH insulin dose";
                    break;
                case 35:
                    myCode="UltraLente insulin dose";
                    break;
                case 57:
                    myCode="Unspecified blood glucose measurement";
                    break;
                case 58:
                    myCode="Pre-breakfast blood glucose measurement";
                    break;
                case 59:
                    myCode="Post-breakfast blood glucose measurement";
                    break;
                case 60:
                    myCode="Pre-lunch blood glucose measurement";
                    break;
                case 61:
                    myCode="Post-lunch blood glucose measurement";
                    break;
                case 62:
                    myCode="Pre-supper blood glucose measurement";
                    break;
                case 63:
                    myCode="Post-supper blood glucose measurement";
                    break;
                case 64:
                    myCode="Pre-snack blood glucose measurement";
                    break;
                case 66:
                    myCode="Typical meal ingestion";
                    break;
                case 67:
                    myCode="More-than-usual meal ingestion";
                    break;
                case 68:
                    myCode="Less-than-usual meal ingestion";
                    break;
                case 69:
                    myCode="Typical exercise activity";
                    break;
                case 70:
                    myCode="More-than-usual exercise activity";
                    break;
                case 71:
                    myCode="Less-than-usual exercise activity";
                    break;
                case 72:
                    myCode="Unspecified special event";
                    break;

            }
            String myTarih=current.mTARIH.toString();
            myTarih=myTarih.substring(0,19);
            holder.diaryHeaderView.setText(myTarih);
            holder.diaryItemView.setText(myTarih+" "+myCode+" "
                                                        +current.mVALUE);
        } else {
            // Covers the case of data not being ready yet.
            holder.diaryItemView.setText("No diaries");
        }
    }

    public void setmDiary(List<Diary> diaries){
        mDiary = diaries;
        notifyDataSetChanged();
    }

    // getItemCount() is called many times, and when it is first called,
    // mWords has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (mDiary != null)
            return mDiary.size();
        else return 0;
    }

    class DiaryViewHolder extends RecyclerView.ViewHolder {
        private final TextView diaryItemView;
        private final TextView diaryHeaderView;

        private DiaryViewHolder(View itemView) {
            super(itemView);
            diaryItemView = itemView.findViewById(R.id.textView);
            diaryHeaderView=itemView.findViewById(R.id.textHeader);
        }
    }
}
