package com.madgeek.devonaward.lossantosweeklyslammer;

import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class LSWS extends ActionBarActivity {

    ListView homeList;
    String[] itemTitle = {"Slammer", "Help Wanted", "This Week's News"};
    Integer[] imageID = {R.mipmap.ic_slammer, R.mipmap.ic_postjobs, R.mipmap.ic_twn};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lsws);

        //Setup custom adapter to display custom list view and OnClick functionality
        HomeListCustomAdapter adapter = new HomeListCustomAdapter(this, itemTitle, imageID);
        homeList = (ListView) findViewById(R.id.homelist);
        homeList.setAdapter(adapter);

        homeList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = itemTitle[+position];
                Toast.makeText(getApplicationContext(), selectedItem, Toast.LENGTH_SHORT).show();
            }
        });
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
