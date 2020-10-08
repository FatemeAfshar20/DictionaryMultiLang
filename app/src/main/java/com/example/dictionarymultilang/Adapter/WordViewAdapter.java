package com.example.dictionarymultilang.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dictionarymultilang.Controller.Activity.WordPageViewActivity;
import com.example.dictionarymultilang.Model.EnglishWords;
import com.example.dictionarymultilang.R;
import com.google.android.material.textview.MaterialTextView;

import java.util.List;

public class WordViewAdapter extends RecyclerView.Adapter<WordViewAdapter.Holder> {
    private List<EnglishWords> mWordsList;
    private Context mContext;

    public List<EnglishWords> getWordsList() {
        return mWordsList;
    }

    public void setWordsList(List<EnglishWords> wordsList) {
        mWordsList = wordsList;
    }

    public WordViewAdapter(List<EnglishWords> wordsList, Context context) {
        mWordsList = wordsList;
        mContext = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view = layoutInflater.
                inflate(R.layout.word_view,
                        parent,
                        false);
        Holder holder = new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.bind(mWordsList.get(position));
    }

    @Override
    public int getItemCount() {
        return mWordsList.size();
    }

    // Holder inner class
    public class Holder extends RecyclerView.ViewHolder {
        private MaterialTextView mTextViewWord;
        private EnglishWords mWord;

        public Holder(@NonNull View itemView) {
            super(itemView);
            mTextViewWord = itemView.findViewById(R.id.word_item);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    WordPageViewActivity.
                            start(mContext,mWord.getWordId());
                }
            });
        }

        public void bind(EnglishWords words) {
            mWord=words;
            mTextViewWord.setText(words.getWord());
        }
    }
}
