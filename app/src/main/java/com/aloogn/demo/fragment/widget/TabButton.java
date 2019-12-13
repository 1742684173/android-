package com.aloogn.demo.fragment.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.aloogn.demo.R;

public class TabButton extends ConstraintLayout implements View.OnClickListener{
    private Context context;
    //图标
    private ImageView iconImageView;
    //标题和通知
    private TextView titleTextView,notifyTextView;


    private int index;
    //选中图片
    private int selectedImg;
    //未选中图片
    private int unselectedImg;
    //事件接口
    private TabButtonClick tabButtonClick;

    public TabButton(Context context) {
        this(context,null);
    }

    public TabButton(Context context, AttributeSet attrs) {
        this(context,attrs,0);
    }

    public TabButton(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;

        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.tab_button,this,true);

        iconImageView = (ImageView)findViewById(R.id.tab_button_icon);
        iconImageView.setOnClickListener(this);

        titleTextView = (TextView)findViewById(R.id.tab_button_title);
        titleTextView.setOnClickListener(this);

        notifyTextView = (TextView)findViewById(R.id.tab_button_notify);
        notifyTextView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.tab_button_icon:;
            case R.id.tab_button_title:
                tabButtonClick.onTabClick(getIndex());
                break;

            case R.id.tab_button_notify:break;
            default:break;
        }
    }

    public void setTabButtonClick(TabButtonClick tabButtonClick){
        this.tabButtonClick = tabButtonClick;
    }

    public abstract interface TabButtonClick {
        public abstract void onTabClick(int index);

        public abstract void onNotifyClick();
    }

    public int getIndex(){
        return index;
    }

    public void setIndex(int index){
        this.index = index;
    }

    public int getSelectedImg() {
        return selectedImg;
    }

    public void setSelectedImg(int selectedImg) {
        this.selectedImg = selectedImg;
    }

    public int getUnselectedImg() {
        return unselectedImg;
    }

    public void setUnselectedImg(int unselectedImg) {
        this.unselectedImg = unselectedImg;
    }

    public void setTitle(String title){
        titleTextView.setText(title);
    }

    public void setSelectedButton(boolean select){

        if(select){
            iconImageView.setImageResource(selectedImg);
            titleTextView.setTextColor(getResources().getColor(R.color.colorBlue));
        }else{
            iconImageView.setImageResource(unselectedImg);
            titleTextView.setTextColor(getResources().getColor(R.color.colorBlack6));
        }
    }

    public void setNotify(int unreadNum){
        if(unreadNum == 0){
            notifyTextView.setVisibility(View.GONE);
            return;
        }

        String notify = "";
        if(unreadNum > 99){
            notify = "99+";
        }else {
            notify = Integer.toString(unreadNum);
        }

        notifyTextView.setText(notify);
        notifyTextView.setVisibility(View.VISIBLE);
    }
}
