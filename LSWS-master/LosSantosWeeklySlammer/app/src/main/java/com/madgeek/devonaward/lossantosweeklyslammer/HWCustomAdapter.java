package com.madgeek.devonaward.lossantosweeklyslammer;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseQueryAdapter;

/**
 * Created by devonaward on 6/27/15.
 */
public class HWCustomAdapter  extends ParseQueryAdapter<ParseObject>{

    Typeface cop;
    Typeface roboto;

    public HWCustomAdapter(Context context) {

        super(context, new ParseQueryAdapter.QueryFactory<ParseObject>() {
            public ParseQuery create() {
                ParseQuery query = new ParseQuery("JobListings");
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
            v = View.inflate(getContext(), R.layout.joblist_item, null);
        }

        super.getItemView(object, v, parent);


        // Get all textviews
        // Set text and font
        TextView name = (TextView) v.findViewById(R.id.jobName);
        name.setText(object.getString("Name"));

        TextView description = (TextView) v.findViewById(R.id.jdescription);
        description.setText(object.getString("Description"));

        TextView rank = (TextView) v.findViewById(R.id.rank);
        rank.setText(object.getString("Rank"));

        TextView reward = (TextView) v.findViewById(R.id.reward);
        reward.setText(object.getString("Reward"));

        TextView console = (TextView) v.findViewById(R.id.console);
        console.setText(object.getString("Console"));



        TextView rConsole = (TextView) v.findViewById(R.id.rConsole);
        TextView rRank = (TextView) v.findViewById(R.id.rRank);


        rConsole.setTypeface(roboto);
        rRank.setTypeface(roboto);
        console.setTypeface(roboto);
        reward.setTypeface(roboto);
        rank.setTypeface(roboto);
        description.setTypeface(roboto);

        name.setTypeface(cop);

        return v;
    }

}

