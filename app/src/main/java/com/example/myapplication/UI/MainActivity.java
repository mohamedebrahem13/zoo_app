package com.example.myapplication.UI;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import androidx.core.view.ViewCompat;
import androidx.viewpager2.widget.ViewPager2;


import com.example.myapplication.Adapter.viewpageradapter;
import com.example.myapplication.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.Locale;


public class MainActivity extends AppCompatActivity {
    private String[]FragmentsName;

viewpageradapter viewpageradapter;
    TabLayout tabLayout;
boolean rtl;
    ViewPager2 viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.viewpager);
        tabLayout=findViewById(R.id.taplayout);
       rtl = isRTL();
       if (rtl){
           FragmentsName = getResources().getStringArray(R.array.tapsarabic);
       }else {
           FragmentsName = getResources().getStringArray(R.array.taps);

       }
        viewpageradapter=new viewpageradapter(getSupportFragmentManager(),getLifecycle());
        viewPager.setAdapter(viewpageradapter);
        new TabLayoutMediator(tabLayout, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(FragmentsName[position]);


            }
        }).attach();
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener(){

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });





    }

    public static boolean isRTL() {
        return isRTL(Locale.getDefault());
    }

    public static boolean isRTL(Locale locale) {
        final int directionality = Character.getDirectionality(locale.getDisplayName().charAt(0));
        return directionality == Character.DIRECTIONALITY_RIGHT_TO_LEFT ||
                directionality == Character.DIRECTIONALITY_RIGHT_TO_LEFT_ARABIC;
    }
    }



