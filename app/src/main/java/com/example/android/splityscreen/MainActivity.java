package com.example.android.splityscreen;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends FragmentActivity implements
        OneFragment.OneFragmentListener,TwoFragment.TwoFragmentListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    @Override
    public void onOneButtonClick(String text) {
        TwoFragment twoFragment = (TwoFragment) getSupportFragmentManager()
                .findFragmentById(R.id.two_fragment);
        Log.e(MainActivity.class.getSimpleName(),"oneeeeee:"+text);
        twoFragment.onechangeTextProperties(text);
    }
    @Override
    public void onTwoButtonClick(String text) {
        OneFragment textFragment = (OneFragment) getSupportFragmentManager()
                .findFragmentById(R.id.one_fragment);
        Log.e(MainActivity.class.getSimpleName(),"twoooooo:"+text);
        textFragment.twochangeTextProperties(text);
    }
}