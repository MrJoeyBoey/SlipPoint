package com.example.joey.slippoint;

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
       slipPoint.setNum(10)
                //.setAutoSlide(true)
                .setDelayTime(1000)
                .create();




    }


}
