package com.example.dictionarymultilang.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dictionarymultilang.R;

public class ChooseLangFragment extends Fragment {

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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_choose_lang, container, false);
    }
}