package com.example.dictionarymultilang.Controller.Activity;

import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;

import com.example.dictionarymultilang.Controller.Fragment.PersianFragment;

public class PersianActivity extends SingleFragmentActivity {

    public static void start(Context context) {
        Intent starter = new Intent(context, PersianActivity.class);
        //starter.putExtra();
        context.startActivity(starter);
    }

    @Override
    public Fragment getFragment() {
        return PersianFragment.newInstance();
    }

}