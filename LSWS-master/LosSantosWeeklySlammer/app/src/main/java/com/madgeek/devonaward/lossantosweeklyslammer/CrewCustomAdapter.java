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
 * Created by devonaward on 7/1/15.
 */
public class CrewCustomAdapter extends ParseQueryAdapter<ParseObject> {

    Typeface cop;
    Typeface roboto;

    public CrewCustomAdapter(Context context) {

        super(context, new ParseQueryAdapter.QueryFactory<ParseObject>() {
            public ParseQuery create() {
                ParseQuery query = new ParseQuery("Crews");
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
            v = View.inflate(getContext(), R.layout.gridsingle_layout, null);
        }

        super.getItemView(object, v, parent);

        // Add and download the image
        ParseImageView theImage = (ParseImageView) v.findViewById(R.id.grid_image);
        ParseFile imageFile = object.getParseFile("Logo");
        if (imageFile != null) {
            theImage.setParseFile(imageFile);
            theImage.loadInBackground();
        }

        // Get all textviews
        // Set text and font
        TextView title = (TextView) v.findViewById(R.id.grid_text);
        title.setText(object.getString("CrewName"));

        title.setTypeface(cop);


        return v;
    }

}

