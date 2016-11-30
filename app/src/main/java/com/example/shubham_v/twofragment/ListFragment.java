package com.example.shubham_v.twofragment;


import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
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
       final String[] FRUITS = new String[]{"apple ", "avocado", "Banana",
            "Blueberries", "Coconut", "durian"};

      /* final  String[] FRUITSDESCRIPTION =
            new String[]{"Apples are obtained from medium-sized tree belonging to the Rosaceae family",
                    "Avocado The avocado (Persea americana) is a tree that is native to South Central Mexico, classified as a member of the flowering plant family Lauraceae",
                    "Banana  are the most popular fruit in the world. The banana is, in fact, not a tree but a high herb that grows up to 15 metres. ",
                    "Blueberries whether it is wild or cultivated have the same colour skin - dark navy-blue to blue-black",
                    "Coconut palm is a long-lived plant that may live as long as 100 years",
                    "durian The durian (/ˈdjʊriən/) is the fruit of several tree species belonging to the genus Durio."};
*/


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
                fragmentTransaction.replace(R.id.fragment_place_Id,infoFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

                Bundle bundle = new Bundle();
                bundle.putString("Fruitsname", clickedFruit);
                infoFragment.setArguments(bundle);


            }
        });
       return view;
    }






}
