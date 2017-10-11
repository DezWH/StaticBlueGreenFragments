package com.dez.staticbluegreenfragments;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;



public class MainActivity extends AppCompatActivity implements BlueFragment.RandomNumberGeneratedListener {


    public static final String RANDOM_BUNDLE_KEY = "you_random_number";

    //Create instances of our two fragments
    private GreenFragment greenFragment = new GreenFragment();
    private BlueFragment blueFragment = new BlueFragment();


    //Used to label the current Fragment displayed
    private static final String BLUE_TAG = "BLUE";
    private static final String GREEN_TAG = "GREEN";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showBlueFragment(); //Need to show something to start with
    }

    private void showBlueFragment() {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(android.R.id.content, blueFragment, BLUE_TAG);
        ft.commit();
    }


    //Send the randdom number to the GreenFragment
    public void sendRandomNumber(int rnd) {
        //Create a Bundle to carry argument to the Fragment
        Bundle arguments = new Bundle();
        //add the random integer
        arguments.putInt(RANDOM_BUNDLE_KEY, rnd);
        //And give the arguments to our GreenFragment
        greenFragment.setArguments(arguments);


        //Replace the BlueFragment with the GreenFragment
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(android.R.id.content, greenFragment, GREEN_TAG);
        ft.addToBackStack(GREEN_TAG);
        ft.commit(); //Don't Foreget:

    }
}