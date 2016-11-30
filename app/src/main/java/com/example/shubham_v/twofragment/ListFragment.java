package com.example.shubham_v.twofragment;


import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment {

       ListView listView  = null;
       final String[] FRUITS = new String[]{"avocado","apple", "Banana",
            "Coconut","Blueberries", "durian"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        container.removeAllViewsInLayout();

        Log.d("ListFragment", "onCreateView: ListFragment");
        View view =  inflater.inflate(R.layout.fragment_list, container, false);
        listView = (ListView)view.findViewById(R.id.list_item);


        view.setBackgroundColor(Color.LTGRAY);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity().getApplicationContext(), android.R.layout.simple_list_item_1, FRUITS);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Toast.makeText(getActivity(), ((TextView) view).getText(), Toast.LENGTH_SHORT).show();

                String clickedFruit = (String) adapterView.getItemAtPosition(i);


                com.example.shubham_v.twofragment.InfoFragment infoFragment = new com.example.shubham_v.twofragment.InfoFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();



                if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
                    fragmentTransaction.replace(R.id.fragment2_place_Id,infoFragment).addToBackStack(null).commit();
                    Bundle bundle = new Bundle();
                    bundle.putString("Fruitsname", clickedFruit);
                    infoFragment.setArguments(bundle);
                }

                if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
                    fragmentTransaction.replace(R.id.fragment_place_Id,infoFragment).addToBackStack(null).commit();
                    Bundle bundle = new Bundle();
                    bundle.putString("Fruitsname", clickedFruit);
                    infoFragment.setArguments(bundle);
                }




            }
        });
       return view;
    }

}
