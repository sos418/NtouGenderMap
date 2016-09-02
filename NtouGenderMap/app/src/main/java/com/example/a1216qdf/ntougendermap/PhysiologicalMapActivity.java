package com.example.a1216qdf.ntougendermap;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.qozix.tileview.TileView;

import java.util.ArrayList;

public class PhysiologicalMapActivity extends AppCompatActivity {


    public TileView tileView;
    public ImageView imageView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_physiological_map);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        imageView1 = new ImageView(this);
        imageView1.setImageResource(R.drawable.water);



        tileView = (TileView)findViewById(R.id.tileView1);
        tileView.setSize( 2160, 3840 );  // the original size of the untiled image

        tileView.addDetailLevel( 1.0000f, "tiles/ntou/1000/%d_%d.png" );
        tileView.setMarkerAnchorPoints( -0.5f, -0.5f );
        tileView.setScale( 0.2500f );

        tileView.addMarker( imageView1, 1400, 2300, null, null );

        tileView.drawPath( points.subList( 0, 2 ), null );
        tileView.drawPath( points.subList( 1, 3 ), null );
    }

    private ArrayList<double[]> points = new ArrayList<>();

    {
        points.add( new double[] {1100, 1920} );
        points.add( new double[] {600,1920} );
        points.add( new double[] {600, 1100} );


    }

}
