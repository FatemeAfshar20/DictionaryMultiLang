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

import java.util.UUID;

public class EditFragment extends DialogFragment {
    public static final String ARG_WORD_ID = "Word Id";
    public static final String EXTRA_UPDATED_WORD =
            "com.example.dictionarymultilang..Word is updated";
    private IRepository<EnglishWords> mEnglishRepository;
    private DialogView mView;
    private EnglishWords mWord;
    private UUID mWordId;

    public EditFragment() {
        // Required empty public constructor
    }

    public static EditFragment newInstance(UUID wordId) {
        EditFragment fragment = new EditFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_WORD_ID, wordId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mEnglishRepository =
                EnglishDBRepository.getInstance(getContext());
        mWordId =
                (UUID) getArguments().getSerializable(ARG_WORD_ID);
        mWord = mEnglishRepository.get(mWordId);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = new DialogView(inflater, container);
        mView.findElem();

        setListener();
        return mView.getView();
    }

    private void setListener() {

        mView.getButtonOk().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnUpdatedWord(mWord);
                mEnglishRepository.update(mWord);
                sendData(mWord);
                dismiss();
            }
        });

        mView.getButtonCancel().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

    }

    private void returnUpdatedWord(EnglishWords englishWords) {
        if (!mView.getTextWord().equals(""))
            englishWords.setWord(
                    mView.getTextWord());
        if (!mView.getTextMeaning().equals(""))
            englishWords.setMeaning(
                    mView.getTextMeaning());
        if (!mView.getTextSynonym().equals(""))
            englishWords.setSynonym(
                    mView.getTextSynonym());
    }

    private void sendData(EnglishWords englishWords) {
        Intent intent = new Intent();
        Fragment fragment = getTargetFragment();
       intent.putExtra(EXTRA_UPDATED_WORD,englishWords);

        fragment.onActivityResult(getTargetRequestCode(),
                Activity.RESULT_OK, intent);
    }
}