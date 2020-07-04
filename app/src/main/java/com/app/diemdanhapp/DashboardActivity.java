package com.app.diemdanhapp;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.app.fragment.fragmentDashboardAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class DashboardActivity extends AppCompatActivity {

    LinearLayout scrollLayout;
    private fragmentDashboardAdapter mFragmentDashboardAdapter;
    private ViewPager mViewPager;

    List<Object> subList = new ArrayList<Object>();




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dasboard);
        scrollLayout = (LinearLayout) findViewById(R.id.scrollLayout);

        mFragmentDashboardAdapter = new fragmentDashboardAdapter(getSupportFragmentManager(),DashboardActivity.this);

        mViewPager = (ViewPager) findViewById(R.id.viewpage1);
        mViewPager.setAdapter(mFragmentDashboardAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tablayoutDashBoard);
        tabLayout.setupWithViewPager(mViewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_person);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_notifications_48);

        tabLayout.getTabAt(0).getIcon().setColorFilter(getResources().getColor(android.R.color.white), PorterDuff.Mode.SRC_IN);
        tabLayout.getTabAt(1).getIcon().setColorFilter(getResources().getColor(android.R.color.white), PorterDuff.Mode.SRC_IN);

    }


    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {

        super.onSaveInstanceState(savedInstanceState);


    }
}
