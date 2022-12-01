package ucas.edu.android.parsejson.retrofit;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by abeer on 01,December,2022
 */
interface ApiService {
//    https://reqres.in/api/users?page=1
    @GET("users")
    Call<UsersResponse> getUserList();

    @POST("auth/login/user")
    Call<LoginResponse2> login();

    @GET("auth/logout")
   Call<Void> logOut();

    class RetrofitClass {

//        public static String BASE_URL = "https://reqres.in/api/";
        public static String BASE_URL2 = "https://studentucas.awamr.com/api/";


        public static ApiService getRetrofitInstance() {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL2)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            return retrofit.create(ApiService.class);
        }


    }
}
