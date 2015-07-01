package com.madgeek.devonaward.lossantosweeklyslammer;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.widget.ListView;
import android.widget.TextView;

import com.parse.Parse;
import com.parse.ParseObject;
import com.parse.ParseQueryAdapter;


/**
 * Created by devonaward on 6/8/15.
 */
public class Slammer extends ActionBarActivity {

    TextView titleTxt;
    private ParseQueryAdapter<ParseObject> parseQueryAdapter;
    private SlammerListCustomAdapter slammerListCustomAdapter;
    private ListView listView;
    TextView slammerTextView;
    Typeface roboto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.slammer_layout);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        titleTxt = (TextView) findViewById(R.id.titleTxt);
        titleTxt.setText("Slammer");

        roboto = Typeface.createFromAsset(getAssets(), "roboto_light.ttf");

        slammerTextView = (TextView)findViewById(R.id.slammerw);
        slammerTextView.setTypeface(roboto);

        Parse.initialize(this, "XGd07hN4HHLE9GJ3PvmkT1s2Hn2SGOSQm9UCTC7b", "E2H8zKaF9MHH8w3X5SxRHhiaJigxhZgXT2nFjLtZ");

        // Initialize main ParseQueryAdapter
        parseQueryAdapter = new ParseQueryAdapter<ParseObject>(this, "Slammer");
        parseQueryAdapter.setImageKey("MugShot");

        // Initialize the subclass of ParseQueryAdapter
        slammerListCustomAdapter = new SlammerListCustomAdapter(this);

        // ListView and set initial view to mainAdapter
        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(parseQueryAdapter);
        parseQueryAdapter.loadObjects();

        if (listView.getAdapter() == parseQueryAdapter) {
            listView.setAdapter(slammerListCustomAdapter);
            slammerListCustomAdapter.loadObjects();
        } else {
            listView.setAdapter(parseQueryAdapter);
            parseQueryAdapter.loadObjects();
        }

        }
    }





