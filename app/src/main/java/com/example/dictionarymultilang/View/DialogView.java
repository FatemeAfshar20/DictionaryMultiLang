package com.example.dictionarymultilang.View;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dictionarymultilang.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class DialogView {
    private TextInputEditText mEditTextWord,mEditTextMeaning,
    mEditTextSynonym;
    private MaterialButton mButtonOk,mButtonCancel;
    private View mView;

    public DialogView(LayoutInflater inflater,
                      ViewGroup container) {
        mView=inflater.inflate(R.layout.fragment_dialog
                ,container,false);
    }

    public void findElem(){
        mEditTextWord=mView.findViewById(R.id.add_word);
        mEditTextMeaning=mView.findViewById(R.id.add_meaning);
        mEditTextSynonym=mView.findViewById(R.id.add_synonym);
        mButtonOk=mView.findViewById(R.id.btn_ok);
        mButtonCancel=mView.findViewById(R.id.btn_cancel);
    }

    public String getTextWord() {
        return mEditTextWord.getText().toString();
    }

    public void setTextWord(String TextWord) {
        mEditTextWord.setText(TextWord);
    }

    public String getTextMeaning() {
        return mEditTextMeaning.getText().toString();
    }

    public void setTextMeaning(String TextMeaning) {
        mEditTextMeaning.setText(TextMeaning);
    }

    public String getTextSynonym() {
        return mEditTextSynonym.getText().toString();
    }

    public void setTextSynonym(String TextSynonym) {
        mEditTextSynonym.setText(TextSynonym);
    }

    public MaterialButton getButtonOk() {
        return mButtonOk;
    }

    public void setButtonOk(MaterialButton buttonOk) {
        mButtonOk = buttonOk;
    }

    public MaterialButton getButtonCancel() {
        return mButtonCancel;
    }

    public void setButtonCancel(MaterialButton buttonCancel) {
        mButtonCancel = buttonCancel;
    }

    public View getView() {
        return mView;
    }

}
