package ucas.edu.android.parsejson.mid_exam;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import ucas.edu.android.parsejson.databinding.ActivityOrdersBinding;

public class OrdersActivity extends AppCompatActivity {

    ActivityOrdersBinding binding;
    String Base_url = "https://studentucas.awamr.com/api/";
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String token;
    RequestQueue requestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOrdersBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        requestQueue = Volley.newRequestQueue(this);
        sharedPreferences = getSharedPreferences("sp", MODE_PRIVATE);
        editor = sharedPreferences.edit();
        token = sharedPreferences.getString("token_exam", "");
        if(!token.isEmpty())
            getOrders("order/un/complete/user");

        binding.logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });
    }

    private void logout() {
        String logoutUrls="auth/logout";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, Base_url + logoutUrls, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                editor.clear();
                editor.commit();
                startActivity(new Intent(getApplicationContext(),LoginActivity.class));

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> map = new HashMap<>();
                map.put("Accept","application/json");
                map.put("Authorization", "Bearer " +token);
                return map;
            }
        };
        requestQueue.add(stringRequest);
    }

    private void getOrders(String s) {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, Base_url+s, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("OrdersActivity", response);
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray dataJsonArray = jsonObject.getJSONArray("data");
                    ArrayList<OrdersData> dataArrayList = new ArrayList<>();
                    for (int i = 0; i < dataJsonArray.length(); i++) {
                        JSONObject jsonItem = new JSONObject(dataJsonArray.get(i).toString());
                        OrdersData ordersData = new OrdersData();
                        int id = jsonItem.getInt("id");
                        String phone = jsonItem.getString("phone");
                        String details = jsonItem.getString("details");
                        ordersData.setDetails(details);
                        ordersData.setPhone(phone);
                        ordersData.setId(id);

                        JSONObject workJsonObject = jsonItem.getJSONObject("work");
                        int workId = workJsonObject.getInt("id");
                        String workName = workJsonObject.getString("name");

                        Work work = new Work();
                        work.setName(workName);
                        work.setId(workId);
                        ordersData.setWork(work);

                        ArrayList<OrderPhoto> orderPhotoArrayList = new ArrayList<>();
                        JSONArray photosJsonArray = jsonItem.getJSONArray("photo_order");
                        for (int j = 0; j < photosJsonArray.length(); j++) {
                            OrderPhoto orderPhoto = new OrderPhoto();
                            JSONObject photoJsonItem = new JSONObject(photosJsonArray.get(j).toString());
                            String photo = photoJsonItem.getString("photo");
                            orderPhoto.setPhoto(photo);
                            orderPhotoArrayList.add(orderPhoto);
                        }
                        ordersData.setOrderPhotoArrayList(orderPhotoArrayList);
                        dataArrayList.add(ordersData);
                    }

                    fillAdapter(dataArrayList);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> map = new HashMap<>();
                map.put("Accept","application/json");
                map.put("Authorization", "Bearer " +token);
                return map;
            }
        };
        requestQueue.add(stringRequest);
    }

    private void fillAdapter(ArrayList<OrdersData> dataArrayList) {
        OrdersAdapter ordersAdapter = new OrdersAdapter(getApplicationContext(), dataArrayList);
        binding.rv.setLayoutManager(new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false));
        binding.rv.setAdapter(ordersAdapter);
    }
}