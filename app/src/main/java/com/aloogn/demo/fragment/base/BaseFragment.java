package com.aloogn.demo.fragment.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.aloogn.demo.R;


public class BaseFragment extends Fragment{
    private Context context;

    protected ViewGroup base;

    //内容
    protected LinearLayout contentLayout;
    //标题栏 加载框
    private LinearLayout loadLayout;
    private RelativeLayout topLayout;
    //左图片 右图片
    private ImageView leftIcon,rightIcon;
    //左标题 右标题 中标题
    private TextView leftText,rightText,tvTitle,loadText;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if(null != base){
            ViewGroup parent =  ((ViewGroup)base.getParent());
            if(null != parent){
                parent.removeView(base);
            }
        }else{
            base = (ViewGroup)inflater.inflate(R.layout.fragment_base,null) ;

            topLayout = (RelativeLayout)base.findViewById(R.id.base_fragment_top_layout);
            contentLayout = (LinearLayout)base.findViewById(R.id.base_fragment_content_layout);
            loadLayout = (LinearLayout)base.findViewById(R.id.base_fragment_content_layout);

            leftIcon = (ImageView)base.findViewById(R.id.base_fragment_left_icon);
            leftText = (TextView) base.findViewById(R.id.base_fragment_left_text);

            tvTitle = (TextView)base.findViewById(R.id.base_fragment_title);

            rightIcon = (ImageView)base.findViewById(R.id.base_fragment_right_icon);
            rightText = (TextView) base.findViewById(R.id.base_fragment_right_text);
        }
        return base;
    }

    //设置是否显示标题栏
    public void setTopVisible(int visible){
        topLayout.setVisibility(visible);
    }

    //设置标题
    public void setTitle(String title){
        tvTitle.setText(title);
    }

    //设置是否显示左图标
    public void setLeftIconVisible(int visible){
        leftIcon.setVisibility(visible);
    }

    //设置左图标
    public void setLeftIcon(int resource){
        leftIcon.setImageResource(resource);
    }

    //设置是否显示右图标
    public void setRightIconVisible(int visible){
        rightIcon.setVisibility(visible);
    }

    //设置右图标
    public void setRightIcon(int resource){
        rightIcon.setImageResource(resource);
    }
}
