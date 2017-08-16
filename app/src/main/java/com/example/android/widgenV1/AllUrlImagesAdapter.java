package com.example.android.widgenV1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Don on 8/5/2017.
 */

public class AllUrlImagesAdapter extends RecyclerView.Adapter
        <AllUrlImagesAdapter.PlantListHolder> {

//    public static final String MY_PREFS_NAME = "MyPrefsFile";

    private ArrayList<AllUrlImagesPlantForListing> plantsList;
    private Context context;

    public AllUrlImagesAdapter(Context context, ArrayList<AllUrlImagesPlantForListing> plantsList) {
        this.context = context;
        this.plantsList = plantsList;

    }


    @Override
    public PlantListHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.activity_all_url_images_individual_layout,viewGroup,false);
        return new PlantListHolder(view);
    }

    @Override
    public void onBindViewHolder(PlantListHolder holder, int position) {
        holder.scientificName.setText(plantsList.get(position).getScientificName());
//        holder.percentScore.setText(plantsList.get(position).getPercentScore());
        holder.familyName.setText(plantsList.get(position).getFamilyName());
        Picasso.with(context).load(plantsList.get(position).getImageUrl())
                .error(R.drawable.default_image)
                .into(holder.plantImage);
    }

    @Override
    public int getItemCount() {
        System.out.println("Inside class PlantListHolder: plantList.size - " + plantsList.size());
        return plantsList.size();
    }

    public class PlantListHolder extends RecyclerView.ViewHolder {
        TextView scientificName;
//        TextView percentScore;
        TextView familyName;
        ImageView plantImage;

        public PlantListHolder(View view) {
            super(view);
            scientificName = (TextView) view.findViewById(R.id.scientificName_all_url);
//            percentScore = (TextView) view.findViewById(R.id.percentScore);
            familyName = (TextView) view.findViewById(R.id.familyName_rv_all_url);
            plantImage = (ImageView) view.findViewById(R.id.icon_rv_all_url);
//            Start PlantProfile activity onItemClick
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String plantForProfile;
                    plantForProfile = scientificName.getText().toString();
                    Context context = v.getContext();
                    Intent i = new Intent(context, PlantProfile.class);
                    i.putExtra("plantForProfile", plantForProfile);

                    context.startActivity(i);
                }
            });

            System.out.println("Inside class PlantListHolder");

        }
    }
}
