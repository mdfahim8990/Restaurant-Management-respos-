package com.example.respos;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.net.wifi.aware.DiscoverySession;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


import com.example.respos.OderDetailsAPIs.Data;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private TabLayout tabLayout;
    protected ViewPager2 viewPagers2;
    ModelClass body;
    private int data;
    BadgeDrawable badgeDrawable;
    BadgeDrawable badgeDrawablek;

    public void CountNumber(int count){
        badgeDrawable.setNumber(count);
    }

    public void CountNumberkitchen(int countt){
        badgeDrawablek.setNumber(countt);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Log.e(TAG, "Main Activity:" +body.getData().size());
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar;
        actionBar = getSupportActionBar();
        actionBar.setTitle("Respos");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        //toolbar.getNavigationIcon().setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);        //Back button enable
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPagers2 = findViewById(R.id.viewPager);
        viewPagers2.setAdapter(new PageAdepter(this));

        /*setupViewPager(viewPagers);*/
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        /*tabLayout.setupWithViewPager(viewPagers);*/
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(tabLayout, viewPagers2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position) {
                    case 0: {
                        tab.setText("New Order");
                        tab.setIcon(R.drawable.ic_pending);
                         badgeDrawable = tab.getOrCreateBadge();
                        badgeDrawable.setBackgroundColor(
                                ContextCompat.getColor(getApplicationContext(), R.color.black)

                        );
                        badgeDrawable.setVisible(true);
                       // badgeDrawable.setNumber(2);
                        break;
                    }
                    case 1: {
                        tab.setText("In Kitchen");
                        tab.setIcon(R.drawable.ic_kitchen);
                         badgeDrawablek = tab.getOrCreateBadge();
                        badgeDrawablek.setBackgroundColor(
                                ContextCompat.getColor(getApplicationContext(), R.color.black)

                        );
                        badgeDrawablek.setVisible(true);
                       // badgeDrawablek.setNumber(2);
                        break;
                    }
                    case 2: {
                        tab.setText("All Activer");
                        tab.setIcon(R.drawable.ic_active);
                        BadgeDrawable badgeDrawable = tab.getOrCreateBadge();
                        badgeDrawable.setBackgroundColor(
                                ContextCompat.getColor(getApplicationContext(), R.color.black)

                        );
                        badgeDrawable.setVisible(true);
                        badgeDrawable.setNumber(0);
                        break;
                    }
                    case 3: {
                        tab.setText("Today's Order");
                        tab.setIcon(R.drawable.ic_today);
                        BadgeDrawable badgeDrawable = tab.getOrCreateBadge();
                        badgeDrawable.setBackgroundColor(
                                ContextCompat.getColor(getApplicationContext(), R.color.black)

                        );
                        badgeDrawable.setVisible(true);
                        badgeDrawable.setNumber(0);
                        break;
                    }
                    case 4: {
                        tab.setText("Delivering");
                        tab.setIcon(R.drawable.ic_delivering);
                        BadgeDrawable badgeDrawable = tab.getOrCreateBadge();
                        badgeDrawable.setBackgroundColor(
                                ContextCompat.getColor(getApplicationContext(), R.color.black)

                        );
                        badgeDrawable.setVisible(true);
                        badgeDrawable.setNumber(0);

                        break;
                    }
                    case 5: {
                        tab.setText("Delivered");
                        tab.setIcon(R.drawable.ic_deliverd);
                        BadgeDrawable badgeDrawable = tab.getOrCreateBadge();
                        badgeDrawable.setBackgroundColor(
                                ContextCompat.getColor(getApplicationContext(), R.color.black)

                        );
                        badgeDrawable.setVisible(true);
                        badgeDrawable.setNumber(0);
                        break;
                    }
                    case 6: {
                        tab.setText("Rejected");
                        tab.setIcon(R.drawable.rejected);
                        BadgeDrawable badgeDrawable = tab.getOrCreateBadge();
                        badgeDrawable.setBackgroundColor(
                                ContextCompat.getColor(getApplicationContext(), R.color.black)

                        );
                        badgeDrawable.setVisible(true);
                        badgeDrawable.setNumber(0);
                        break;
                    }

                }
            }
        });
        tabLayoutMediator.attach();

    }


    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

}