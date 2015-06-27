package com.madgeek.devonaward.lossantosweeklyslammer;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import com.parse.Parse;
import com.parse.ParseObject;
import com.parse.ParseQueryAdapter;


/**
 * Created by devonaward on 6/26/15.
 */
public class HelpWanted extends ActionBarActivity {

    TextView titleTxt;
    ParseQueryAdapter parseQueryAdapter;
    HWCustomAdapter hwCustomAdapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.helpwanted_layout);

        titleTxt = (TextView) findViewById(R.id.titleTxt);
        titleTxt.setText("Help Wanted");

        Parse.initialize(this, "XGd07hN4HHLE9GJ3PvmkT1s2Hn2SGOSQm9UCTC7b", "E2H8zKaF9MHH8w3X5SxRHhiaJigxhZgXT2nFjLtZ");

        // Initialize main ParseQueryAdapter
        parseQueryAdapter = new ParseQueryAdapter<ParseObject>(this, "Slammer");
        parseQueryAdapter.setImageKey("MugShot");

        // Initialize the subclass of ParseQueryAdapter
        hwCustomAdapter = new HWCustomAdapter(this);

        // ListView and set initial view to mainAdapter
        listView = (ListView) findViewById(R.id.joblist);
        listView.setAdapter(parseQueryAdapter);
        parseQueryAdapter.loadObjects();

        if (listView.getAdapter() == parseQueryAdapter) {
            listView.setAdapter(hwCustomAdapter);
            hwCustomAdapter.loadObjects();
        } else {
            listView.setAdapter(parseQueryAdapter);
            parseQueryAdapter.loadObjects();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_lsw, menu);
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}


