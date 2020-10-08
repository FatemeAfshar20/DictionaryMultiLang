package com.example.dictionarymultilang.Controller.Activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.dictionarymultilang.R;

public abstract class SingleFragmentActivity extends AppCompatActivity {

    public abstract Fragment getFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.container);

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.fragment_container);

        if (fragment == null) {
            fragmentManager
                    .beginTransaction()
                    .add(R.id.fragment_container, getFragment())
                    .commit();
        }
    }
}
