package com.example.android.widgenV1;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Arrays;

import com.example.android.widgenV1.CircleDrawable;
import com.squareup.picasso.Picasso;

import static com.example.android.widgenV1.R.array.imageUrl;

/**
 * Created by Don on 10/14/2016.
 */

public class CustomListAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String [] itemname;
    private final int[] resID;
    private String[] imageUrlArray;
//    CircleDrawable circle;
    private ImageView imageView;
    private int i = 0;
    private int indexOfItemName = 0;
    private final String [] scientificName;
    private String [] rateMatch;

    /*This Adapter displays the stored image in the imageView if it is available via its
    * resource id (int [] resID). If no image is available, it displays image from the webpage
    * via string url from String [] imageUrlArray.*/

    public CustomListAdapter(Activity context, String [] itemname, String [] rateMatch, int[] resID,
                             String [] scientificName ,String [] imageUrlArray)
    {
        super(context, R.layout.activity_plant_list_with_layout, itemname);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.itemname=itemname;
        this.resID=resID;
        this.imageUrlArray=imageUrlArray;
        this.scientificName=scientificName;
        this.rateMatch=rateMatch;
    }
    public View getView(int position,View view,ViewGroup parent) {

        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.activity_plant_list_with_layout, null,true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.scientificName);
        TextView percentMatch = (TextView) rowView.findViewById(R.id.percentMatch);
        imageView = (ImageView) rowView.findViewById(R.id.icon);

        txtTitle.setText(itemname[position]);
        percentMatch.setText(rateMatch[position]+"%");
        if (resID[position] == 0) {
            indexOfItemName = Arrays.asList(scientificName).indexOf(itemname[position]);
            loadImageFromUrl(imageUrlArray[indexOfItemName]);
        } else {
            imageView.setImageResource(resID[position]);
        }
        System.out.println("itemName - " + itemname[position]);
        System.out.println("indexOfItemName - " + indexOfItemName);
        System.out.println("this is run " + i);
//        System.out.println("position array size - " + positionArray.length);
        i+=1;

        return rowView;
    };



    private void loadImageFromUrl(String url) {
        Picasso.with(context).load(url).placeholder(R.mipmap.ic_launcher)
                .error(R.drawable.default_image)
                .into(imageView, new com.squareup.picasso.Callback() {
                    @Override
                    public void onSuccess() {

                    }

                    @Override
                    public void onError() {

                    }
                });
    }
}
