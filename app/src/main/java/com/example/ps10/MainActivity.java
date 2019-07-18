package com.example.ps10;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ArrayList<Fragment> al;
    MyFragmentPagerAdapter adapter;
    ViewPager vPager;
    Button btnReadLater;
    Integer currentPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vPager = findViewById(R.id.vp);
        btnReadLater = findViewById(R.id.btnLater);
        FragmentManager fm = getSupportFragmentManager();
        al = new ArrayList<Fragment>();
        al.add(new frag1());
        al.add(new Frag2());
        al.add(new frag3());
        adapter = new MyFragmentPagerAdapter(fm, al);
        vPager.setAdapter(adapter);


        btnReadLater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
                Intent i = new Intent(MainActivity.this, Receiver.class);
                PendingIntent pIntent = PendingIntent.getBroadcast(MainActivity.this, 1, i, 0);
                Calendar cal = Calendar.getInstance();
                cal.add(Calendar.MINUTE, 1);
                am.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), pIntent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_previous) {
            if (vPager.getCurrentItem() > 0){
                int previous = vPager.getCurrentItem() - 1;
                vPager.setCurrentItem(previous, true);
            }
        } else if (item.getItemId() == R.id.action_random) {
            Random random = new Random();
            int page = random.nextInt(vPager.getChildCount());
            vPager.setCurrentItem(page, true);
        } else if (item.getItemId() == R.id.action_next) {
            int max = vPager.getChildCount();
            if (vPager.getCurrentItem() < max-1){
                int next = vPager.getCurrentItem() + 1;
                vPager.setCurrentItem(next, true);
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor prefEdit = prefs.edit();
        currentPage = vPager.getCurrentItem();
        prefEdit.putInt("current", currentPage);
        prefEdit.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        currentPage = prefs.getInt("current", -1);
        vPager.setCurrentItem(currentPage);
    }


}
