package com.example.shubham_v.twofragment;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;


/**
 * A simple {@link Fragment} subclass.
 */
public class InfoFragment extends Fragment {

    TextView  fruit_lable;
    ImageView fruit_Image;
    TextView   fruit_description_scroll_view;

    final String[] FRUITS = new String[]{"apple ", "avocado", "Banana",
            "blueberries", "coconut", "durian"};

    final String[] FRUITSDESCRIPTION =
            new String[]{"Apples are obtained from medium-sized tree belonging to the Rosaceae family",
                    "Avocado The avocado (Persea americana) is a tree that is native to South Central Mexico, classified as a member of the flowering plant family Lauraceae",
                    "Banana  are the most popular fruit in the world. The banana is, in fact, not a tree but a high herb that grows up to 15 metres. ",
                    "Blueberries whether it is wild or cultivated have the same colour skin - dark navy-blue to blue-black",
                    "Coconut palm is a long-lived plant that may live as long as 100 years",
                    "durian The durian (/ˈdjʊriən/) is the fruit of several tree species belonging to the genus Durio."};


    public HashMap<String, FruitsDetail> FRUITHASHMAP = new HashMap<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_info, container, false);
        fruit_lable = (TextView) view.findViewById(R.id.fruit_id);
        fruit_Image = (ImageView)view.findViewById(R.id.imageView);
        fruit_description_scroll_view = (TextView) view.findViewById(R.id.scroll_TextView_id);


        int ImageId = getResources().getIdentifier(FruitsListDataHandaling().toLowerCase(), "drawable", getContext().getPackageName());

        fruit_Image.setImageResource(ImageId);
        fruit_lable.setText(FruitsListDataHandaling());

          fruitDetailHandling();
          FruitsDetail fruitsDetailfroScrollview = new  FruitsDetail();
          fruitsDetailfroScrollview  =  FRUITHASHMAP.get(FruitsListDataHandaling());
          fruit_description_scroll_view.setText(fruitsDetailfroScrollview.getFruitDescription());


        return view;
    }




   void fruitDetailHandling() {

        for (int i = 0; i < FRUITS.length; i++) {

            FruitsDetail fruitsDetail = new FruitsDetail();

            fruitsDetail.setFruitName(FRUITS[i]);
            fruitsDetail.setFruitDescription(FRUITSDESCRIPTION[i]);
            FRUITHASHMAP.put(FRUITS[i], fruitsDetail);

        }
    }




    String FruitsListDataHandaling() {
        String incomingFruitName = null;
        Bundle bundle = getArguments();
        if (bundle != null) {

             incomingFruitName = bundle.getString("Fruitsname");

            Toast.makeText(getContext(), " the fruit is " + incomingFruitName, Toast.LENGTH_LONG).show();

        }
        return incomingFruitName;
    }

}
