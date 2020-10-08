package com.example.dictionarymultilang.Controller.Fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dictionarymultilang.Database.Repository.EnglishDBRepository;
import com.example.dictionarymultilang.Database.Repository.IRepository;
import com.example.dictionarymultilang.Model.EnglishWords;
import com.example.dictionarymultilang.View.DialogView;

public class AddDialogFragment extends DialogFragment {
    public static final String EXTRA_NEW_WORD = "com.example.dictionarymultilang.new word";
    private DialogView mDialogView;
    private EnglishWords mEnglishWords=new EnglishWords();
    private IRepository<EnglishWords> mEnglishRepository;
    public AddDialogFragment() {
        // Required empty public constructor
    }

    public static AddDialogFragment newInstance() {
        AddDialogFragment fragment = new AddDialogFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mEnglishRepository =EnglishDBRepository.getInstance(getContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mDialogView=new DialogView(inflater,container);
        mDialogView.findElem();
        setListener();
        return mDialogView.getView();
    }

    public void setListener(){
        mDialogView.getButtonOk().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEnglishWords=returnNewWord();
                mEnglishRepository.insert(mEnglishWords);
                sendData(mEnglishWords);
                dismiss();
            }
        });

        mDialogView.getButtonCancel().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    dismiss();
            }
        });
    }

    private EnglishWords returnNewWord() {
        EnglishWords englishWords=new EnglishWords();
        englishWords.setWord(
                mDialogView.getTextWord());
        englishWords.setMeaning(
                mDialogView.getTextMeaning());
        englishWords.setSynonym(
                mDialogView.getTextSynonym());
            return englishWords;
    }

    private  void sendData(EnglishWords englishWords){
        Intent intent=new Intent();
        Fragment fragment=getTargetFragment();
        intent.putExtra(EXTRA_NEW_WORD,englishWords);

        fragment.onActivityResult(getTargetRequestCode(),
                Activity.RESULT_OK,intent);
    }
}