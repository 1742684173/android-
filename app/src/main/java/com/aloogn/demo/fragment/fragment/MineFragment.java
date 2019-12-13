package com.aloogn.demo.fragment.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aloogn.demo.R;
import com.aloogn.demo.fragment.base.BaseFragment;


public class MineFragment extends BaseFragment {
    private View curView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        if (null != curView) {
            ((ViewGroup) curView.getParent()).removeView(curView);

            return curView;
        }
        curView = inflater.inflate(R.layout.fragment_mine, contentLayout,true);
        //(TextView)curView.findViewById(R.id.tt_fragment_my_account);
        return curView;
    }
}
