package com.example.android.widgenV1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Don on 10/14/2016.
 */

public class CharacterImageAdapter extends ArrayAdapter<CharacterImageLabel> {

    public CharacterImageAdapter(Context context, ArrayList<CharacterImageLabel> breadItem) {
        super(context, 0, breadItem);
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position The position in the list of data that should be displayed in the
     *                 list item view.
     * @param convertView The recycled view to populate.
     * @param parent The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.character_image_label,parent,false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        CharacterImageLabel currentCharacterImageLabel = getItem(position);

        // Find the TextView in the main_bread_list.xml layout with the bread_name
        TextView characterLabelTextView = (TextView) listItemView.findViewById(R.id.image_label);

        characterLabelTextView.setText(currentCharacterImageLabel.getLabel());

        ImageView breadIcon = (ImageView) listItemView.findViewById(R.id.image_icon);

        breadIcon.setImageResource(currentCharacterImageLabel.getImageResource());

        return listItemView;
    }
}
