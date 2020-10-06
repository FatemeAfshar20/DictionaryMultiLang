package com.example.dictionarymultilang.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.dictionarymultilang.Fragment.PersianFragment;
import com.example.dictionarymultilang.R;

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