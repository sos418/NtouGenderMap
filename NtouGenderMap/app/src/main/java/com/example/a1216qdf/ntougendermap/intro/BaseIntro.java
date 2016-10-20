package com.example.a1216qdf.ntougendermap.intro;

import android.content.Intent;

import com.example.a1216qdf.ntougendermap.MainActivity;
import com.github.paolorotolo.appintro.AppIntro2;

/**
 * Created by 1216QDF on 10/16/2016.
 */
public class BaseIntro  extends AppIntro2 {

    void loadMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
