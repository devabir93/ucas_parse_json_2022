package ucas.edu.android.parsejson.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ucas.edu.android.parsejson.R;
import ucas.edu.android.parsejson.model.OrderResponse;

public class OrdersActivity extends AppCompatActivity {

    private ApiService retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);
        retrofit =ApiService.RetrofitClass.getRetrofitInstance();
        SharedPreferences sharedPreferences = getSharedPreferences("sp", MODE_PRIVATE);

        String token = "Bearer "+sharedPreferences.getString("token","");
        retrofit.getOrders(token).enqueue(new Callback<OrderResponse>() {
            @Override
            public void onResponse(Call<OrderResponse> call, Response<OrderResponse> response) {

            }

            @Override
            public void onFailure(Call<OrderResponse> call, Throwable t) {

            }
        });
    }
}