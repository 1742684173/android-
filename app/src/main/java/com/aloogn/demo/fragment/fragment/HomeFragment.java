package com.aloogn.demo.fragment.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aloogn.demo.R;
import com.aloogn.demo.fragment.base.BaseFragment;

public class HomeFragment extends BaseFragment {

    private View curView;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater,container,savedInstanceState);


        if(null == curView){
            curView = inflater.inflate(R.layout.fragment_home,contentLayout);
            setTitle("首页");
            setLeftIconVisible(View.GONE);
        }

        return base;
    }

}
