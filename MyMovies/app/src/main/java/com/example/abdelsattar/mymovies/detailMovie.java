package com.example.abdelsattar.mymovies;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


public class detailMovie extends AppCompatActivity {


    private static final String DETAILFRAGMENT_TAG = "DFTAG";
    private  boolean check =true;
    public  static int postion ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);

        if (savedInstanceState == null) {

            int id = getIntent()
                    .getIntExtra(detailMovieFragment.ID_KEY, 0);
            //int date = getIntent().getIntExtra(DetailsFragment.ID_KEY);
            Log.w("TWEETID", "" + id);

            Bundle args = new Bundle();
            args.putInt(detailMovieFragment.ID_KEY, id);

            detailMovieFragment fragment
                    =  detailMovieFragment.newInstance(args);

            getSupportFragmentManager().beginTransaction()
                     .add(R.id.movie_detail_container,
                             fragment)
                    .commit();
            }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detail_movie, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            startActivity(new Intent(this, SettingsActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
