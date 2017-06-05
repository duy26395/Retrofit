package com.example.duy.retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by duy on 05/06/2017.
 */

public class data2 {
    @Expose
    @SerializedName("data")
    Data data;

    public Data getData() {
        return data;
    }
}
