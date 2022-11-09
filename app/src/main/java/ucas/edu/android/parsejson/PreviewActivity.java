package ucas.edu.android.parsejson;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;

public class PreviewActivity extends AppCompatActivity {
    StringBuilder stringBuilder = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);
        LoginResponse loginResponse = getIntent().getParcelableExtra("loginResponseClass");
        String type = getIntent().getStringExtra("type");
        TextView typeTv = findViewById(R.id.type_tv);
        TextView studentIdTv = findViewById(R.id.student_id_tv);
        TextView keyTv = findViewById(R.id.key_tv);

        typeTv.setText(type);
        studentIdTv.setText("student id: "+ loginResponse.getStudentId());
        keyTv.setText("by level Key: "+loginResponse.getData().getOpenLibrarySub().getByLevel().getKey());
        ArrayList<LandingPageItem> landingPageItemArrayList = loginResponse.getData().getLandingPageItemArrayList();
        String id = "id";
        String name = "abir";
        String age = "29";

    }
}