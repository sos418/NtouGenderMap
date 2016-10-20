package com.example.a1216qdf.ntougendermap;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a1216qdf.ntougendermap.intro.DefaultIntro;
import com.github.clans.fab.FloatingActionButton;
import com.qozix.tileview.TileView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        MarkFragment.OnFragmentInteractionListener, MapFragment.OnFragmentInteractionListener,
        RouteFragment.OnFragmentInteractionListener {

    public TextView textView;
    private FloatingActionButton fab12, fab22,fab32;
    private static final int Size = 3;
    private LocationManager locationManager;
    private Location location;
    private ImageView locationImage;
    private TileView tileView;
    public final static int REQUEST_CODE_GPS_PERMISSIONS = 0;
    public final static int REQUEST_CODE_CALL_PERMISSIONS = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //  Declare a new thread to do a preference check
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                //  Initialize SharedPreferences
                SharedPreferences getPrefs = PreferenceManager
                        .getDefaultSharedPreferences(getBaseContext());

                //  Create a new boolean and preference and set it to true
                boolean isFirstStart = getPrefs.getBoolean("firstStart", true);

                //  If the activity has never started before...
                if (isFirstStart) {

                    //  Launch app intro
                    Intent i = new Intent(MainActivity.this, DefaultIntro.class);
                    startActivity(i);

                    //  Make a new preferences editor
                    SharedPreferences.Editor e = getPrefs.edit();

                    //  Edit preference to make it false because we don't want this to run again
                    e.putBoolean("firstStart", false);

                    //  Apply changes
                    e.apply();
                }
            }
        });

        // Start the thread
        t.start();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        if (viewPager != null) {
            setupViewPager(viewPager);
        }
        viewPager.setCurrentItem(1);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);


        fab12 = (FloatingActionButton) findViewById(R.id.fab12);
        fab22 = (FloatingActionButton) findViewById(R.id.fab22);
        fab32 = (FloatingActionButton) findViewById(R.id.fab32);
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        fab12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, RouteActivity.class);
                startActivityForResult(intent, Size);
            }
        });
        fab22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tileView = (TileView) findViewById(R.id.tileView);
                locationImage = new ImageView(MainActivity.this);
                locationImage.setImageResource(R.drawable.mgarbage);

                String s = LocationManager.GPS_PROVIDER;
                if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                location = locationManager.getLastKnownLocation(s);
                locationManager.requestLocationUpdates(s,0,0,locationListener);
                tileView.addMarker(locationImage,121.773265, 25.150501,null,null);
                Toast toast = Toast.makeText(MainActivity.this,"" + location.getLatitude()+"," + location.getLongitude(),Toast.LENGTH_LONG);
                toast.show();

            }
        });
        fab32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RouteActivity.class);
                startActivityForResult(intent, Size);
            }
        });
        textView = (TextView) findViewById(R.id.textView);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

       if (id == R.id.nav_PhysiologicalMap) {
            PhysiologicalMap();
        } else if (id == R.id.nav_GenderInformation) {
            GenderInfor();
        } else if (id == R.id.nav_SOSCall) {
            SOSCall();
        } else if (id == R.id.nav_SOSBell) {
            SOSBell();
        } else if (id == R.id.nav_AppRate) {
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void setupViewPager(ViewPager viewPager) {
        Adapter adapter = new Adapter(getSupportFragmentManager());

        adapter.addFragment(new MarkFragment(), "圖標");
        adapter.addFragment(new MapFragment(), "地圖");
        adapter.addFragment(new RouteFragment(), "路線");


        viewPager.setAdapter(adapter);
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    static class Adapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragments = new ArrayList<>();
        private final List<String> mFragmentTitles = new ArrayList<>();

        public Adapter(FragmentManager fm) {
            super(fm);
        }

        public void addFragment(Fragment fragment, String title) {
            mFragments.add(fragment);
            mFragmentTitles.add(title);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitles.get(position);
        }
    }

    private void PhysiologicalMap() {
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, PhysiologicalMapActivity.class);
        startActivity(intent);
    }

    private void GenderInfor() {
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, GenderInforActivity.class);
        startActivity(intent);
    }

    private void SOSCall() {
        Uri uri = Uri.parse(("tel:0224622192"));
        Intent intent = new Intent(Intent.ACTION_CALL, uri);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this,new String[] {Manifest.permission.CALL_PHONE},REQUEST_CODE_CALL_PERMISSIONS);
            return;
        }
        startActivity(intent);

    }

    private void SOSBell() {
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, SosBellActivity.class);
        MediaPlayer ringsong = new MediaPlayer();
        ringsong.reset();
        ringsong = MediaPlayer.create(MainActivity.this, R.raw.ring);
        ringsong.start();
        startActivity(intent);
    }
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        if (resultCode == RESULT_OK) {
//            switch (requestCode) {
//
//                case Size:
//
//                    Bundle E = data.getExtras();
//                    String ssss = E.getString("Size");
//                    textView.setText(ssss);
//
//                    break;
//
//                default:
//                    break;
//            }
//
//        }
//
//    }

    private LocationListener locationListener = new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {

        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {

        }
    };

    private void GetLocation(){
        tileView = (TileView) findViewById(R.id.tileView);
        locationImage = new ImageView(MainActivity.this);
        locationImage.setImageResource(R.drawable.mapgetlocation);


        if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            ActivityCompat.requestPermissions(MainActivity.this,new String[] {Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION},REQUEST_CODE_GPS_PERMISSIONS);
            return;
        }
        String s = LocationManager.GPS_PROVIDER;
        location = locationManager.getLastKnownLocation(s);
        locationManager.requestLocationUpdates(s,0,0,locationListener);

        if (location!=null){
            tileView.addMarker(locationImage,location.getLongitude(),location.getLatitude(),null,null);
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE_GPS_PERMISSIONS:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Permission Granted
                    GetLocation();
                } else {
                    // Permission Denied
                    Toast.makeText(MainActivity.this, "LOCATION Denied", Toast.LENGTH_SHORT)
                            .show();
                }
                break;
            case REQUEST_CODE_CALL_PERMISSIONS:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Permission Granted
                    SOSCall();
                } else {
                    // Permission Denied
                    Toast.makeText(MainActivity.this, "CALL Denied", Toast.LENGTH_SHORT)
                            .show();
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }
}
