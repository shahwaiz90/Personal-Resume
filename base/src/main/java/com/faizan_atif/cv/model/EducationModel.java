package com.faizan_atif.cv.model;

import android.widget.ImageView;
import android.widget.TextView;

public class EducationModel {
    public String degreeRank;
    public String universityName;
    public String year;
    public int instituteLogo;

    public EducationModel(String degreeRank, String universityName, String year, int instituteLogo) {
        this.degreeRank =  degreeRank;
        this.universityName = universityName;
        this.year = year;
        this.instituteLogo = instituteLogo;
    }
}
