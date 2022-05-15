
package com.example.respos.OderDetailsAPIs;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class OrderDetailsModelClass {

    @SerializedName("status")
    @Expose
    public Boolean status;
    @SerializedName("message")
    @Expose
    public String message;
    @SerializedName("data")
    @Expose
    public Data data;

}
