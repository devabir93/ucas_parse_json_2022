package ucas.edu.android.parsejson;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import ucas.edu.android.parsejson.databinding.ActivityGetDataByVolleyBinding;

public class GetDataByVolleyActivity extends AppCompatActivity {

    String url = "https://run.mocky.io/v3/83a9857a-b814-4e5e-ba98-648ec434499f";
    ActivityGetDataByVolleyBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGetDataByVolleyBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        postResponse();
        //getLoginResponse();
    }

    private void getStringRequest() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }
        );
    }

    private void getLoginResponse() {

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    String studentId = response.getString("student_id");
                    JSONObject datajson_object = response.getJSONObject("data");
                    JSONArray productArray = datajson_object.getJSONArray("products");
                    ArrayList<Product> ProductArrayList = new ArrayList<>();
                    for (int i = 0; i < productArray.length(); i++) {
                        JSONObject product_item_Json = new JSONObject(productArray.get(i).toString());
//                        int product_name = product_item_Json.getInt("product_name");
                        String product_id = product_item_Json.getString("product_id");
                        Product product = new Product();
                        product.setProductId(product_id);
                        ProductArrayList.add(product);
                    }
                    CustomAdapter customAdapter = new CustomAdapter(GetDataByVolleyActivity.this, ProductArrayList);
                    binding.rv.setAdapter(customAdapter);
                    binding.rv.setLayoutManager(new LinearLayoutManager(GetDataByVolleyActivity.this, RecyclerView.VERTICAL, false));


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonObjectRequest);

    }
    private void postResponse() {

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("name","morpheus");
            jsonObject.put("job","leader");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, "https://reqres.in/api/users", jsonObject, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
               // try {
                    Log.d("onResponse",response.toString());
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonObjectRequest);

    }
}