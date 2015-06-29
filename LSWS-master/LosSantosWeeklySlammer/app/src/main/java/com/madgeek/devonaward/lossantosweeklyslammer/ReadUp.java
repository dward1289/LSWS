package com.madgeek.devonaward.lossantosweeklyslammer;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;
import java.net.URL;

/**
 * Created by devonaward on 6/28/15.
 */
public class ReadUp extends ActionBarActivity {

    TextView titleTxt;
    TextView article;
    ImageView image;
    Typeface typeface;
    Typeface typeface2;
    ProgressDialog pDialog;
    Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.readup_layout);

        //Getting textviews and applying custom fonts
        titleTxt = (TextView)findViewById(R.id.tTxt);
        article = (TextView)findViewById(R.id.aTxt);
        image = (ImageView)findViewById(R.id.articleImg);
        typeface = Typeface.createFromAsset(getAssets(), "roboto_light.ttf");
        typeface2 = Typeface.createFromAsset(getAssets(), "copperplatelight.ttf");
        titleTxt.setTypeface(typeface2);
        article.setTypeface(typeface);

        Bundle extras = getIntent().getExtras();
        String rTitle;
        String rArticle;
        String rImage;

        //Checking for data from previous activity
        //Putting received data in proper areas
        if (extras != null) {
            rTitle = extras.getString("title");
            rImage = extras.getString("image");
            rArticle = extras.getString("article");

            titleTxt.setText(rTitle);
            new LoadImage().execute(rImage);
            article.setText(rArticle);

        }

    }

    //Load image file from URL
    private class LoadImage extends AsyncTask<String, String, Bitmap> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(ReadUp.this);
            pDialog.setMessage("Loading Article...");
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
                Toast.makeText(ReadUp.this, "Unable to load image", Toast
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
