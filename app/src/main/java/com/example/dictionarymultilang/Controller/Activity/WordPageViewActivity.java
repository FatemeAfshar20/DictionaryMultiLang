package com.example.dictionarymultilang.Controller.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.dictionarymultilang.Controller.Fragment.WordPageFragment;
import com.example.dictionarymultilang.R;

import java.util.UUID;

public class WordPageViewActivity extends SingleFragmentActivity {

    public static final String EXTRA_WORD_ID =
            "com.example.dictionarymultilang.Word Id";

    public static void start(Context context, UUID wordId) {
        Intent starter = new Intent(context,
                WordPageViewActivity.class);
        starter.putExtra(EXTRA_WORD_ID,wordId);
        context.startActivity(starter);
    }

    @Override
    public Fragment getFragment() {
        Intent intent=getIntent();
        UUID id= (UUID) intent
                .getSerializableExtra(EXTRA_WORD_ID);

        return WordPageFragment.newInstance(id);
    }
}