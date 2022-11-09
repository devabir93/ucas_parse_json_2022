package ucas.edu.android.parsejson;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import ucas.edu.android.parsejson.model.User;

public class UserActivity extends AppCompatActivity {
    String baseUrl = "https://reqres.in/api/";
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        int userId = getIntent().getIntExtra("user",0);

        textView = findViewById(R.id.user);
        getUserInfo(baseUrl + "users/" + userId);
    }

    private void getUserInfo(String path) {
        Log.d("getUsers", path);
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, path, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d("getUser onResponse", response.toString());
                try {

                    JSONObject dataJsonObject = response.getJSONObject("data");
                    int id = dataJsonObject.getInt("id");
                    String email = dataJsonObject.getString("email");
                    String first_name = dataJsonObject.getString("first_name");
                    String last_name = dataJsonObject.getString("last_name");
                    String avatar = dataJsonObject.getString("avatar");
                    User user = new User();
                    user.setId(id);
                    user.setEmail(email);
                    user.setFirstName(first_name);
                    user.setLastName(last_name);
                    user.setAvater(avatar);

                    textView.setText(user.toString());
                    Toast.makeText(getApplicationContext(), user.toString(), Toast.LENGTH_SHORT).show();

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