package com.example.abdelsattar.mymovies;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;


public class detailMovie extends ActionBarActivity {


    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detail_movie);
        // Check that the activity is using the layout version with
        // the fragment_container FrameLayout
        if (savedInstanceState == null) {
            // Create the detail fragment and add it to the activity
            // using a fragment transaction.

            Bundle arguments = new Bundle();
            Bundle bundle = this.getIntent().getExtras();
            arguments.putString("title"       , bundle.getString("title"));
            arguments.putString("overview" , bundle.getString("overview"));
            arguments.putString("rating"   , bundle.getString("rating"));
            arguments.putString("rDate"    ,bundle.getString("rDate"));
            arguments.putString("id"       , bundle.getString("id"));
            arguments.putString("pURL"     , bundle.getString("pURL"));

            detailMovieFragment fragment = new detailMovieFragment();
            fragment.setArguments(arguments);

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.movie_detail_container, fragment)
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detail_movie, menu);
        return true;
    }


}
