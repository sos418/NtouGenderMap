package com.example.a1216qdf.ntougendermap;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class GenderInforActivity extends AppCompatActivity {

    public Button btn1,btn2,btn3,btn4,btn5,btn6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender_infor);
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("mailto:sq@mail.ntou.edu.tw");
                Intent it = new Intent(Intent.ACTION_SENDTO, uri);
                startActivity(it);

            }
        });

        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(" ");
        loadBackdrop();

        btn1 = (Button)findViewById(R.id.btn1);
        btn2 = (Button)findViewById(R.id.btn2);
        btn3 = (Button)findViewById(R.id.btn3);
        btn4 = (Button)findViewById(R.id.btn4);
        btn5 = (Button)findViewById(R.id.btn5);
        btn6 = (Button)findViewById(R.id.btn6);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ie1 = new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.gender.edu.tw/web/index.php/home/index"));
                startActivity(ie1);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ie2 = new Intent(Intent.ACTION_VIEW,Uri.parse("http://law.moj.gov.tw/LawClass/LawAll.aspx?PCode=H0080069"));
                startActivity(ie2);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ie3 = new Intent(Intent.ACTION_VIEW,Uri.parse("http://law.moj.gov.tw/LawClass/LawAll.aspx?PCode=H0080067"));
                startActivity(ie3);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ie4 = new Intent(Intent.ACTION_VIEW,Uri.parse("http://law.moj.gov.tw/LawClass/LawAll.aspx?PCode=D0050074"));
                startActivity(ie4);
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ie5 = new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.gender.edu.tw/web/index.php/m7/m7_02_01_01?sid=74#"));
                startActivity(ie5);
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ie6 = new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.stu.ntou.edu.tw/sq/Page_Show.asp?Page_ID=1243"));
                startActivity(ie6);
            }
        });
    }

    private void loadBackdrop() {
        final ImageView imageView = (ImageView) findViewById(R.id.backdrop);
        Glide.with(this).load(R.drawable.imggender).centerCrop().into(imageView);
    }
}
