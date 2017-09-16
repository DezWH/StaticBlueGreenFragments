package com.dez.staticbluegreenfragments;

import android.app.FragmentTransaction;
import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    //Create instances of our two fragments
    private GreenFragment greenFragment = new GreenFragment();
    private BlueFragment blueFragment = new BlueFragment();

    //Used to label the current Fragment displayed
    private static final String BLUE_TAG="BLUE";
    private static final String GREEN_TAG = "GREEN";

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        updateFragment(); //Initial update

        //add click listener to main window
        //android.R.id.conent is a built-in refernce to your Activity's main user interface components
        View v = findViewById(android.R.id.content);
        v.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                updateFragment();

            }
        });
    }

    private void updateFragment(){
        //TODO - swap fragments
}

    FragmentManger fm = getFragmentManager();
        //Request the FragmentManager begins a Fragment Transactions
        FragmentTransaction ft = fm.beginTransaction());

    //If blue Fragment is show, then replace with green fragment
    //Chekc if the FragmentManager is managing a fragment with the tag BLUE_TAG
    //If not, then replace whatever is there with the BlueFragement
    if (fm.findFragmentByTag(BLUE_TAG)) != null{
        //Carry out the transaction - in this case, replace one fragment with another
        //replace() removes all Fragements and replace with another Fragment
        //Add a string tag to the transaction.. (Can use to figure out what's displayed)
        ft.replac(android.R.id.content,greenFragment,GREEN_TAG);
        //And keep track of which Fragment is currently shown
        }

        //otherwise, the green fragment is currently showm. Replace with blue.
        else{
            //Add a tag to this Fragment, so that we are able to find out what fragment is displayed
            ft.replace(android.R.id.content, blueFragment, BLUE_TAG);
        }
        ft.commit(); //Must commit Fragment transaction or no changes will be made
        }
