package com.aloogn.demo.fragment;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;

import com.aloogn.demo.R;
import com.aloogn.demo.fragment.base.BaseActivity;
import com.aloogn.demo.fragment.widget.TabButton;

public class MainActivity extends BaseActivity implements TabButton.TabButtonClick {
    private Context context;
    private TabButton[] tabButtons;
    private Fragment[] fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LayoutInflater.from(this).inflate(R.layout.activity_main, baseContentLinearLayout,true);

        initTabButton();
        initFragment();
        setFragmentIndicator(0);


    }

    void initTabButton(){
        tabButtons = new TabButton[3];
        tabButtons[0] = findViewById(R.id.main_home);
        tabButtons[0].setIndex(0);
        tabButtons[0].setTitle("首页");
        tabButtons[0].setUnselectedImg(R.drawable.main_tab_unhome);
        tabButtons[0].setSelectedImg(R.drawable.main_tab_home);
        tabButtons[0].setTabButtonClick(this);
        tabButtons[0].setNotify(5);

        tabButtons[1] = findViewById(R.id.main_work);
        tabButtons[1].setIndex(1);
        tabButtons[1].setTitle("工作");
        tabButtons[1].setUnselectedImg(R.drawable.main_tab_unwork);
        tabButtons[1].setSelectedImg(R.drawable.main_tab_work);
        tabButtons[1].setTabButtonClick(this);

        tabButtons[2] = findViewById(R.id.main_mine);
        tabButtons[2].setIndex(2);
        tabButtons[2].setTitle("我的");
        tabButtons[2].setUnselectedImg(R.drawable.main_tab_unmine);
        tabButtons[2].setSelectedImg(R.drawable.main_tab_mine);
        tabButtons[2].setTabButtonClick(this);
    }

    void initFragment(){
        fragments = new Fragment[3];
        fragments[0] = getSupportFragmentManager().findFragmentById(R.id.main_fragment_home);
        fragments[1] = getSupportFragmentManager().findFragmentById(R.id.main_fragment_work);
        fragments[2] = getSupportFragmentManager().findFragmentById(R.id.main_fragment_mine);
    }

    public void setFragmentIndicator(int which) {
        /**
         FragmentManager manager = getSupportFragmentManager();
         FragmentTransaction transaction = manager.beginTransaction();
         Fragment1 fragment1 = new Fragment1();
         transaction.add(R.id.fragment_container, fragment1);
         transaction.commit();
         */
        getSupportFragmentManager()
                .beginTransaction()
                .hide(fragments[0])
                .hide(fragments[1])
                .hide(fragments[2])
                .show(fragments[which])
                .commit();

        tabButtons[0].setSelectedButton(false);
        tabButtons[1].setSelectedButton(false);
        tabButtons[2].setSelectedButton(false);

        tabButtons[which].setSelectedButton(true);
    }

    //返回时修改此Activity为启动窗口
    public void onBackPressed(){
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addCategory(Intent.CATEGORY_HOME);
        startActivity(intent);
    }

    @Override
    public void onTabClick(int index) {
        setFragmentIndicator(index);
    }

    @Override
    public void onNotifyClick() {

    }
}
