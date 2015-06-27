package com.madgeek.devonaward.lossantosweeklyslammer;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.ParseException;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by devonaward on 6/26/15.
 */
public class HelpWanted extends ActionBarActivity {


    TextView titleTxt;
    JSONArray theData;
    ProgressDialog dialog;
    //URL to get JSON Array
    private static String url;
    String jobName;
    String jobDescription;
    String jobRank;
    String jobReward;

    //MOST IMPORTANT BECAUSE IT HOLDS ALL OF THE DATA
    private static final String TAG_RESULTED = "jobs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.helpwanted_layout);

        titleTxt = (TextView) findViewById(R.id.titleTxt);
        titleTxt.setText("Help Wanted");

        url = "https://gist.githubusercontent" +
                ".com/dward1289/d51c9d5c534db442bf34/raw/9fa90300c246753fb905f8ac57c3e64ca5244af1/LSWS_Job_Listing";
        //Get the data
        new GetData().execute();
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

    //Get the data and display from API
    private class GetData extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Log.i("WORKING", "WORKING ON IT...");
            // Showing progress dialog
            dialog = ProgressDialog.show(HelpWanted.this, "",
                    "Loading jobs. Please wait...", true);
        }

        @Override
        protected Void doInBackground(Void... arg0) {
            //Setup the service
            JSONParser jsonParser = new JSONParser();

            //Make the request for data
            String jsonStr = jsonParser.makeServiceCall(url, JSONParser.GET);

            Log.d("Response: ", "> " + jsonStr);

            if (jsonStr != null) {
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);

                    //Getting JSON Array
                    theData = jsonObj.getJSONArray(TAG_RESULTED);

                    //Loop through data
                    for (int i = 0; i < theData.length(); i++) {
                        JSONObject c = theData.getJSONObject(i);

                        jobName = c.getString("name");
                        jobDescription = c.getString("description");
                        jobRank = c.getString("rank");
                        jobReward = c.getString("reward");
                        Log.i("API WORKING DATA", jobName);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            } else {
                Log.e("ServiceHandler", "Couldn't get any data from the url");
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            Log.i("API WORKING 2", "GREAT");
            dialog.dismiss();

        }
    }
}


