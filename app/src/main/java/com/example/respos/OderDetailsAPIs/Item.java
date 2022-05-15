
package com.example.respos.OderDetailsAPIs;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Item {

    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("user_id")
    @Expose
    public Integer userId;
    @SerializedName("order_id")
    @Expose
    public Integer orderId;
    @SerializedName("item_id")
    @Expose
    public Integer itemId;
    @SerializedName("item_name")
    @Expose
    public String itemName;
    @SerializedName("item_image")
    @Expose
    public String itemImage;
    @SerializedName("addons_price")
    @Expose
    public Integer addonsPrice;
    @SerializedName("addons_name")
    @Expose
    public Object addonsName;
    @SerializedName("price")
    @Expose
    public Integer price;
    @SerializedName("subtotal")
    @Expose
    public String subtotal;
    @SerializedName("variation_id")
    @Expose
    public String variationId;
    @SerializedName("variation_price")
    @Expose
    public Integer variationPrice;
    @SerializedName("variation")
    @Expose
    public String variation;
    @SerializedName("qty")
    @Expose
    public String qty;
    @SerializedName("item_notes")
    @Expose
    public Object itemNotes;
    @SerializedName("addons_id")
    @Expose
    public Object addonsId;
    @SerializedName("created_at")
    @Expose
    public String createdAt;
    @SerializedName("updated_at")
    @Expose
    public String updatedAt;

}
