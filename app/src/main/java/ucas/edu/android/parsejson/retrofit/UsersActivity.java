package ucas.edu.android.parsejson.retrofit;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ucas.edu.android.parsejson.R;

public class UsersActivity extends AppCompatActivity {
    ApiService retrofitInstance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);

        RecyclerView recyclerView = findViewById(R.id.rv);
        retrofitInstance = ApiService.RetrofitClass.getRetrofitInstance();
        retrofitInstance.getUserList().enqueue(new Callback<UsersResponse>() {
            @Override
            public void onResponse(Call<UsersResponse> call, Response<UsersResponse> response) {
                UsersResponse usersResponse=response.body();
                ArrayList<UsersResponse.UserData> userDataArrayList=usersResponse.getUserDataArrayList();
                UsersAdapter2 usersAdapter2 = new UsersAdapter2(getApplicationContext(),userDataArrayList,null);
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL,false));
                recyclerView.setAdapter(usersAdapter2);
            }

            @Override
            public void onFailure(Call<UsersResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}