package com.example.dictionarymultilang.View;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;

import com.example.dictionarymultilang.R;
import com.google.android.material.textview.MaterialTextView;

public class WordPageView {
    private MaterialTextView mWordView, mSynonym, mMeaning;
    private View mView;
    private Toolbar mToolbar;

    public WordPageView(LayoutInflater inflater, ViewGroup container) {
        mView = inflater.inflate(R.layout.word_page_view,
                container, false);
    }

    public void findElem() {
        mWordView = mView.findViewById(R.id.word);
        mMeaning = mView.findViewById(R.id.meaning);
        mSynonym = mView.findViewById(R.id.synonym);
        mToolbar=mView.findViewById(R.id.toolbar_word_page);
    }

    public String getWordView() {
        return mWordView.getText().toString();
    }

    public void setWordView(String wordView) {
        mWordView.setText(wordView);
    }

    public String getSynonym() {
        return mSynonym.getText().toString();
    }

    public void setSynonym(String synonym) {
        mSynonym.setText(synonym);
    }

    public String getMeaning() {
        return mMeaning.getText().toString();
    }

    public void setMeaning(String meaning) {
        mMeaning.setText(meaning);
    }

    public View getView() {
        return mView;
    }

    public Toolbar getToolbar() {
        return mToolbar;
    }

    public void setToolbar(Toolbar toolbar) {
        mToolbar = toolbar;
    }
}
