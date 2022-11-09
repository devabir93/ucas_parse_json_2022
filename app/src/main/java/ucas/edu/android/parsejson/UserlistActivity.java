package ucas.edu.android.parsejson;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import ucas.edu.android.parsejson.model.User;

public class UserlistActivity extends AppCompatActivity {

    String baseUrl = "https://reqres.in/api/";
    RecyclerView recyclerView;
    private int page;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userlist);
        recyclerView = findViewById(R.id.rv);
        Button addButton = findViewById(R.id.add_btn);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addUser(baseUrl + "users");
            }
        });
        page = 2;
        String pageUri = String.format("page=%1$s", page);
        getUsers(baseUrl + "users?" + pageUri);

    }

    private void addUser(String path) {
//        JSONObject jsonObject = new JSONObject();
//        try {
//            jsonObject.put("name", "morpheus");
//            jsonObject.put("job", "leader");
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, path, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.d("addUser", response.toString());
                try {
                    String id = response.getString("id");
                    String date = response.getString("createdAt");
                    Toast.makeText(getApplicationContext(), "your is " + id + " createdAt: " + date, Toast.LENGTH_SHORT).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> map = new HashMap<>();
                String token="";
                map.put("token","Bearer "+token);
                return map;
            }

            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<>();
                map.put("name", "morpheus");
                map.put("job", "leader");
                return map;
            }
        };
        requestQueue.add(jsonObjectRequest);
    }

    private void getUsers(String path) {
        Log.d("getUsers", path);
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, path, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d("getUsers onResponse", response.toString());
                try {
                    int page = response.getInt("page");
                    int total = response.getInt("total");

                    JSONArray usersJsonArray = response.getJSONArray("data");
                    ArrayList<User> userArrayList = new ArrayList<>();
                    for (int i = 0; i < usersJsonArray.length(); i++) {
                        String userString = usersJsonArray.get(i).toString();
                        JSONObject userJsonObject = new JSONObject(userString);
                        int id = userJsonObject.getInt("id");
                        String email = userJsonObject.getString("email");
                        String first_name = userJsonObject.getString("first_name");
                        String last_name = userJsonObject.getString("last_name");
                        String avatar = userJsonObject.getString("avatar");
                        User user = new User();
                        user.setId(id);
                        user.setEmail(email);
                        user.setFirstName(first_name);
                        user.setLastName(last_name);
                        user.setAvater(avatar);
                        userArrayList.add(user);
                    }

                    UsersAdapter usersAdapter = new UsersAdapter(getApplicationContext(), userArrayList, new ListenerInterface() {
                        @Override
                        public void onclick(int userId, int pos) {
                            Intent intent = new Intent(getApplicationContext(), UserActivity.class);
                            intent.putExtra("user", userId);
                            startActivity(intent);
                        }
                    });
                    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false));
                    recyclerView.setAdapter(usersAdapter);
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

        requestQueue.add(jsonObjectRequest);
    }
}