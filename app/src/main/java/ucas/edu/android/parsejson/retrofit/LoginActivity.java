package ucas.edu.android.parsejson.retrofit;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ucas.edu.android.parsejson.LoginResponse;
import ucas.edu.android.parsejson.databinding.ActivityLoginBinding;
import ucas.edu.android.parsejson.model.LoginRequest;

public class LoginActivity extends AppCompatActivity {
    ApiService retrofitInstance;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        sharedPreferences = getSharedPreferences("sp", MODE_PRIVATE);
        editor = sharedPreferences.edit();

        retrofitInstance = ApiService.RetrofitClass.getRetrofitInstance();

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginAssignment();
            }
        });
    }

    private void logOut() {
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

    private void loginExam() {
        String email = binding.editTextTextEmailAddress.getText().toString();
        String password = binding.editTextNumberPassword.getText().toString();
        LoginRequest loginRequest = new LoginRequest(email,password);
        retrofitInstance.loginExam(loginRequest).enqueue(new Callback<LoginResponse2>() {
            @Override
            public void onResponse(Call<LoginResponse2> call, Response<LoginResponse2> response) {
                Log.d(LoginActivity.class.getSimpleName(),response.toString());
                if(response.isSuccessful()) {
                    LoginResponse2 loginResponse2= response.body();
                    LoginResponse2.Data DATA = loginResponse2.data;
                    String token=DATA.token;
                    editor.putString("token", token);
                    editor.apply();

                    Intent intent = new Intent( getApplicationContext(),OrdersActivity.class);
                    startActivity(intent);
                }

            }

            @Override
            public void onFailure(Call<LoginResponse2> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
    private void loginAssignment() {
        String email = binding.editTextTextEmailAddress.getText().toString();
        String password = binding.editTextNumberPassword.getText().toString();
        LoginRequest loginRequest = new LoginRequest(email,password,"IOS","7.1.0","student","10","fsdsf","sdgsdg");
        loginRequest.setOs("ANDROID");
        loginRequest.setVersion("7.1.0");
        loginRequest.setUsername(email);
        loginRequest.setPassword(password);
        loginRequest.setUser_type("student");
        loginRequest.setOs_version("10");
        loginRequest.setDevice_token("acsadcfsa");
        loginRequest.setDevice_id("fdvdsvsd");

        retrofitInstance.loginAssignment(loginRequest.getOs(),loginRequest.getVersion(),loginRequest.getOs_version(),loginRequest.getDevice_token(),loginRequest.getDevice_id(),loginRequest.getUsername(),loginRequest.getPassword(),loginRequest.getUser_type())
                .enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                Log.d(LoginActivity.class.getSimpleName(),response.toString());
                if(response.isSuccessful()) {
                    LoginResponse loginResponse= response.body();
                    String token=loginResponse.getToken();
                    editor.putString("token", token);
                    editor.apply();

                }else{
                    try {
                        String errorBody=response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorBody);
                        JSONObject errorJsonObject=jsonObject.getJSONObject("error");
                        String code = errorJsonObject.getString("code");
                        String message = errorJsonObject.getString("message");
                        Toast.makeText(getApplicationContext(), code +" "+message, Toast.LENGTH_SHORT).show();
                    } catch (JSONException | IOException e) {
                        e.printStackTrace();
                    }

                }

            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}