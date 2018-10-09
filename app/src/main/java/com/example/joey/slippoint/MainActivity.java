package com.example.joey.slippoint;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SlipPoint slipPoint=findViewById(R.id.slippoint);
        ViewPager viewPager =findViewById(R.id.view_pager);

        MyPagerAdapter adapter=new MyPagerAdapter(this);
        viewPager.setAdapter(adapter);

        slipPoint.bindViewPager(viewPager,adapter);
        slipPoint
                //.setNum(7)
                .setDelayTime(2000)
                .setAutoSlide(true)
                .create();


    }


}
