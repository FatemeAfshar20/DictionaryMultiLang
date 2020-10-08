package com.example.dictionarymultilang.Controller.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dictionarymultilang.Controller.Activity.WordViewActivity;
import com.example.dictionarymultilang.Controller.Activity.PersianActivity;
import com.example.dictionarymultilang.View.ChooseLangView;

public class ChooseLangFragment extends Fragment {
    private ChooseLangView mView;
    public ChooseLangFragment() {
        // Required empty public constructor
    }

    public static ChooseLangFragment newInstance() {
        ChooseLangFragment fragment = new ChooseLangFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView=new ChooseLangView(inflater,container);
        mView.findElem();
        setListener();
        return mView.getView();
    }

    private void setListener(){
        mView.getButtonEnglish().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WordViewActivity.start(getActivity(),"English");
            }
        });

        mView.getButtonPersian().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  WordViewActivity.start(getActivity(),"Persian");
            }
        });
    }
}