
package com.example.respos.OderDetailsAPIs;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Addon {

    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("order_id")
    @Expose
    public Integer orderId;
    @SerializedName("addon_id")
    @Expose
    public Integer addonId;
    @SerializedName("item_id")
    @Expose
    public Integer itemId;
    @SerializedName("created_at")
    @Expose
    public Object createdAt;
    @SerializedName("updated_at")
    @Expose
    public Object updatedAt;

}
