package com.example.android.widgenV1;

/**
 * Created by Don on 10/14/2016.
 */

public class CharacterImageLabel {

    //       name of ingredient e.g. First class flour, Yeast, etc.
    private String mLabel;

    //    price of ingredient per gram, in case of egg its per piece, in case of
//    liquid ingredient, volume is converted to mass
    private int mImageResource;

    //    Create an object of type IngredientAndAmount
    public CharacterImageLabel(String label, int imageResource) {

        mImageResource = imageResource;
        mLabel = label;
    }

    //    make getter method to return ingredient and amount
    public String getLabel() {
        return mLabel;
    }

    public int getImageResource() {
        return mImageResource;
    }
}
