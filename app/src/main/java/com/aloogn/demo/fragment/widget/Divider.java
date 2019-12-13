package com.aloogn.demo.fragment.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.aloogn.demo.R;

public class Divider extends LinearLayout {

    public Divider(Context context) {
        super(context);
        initView(context);
    }

    public Divider(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
//        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.dividerArrts);
//
//        int height = typedArray.getInteger(R.styleable.dividerArrts_height,1);
//        int color = typedArray.getInteger(R.styleable.dividerArrts_color,R.color.colorGray);
//
//        typedArray.recycle();
        initView(context);
    }

    public Divider(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    public Divider(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView(context);
    }

    private void initView(Context context){
        LayoutInflater.from(context).inflate(R.layout.divider,this,true);

    }
}
