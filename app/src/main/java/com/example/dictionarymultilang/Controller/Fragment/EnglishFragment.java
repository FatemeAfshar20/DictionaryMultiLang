package com.example.dictionarymultilang.Controller.Fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dictionarymultilang.Adapter.WordViewAdapter;
import com.example.dictionarymultilang.Database.Repository.EnglishDBRepository;
import com.example.dictionarymultilang.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class EnglishFragment extends Fragment {
    public static final String FRAGMENT_ADD_WORD = "Add Word";
    public static final int REQUEST_CODE_ADD_DIALOG = 1;
    private RecyclerView mRecyclerView;
    private FloatingActionButton mButtonAdd;
    private WordViewAdapter mAdapter;
    private EnglishDBRepository mEnglishDBRepository;
    public EnglishFragment() {
        // Required empty public constructor
    }

    public static EnglishFragment newInstance() {
        EnglishFragment fragment = new EnglishFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mEnglishDBRepository=
                EnglishDBRepository.getInstance(getContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.all_word_view, container, false);
        findElem(view);
        mAdapter=new WordViewAdapter(
                mEnglishDBRepository.getLists(),getContext());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(mAdapter);
        setListener();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (resultCode!= Activity.RESULT_OK || data==null)
            return;
        if(requestCode==REQUEST_CODE_ADD_DIALOG){
            updateUI();
        }
    }

    private void findElem(View view){
        mRecyclerView=view.findViewById(R.id.recycler_view);
        mButtonAdd=view.findViewById(R.id.btn_add);
    }

    private void setListener(){
        mButtonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddDialogFragment addDialogFragment=
                        AddDialogFragment.newInstance();

                addDialogFragment.setTargetFragment(
                        EnglishFragment.this, REQUEST_CODE_ADD_DIALOG);

                addDialogFragment.show(
                        getActivity().getSupportFragmentManager(),
                        FRAGMENT_ADD_WORD);

            }
        });
    }

    private void updateUI() {
        mAdapter.setWordsList(mEnglishDBRepository.getLists());
        mAdapter.notifyDataSetChanged();
    }
}