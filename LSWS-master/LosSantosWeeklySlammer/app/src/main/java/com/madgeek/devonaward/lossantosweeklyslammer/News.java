package com.madgeek.devonaward.lossantosweeklyslammer;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.GetCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseQueryAdapter;

/**
 * Created by devonaward on 6/27/15.
 */
public class News extends ActionBarActivity {

    TextView titleTxt;
    private ParseQueryAdapter<ParseObject> parseQueryAdapter;
    private NCustomAdapter nCustomAdapter;
    private GridView listView;
    TextView slammerTextView;
    Typeface roboto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newsmain_layout);

        titleTxt = (TextView) findViewById(R.id.titleTxt);
        titleTxt.setText("News");

        roboto = Typeface.createFromAsset(getAssets(), "roboto_light.ttf");


        Parse.initialize(this, "XGd07hN4HHLE9GJ3PvmkT1s2Hn2SGOSQm9UCTC7b", "E2H8zKaF9MHH8w3X5SxRHhiaJigxhZgXT2nFjLtZ");

        // Initialize main ParseQueryAdapter
        parseQueryAdapter = new ParseQueryAdapter<ParseObject>(this, "News");
        parseQueryAdapter.setImageKey("Image");

        // Initialize the subclass of ParseQueryAdapter
        nCustomAdapter = new NCustomAdapter(this);

        // ListView and set initial view to mainAdapter
        listView = (GridView) findViewById(R.id.gridView);
        listView.setAdapter(parseQueryAdapter);
        parseQueryAdapter.loadObjects();

        if (listView.getAdapter() == parseQueryAdapter) {
            listView.setAdapter(nCustomAdapter);
            nCustomAdapter.loadObjects();
        } else {
            listView.setAdapter(parseQueryAdapter);
            parseQueryAdapter.loadObjects();
        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


            }
        });
    }
}





