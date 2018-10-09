package com.example.joey.slippoint;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MyPagerAdapter extends PagerAdapter {
    private Context context;
    private int bgres[]={R.drawable.citybg,R.drawable.summer,R.drawable.sunnyday};

    MyPagerAdapter(Context context){
        this.context=context;
    }

    @Override
    public int getCount() {
        return bgres.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view==o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view=View.inflate(context,R.layout.imageview,null);
        ImageView imageView=view.findViewById(R.id.image);
        Glide.with(context).load(bgres[position]).into(imageView);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
