package com.madgeek.devonaward.lossantosweeklyslammer;

import android.app.Activity;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by devonaward on 6/3/15.
 * Custom adapter for the ListView on the main screen.
 */
public class HomeListCustomAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] listTitleName;
    private final Integer[] imgID;
    Typeface typeface;


    public HomeListCustomAdapter(Activity context, String[] listTitleName, Integer[] imgID){
    super(context, R.layout.homelist_customlayout, listTitleName);

        this.context = context;
        this.listTitleName = listTitleName;
        this.imgID = imgID;

    }

    public View getView(int position,View view, ViewGroup parent){
        LayoutInflater theInflater = context.getLayoutInflater();
        View rowView = theInflater.inflate(R.layout.homelist_customlayout, null, true);

        TextView menuTxt = (TextView)rowView.findViewById(R.id.menuName);
        //Set custom font: Copperplate Light
        typeface = Typeface.createFromAsset(context.getAssets(),"copperplatelight.ttf");
        menuTxt.setTypeface(typeface);
        ImageView menuImg = (ImageView)rowView.findViewById(R.id.iconTitle);

        menuTxt.setText(listTitleName[position]);
        menuImg.setImageResource(imgID[position]);
        return rowView;
    }
}
