package ucas.edu.android.parsejson;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ReadHtmlFromAssetsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_html_from_assets);
        String string =AppUtility.readFromAssets(getApplicationContext(),"text_ar.html");
        WebView webView = findViewById(R.id.webview);
        webView.loadDataWithBaseURL(null,string, "text/html; charset=UTF-8", null,null);
    }


}