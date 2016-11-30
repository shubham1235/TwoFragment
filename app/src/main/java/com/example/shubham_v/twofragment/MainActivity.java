package com.example.shubham_v.twofragment;

import android.app.*;
import android.app.FragmentManager;
import android.app.ListFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        com.example.shubham_v.twofragment.ListFragment fragment = new com.example.shubham_v.twofragment.ListFragment();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_place_Id,fragment);
        fragmentTransaction.commit();

    }


    @Override
    public void onBackPressed() {

        if(getFragmentManager().getBackStackEntryCount()>0)
        {
            getFragmentManager().popBackStack();
        }

        else
        {
            super.onBackPressed();
        }

    }
}
