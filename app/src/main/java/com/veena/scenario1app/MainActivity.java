package com.veena.scenario1app;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import layout.RecyclerViewFragment;
import layout.ButtonFragment;
import layout.RecyclerViewClickFragment;
import layout.TextViewFragment;
import layout.ViewPagerFragment;


public class MainActivity extends FragmentActivity implements HorizontalAdapterInterface {

    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_container, RecyclerViewFragment.newInstance(), "recyclerView")
                    .add(R.id.fragment_container1, ViewPagerFragment.newInstance(),"viewPager")
                    .add(R.id.fragment_container2, TextViewFragment.newInstance(), "textView")
                    .add(R.id.fragment_container3, RecyclerViewClickFragment.newInstance(""), "recyclerViewClick")
                    .add(R.id.fragment_container4, ButtonFragment.newInstance(), "button")
                    .commit();
        }

    }

    @Override
    public void viewItemClicked(String text) {
        RecyclerViewClickFragment recyclerViewClickFragment =
                (RecyclerViewClickFragment) getSupportFragmentManager().findFragmentByTag("recyclerViewClick");

        if (recyclerViewClickFragment != null) {
            Log.d(TAG, "viewItemClicked: recyclerViewClick available");
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container3, RecyclerViewClickFragment.newInstance(text), "recyclerViewClick")
                    .commit();
        } else {
            Log.d(TAG, "viewItemClicked: recyclerViewClick not available");
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_container3, RecyclerViewClickFragment.newInstance(text), "recyclerViewClick")
                    .commit();
        }
    }
}
