package com.example.android.widgenV1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by Don on 8/5/2017.
 */

public class PlantListRecyclerViewAdapter extends RecyclerView.Adapter
        <PlantListRecyclerViewAdapter.PlantListHolder> {

    public static final String MY_PREFS_NAME = "MyPrefsFile";

    private ArrayList<Plant> plantsList;
    private Context context;

    public PlantListRecyclerViewAdapter(Context context, ArrayList<Plant> plantsList) {
        this.context = context;
        this.plantsList = plantsList;

    }


    @Override
    public PlantListHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.activity_plant_list_with_layout_recycler_view,viewGroup,false);
        return new PlantListHolder(view);
    }

    @Override
    public void onBindViewHolder(PlantListHolder holder, int position) {
        holder.scientificName.setText(plantsList.get(position).getScientificName());
        holder.percentScore.setText(plantsList.get(position).getPercentScore());
        holder.familyName.setText(plantsList.get(position).getFamilyName());
        Picasso.with(context).load(plantsList.get(position).getImageUrl())
                .error(R.drawable.default_image)
                .fit().centerCrop()
                .into(holder.plantImage);
    }

    @Override
    public int getItemCount() {
        System.out.println("Inside class PlantListHolder: plantList.size - " + plantsList.size());
        return plantsList.size();
    }

    public class PlantListHolder extends RecyclerView.ViewHolder {
        TextView scientificName;
        TextView percentScore;
        TextView familyName;
        ImageView plantImage;

        public PlantListHolder(View view) {
            super(view);
            scientificName = (TextView) view.findViewById(R.id.scientificName);
            percentScore = (TextView) view.findViewById(R.id.percentScore);
            familyName = (TextView) view.findViewById(R.id.familyName_rv);
            plantImage = (ImageView) view.findViewById(R.id.icon_rv);
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
