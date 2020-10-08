package com.example.dictionarymultilang.Controller.Activity;

import android.content.Context;
import android.content.Intent;

import androidx.fragment.app.Fragment;

import com.example.dictionarymultilang.Controller.Fragment.EnglishFragment;

public class EnglishActivity extends SingleFragmentActivity {
    public static void start(Context context) {
        Intent starter = new Intent(context, EnglishActivity.class);
        //starter.putExtra();
        context.startActivity(starter);
    }
    @Override
    public Fragment getFragment() {
        return EnglishFragment.newInstance();
    }
}