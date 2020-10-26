package com.example.onboardapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPagerOnBoard;
    OnBoardViewPagerAdapter adapterOnBoard;
    TabLayout tabDotsOnBoard;
    int pageCount = 3;
    TextView tvGetStartedOnBoard, tvNextOnBoard, tvSignUpOnBoard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (restorePrefData()) {
            startActivity(new Intent(MainActivity.this, DestinationActivity.class));
            finish();
        }

        getUIReferences();
        setViewPager();
        setButtonClicks();


    }

    private void setButtonClicks() {

        tvNextOnBoard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPagerOnBoard.setCurrentItem((viewPagerOnBoard.getCurrentItem() + 1) % 3);
            }
        });

        tvSignUpOnBoard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MainActivity.this, DestinationActivity.class));
                savePrefsData();
                finish();

            }
        });

        tvGetStartedOnBoard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, DestinationActivity.class));
                savePrefsData();
                finish();
            }
        });
    }

    private boolean restorePrefData() {


        SharedPreferences pref = getApplicationContext().getSharedPreferences("view_pager", MODE_PRIVATE);
        return pref.getBoolean("is_viewed", false);
    }

    private void savePrefsData() {

        SharedPreferences pref = getApplicationContext().getSharedPreferences("view_pager", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean("is_viewed", true);
        editor.apply();
    }

    private void setViewPager() {

        List<OnBoardScreenItemModel> screenLists = new ArrayList<>();
        screenLists.add(new OnBoardScreenItemModel("Acadmey", "The best place to learn anything", R.drawable.demo_image));
        screenLists.add(new OnBoardScreenItemModel("Institue", "The best place to teach anything", R.drawable.demo_image));
        screenLists.add(new OnBoardScreenItemModel("Home", "The best place to Stay Safe ", R.drawable.demo_image));
        tabDotsOnBoard.setupWithViewPager(viewPagerOnBoard, true);
        adapterOnBoard = new OnBoardViewPagerAdapter(this, screenLists);
        viewPagerOnBoard.setAdapter(adapterOnBoard);

        viewPagerOnBoard.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                if (position == pageCount - 1) {
                    tvNextOnBoard.setVisibility(View.GONE);
                    tvGetStartedOnBoard.setVisibility(View.VISIBLE);
                } else {
                    tvNextOnBoard.setVisibility(View.VISIBLE);
                    tvGetStartedOnBoard.setVisibility(View.GONE);
                }
            }

            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });


    }

    private void getUIReferences() {
        viewPagerOnBoard =findViewById(R.id.idViewPagerOnBoard);
        tabDotsOnBoard = findViewById(R.id.idTabDotsOnBoard);
        tvNextOnBoard = findViewById(R.id.idTVNextOnBoard);
        tvNextOnBoard = findViewById(R.id.idTVNextOnBoard);
        tvSignUpOnBoard=findViewById(R.id.idTVSignUpOnBoard);
        tvGetStartedOnBoard = findViewById(R.id.idTVGetStartedOnBoard);
    }
}