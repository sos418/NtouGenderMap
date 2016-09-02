package com.example.a1216qdf.ntougendermap;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.qozix.tileview.TileView;

import java.util.ArrayList;

public class RouteActivity extends AppCompatActivity {

    private Button button;
    public TileView tileView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route);

        button = (Button)findViewById(R.id.button);
        tileView = (TileView)findViewById(R.id.tileView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(RouteActivity.this,MainActivity.class);
                String s = "單線繩";
                intent.putExtra("Size", s);
                setResult(RESULT_OK, intent);
                finish();

            }
        });
    }

    private ArrayList<double[]> points = new ArrayList<>();

    {
        points.add( new double[] {1, 2} );
        points.add( new double[] {3,6} );
        points.add( new double[] {7, 11} );
        points.add( new double[] {20,20} );
        points.add( new double[] {50, 50} );
        points.add( new double[] {60,90} );
        points.add( new double[] {100,150} );
        points.add( new double[] {200, 250} );
        points.add( new double[] {300, 388} );
        points.add( new double[] {1000,1000} );
        points.add( new double[] {1555,1500} );

    }
}
