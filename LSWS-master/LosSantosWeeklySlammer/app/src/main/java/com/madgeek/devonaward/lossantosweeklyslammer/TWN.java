package com.madgeek.devonaward.lossantosweeklyslammer;


import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by devonaward on 6/26/15.
 */
public class TWN extends ActionBarActivity{

    ImageView twnImg;
    ListView twnList;
    String[] itemTitle = {"News", "Events", "Crews"};
    Integer[] imageID = {R.mipmap.ic_twn, R.mipmap.ic_events, R.mipmap.ic_crews};
    Typeface typeface;
    TextView introTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.twn_layout);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        introTxt = (TextView)findViewById(R.id.twnw);
        typeface = Typeface.createFromAsset(getAssets(), "roboto_light.ttf");
        introTxt.setTypeface(typeface);

        //Get image view and change everyday
        twnImg = (ImageView)findViewById(R.id.twnimage);
        dayImage();

        //Setup custom adapter to display custom list view and OnClick functionality
        HomeListCustomAdapter adapter = new HomeListCustomAdapter(this, itemTitle, imageID);
        twnList = (ListView) findViewById(R.id.twnlist);
        twnList.setAdapter(adapter);

        twnList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = itemTitle[+position];
                Toast.makeText(getApplicationContext(), selectedItem, Toast.LENGTH_SHORT).show();

                if(selectedItem == "News"){
                    Intent i = new Intent(TWN.this, News.class);
                    startActivity(i);
                }else if(selectedItem == "Crews"){
                    Intent i = new Intent(TWN.this, Crew.class);
                    startActivity(i);
                }

            }
        });

    }

    //Image switch for each day of the week
    public void dayImage(){
        Calendar calendar = Calendar.getInstance();
        String weekDay;
        //Format the day to string form
        SimpleDateFormat dayFormat = new SimpleDateFormat("EEEE", Locale.US);;
        weekDay = dayFormat.format(calendar.getTime());

        switch (weekDay) {
            case "Sunday":
                twnImg.setImageResource(R.drawable.sunday);
                break;
            case "Monday":
                twnImg.setImageResource(R.drawable.monday);
                break;
            case "Tuesday":
                twnImg.setImageResource(R.drawable.tuesday);
                break;
            case "Wednesday":
                twnImg.setImageResource(R.drawable.wednesday);
                break;
            case "Thursday":
                twnImg.setImageResource(R.drawable.thursday);
                break;
            case "Friday":
                twnImg.setImageResource(R.drawable.friday);
                break;
            case "Saturday":
                twnImg.setImageResource(R.drawable.saturday);
                break;
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
