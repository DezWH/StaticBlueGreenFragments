package com.dez.staticbluegreenfragments;

/**
 * Created by danne on 9/16/2017.
 */

//import android.app.Fragment;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class GreenFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.green_fragment, container, false);

        int random = -1;

        //Check to seee if argument have been received - if so, get random nmber
        if (getArguments() != null) {
            random = getArguments().getInt(MainActivity.RANDOM_BUNDLE_KEY, -1); //default for no random number
        }
        TextView showRandomTV = (TextView) view.findViewById(R.id.green_fragment_random_textview);

            if (random == -1) {
                //No random number received, no arguments or no data for RANDOM_BUNDLE_KEY
                showRandomTV.setText("No random number received :(");
            } else {
                showRandomTV.setText("The random number is" + random);
            }
            return view;

        }
    }



