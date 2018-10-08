package com.example.joey.slippoint;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class SlipPoint extends LinearLayout {
    private static final String TAG = "SlipPoint";

    private Context context;
    private int pointNum;
    private LinearLayout layout;
    private View view;
    private Boolean isAutoSlide;
    private int delayTime;
    private int currentItem;
    private int pointSize;
    private Handler handler=new Handler();

    public SlipPoint(Context context) {
        super(context);
        this.context=context;
        initView(context);
    }

    public SlipPoint(Context context,AttributeSet attrs) {
        super(context, attrs);
        this.context=context;
        TypedArray typedArray=context.obtainStyledAttributes(attrs,R.styleable.slippoint);
        pointSize=typedArray.getInt(R.styleable.slippoint_point_size,20);
        typedArray.recycle();
        initView(context);
    }

    public SlipPoint(Context context,AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context=context;
        initView(context);
    }

    private void initView(Context context) {

        view=LayoutInflater.from(context).inflate(R.layout.slip_point,this,true);
        layout=view.findViewById(R.id.slippoint_layout);
        pointNum=1;
        isAutoSlide=false;
        currentItem=1;
    }

    public SlipPoint setNum(int pointNum){
        this.pointNum=pointNum;
        return this;
    }

    public SlipPoint setAutoSlide(Boolean isAutoSlide){
        this.isAutoSlide=isAutoSlide;
        return this;
    }

    public SlipPoint setDelayTime(int delayTime){
        this.delayTime=delayTime;
        return this;
    }

    public void create(){
        for (int i=0;i<pointNum;i++){
            View view=new View(context);
            view.setBackgroundResource(R.drawable.indicator);
            if(i==0){
                view.setEnabled(true);
            }else {
                view.setEnabled(false);
            }
            LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(pointSize,pointSize);
            params.leftMargin=10;
            layout.addView(view,params);
        }

        if(isAutoSlide){
            startAutoSlide();
        }

    }

    private void startAutoSlide(){
        handler.removeCallbacks(task);
        handler.postDelayed(task,delayTime);
    }

    private final Runnable task = new Runnable() {
        @Override
        public void run() {
            if(isAutoSlide){
                for(int i=0;i<pointNum;i++){
                    layout.getChildAt(i).setEnabled(false);
                }
                layout.getChildAt(currentItem).setEnabled(true);
                if(currentItem!=pointNum-1){
                    currentItem ++;
                }else {
                    currentItem=0;
                }
                handler.postDelayed(task,delayTime);
            }
        }
    };

}