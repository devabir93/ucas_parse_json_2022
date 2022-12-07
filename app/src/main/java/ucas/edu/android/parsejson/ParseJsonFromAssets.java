package ucas.edu.android.parsejson;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ParseJsonFromAssets extends AppCompatActivity {
    ArrayList<Product> productArrayList;
    private CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parse_json_from_assets);
        String jsonStr=AppUtility.readFromAssets(getApplicationContext(),"json/jsonStr.json");
        sendToAdapter(productArrayList);
        parseJsonFromAssets(jsonStr);
    }

    private void parseJsonFromAssets(String jsonString){

        LoginResponse loginResponseClass = new LoginResponse();
        LoginData dataClass = new LoginData();
        OpenLibrarySub openLibrarySubClass = new OpenLibrarySub();
        ByLevel byLevelClass = new ByLevel();

        try {
            JSONObject loginResponse = new JSONObject(jsonString);
            String studentId=loginResponse.getString("student_id");
            String userId = loginResponse.getString("user_id");
            boolean flag = loginResponse.getBoolean("flag");

            JSONObject dataJsonObject = loginResponse.getJSONObject("data");
            String notificationCount = dataJsonObject.getString("notificationsCount");
            JSONObject openLibrarySub = dataJsonObject.getJSONObject("open_library_sub");
            JSONObject byLevel = openLibrarySub.getJSONObject("by_level");
            String key = byLevel.getString("key");

            JSONArray landingPageItemJsonArray = dataJsonObject.getJSONArray("landing_page_item");
            ArrayList<LandingPageItem> landingPageItemArrayList = new ArrayList<>();
            for (int i = 0; i < landingPageItemJsonArray.length(); i++) {
                String item =landingPageItemJsonArray.get(i).toString();
                JSONObject landingPageItemJsonObject = new JSONObject(item);
                String id = landingPageItemJsonObject.getString("id");
                String title = landingPageItemJsonObject.getString("title");
                LandingPageItem landingPageItemClass = new LandingPageItem();
                landingPageItemClass.setId(id);
                landingPageItemClass.setTitle(title);
                landingPageItemArrayList.add(landingPageItemClass);
            }
            StringBuilder stringBuilder = new StringBuilder();

            for (int i = 0; i < landingPageItemArrayList.size(); i++) {
                stringBuilder.append(landingPageItemArrayList.get(i).getTitle());
                if(i != landingPageItemArrayList.size()-1){
                    stringBuilder.append(" ,");
                }
            }
            String titles = stringBuilder.toString();

            Log.d("titles",titles);
            JSONArray mainMenuJsonArray = dataJsonObject.getJSONArray("main_menu");
            ArrayList<MainMenu> mainMenuArrayList = new ArrayList<>();
            for (int i = 0; i < mainMenuJsonArray.length(); i++) {
                String menuItem = mainMenuJsonArray.get(i).toString();
                JSONObject menuJsonObject = new JSONObject(menuItem);
                String status = menuJsonObject.getString("status");
                MainMenu mainMenuClass = new MainMenu();
                mainMenuClass.setStatus(status);
                mainMenuArrayList.add(mainMenuClass);
            }

            JSONArray productjisonarry=dataJsonObject.getJSONArray("products");
            productArrayList=new ArrayList<>();
            for (int i = 0; i < productjisonarry.length(); i++) {
                String productItem = productjisonarry.get(i).toString();
                JSONObject ProductJASONobject = new JSONObject(productItem);
                String product_id = ProductJASONobject.getString("product_id");
                Product prouductclass=new Product();
                prouductclass.setProductId(product_id);
                prouductclass.setProductName(ProductJASONobject.getString("product_name"));
                productArrayList.add(prouductclass);
            }
            customAdapter.setProducts(productArrayList);
            customAdapter.notifyDataSetChanged();
            productArrayList.add(new Product("0","test"));
            customAdapter.notifyDataSetChanged();


            loginResponseClass.setStudentId(studentId);
            loginResponseClass.setUser_id(userId);
            dataClass.setLandingPageItemArrayList(landingPageItemArrayList);
            dataClass.setMainMenuArrayList(mainMenuArrayList);
            dataClass.setNotificationCount(notificationCount);
            dataClass.setProductArrayList(productArrayList);

            byLevelClass.setKey(key);
            openLibrarySubClass.setByLevel(byLevelClass);
            dataClass.setOpenLibrarySub(openLibrarySubClass);
            loginResponseClass.setData(dataClass);

//            Intent intent  = new Intent(this,PreviewActivity.class);
//            intent.putExtra("type","Read From Assets");
//            intent.putExtra("loginResponseClass",loginResponseClass);
//            startActivity(intent);

            Log.d("Login Response",loginResponseClass.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void sendToAdapter(ArrayList<Product> productArrayList) {
        customAdapter = new CustomAdapter(this);
        RecyclerView recyclerView = findViewById(R.id.rv);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(customAdapter);

    }

}