package com.example.android.widgenV1;

/**
 * Created by Don on 8/5/2017.
 */

public class Plant {
    private String scientificName;
    private String percentScore;
    private String familyName;
    private String imageUrl;

    public String getScientificName () {
        return scientificName;
    }
    public void setScientificName (String scientificName) {
        this.scientificName = scientificName;
    }

    public String getPercentScore () {
        return percentScore;
    }
    public void setPercentScore (String percentScore) {
        this.percentScore = percentScore;
    }

    public String getFamilyName () { return familyName;}
    public void setFamilyName (String familyName) {this.familyName = familyName;}


    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {this.imageUrl = imageUrl;
    }

}
