
package com.example.respos.OderDetailsAPIs;

import java.util.List;



import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Data {

    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("order_number")
    @Expose
    public String orderNumber;
    @SerializedName("user_id")
    @Expose
    public Integer userId;
    @SerializedName("driver_id")
    @Expose
    public Integer driverId;
    @SerializedName("order_total")
    @Expose
    public Integer orderTotal;
    @SerializedName("stripe_payment_id")
    @Expose
    public Object stripePaymentId;
    @SerializedName("payment_type")
    @Expose
    public String paymentType;
    @SerializedName("order_type")
    @Expose
    public Integer orderType;
    @SerializedName("address")
    @Expose
    public Object address;
    @SerializedName("pincode")
    @Expose
    public Object pincode;
    @SerializedName("building")
    @Expose
    public Object building;
    @SerializedName("landmark")
    @Expose
    public Object landmark;
    @SerializedName("promocode")
    @Expose
    public Object promocode;
    @SerializedName("discount_amount")
    @Expose
    public Object discountAmount;
    @SerializedName("discount_pr")
    @Expose
    public Integer discountPr;
    @SerializedName("tax")
    @Expose
    public Integer tax;
    @SerializedName("tax_amount")
    @Expose
    public Integer taxAmount;
    @SerializedName("delivery_charge")
    @Expose
    public Object deliveryCharge;
    @SerializedName("order_notes")
    @Expose
    public Object orderNotes;
    @SerializedName("order_from")
    @Expose
    public String orderFrom;
    @SerializedName("payment_status")
    @Expose
    public String paymentStatus;
    @SerializedName("status")
    @Expose
    public String status;
    @SerializedName("is_notification")
    @Expose
    public Integer isNotification;
    @SerializedName("created_at")
    @Expose
    public String createdAt;
    @SerializedName("updated_at")
    @Expose
    public String updatedAt;
    @SerializedName("item_list")
    @Expose
    public List<Item> itemList = null;
    @SerializedName("addon_list")
    @Expose
    public List<Addon> addonList = null;

}
