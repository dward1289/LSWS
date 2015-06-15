package com.madgeek.devonaward.lossantosweeklyslammer;

import android.content.Context;
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

        public SlammerListCustomAdapter(Context context) {
            // Use the QueryFactory to construct a PQA that will only show
            // Todos marked as high-pri
            super(context, new ParseQueryAdapter.QueryFactory<ParseObject>() {
                public ParseQuery create() {
                    ParseQuery query = new ParseQuery("Slammer");
                    return query;
                }
            });
        }

        // Customize the layout by overriding getItemView
        @Override
        public View getItemView(ParseObject object, View v, ViewGroup parent) {
            if (v == null) {
                v = View.inflate(getContext(), R.layout.listview_item, null);
            }

            super.getItemView(object, v, parent);

            // Add and download the image
            ParseImageView todoImage = (ParseImageView) v.findViewById(R.id.mugshotImg);
            ParseFile imageFile = object.getParseFile("MugShot");
            if (imageFile != null) {
                todoImage.setParseFile(imageFile);
                todoImage.loadInBackground();
            }

            TextView nameTextView = (TextView) v.findViewById(R.id.name);
            nameTextView.setText(object.getString("Name"));

            TextView rankTextView = (TextView) v.findViewById(R.id.rank);
            rankTextView.setText(String.valueOf(object.getInt("Rank")));

            TextView crewTextView = (TextView) v.findViewById(R.id.crew);
            crewTextView.setText(object.getString("Crew"));

            TextView consoleTextView = (TextView) v.findViewById(R.id.console);
            consoleTextView.setText(object.getString("Console"));


            return v;
        }

}

