package com.example.respos;


import com.example.respos.OderDetailsAPIs.OrderDetailsModelClass;
import com.example.respos.kitchen.Modelkitchen;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

public interface Methods {
    @GET("order-list?status=1&kitchen_id=VC56223CE4B59496&start_date=2022-03-01&end_date=2022-04-15")
    Call<ModelClass> getAllData(@Header("apikey") String api_key,@Header("apisecret") String apisecret );

    @GET("order-details?order_id=1&kitchen_id=VC56223CE4B59496")
    Call<OrderDetailsModelClass> getOrderDetailsData(@Header("apikey") String api_key);

    @GET("order-list?status=2&kitchen_id=VC56223CE4B59496&start_date=2022-03-5&end_date=2022-04-8")
    Call<Modelkitchen> getOrderINKitchen(@Header("apikey") String api_key, @Header("apisecret") String apisecret);

    @POST("order-status-update")
    Call<OderStatusUpdateModel> postAllData(@Header("apikey") String api_key,@Header("apisecret") String apisecret, @QueryMap Map<String, String> param
            /*@Query("order_id") int order_id , @Query("kitchen_id") String kitchen_id, @Query("status")int status*/);


}
