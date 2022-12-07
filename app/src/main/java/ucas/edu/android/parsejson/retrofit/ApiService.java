package ucas.edu.android.parsejson.retrofit;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import ucas.edu.android.parsejson.LoginResponse;
import ucas.edu.android.parsejson.model.LoginRequest;
import ucas.edu.android.parsejson.model.OrderResponse;

/**
 * Created by abeer on 01,December,2022
 */
interface ApiService {
//    https://reqres.in/api/users/1?page=1
    @GET("users")
    Call<UsersResponse> getUserList();

    @POST("auth/login/user")
    Call<LoginResponse2> loginExam(@Body LoginRequest loginRequest);

    @FormUrlEncoded
    @POST("Auth/login")
    Call<LoginResponse> loginAssignment(@Field("os") String os, @Field("version")String version, @Field("os_version")String os_version, @Field("device_token")String device_token, @Field("device_id") String device_id, @Field("username")String username, @Field("password")String password, @Field("user_type")String user_type);

    @GET("auth/logout")
   Call<Void> logOut();

    @GET("Video/videosList?")
    Call<Void> getVideos(@Query("category_id") int id);

    @GET("users/{user_id}")
    Call<Void> getUser(@Path("user_id") int id, @Query("category_id") int name, @Header("token") String token);

    @GET("order/un/complete/user")
    Call<OrderResponse> getOrders(@Header("Authorization") String token);

    class RetrofitClass {

//        public static String BASE_URL = "https://reqres.in/api/";
//public static String BASE_URL2 = "https://studentucas.awamr.com/api/";
        public static String BASE_URL2 = "https://stgapiphp7.ireadarabic.com/ar/";


        public static ApiService getRetrofitInstance() {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL2)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            return retrofit.create(ApiService.class);
        }


    }
}
