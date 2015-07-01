package com.madgeek.devonaward.lossantosweeklyslammer;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import com.parse.Parse;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQueryAdapter;

/**
 * Created by devonaward on 7/1/15.
 */
public class Crew extends ActionBarActivity {

    TextView titleTxt;
    TextView crewTxt;
    private ParseQueryAdapter<ParseObject> parseQueryAdapter;
    private CrewCustomAdapter crewCustomAdapter;
    private GridView listView;
    Typeface roboto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crewmain_layout);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        titleTxt = (TextView) findViewById(R.id.titleTxt);
        crewTxt = (TextView) findViewById(R.id.crewTxt);
        titleTxt.setText("Crews");

        roboto = Typeface.createFromAsset(getAssets(), "roboto_light.ttf");
        crewTxt.setTypeface(roboto);


        Parse.initialize(this, "XGd07hN4HHLE9GJ3PvmkT1s2Hn2SGOSQm9UCTC7b", "E2H8zKaF9MHH8w3X5SxRHhiaJigxhZgXT2nFjLtZ");

        // Initialize main ParseQueryAdapter
        parseQueryAdapter = new ParseQueryAdapter<ParseObject>(this, "Crews");
        parseQueryAdapter.setImageKey("Logo");

        // Initialize the subclass of ParseQueryAdapter
        crewCustomAdapter = new CrewCustomAdapter(this);

        // ListView and set initial view to mainAdapter
        listView = (GridView) findViewById(R.id.gridView);
        listView.setAdapter(parseQueryAdapter);
        parseQueryAdapter.loadObjects();

        if (listView.getAdapter() == parseQueryAdapter) {
            listView.setAdapter(crewCustomAdapter);
            crewCustomAdapter.loadObjects();
        } else {
            listView.setAdapter(parseQueryAdapter);
            parseQueryAdapter.loadObjects();
        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //Get data from selected item
                ParseObject object = (ParseObject)listView.getItemAtPosition(position);
                String crewName = object.getString("CrewName");
                ParseFile image = object.getParseFile("Logo");
                ParseFile image2 = object.getParseFile("CrewPics");
                String motto = object.getString("Motto");
                String founders = object.getString("Founders");
                int numberMem  = object.getInt("CrewMembers");
                String console = object.getString("Console");
                String twitterName = object.getString("CrewTwitter");
                String aroundSince = object.getString("AroundSince");

                //Send data to next activity
                Intent i = new Intent(Crew.this, CrewInfo.class);
                i.putExtra("CrewName",crewName);
                i.putExtra("Logo",image.getUrl());
                i.putExtra("CrewPic",image2.getUrl());
                i.putExtra("Motto",motto);
                i.putExtra("Founders",founders);
                i.putExtra("Members",numberMem);
                i.putExtra("Console",console);
                i.putExtra("TwitterName",twitterName);
                i.putExtra("Around",aroundSince);
                startActivity(i);

            }
        });
    }
}