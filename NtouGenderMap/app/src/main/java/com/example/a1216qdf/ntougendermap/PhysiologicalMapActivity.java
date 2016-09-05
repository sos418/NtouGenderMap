package com.example.a1216qdf.ntougendermap;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.qozix.tileview.TileView;

import java.util.ArrayList;

public class PhysiologicalMapActivity extends AppCompatActivity {


    public TileView tileView;
    public ImageView babyImg,loveImg,loveImg1,carImg,nightImg,nightImg1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_physiological_map);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        babyImg = new ImageView(this);
        babyImg.setImageResource(R.drawable.mbaby);
        loveImg = new ImageView(this);
        loveImg.setImageResource(R.drawable.mlove);
        loveImg1 = new ImageView(this);
        loveImg1.setImageResource(R.drawable.mlove);
        carImg = new ImageView(this);
        carImg.setImageResource(R.drawable.mcar);
        nightImg = new ImageView(this);
        nightImg.setImageResource(R.drawable.mnight);
        nightImg1 = new ImageView(this);
        nightImg1.setImageResource(R.drawable.mnight);


        tileView = (TileView)findViewById(R.id.tileView1);
        tileView.setSize( 2160, 3840 );  // the original size of the untiled image

        tileView.addDetailLevel( 1.0000f, "tiles/ntou/1000/%d_%d.png" );
        tileView.setMarkerAnchorPoints( -0.5f, -0.5f );
        tileView.setScale( 0.2500f );

        tileView.addMarker( babyImg, 1414, 2557, null, null );
        tileView.addMarker( loveImg, 1329, 2557, null, null );
        tileView.addMarker( loveImg1, 746, 1306, null, null );
        tileView.addMarker( carImg, 1292, 1616, null, null );
        tileView.addMarker( nightImg, 418, 1872, null, null );
        tileView.addMarker( nightImg1, 78, 1932, null, null );

        tileView.drawPath( points.subList( 0, 2 ), null );
        tileView.drawPath( points.subList( 1, 3 ), null );
        tileView.drawPath( points.subList( 2, 4 ), null );
        tileView.drawPath( points.subList( 3, 5 ), null );
        tileView.drawPath( points.subList( 4, 6 ), null );
        tileView.drawPath( points.subList( 5, 7 ), null );
        tileView.drawPath( points.subList( 6, 8 ), null );
        tileView.drawPath( points.subList( 7, 9 ), null );
    }

    private ArrayList<double[]> points = new ArrayList<>();

    {
        points.add( new double[] {644, 1366} );
        points.add( new double[] {567, 1366} );
        points.add( new double[] {563, 1656} );
        points.add( new double[] {648, 1656} );
        points.add( new double[] {648, 1772} );
        points.add( new double[] {633, 2036} );
        points.add( new double[] {965, 1772} );
        points.add( new double[] {965, 2036} );
        points.add( new double[] {965, 2441} );
    }

}
