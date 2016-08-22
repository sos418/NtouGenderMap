package com.example.a1216qdf.ntougendermap;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.qozix.tileview.TileView;

public class PhysiologicalMapActivity extends AppCompatActivity {


    public TileView tileView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_physiological_map);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        tileView = (TileView)findViewById(R.id.tileView1);
        tileView.setSize( 2160, 3840 );  // the original size of the untiled image

        tileView.addDetailLevel( 1.0000f, "tiles/ntou/1000/%d_%d.png" );
        tileView.setMarkerAnchorPoints( -0.5f, -0.5f );
        tileView.setScale( 0.2500f );

    }

}
