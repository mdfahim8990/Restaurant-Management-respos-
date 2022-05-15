package com.example.respos.SqliteDataBase;

public class Data {

    private String Restaurant_name;
    private String Phone_number;
    private String Api_key;
    private String Api_secret;
    private String Kitchen_id;
    private String Api_endpoint;
    private String Address;

    public Data(String restaurant_name, String phone_number, String api_key, String api_secret, String kitchen_id, String api_endpoint, String address) {
        Restaurant_name = restaurant_name;
        Phone_number = phone_number;
        Api_key = api_key;
        Api_secret = api_secret;
        Kitchen_id = kitchen_id;
        Api_endpoint = api_endpoint;
        Address = address;
    }

    public String getRestaurant_name() {
        return Restaurant_name;
    }

    public void setRestaurant_name(String restaurant_name) {
        Restaurant_name = restaurant_name;
    }

    public String getPhone_number() {
        return Phone_number;
    }

    public void setPhone_number(String phone_number) {
        Phone_number = phone_number;
    }

    public String getApi_key() {
        return Api_key;
    }

    public void setApi_key(String api_key) {
        Api_key = api_key;
    }

    public String getApi_secret() {
        return Api_secret;
    }

    public void setApi_secret(String api_secret) {
        Api_secret = api_secret;
    }

    public String getKitchen_id() {
        return Kitchen_id;
    }

    public void setKitchen_id(String kitchen_id) {
        Kitchen_id = kitchen_id;
    }

    public String getApi_endpoint() {
        return Api_endpoint;
    }

    public void setApi_endpoint(String api_endpoint) {
        Api_endpoint = api_endpoint;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
}
