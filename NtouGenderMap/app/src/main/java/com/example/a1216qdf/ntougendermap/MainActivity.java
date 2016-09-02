package com.example.a1216qdf.ntougendermap;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.github.clans.fab.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        MarkFragment.OnFragmentInteractionListener, MapFragment.OnFragmentInteractionListener,
        RouteFragment.OnFragmentInteractionListener {

    public TextView textView;
    private FloatingActionButton fab12,fab22;
    private static final int    Size    = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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


        fab12 = (FloatingActionButton)findViewById(R.id.fab12);
        fab22 = (FloatingActionButton)findViewById(R.id.fab22);
        fab12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,RouteActivity.class);
                startActivityForResult(intent, Size);
            }
        });
        textView = (TextView)findViewById(R.id.textView);
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

        if (id == R.id.nav_FriendlyMap) {

        } else if (id == R.id.nav_PhysiologicalMap) {
            PhysiologicalMap();
        } else if (id == R.id.nav_GenderInformation) {
            GenderInfor();
        } else if (id == R.id.nav_SOSCall) {
            SOSCall();
        } else if (id == R.id.nav_SOSBell) {
            SOSBell();
        } else if (id == R.id.nav_send) {
        } else if (id == R.id.nav_send) {

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

    private void PhysiologicalMap(){
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
        Uri uri = Uri.parse(("tel:0952875757"));
        Intent intent = new Intent(Intent.ACTION_CALL, uri);
        if (ContextCompat.checkSelfPermission(MainActivity.this, android.Manifest.permission.CALL_PHONE) ==
                PackageManager.PERMISSION_GRANTED) {
            startActivity(intent);
        }
    }

    private void SOSBell() {
        MediaPlayer ringsong = new MediaPlayer();
        ringsong.reset();
        ringsong = MediaPlayer.create(MainActivity.this, R.raw.ring); //播放歌曲源
        ringsong.start(); //開始播放
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
}
