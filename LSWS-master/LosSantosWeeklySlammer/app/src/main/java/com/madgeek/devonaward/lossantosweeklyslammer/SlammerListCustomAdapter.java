package com.madgeek.devonaward.lossantosweeklyslammer;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.parse.ParseFile;
import com.parse.ParseImageView;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseQueryAdapter;

/**
 * Created by devonaward on 6/14/15.
 */
public class SlammerListCustomAdapter extends ParseQueryAdapter<ParseObject> {

    Typeface cop;
    Typeface roboto;
    Context context;

        public SlammerListCustomAdapter(Context context) {

            super(context, new ParseQueryAdapter.QueryFactory<ParseObject>() {
                public ParseQuery create() {
                    ParseQuery query = new ParseQuery("Slammer");
                    return query;
                }
            });
            cop = Typeface.createFromAsset(context.getAssets(), "copperplatelight.ttf");
            roboto = Typeface.createFromAsset(context.getAssets(), "roboto_light.ttf");
        }

        // Customize the layout by overriding getItemView
        @Override
        public View getItemView(ParseObject object, View v, ViewGroup parent) {
            if (v == null) {
                v = View.inflate(getContext(), R.layout.listview_item, null);
            }

            super.getItemView(object, v, parent);

            // Add and download the image
            ParseImageView theImage = (ParseImageView) v.findViewById(R.id.mugshotImg);
            ParseFile imageFile = object.getParseFile("MugShot");
            if (imageFile != null) {
                theImage.setParseFile(imageFile);
                theImage.loadInBackground();
            }

            // Get all textviews
            // Set text and font
            TextView nameTextView = (TextView) v.findViewById(R.id.name);
            nameTextView.setText(object.getString("Name"));

            TextView rankTextView = (TextView) v.findViewById(R.id.rank);
            rankTextView.setText(String.valueOf(object.getInt("Rank")));

            TextView crewTextView = (TextView) v.findViewById(R.id.crew);
            crewTextView.setText(object.getString("Crew"));

            TextView consoleTextView = (TextView) v.findViewById(R.id.console);
            consoleTextView.setText(object.getString("Console"));

            TextView wantedTextView = (TextView) v.findViewById(R.id.wanted);
            wantedTextView.setText(object.getString("WantedFor"));

            TextView specialTextView = (TextView) v.findViewById(R.id.special);
            specialTextView.setText(object.getString("Specialties"));

            TextView favTextView = (TextView) v.findViewById(R.id.fav);
            favTextView.setText(object.getString("FavWeapon"));

            TextView killTextView = (TextView) v.findViewById(R.id.kill);
            killTextView.setText(String.valueOf(object.getInt("PlayerKills")));

            TextView bankTextView = (TextView) v.findViewById(R.id.bank);
            bankTextView.setText(String.valueOf(object.getString("Bank")));

            TextView workTextView = (TextView) v.findViewById(R.id.work);
            workTextView.setText(String.valueOf(object.getString("Unemployed")));

            TextView name = (TextView) v.findViewById(R.id.nameTxt);
            TextView rank = (TextView) v.findViewById(R.id.rankTxt);
            TextView crew = (TextView) v.findViewById(R.id.crewTxt);
            TextView console = (TextView) v.findViewById(R.id.consoleTxt);
            TextView wanted = (TextView) v.findViewById(R.id.wantedTxt);
            TextView special = (TextView) v.findViewById(R.id.specialTxt);
            TextView fw = (TextView) v.findViewById(R.id.favTxt);
            TextView kill = (TextView) v.findViewById(R.id.killTxt);
            TextView cb = (TextView) v.findViewById(R.id.bankTxt);
            TextView aw = (TextView) v.findViewById(R.id.workTxt);

            workTextView.setTypeface(roboto);
            bankTextView.setTypeface(roboto);
            killTextView.setTypeface(roboto);
            favTextView.setTypeface(roboto);
            specialTextView.setTypeface(roboto);
            wantedTextView.setTypeface(roboto);
            consoleTextView.setTypeface(roboto);
            crewTextView.setTypeface(roboto);
            rankTextView.setTypeface(roboto);
            nameTextView.setTypeface(roboto);

            aw.setTypeface(cop);
            cb.setTypeface(cop);
            kill.setTypeface(cop);
            fw.setTypeface(cop);
            special.setTypeface(cop);
            wanted.setTypeface(cop);
            console.setTypeface(cop);
            crew.setTypeface(cop);
            rank.setTypeface(cop);
            name.setTypeface(cop);


            return v;
        }

}

