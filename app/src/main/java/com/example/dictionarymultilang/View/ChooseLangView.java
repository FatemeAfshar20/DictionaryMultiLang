package com.example.dictionarymultilang.View;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dictionarymultilang.R;
import com.google.android.material.button.MaterialButton;

public class ChooseLangView {
    private MaterialButton mButtonEnglish,mButtonPersian;
    private View mView;

    public ChooseLangView(LayoutInflater inflater, ViewGroup container) {
        mView=inflater.inflate(R.layout.fragment_choose_lang,container,false);
    }

    public void findElem(){
        mButtonEnglish=mView.findViewById(R.id.btn_choose_english);
        mButtonPersian=mView.findViewById(R.id.btn_choose_persian);
    }

    public MaterialButton getButtonEnglish() {
        return mButtonEnglish;
    }

    public void setButtonEnglish(MaterialButton buttonEnglish) {
        mButtonEnglish = buttonEnglish;
    }

    public MaterialButton getButtonPersian() {
        return mButtonPersian;
    }

    public void setButtonPersian(MaterialButton buttonPersian) {
        mButtonPersian = buttonPersian;
    }

    public View getView() {
        return mView;
    }

}
