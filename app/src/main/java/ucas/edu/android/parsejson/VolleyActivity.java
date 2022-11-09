package ucas.edu.android.parsejson;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
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
import java.util.HashMap;
import java.util.Map;

import ucas.edu.android.parsejson.model.User;

public class VolleyActivity extends AppCompatActivity {

    String base_url = "https://reqres.in/api/";
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley);
        requestQueue = Volley.newRequestQueue(this);
        getUsers("users?");
        //addUser("users");
        //getUserById("users", 2);
    }

    private void addUser(String path) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("name", "morpheus");
            jsonObject.put("job", "leader");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, base_url + path, jsonObject, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d("onResponse", response.toString());
                try {
                    String id = response.getString("id");
                    Toast.makeText(getApplicationContext(), "Added successfully and your id is " + id, Toast.LENGTH_LONG).show();
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

    private void getUsers(String path) {
        String uri = String.format("page=%1$s",
                "2");
        StringRequest jsonObjectRequest = new StringRequest(Request.Method.GET, base_url + path+uri, new Response.Listener<String>() {
            @Override
            public void onResponse(String responseS) {
                Log.d("onResponse", responseS.toString());
                try {
                    JSONObject response = new JSONObject(responseS);
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
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> hashMap = new HashMap<String, String>();
                hashMap.put("page", "3");
                return hashMap;
            }
        };

        requestQueue.add(jsonObjectRequest);
    }

    private void getUserById(String path, int id) {
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, base_url + path + "/" + id, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d("getUserById onResponse", response.toString());
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