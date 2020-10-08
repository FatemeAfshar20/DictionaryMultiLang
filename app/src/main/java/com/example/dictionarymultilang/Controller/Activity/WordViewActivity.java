package com.example.dictionarymultilang.Controller.Activity;

import android.animation.IntArrayEvaluator;
import android.content.Context;
import android.content.Intent;

import androidx.fragment.app.Fragment;

import com.example.dictionarymultilang.Controller.Fragment.WordViewFragment;

public class WordViewActivity extends SingleFragmentActivity {

    public static final String EXTRA_LANGUAGE_NAME =
            "com.example.dictionarymultilang.Language";

    public static void start(Context context, String language) {
        Intent starter = new Intent(context, WordViewActivity.class);
        starter.putExtra(EXTRA_LANGUAGE_NAME,language);
        context.startActivity(starter);
    }
    @Override
    public Fragment getFragment() {
        Intent intent=getIntent();
       String language= intent.getStringExtra(EXTRA_LANGUAGE_NAME);
        return WordViewFragment.newInstance(language);
    }
}