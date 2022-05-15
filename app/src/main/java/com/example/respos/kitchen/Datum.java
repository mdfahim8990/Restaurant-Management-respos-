
package com.example.respos.kitchen;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Datum {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("location_id")
    @Expose
    private Integer locationId;
    @SerializedName("order_number")
    @Expose
    private String orderNumber;
    @SerializedName("order_total")
    @Expose
    private Double orderTotal;
    @SerializedName("accepted_at")
    @Expose
    private Object acceptedAt;
    @SerializedName("delivery_in")
    @Expose
    private Object deliveryIn;
    @SerializedName("status")
    @Expose
    private String status;

    /**
     * No args constructor for use in serialization
     *
     */
    public Datum() {
    }

    /**
     *
     * @param orderNumber
     * @param deliveryIn
     * @param locationId
     * @param id
     * @param orderTotal
     * @param acceptedAt
     * @param status
     */
    public Datum(Integer id, Integer locationId, String orderNumber, Double orderTotal, Object acceptedAt, Object deliveryIn, String status) {
        super();
        this.id = id;
        this.locationId = locationId;
        this.orderNumber = orderNumber;
        this.orderTotal = orderTotal;
        this.acceptedAt = acceptedAt;
        this.deliveryIn = deliveryIn;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Double getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(Double orderTotal) {
        this.orderTotal = orderTotal;
    }

    public Object getAcceptedAt() {
        return acceptedAt;
    }

    public void setAcceptedAt(Object acceptedAt) {
        this.acceptedAt = acceptedAt;
    }

    public Object getDeliveryIn() {
        return deliveryIn;
    }

    public void setDeliveryIn(Object deliveryIn) {
        this.deliveryIn = deliveryIn;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
