
package com.example.respos;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Datum {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("order_number")
    @Expose
    private String orderNumber;
    @SerializedName("user_id")
    @Expose
    private Integer userId;
    @SerializedName("driver_id")
    @Expose
    private Integer driverId;
    @SerializedName("order_total")
    @Expose
    private Double orderTotal;
    @SerializedName("stripe_payment_id")
    @Expose
    private Object stripePaymentId;
    @SerializedName("payment_type")
    @Expose
    private String paymentType;
    @SerializedName("order_type")
    @Expose
    private Integer orderType;
    @SerializedName("address")
    @Expose
    private Object address;
    @SerializedName("pincode")
    @Expose
    private Object pincode;
    @SerializedName("building")
    @Expose
    private Object building;
    @SerializedName("landmark")
    @Expose
    private Object landmark;
    @SerializedName("promocode")
    @Expose
    private Object promocode;
    @SerializedName("discount_amount")
    @Expose
    private Object discountAmount;
    @SerializedName("discount_pr")
    @Expose
    private Integer discountPr;
    @SerializedName("tax")
    @Expose
    private Integer tax;
    @SerializedName("tax_amount")
    @Expose
    private Integer taxAmount;
    @SerializedName("delivery_charge")
    @Expose
    private Object deliveryCharge;
    @SerializedName("order_notes")
    @Expose
    private Object orderNotes;
    @SerializedName("order_from")
    @Expose
    private String orderFrom;
    @SerializedName("payment_status")
    @Expose
    private String paymentStatus;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("is_notification")
    @Expose
    private Integer isNotification;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getDriverId() {
        return driverId;
    }

    public void setDriverId(Integer driverId) {
        this.driverId = driverId;
    }

    public Double getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(Double orderTotal) {
        this.orderTotal = orderTotal;
    }

    public Object getStripePaymentId() {
        return stripePaymentId;
    }

    public void setStripePaymentId(Object stripePaymentId) {
        this.stripePaymentId = stripePaymentId;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public Object getAddress() {
        return address;
    }

    public void setAddress(Object address) {
        this.address = address;
    }

    public Object getPincode() {
        return pincode;
    }

    public void setPincode(Object pincode) {
        this.pincode = pincode;
    }

    public Object getBuilding() {
        return building;
    }

    public void setBuilding(Object building) {
        this.building = building;
    }

    public Object getLandmark() {
        return landmark;
    }

    public void setLandmark(Object landmark) {
        this.landmark = landmark;
    }

    public Object getPromocode() {
        return promocode;
    }

    public void setPromocode(Object promocode) {
        this.promocode = promocode;
    }

    public Object getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(Object discountAmount) {
        this.discountAmount = discountAmount;
    }

    public Integer getDiscountPr() {
        return discountPr;
    }

    public void setDiscountPr(Integer discountPr) {
        this.discountPr = discountPr;
    }

    public Integer getTax() {
        return tax;
    }

    public void setTax(Integer tax) {
        this.tax = tax;
    }

    public Integer getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(Integer taxAmount) {
        this.taxAmount = taxAmount;
    }

    public Object getDeliveryCharge() {
        return deliveryCharge;
    }

    public void setDeliveryCharge(Object deliveryCharge) {
        this.deliveryCharge = deliveryCharge;
    }

    public Object getOrderNotes() {
        return orderNotes;
    }

    public void setOrderNotes(Object orderNotes) {
        this.orderNotes = orderNotes;
    }

    public String getOrderFrom() {
        return orderFrom;
    }

    public void setOrderFrom(String orderFrom) {
        this.orderFrom = orderFrom;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getIsNotification() {
        return isNotification;
    }

    public void setIsNotification(Integer isNotification) {
        this.isNotification = isNotification;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

}
