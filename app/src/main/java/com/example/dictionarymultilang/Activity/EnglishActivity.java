package com.example.dictionarymultilang.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.dictionarymultilang.Fragment.EnglishFragment;
import com.example.dictionarymultilang.R;

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