package com.example.dictionarymultilang.Controller.Fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.dictionarymultilang.Database.Repository.EnglishDBRepository;
import com.example.dictionarymultilang.Database.Repository.IRepository;
import com.example.dictionarymultilang.Model.EnglishWords;
import com.example.dictionarymultilang.R;
import com.example.dictionarymultilang.View.WordPageView;

import java.util.UUID;

public class WordPageFragment extends Fragment {
    public static final String ARG_WORD_ID = "Word Id";
    public static final int REQUEST_CODE_EDIT = 1;
    public static final String FRAGMENT_EDIT_FRAGMENT = "Edit Fragment";
    private IRepository<EnglishWords> mEnglishRepository;
    private WordPageView mView;
    private EnglishWords mWord;
    private UUID mWordId;

    public WordPageFragment() {
        // Required empty public constructor
    }

    public static WordPageFragment newInstance(UUID wordId) {
        WordPageFragment fragment = new WordPageFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_WORD_ID,wordId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        mEnglishRepository=
                EnglishDBRepository.getInstance(getContext());
        mWordId=
                (UUID) getArguments().getSerializable(ARG_WORD_ID);
        mWord=mEnglishRepository.get(mWordId);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView=new WordPageView(inflater,container);
        mView.findElem();
        ((AppCompatActivity)getActivity()).setSupportActionBar(mView.getToolbar());
        initView(mWord);
        return mView.getView();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if(resultCode!= Activity.RESULT_OK || data==null)
            return;
        if(requestCode==REQUEST_CODE_EDIT){
            EnglishWords word=
                    (EnglishWords) data.getSerializableExtra(
                            EditFragment.EXTRA_UPDATED_WORD);

            initView(word);
        }
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu_word_page,menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_edit_word:
                EditFragment editFragment=
                        EditFragment.newInstance(mWordId);

                editFragment.setTargetFragment(WordPageFragment.this
                        , REQUEST_CODE_EDIT);

                editFragment.show(
                        getActivity().getSupportFragmentManager(),
                        FRAGMENT_EDIT_FRAGMENT);
                return true;
            case R.id.menu_delete_word:
                mEnglishRepository.delete(mWord);
                getActivity().finish();
                return true;
            default:
                return false;
        }

    }

    private void initView(EnglishWords word){
        mView.setWordView(word.getWord());
        mView.setMeaning(word.getMeaning());
        mView.setSynonym(word.getSynonym());
    }
}