package com.example.a1216qdf.ntougendermap.intro;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Toast;

import com.example.a1216qdf.ntougendermap.R;

/**
 * Created by 1216QDF on 10/16/2016.
 */
public class DefaultIntro extends BaseIntro {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addSlide(SampleSlide.newInstance(R.layout.intro_1));
        addSlide(SampleSlide.newInstance(R.layout.intro_2));
        addSlide(SampleSlide.newInstance(R.layout.intro_3));
        addSlide(SampleSlide.newInstance(R.layout.intro_4));
        addSlide(SampleSlide.newInstance(R.layout.intro_5));
    }

    @Override
    public void onSkipPressed(Fragment currentFragment) {
        super.onSkipPressed(currentFragment);
        loadMainActivity();
        Toast.makeText(getApplicationContext(), getString(R.string.skip), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);

        loadMainActivity();
    }

    public void getStarted(View v) {
        loadMainActivity();
    }
}
