package ucas.edu.android.parsejson.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ucas.edu.android.parsejson.R;
import ucas.edu.android.parsejson.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {
    ApiService retrofitInstance;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        sharedPreferences = getSharedPreferences("sp",MODE_PRIVATE);
        editor = sharedPreferences.edit();

        retrofitInstance = ApiService.RetrofitClass.getRetrofitInstance();

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    private void logOut(){
        retrofitInstance.logOut().enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                editor.clear();
                editor.commit();
//                startActivity(new Intent(getApplicationContext(),));
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });
    }
    private void login() {
        retrofitInstance.login().enqueue(new Callback<LoginResponse2>() {
            @Override
            public void onResponse(Call<LoginResponse2> call, Response<LoginResponse2> response) {
               LoginResponse2 loginResponse2= response.body();
             LoginResponse2.Data DATA = loginResponse2.data;
             String token=DATA.token;
             editor.putString("token",token);
             editor.apply();

            }

            @Override
            public void onFailure(Call<LoginResponse2> call, Throwable t) {
             t.printStackTrace();
            }
        });
    }
}