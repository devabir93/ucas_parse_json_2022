package ucas.edu.android.parsejson;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ParseJsonFromStringActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parse_json_from_string);
        //parseJsonFromString1();
        //parseJsonFromString2();
        parseJson3();
    }

    private void parseJsonFromString2() {
        String json ="{\n" +
                "  \"Name\": \"abir\",\n" +
                "  \"id\": 34532,\n" +
                "  \"country\": \"palestine\"\n" +
                "}";

        try {
            JSONObject jsonObject = new JSONObject(json);
            String name =jsonObject.getString("Name");
            int id = jsonObject.getInt("id");
            String contry = jsonObject.getString("country");
            JsonClass2 jsonClass2 = new JsonClass2(name,id,contry);
            Log.d("parse ",jsonClass2.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    private void parseJsonFromString1() {
        String json="{\n" +
                "  \"student\": {\n" +
                "    \"name\": \"alaa\",\n" +
                "    \"age\": 44\n" +
                "  },\n" +
                "  \"data\": [\n" +
                "    {\n" +
                "      \"name\": \"alaa\",\n" +
                "      \"age\": 44\n" +
                "    },\n" +
                "    {\n" +
                "      \"country\": \"gaza\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"school\": {\n" +
                "    \"schoolName\": \"Gaza school\",\n" +
                "    \"schoolId\": 1234\n" +
                "  },\n" +
                "  \"FOOD\": [\n" +
                "    \"NAME\",\n" +
                "    \"PIZZA\",\n" +
                "    \"MILK\"\n" +
                "  ]\n" +
                "}";

        try {
            JsonClass jsonClass = new JsonClass();
            JSONObject jsonObject = new JSONObject(json);
            JSONObject studentJson =jsonObject.getJSONObject("student");
            String name =studentJson.getString("name");
            int age = studentJson.getInt("age");

            Student student = new Student(name,age);
//            student.setAge(age);
//            student.setName(name);
            jsonClass.setStudent(student);

            JSONObject schoolJson = jsonObject.getJSONObject("school");
            String schoolName = schoolJson.getString("schoolName");
            int schoolId = schoolJson.getInt("schoolId");

            School school = new School();
            school.setSchoolId(schoolId);
            school.setSchoolName(schoolName);

            jsonClass.setSchool(school);

            JSONArray foodJsonArray = jsonObject.getJSONArray("FOOD");
            ArrayList<String> foodStringArrayList = new ArrayList<String>();
            for (int i = 0; i < foodJsonArray.length(); i++) {
                String item =foodJsonArray.getString(i);
                foodStringArrayList.add(item);
                Log.d("ParseJson item",item);
            }
            jsonClass.setFoodArrayList(foodStringArrayList);

            JSONArray dataJsonArray = jsonObject.getJSONArray("data");
            ArrayList<Student> studentArrayList = new ArrayList<>();
            for (int i = 0; i < dataJsonArray.length(); i++) {
                JSONObject jsonObject1 = new JSONObject(dataJsonArray.get(i).toString());
                Student student1 = new Student();
                if(jsonObject1.has("name"))
                    student1.setName(jsonObject1.getString("name"));
                if(jsonObject1.has("age"))
                    student1.setAge(jsonObject1.getInt("age"));
                if(jsonObject1.has("country"))
                    student1.setCountry(jsonObject1.getString("country"));
                studentArrayList.add(student1);
            }

            jsonClass.setStudentArrayList(studentArrayList);

            Log.d("ParseJson student",student.toString());
            Log.d("ParseJson school",school.toString());
            Log.d("ParseJson jsonClass",jsonClass.toString());

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void parseJson3(){
        String jsonString ="{\n" +
                "    \"student_id\": \"531577\",\n" +
                "    \"user_id\": \"531577\",\n" +
                "    \"data\": {\n" +
                "        \"notificationsCount\": \"0\",\n" +
                "        \"send_google_event\": \"1\",\n" +
                "        \"open_library_sub\": {\n" +
                "            \"by_level\": {\n" +
                "                \"key\": \"by_level\",\n" +
                "                \"url\": \"/OpenLibrary\",\n" +
                "                \"label_index\": \"by_level\",\n" +
                "                \"theme_type\": \"theme_1\",\n" +
                "                \"order\": \"1\",\n" +
                "                \"en_image_link\": \"https://stgphp7.ireadarabic.com/assets/assets/images/en/level.png\",\n" +
                "                \"ar_image_link\": \"https://stgphp7.ireadarabic.com/assets/assets/images/ar/level.png\",\n" +
                "                \"mobile_en_image_link\": \"https://stgphp7.ireadarabic.com/assets/assets/images/en/m_level_1.png\",\n" +
                "                \"mobile_ar_image_link\": \"https://stgphp7.ireadarabic.com/assets/assets/images/ar/m_level_1.png\",\n" +
                "                \"en_label\": \"By Level\",\n" +
                "                \"ar_label\": \"حسب المستوى\"\n" +
                "            },\n" +
                "            \"by_category\": {\n" +
                "                \"key\": \"by_category\",\n" +
                "                \"url\": \"/OpenLibrary/groups/1\",\n" +
                "                \"label_index\": \"by_category\",\n" +
                "                \"theme_type\": \"theme_2\",\n" +
                "                \"order\": \"2\",\n" +
                "                \"en_image_link\": \"https://stgphp7.ireadarabic.com/assets/assets/images/en/category.png\",\n" +
                "                \"ar_image_link\": \"https://stgphp7.ireadarabic.com/assets/assets/images/ar/category.png\",\n" +
                "                \"mobile_en_image_link\": \"https://stgphp7.ireadarabic.com/assets/assets/images/en/m_category_1.png\",\n" +
                "                \"mobile_ar_image_link\": \"https://stgphp7.ireadarabic.com/assets/assets/images/ar/m_category_1.png\",\n" +
                "                \"en_label\": \"By Category\",\n" +
                "                \"ar_label\": \"حسب التصنيف\"\n" +
                "            },\n" +
                "            \"by_theme\": {\n" +
                "                \"key\": \"by_theme\",\n" +
                "                \"url\": \"/OpenLibrary/groups/2\",\n" +
                "                \"label_index\": \"by_theme\",\n" +
                "                \"theme_type\": \"theme_2\",\n" +
                "                \"order\": \"4\",\n" +
                "                \"en_image_link\": \"https://stgphp7.ireadarabic.com/assets/assets/images/en/theme.png\",\n" +
                "                \"ar_image_link\": \"https://stgphp7.ireadarabic.com/assets/assets/images/ar/theme.png\",\n" +
                "                \"mobile_en_image_link\": \"https://stgphp7.ireadarabic.com/assets/assets/images/en/m_theme_1.png\",\n" +
                "                \"mobile_ar_image_link\": \"https://stgphp7.ireadarabic.com/assets/assets/images/ar/m_theme_1.png\",\n" +
                "                \"en_label\": \"PYP Themes\",\n" +
                "                \"ar_label\": \"محاور (PYP)\"\n" +
                "            },\n" +
                "            \"read_challenge\": {\n" +
                "                \"key\": \"read_challenge\",\n" +
                "                \"url\": \"/OpenLibrary/challenges\",\n" +
                "                \"label_index\": \"read_challenge\",\n" +
                "                \"theme_type\": \"theme_3\",\n" +
                "                \"order\": \"5\",\n" +
                "                \"en_image_link\": \"https://stgphp7.ireadarabic.com/assets/assets/images/en/challenge.png\",\n" +
                "                \"ar_image_link\": \"https://stgphp7.ireadarabic.com/assets/assets/images/ar/challenge.png\",\n" +
                "                \"mobile_en_image_link\": \"https://stgphp7.ireadarabic.com/assets/assets/images/en/m_challenge_1.png\",\n" +
                "                \"mobile_ar_image_link\": \"https://stgphp7.ireadarabic.com/assets/assets/images/ar/m_challenge_1.png\",\n" +
                "                \"en_label\": \"Read Challenge\",\n" +
                "                \"ar_label\": \"تحدي القراءة\"\n" +
                "            },\n" +
                "            \"genres\": {\n" +
                "                \"key\": \"genres\",\n" +
                "                \"url\": \"/OpenLibrary/groups/3\",\n" +
                "                \"label_index\": \"genres\",\n" +
                "                \"theme_type\": \"theme_2\",\n" +
                "                \"order\": \"3\",\n" +
                "                \"en_image_link\": \"https://stgphp7.ireadarabic.com/assets/assets/images/en/genres.png\",\n" +
                "                \"ar_image_link\": \"https://stgphp7.ireadarabic.com/assets/assets/images/ar/genres.png\",\n" +
                "                \"mobile_en_image_link\": \"https://stgphp7.ireadarabic.com/assets/assets/images/en/m_genres_1.png\",\n" +
                "                \"mobile_ar_image_link\": \"https://stgphp7.ireadarabic.com/assets/assets/images/ar/m_genres_1.png\",\n" +
                "                \"en_label\": \"Genres\",\n" +
                "                \"ar_label\": \"النوع الأدبي\"\n" +
                "            }\n" +
                "        },\n" +
                "        \"gender\": \"male\",\n" +
                "        \"alert_notice_period\": \"0\",\n" +
                "        \"landing_page_item\": [\n" +
                "            {\n" +
                "                \"id\": \"1\",\n" +
                "                \"title\": \"level\",\n" +
                "                \"landing_page_key\": \"my_books\",\n" +
                "                \"icon\": \"level_ios.png\",\n" +
                "                \"os\": \"ios\",\n" +
                "                \"status\": \"active\",\n" +
                "                \"order\": \"1\",\n" +
                "                \"addition_ts\": \"1639986279\",\n" +
                "                \"update_ts\": \"0\",\n" +
                "                \"show\": \"1\",\n" +
                "                \"ar_title\": \"مستواي\",\n" +
                "                \"en_title\": \"My Level\",\n" +
                "                \"icon_link\": \"https://stgapiphp7.ireadarabic.com/en/Content/landingPageItem?file=level_ios.png\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": \"2\",\n" +
                "                \"title\": \"video\",\n" +
                "                \"landing_page_key\": \"videos_portal\",\n" +
                "                \"icon\": \"video_ios.png\",\n" +
                "                \"os\": \"ios\",\n" +
                "                \"status\": \"active\",\n" +
                "                \"order\": \"2\",\n" +
                "                \"addition_ts\": \"1639986279\",\n" +
                "                \"update_ts\": \"0\",\n" +
                "                \"show\": \"1\",\n" +
                "                \"ar_title\": \"فيديو\",\n" +
                "                \"en_title\": \"Videos\",\n" +
                "                \"icon_link\": \"https://stgapiphp7.ireadarabic.com/en/Content/landingPageItem?file=video_ios.png\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": \"3\",\n" +
                "                \"title\": \"games\",\n" +
                "                \"landing_page_key\": \"games\",\n" +
                "                \"icon\": \"games_ios.png\",\n" +
                "                \"os\": \"ios\",\n" +
                "                \"status\": \"active\",\n" +
                "                \"order\": \"3\",\n" +
                "                \"addition_ts\": \"1639986279\",\n" +
                "                \"update_ts\": \"0\",\n" +
                "                \"show\": \"1\",\n" +
                "                \"ar_title\": \"ألعاب\",\n" +
                "                \"en_title\": \"Games\",\n" +
                "                \"icon_link\": \"https://stgapiphp7.ireadarabic.com/en/Content/landingPageItem?file=games_ios.png\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": \"4\",\n" +
                "                \"title\": \"library\",\n" +
                "                \"landing_page_key\": \"open_library\",\n" +
                "                \"icon\": \"library_ios.png\",\n" +
                "                \"os\": \"ios\",\n" +
                "                \"status\": \"active\",\n" +
                "                \"order\": \"4\",\n" +
                "                \"addition_ts\": \"1639986279\",\n" +
                "                \"update_ts\": \"0\",\n" +
                "                \"show\": \"1\",\n" +
                "                \"ar_title\": \"مكتبة\",\n" +
                "                \"en_title\": \"Library\",\n" +
                "                \"icon_link\": \"https://stgapiphp7.ireadarabic.com/en/Content/landingPageItem?file=library_ios.png\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": \"5\",\n" +
                "                \"title\": \"assignments\",\n" +
                "                \"landing_page_key\": \"assignments\",\n" +
                "                \"icon\": \"assignments_ios.png\",\n" +
                "                \"os\": \"ios\",\n" +
                "                \"status\": \"active\",\n" +
                "                \"order\": \"5\",\n" +
                "                \"addition_ts\": \"1639986279\",\n" +
                "                \"update_ts\": \"0\",\n" +
                "                \"show\": \"1\",\n" +
                "                \"ar_title\": \"مهمات\",\n" +
                "                \"en_title\": \"Assignments\",\n" +
                "                \"icon_link\": \"https://stgapiphp7.ireadarabic.com/en/Content/landingPageItem?file=assignments_ios.png\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": \"6\",\n" +
                "                \"title\": \"enrichment\",\n" +
                "                \"landing_page_key\": \"enrichment\",\n" +
                "                \"icon\": \"enrichment_ios.png\",\n" +
                "                \"os\": \"ios\",\n" +
                "                \"status\": \"active\",\n" +
                "                \"order\": \"6\",\n" +
                "                \"addition_ts\": \"1639986279\",\n" +
                "                \"update_ts\": \"0\",\n" +
                "                \"show\": \"1\",\n" +
                "                \"ar_title\": \"تقوية\",\n" +
                "                \"en_title\": \"Enrichment\",\n" +
                "                \"icon_link\": \"https://stgapiphp7.ireadarabic.com/en/Content/landingPageItem?file=enrichment_ios.png\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"main_menu\": [\n" +
                "            {\n" +
                "                \"id\": \"1\",\n" +
                "                \"title\": \"home\",\n" +
                "                \"main_menu_key\": \"home\",\n" +
                "                \"icon\": \"home_ios.png\",\n" +
                "                \"os\": \"ios\",\n" +
                "                \"status\": \"active\",\n" +
                "                \"order\": \"1\",\n" +
                "                \"addition_ts\": \"1639986279\",\n" +
                "                \"update_ts\": \"0\",\n" +
                "                \"show\": \"1\",\n" +
                "                \"ar_title\": \"الصفحة الرئيسية\",\n" +
                "                \"en_title\": \"Home\",\n" +
                "                \"icon_link\": \"https://stgapiphp7.ireadarabic.com/en/Content/mainMenu?file=home_ios.png\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": \"2\",\n" +
                "                \"title\": \"level\",\n" +
                "                \"main_menu_key\": \"my_books\",\n" +
                "                \"icon\": \"level_ios.png\",\n" +
                "                \"os\": \"ios\",\n" +
                "                \"status\": \"active\",\n" +
                "                \"order\": \"2\",\n" +
                "                \"addition_ts\": \"1639986279\",\n" +
                "                \"update_ts\": \"0\",\n" +
                "                \"show\": \"1\",\n" +
                "                \"ar_title\": \"مستواي\",\n" +
                "                \"en_title\": \"My Level\",\n" +
                "                \"icon_link\": \"https://stgapiphp7.ireadarabic.com/en/Content/mainMenu?file=level_ios.png\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": \"3\",\n" +
                "                \"title\": \"video\",\n" +
                "                \"main_menu_key\": \"videos_portal\",\n" +
                "                \"icon\": \"video_ios.png\",\n" +
                "                \"os\": \"ios\",\n" +
                "                \"status\": \"active\",\n" +
                "                \"order\": \"3\",\n" +
                "                \"addition_ts\": \"1639986279\",\n" +
                "                \"update_ts\": \"0\",\n" +
                "                \"show\": \"1\",\n" +
                "                \"ar_title\": \"فيديو\",\n" +
                "                \"en_title\": \"Videos\",\n" +
                "                \"icon_link\": \"https://stgapiphp7.ireadarabic.com/en/Content/mainMenu?file=video_ios.png\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": \"4\",\n" +
                "                \"title\": \"library\",\n" +
                "                \"main_menu_key\": \"open_library\",\n" +
                "                \"icon\": \"library_ios.png\",\n" +
                "                \"os\": \"ios\",\n" +
                "                \"status\": \"active\",\n" +
                "                \"order\": \"4\",\n" +
                "                \"addition_ts\": \"1639986279\",\n" +
                "                \"update_ts\": \"0\",\n" +
                "                \"show\": \"1\",\n" +
                "                \"ar_title\": \"مكتبة\",\n" +
                "                \"en_title\": \"Library\",\n" +
                "                \"icon_link\": \"https://stgapiphp7.ireadarabic.com/en/Content/mainMenu?file=library_ios.png\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": \"5\",\n" +
                "                \"title\": \"games\",\n" +
                "                \"main_menu_key\": \"games\",\n" +
                "                \"icon\": \"games_ios.png\",\n" +
                "                \"os\": \"ios\",\n" +
                "                \"status\": \"active\",\n" +
                "                \"order\": \"5\",\n" +
                "                \"addition_ts\": \"1639986279\",\n" +
                "                \"update_ts\": \"0\",\n" +
                "                \"show\": \"1\",\n" +
                "                \"ar_title\": \"ألعاب\",\n" +
                "                \"en_title\": \"Games\",\n" +
                "                \"icon_link\": \"https://stgapiphp7.ireadarabic.com/en/Content/mainMenu?file=games_ios.png\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": \"6\",\n" +
                "                \"title\": \"reports\",\n" +
                "                \"main_menu_key\": \"reports\",\n" +
                "                \"icon\": \"reports_ios.png\",\n" +
                "                \"os\": \"ios\",\n" +
                "                \"status\": \"active\",\n" +
                "                \"order\": \"6\",\n" +
                "                \"addition_ts\": \"1639986279\",\n" +
                "                \"update_ts\": \"0\",\n" +
                "                \"show\": \"1\",\n" +
                "                \"ar_title\": \"تقارير\",\n" +
                "                \"en_title\": \"Reports\",\n" +
                "                \"icon_link\": \"https://stgapiphp7.ireadarabic.com/en/Content/mainMenu?file=reports_ios.png\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": \"43\",\n" +
                "                \"title\": \"activity\",\n" +
                "                \"main_menu_key\": \"activity\",\n" +
                "                \"icon\": \"activity_web.png\",\n" +
                "                \"os\": \"ios\",\n" +
                "                \"status\": \"active\",\n" +
                "                \"order\": \"7\",\n" +
                "                \"addition_ts\": \"1655126415\",\n" +
                "                \"update_ts\": \"0\",\n" +
                "                \"show\": \"1\",\n" +
                "                \"ar_title\": \"نشاطاتي\",\n" +
                "                \"en_title\": \"Activities\",\n" +
                "                \"icon_link\": \"https://stgapiphp7.ireadarabic.com/en/Content/mainMenu?file=activity_web.png\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": \"7\",\n" +
                "                \"title\": \"assignments\",\n" +
                "                \"main_menu_key\": \"assignments\",\n" +
                "                \"icon\": \"assignments_ios.png\",\n" +
                "                \"os\": \"ios\",\n" +
                "                \"status\": \"active\",\n" +
                "                \"order\": \"8\",\n" +
                "                \"addition_ts\": \"1639986279\",\n" +
                "                \"update_ts\": \"0\",\n" +
                "                \"show\": \"1\",\n" +
                "                \"ar_title\": \"مهمات\",\n" +
                "                \"en_title\": \"Assignments\",\n" +
                "                \"icon_link\": \"https://stgapiphp7.ireadarabic.com/en/Content/mainMenu?file=assignments_ios.png\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": \"8\",\n" +
                "                \"title\": \"enrichment\",\n" +
                "                \"main_menu_key\": \"enrichment\",\n" +
                "                \"icon\": \"enrichment_ios.png\",\n" +
                "                \"os\": \"ios\",\n" +
                "                \"status\": \"active\",\n" +
                "                \"order\": \"9\",\n" +
                "                \"addition_ts\": \"1639986279\",\n" +
                "                \"update_ts\": \"0\",\n" +
                "                \"show\": \"1\",\n" +
                "                \"ar_title\": \"تقوية\",\n" +
                "                \"en_title\": \"Enrichment\",\n" +
                "                \"icon_link\": \"https://stgapiphp7.ireadarabic.com/en/Content/mainMenu?file=enrichment_ios.png\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": \"9\",\n" +
                "                \"title\": \"pirls\",\n" +
                "                \"main_menu_key\": \"pirls_category\",\n" +
                "                \"icon\": \"pirls_ios.png\",\n" +
                "                \"os\": \"ios\",\n" +
                "                \"status\": \"active\",\n" +
                "                \"order\": \"10\",\n" +
                "                \"addition_ts\": \"1639986279\",\n" +
                "                \"update_ts\": \"0\",\n" +
                "                \"show\": \"1\",\n" +
                "                \"ar_title\": \"PIRLS\",\n" +
                "                \"en_title\": \"PIRLS\",\n" +
                "                \"icon_link\": \"https://stgapiphp7.ireadarabic.com/en/Content/mainMenu?file=pirls_ios.png\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": \"10\",\n" +
                "                \"title\": \"help\",\n" +
                "                \"main_menu_key\": \"help\",\n" +
                "                \"icon\": \"help_ios.png\",\n" +
                "                \"os\": \"ios\",\n" +
                "                \"status\": \"active\",\n" +
                "                \"order\": \"11\",\n" +
                "                \"addition_ts\": \"1639986279\",\n" +
                "                \"update_ts\": \"0\",\n" +
                "                \"show\": \"1\",\n" +
                "                \"ar_title\": \"مساعدة\",\n" +
                "                \"en_title\": \"Help\",\n" +
                "                \"icon_link\": \"https://stgapiphp7.ireadarabic.com/en/Content/mainMenu?file=help_ios.png\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": \"11\",\n" +
                "                \"title\": \"settings\",\n" +
                "                \"main_menu_key\": \"settings\",\n" +
                "                \"icon\": \"settings_ios.png\",\n" +
                "                \"os\": \"ios\",\n" +
                "                \"status\": \"active\",\n" +
                "                \"order\": \"12\",\n" +
                "                \"addition_ts\": \"1639986279\",\n" +
                "                \"update_ts\": \"0\",\n" +
                "                \"show\": \"1\",\n" +
                "                \"ar_title\": \"إعدادات\",\n" +
                "                \"en_title\": \"Settings\",\n" +
                "                \"icon_link\": \"https://stgapiphp7.ireadarabic.com/en/Content/mainMenu?file=settings_ios.png\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": \"12\",\n" +
                "                \"title\": \"rating\",\n" +
                "                \"main_menu_key\": \"rating\",\n" +
                "                \"icon\": \"rating_ios.png\",\n" +
                "                \"os\": \"ios\",\n" +
                "                \"status\": \"active\",\n" +
                "                \"order\": \"13\",\n" +
                "                \"addition_ts\": \"1639986279\",\n" +
                "                \"update_ts\": \"0\",\n" +
                "                \"show\": \"1\",\n" +
                "                \"ar_title\": \"تقييم\",\n" +
                "                \"en_title\": \"Rating\",\n" +
                "                \"icon_link\": \"https://stgapiphp7.ireadarabic.com/en/Content/mainMenu?file=rating_ios.png\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": \"13\",\n" +
                "                \"title\": \"logout\",\n" +
                "                \"main_menu_key\": \"logout\",\n" +
                "                \"icon\": \"logout_ios.png\",\n" +
                "                \"os\": \"ios\",\n" +
                "                \"status\": \"active\",\n" +
                "                \"order\": \"14\",\n" +
                "                \"addition_ts\": \"1639986279\",\n" +
                "                \"update_ts\": \"0\",\n" +
                "                \"show\": \"1\",\n" +
                "                \"ar_title\": \"خروج\",\n" +
                "                \"en_title\": \"Logout\",\n" +
                "                \"icon_link\": \"https://stgapiphp7.ireadarabic.com/en/Content/mainMenu?file=logout_ios.png\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"products\": [\n" +
                "            {\n" +
                "                \"product_id\": \"1\",\n" +
                "                \"product_name\": \"my_books\",\n" +
                "                \"product_title_en\": \"My Books\",\n" +
                "                \"product_title_ar\": \"كتبي\",\n" +
                "                \"available\": \"1\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"product_id\": \"6\",\n" +
                "                \"product_name\": \"pirls_category\",\n" +
                "                \"product_title_en\": \"PIRLS\",\n" +
                "                \"product_title_ar\": \"PIRLS\",\n" +
                "                \"available\": \"1\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"product_id\": \"2\",\n" +
                "                \"product_name\": \"open_library\",\n" +
                "                \"product_title_en\": \"Library\",\n" +
                "                \"product_title_ar\": \"مكتبة\",\n" +
                "                \"available\": \"1\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"product_id\": \"3\",\n" +
                "                \"product_name\": \"videos_portal\",\n" +
                "                \"product_title_en\": \"Video Library\",\n" +
                "                \"product_title_ar\": \"مكتبة الفيديو\",\n" +
                "                \"available\": \"1\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"product_id\": \"4\",\n" +
                "                \"product_name\": \"games\",\n" +
                "                \"product_title_en\": \"Games\",\n" +
                "                \"product_title_ar\": \"ألعاب\",\n" +
                "                \"available\": \"1\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"product_id\": \"7\",\n" +
                "                \"product_name\": \"search\",\n" +
                "                \"product_title_en\": \"Search\",\n" +
                "                \"product_title_ar\": \"بحث\",\n" +
                "                \"available\": \"1\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"product_id\": \"8\",\n" +
                "                \"product_name\": \"enrichment\",\n" +
                "                \"product_title_en\": \"Enrichment\",\n" +
                "                \"product_title_ar\": \"تقوية\",\n" +
                "                \"available\": \"1\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"notification_counter\": \"0\",\n" +
                "        \"gamification_leaderboard\": \"1\",\n" +
                "        \"gamification_stories\": \"1\",\n" +
                "        \"gamification_streaks\": \"1\",\n" +
                "        \"is_deleted\": \"0\",\n" +
                "        \"message_counter\": \"0\",\n" +
                "        \"actions\": \"\",\n" +
                "        \"stars\": \"16\",\n" +
                "        \"avatar\": \"debd4de468013ada761f23e33700e103.jpg\",\n" +
                "        \"avatar_url\": \"https://stgapiphp7.ireadarabic.com/en/Content/avatar?user_type=student&file=debd4de468013ada761f23e33700e103.jpg\",\n" +
                "        \"student_id\": \"531577\",\n" +
                "        \"student_school_id\": \"111\",\n" +
                "        \"student_fname\": \"Issa\",\n" +
                "        \"student_lname\": \"Aleisawi\",\n" +
                "        \"EGRA\": {\n" +
                "            \"student_experiment\": \"0\",\n" +
                "            \"experiment_type\": \"normal\",\n" +
                "            \"baseline\": {\n" +
                "                \"id\": \"\",\n" +
                "                \"baseline_status\": \"\",\n" +
                "                \"baseline_url\": \"\"\n" +
                "            },\n" +
                "            \"endline\": {\n" +
                "                \"id\": \"\",\n" +
                "                \"endline_status\": \"\",\n" +
                "                \"endline_url\": \"\"\n" +
                "            },\n" +
                "            \"quiz\": {\n" +
                "                \"id\": \"\",\n" +
                "                \"quiz_status\": \"\",\n" +
                "                \"quiz_url\": \"\"\n" +
                "            }\n" +
                "        },\n" +
                "        \"level_id\": \"4\",\n" +
                "        \"status\": \"active\",\n" +
                "        \"student_email\": \"mutasem@littlethinkingminds.com\",\n" +
                "        \"popup_verify_email\": \"enable\",\n" +
                "        \"is_first_time_login\": \"0\",\n" +
                "        \"last_login_time\": \"05-10-2022 20:40\",\n" +
                "        \"last_trn\": \"\",\n" +
                "        \"student_is_old\": \"0\",\n" +
                "        \"login_name\": \"its1\",\n" +
                "        \"grade_name\": \"Grade 3\",\n" +
                "        \"grade_id\": \"5\",\n" +
                "        \"student_dob\": \"1651201200\",\n" +
                "        \"student_dob_format\": \"29-04-2022\",\n" +
                "        \"date_year_checker\": \"\",\n" +
                "        \"age\": \"8\",\n" +
                "        \"disable_school_placment_test\": \"1\",\n" +
                "        \"level_exam\": {\n" +
                "            \"type\": \"students\",\n" +
                "            \"exam_id\": \"\",\n" +
                "            \"level_exam_id\": \"\",\n" +
                "            \"level_exam_url\": \"\",\n" +
                "            \"level_exam_status\": \"\",\n" +
                "            \"level_exam_lable\": {\n" +
                "                \"en\": \"Well done! To move to the next level you must take level exam\",\n" +
                "                \"ar\": \"أحسنت! لتنتقل إلى المستوى التالي يجب عليك إجراء اختبار المستوى\"\n" +
                "            },\n" +
                "            \"level_exam_name\": \"\"\n" +
                "        },\n" +
                "        \"school\": {\n" +
                "            \"id\": \"1885\",\n" +
                "            \"school_name\": \"School Test IRA New\",\n" +
                "            \"school_image\": \"\",\n" +
                "            \"type\": \"actual\",\n" +
                "            \"country_id\": \"18\",\n" +
                "            \"country_name\": \"Bahrain\",\n" +
                "            \"time_zone\": \"Asia/Bahrain\",\n" +
                "            \"capture_student_email\": \"0\",\n" +
                "            \"enrichment_score_limit\": \"60\",\n" +
                "            \"experimental_school\": \"0\"\n" +
                "        },\n" +
                "        \"teacher\": {\n" +
                "            \"id\": \"62400\",\n" +
                "            \"teacher_name\": \"teacher1\"\n" +
                "        },\n" +
                "        \"class_id\": \"71819\",\n" +
                "        \"class_name\": \"Class3- Grae3\",\n" +
                "        \"level\": {\n" +
                "            \"id\": \"4\",\n" +
                "            \"label\": \"د\",\n" +
                "            \"progress\": \"1\",\n" +
                "            \"remaining_progress\": \"24\",\n" +
                "            \"level_books\": \"25\",\n" +
                "            \"progress_percentage\": \"4\"\n" +
                "        },\n" +
                "        \"messages_system_status\": \"0\",\n" +
                "        \"messages_upload_status\": \"0\",\n" +
                "        \"disable_leaderboard_status\": \"0\",\n" +
                "        \"games_new_popup\": \"0\",\n" +
                "        \"has_enrichment\": \"1\",\n" +
                "        \"pending_enrichment\": \"0\",\n" +
                "        \"reminder_school_status\": \"1\",\n" +
                "        \"reminder_student_status\": \"on\",\n" +
                "        \"level_hist\": \"ج,د\",\n" +
                "        \"change_level\": \"up\",\n" +
                "        \"placement_test_serving_url\": \"https://stgphp7.ireadarabic.com/en/PlacementTest\",\n" +
                "        \"api_status\": \"success\",\n" +
                "        \"session_id\": \"qchitpjkvp69kpihlufgo1plroq9v1o8\",\n" +
                "        \"token\": \"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoiNTMxNTc3IiwidXNlcl90eXBlIjoic3R1ZGVudCIsInZlbmRvciI6IkxUTSIsImRldmljZV90b2tlbiI6ImRhc2RzYSIsImFwcCI6IklSQSIsIm9zIjoiSU9TIiwidmVyc2lvbiI6IjEuMiIsImRpc2FibGVfc2Nob29sX3BsYWNtZW50X3Rlc3QiOiIxIiwiZGV2aWNlX2lkIjoiZnNhZmFzYWRzIiwibGFuZyI6ImVuIiwic3R1ZGVudF9maXJzdF9uYW1lIjoiSXNzYSIsInN0dWRlbnRfbGFzdF9uYW1lIjoiQWxlaXNhd2kiLCJsZXZlbF9pZCI6IjQiLCJ0ZWFjaGVyIjp7ImlkIjoiNjI0MDAiLCJ0ZWFjaGVyX25hbWUiOiJ0ZWFjaGVyMSJ9LCJtZXNzYWdlc19zeXN0ZW1fc3RhdHVzIjoiMCIsIm1lc3NhZ2VzX3VwbG9hZF9zdGF0dXMiOiIwIiwic2Nob29sX2lkIjoiMTg4NSIsInN0dWRlbnRfZXhwZXJpbWVudCI6IjAiLCJleHBlcmltZW50X3R5cGUiOiJub3JtYWwiLCJleHBlcmltZW50YWxfc2Nob29sIjoiMCIsInRpbWVzdGFtcCI6MTY2NTAwNTE0NiwiZ2VuZXJhdGVkX2F0IjoxNjY1MDA1MTQ2LCJleHBpcmVkX2F0IjoxNjY1MDk1MTQ2fQ.XWz6UaV-xqJuSJkiEC-BYQs2ttZ7K9gOfDZklE3LgII\"\n" +
                "    },\n" +
                "    \"teacher_status\": \"active\",\n" +
                "    \"message\": \"success\",\n" +
                "    \"status\": \"success\",\n" +
                "    \"flag\": true,\n" +
                "    \"vendor\": \"LTM\",\n" +
                "    \"token\": \"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoiNTMxNTc3IiwidXNlcl90eXBlIjoic3R1ZGVudCIsInZlbmRvciI6IkxUTSIsImRldmljZV90b2tlbiI6ImRhc2RzYSIsImFwcCI6IklSQSIsIm9zIjoiSU9TIiwidmVyc2lvbiI6IjEuMiIsImRpc2FibGVfc2Nob29sX3BsYWNtZW50X3Rlc3QiOiIxIiwiZGV2aWNlX2lkIjoiZnNhZmFzYWRzIiwibGFuZyI6ImVuIiwic3R1ZGVudF9maXJzdF9uYW1lIjoiSXNzYSIsInN0dWRlbnRfbGFzdF9uYW1lIjoiQWxlaXNhd2kiLCJsZXZlbF9pZCI6IjQiLCJ0ZWFjaGVyIjp7ImlkIjoiNjI0MDAiLCJ0ZWFjaGVyX25hbWUiOiJ0ZWFjaGVyMSJ9LCJtZXNzYWdlc19zeXN0ZW1fc3RhdHVzIjoiMCIsIm1lc3NhZ2VzX3VwbG9hZF9zdGF0dXMiOiIwIiwic2Nob29sX2lkIjoiMTg4NSIsInN0dWRlbnRfZXhwZXJpbWVudCI6IjAiLCJleHBlcmltZW50X3R5cGUiOiJub3JtYWwiLCJleHBlcmltZW50YWxfc2Nob29sIjoiMCIsInRpbWVzdGFtcCI6MTY2NTAwNTE0NiwiZ2VuZXJhdGVkX2F0IjoxNjY1MDA1MTQ2LCJleHBpcmVkX2F0IjoxNjY1MDk1MTQ2fQ.XWz6UaV-xqJuSJkiEC-BYQs2ttZ7K9gOfDZklE3LgII\",\n" +
                "    \"domain\": \"https://stgtphp7.ireadarabic.com/\"\n" +
                "}";

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
            ArrayList<Product> productArrayList=new ArrayList<>();
            for (int i = 0; i < productjisonarry.length(); i++) {
                String productItem = productjisonarry.get(i).toString();
                JSONObject ProductJASONobject = new JSONObject(productItem);
                String product_id = ProductJASONobject.getString("product_id");
                Product prouductclass=new Product();
                prouductclass.setProductId(product_id);
                productArrayList.add(prouductclass);
            }

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

/*            Intent intent  = new Intent(this,PreviewActivity.class);
            intent.putExtra("loginResponseClass",loginResponseClass);
            startActivity(intent);*/

            Log.d("Login Response",loginResponseClass.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}