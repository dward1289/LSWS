package com.madgeek.devonaward.lossantosweeklyslammer;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseQueryAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by devonaward on 6/8/15.
 */
public class Slammer extends ActionBarActivity {

    TextView titleTxt;
    private ParseQueryAdapter<ParseObject> parseQueryAdapter;
    private SlammerListCustomAdapter slammerListCustomAdapter;
    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.slammer_layout);

        titleTxt = (TextView) findViewById(R.id.titleTxt);
        titleTxt.setText("Slammer");

        Parse.initialize(this, "XGd07hN4HHLE9GJ3PvmkT1s2Hn2SGOSQm9UCTC7b", "E2H8zKaF9MHH8w3X5SxRHhiaJigxhZgXT2nFjLtZ");

        // Initialize main ParseQueryAdapter
        parseQueryAdapter = new ParseQueryAdapter<ParseObject>(this, "Slammer");
        parseQueryAdapter.setImageKey("MugShot");

        // Initialize the subclass of ParseQueryAdapter
        slammerListCustomAdapter = new SlammerListCustomAdapter(this);

        // Initialize ListView and set initial view to mainAdapter
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





