package com.madgeek.devonaward.lossantosweeklyslammer;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;
import java.net.URL;

/**
 * Created by devonaward on 7/1/15.
 */
public class CrewInfo extends ActionBarActivity {

    TextView crewName;
    TextView motto;
    TextView crewNumber;
    TextView crewFounder;
    TextView crewConsole;
    TextView crewTwitter;
    TextView crewAround;
    ImageView image;
    ImageView image2;
    Typeface typeface;
    Typeface typeface2;
    ProgressDialog pDialog;
    Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crewread_layout);

        //Getting textviews and applying custom fonts
        crewName = (TextView)findViewById(R.id.crewName);
        motto = (TextView)findViewById(R.id.crewMoto);
        crewNumber = (TextView)findViewById(R.id.crewNumber);
        crewFounder = (TextView)findViewById(R.id.crewFounders);
        crewConsole = (TextView)findViewById(R.id.crewConsole);
        crewTwitter = (TextView)findViewById(R.id.crewTwitter);
        crewAround = (TextView)findViewById(R.id.crewAround);
        motto = (TextView)findViewById(R.id.crewMoto);

        image = (ImageView)findViewById(R.id.crewImg);
        image2 = (ImageView)findViewById(R.id.crewImg2);

        typeface = Typeface.createFromAsset(getAssets(), "roboto_light.ttf");
        typeface2 = Typeface.createFromAsset(getAssets(), "copperplatelight.ttf");

        crewName.setTypeface(typeface2);
        crewNumber.setTypeface(typeface);
        crewFounder.setTypeface(typeface);
        crewConsole.setTypeface(typeface);
        crewTwitter.setTypeface(typeface);
        crewAround.setTypeface(typeface);
        motto.setTypeface(typeface2);

        Bundle extras = getIntent().getExtras();

        String crewname;
        String logo;
        String crewpic;
        String mottotxt;
        String founders;
        int members;
        String console;
        String twittername;
        String beenaround;


        //Checking for data from previous activity
        //Putting received data in proper areas
       if (extras != null) {
           crewname = extras.getString("CrewName");
           logo = extras.getString("Logo");
           crewpic = extras.getString("CrewPic");
           mottotxt = extras.getString("Motto");
           founders = extras.getString("Founders");
           members = extras.getInt("Members");
           console = extras.getString("Console");
           twittername = extras.getString("TwitterName");
           beenaround = extras.getString("Around");

           crewName.setText(crewname);
           motto.setText(mottotxt);
           crewNumber.setText("Number of members: "+members);
           crewFounder.setText("Founders: "+founders);
           crewConsole.setText(console);
           crewTwitter.setText("Twitter: "+twittername);
           crewAround.setText(beenaround);
           new LoadImage().execute(logo);
           new LoadCrewPics().execute(crewpic);

        }

    }

    //Load image file from URL
    private class LoadImage extends AsyncTask<String, String, Bitmap> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(CrewInfo.this);
            pDialog.setMessage("Loading Crew Info...");
            pDialog.show();

        }
        protected Bitmap doInBackground(String... args) {

            try {
                bitmap = BitmapFactory.decodeStream((InputStream) new URL(args[0]).getContent());

            } catch (Exception e) {
                e.printStackTrace();
            }
            return bitmap;
        }

        protected void onPostExecute(Bitmap aimage) {

            if(image != null){
                image.setImageBitmap(aimage);
                pDialog.dismiss();

            }else{

                pDialog.dismiss();
                Toast.makeText(CrewInfo.this, "Unable to load crew", Toast
                        .LENGTH_SHORT).show();

            }
        }
    }

    //Load image file from URL
    private class LoadCrewPics extends AsyncTask<String, String, Bitmap> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }
        protected Bitmap doInBackground(String... args) {

            try {
                bitmap = BitmapFactory.decodeStream((InputStream) new URL(args[0]).getContent());

            } catch (Exception e) {
                e.printStackTrace();
            }
            return bitmap;
        }

        protected void onPostExecute(Bitmap aimage) {

            if(image2 != null){
                image2.setImageBitmap(aimage);
            }else{
                Toast.makeText(CrewInfo.this, "Unable to load crew", Toast
                        .LENGTH_SHORT).show();

            }
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
