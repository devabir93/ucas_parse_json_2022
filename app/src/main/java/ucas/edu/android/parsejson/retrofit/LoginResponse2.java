package ucas.edu.android.parsejson.retrofit;

import com.google.gson.annotations.SerializedName;

/**
 * Created by abeer on 01,December,2022
 */


/*
* {
    "code": 200,
    "success": true,
    "message": "تم تسجيل دخول المستخدم بنجاح",
    "data": {
        "id": 55,
        "name": "jasser",
        "email": "mott@gmail.com",
        "photo": "",
        "phone": "0592782892",
        "active": "مفعل",
        "token": "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJhdWQiOiI5Nzc2N2JmYS1mZWVhLTQ0MTEtOWE0My0wYTliNzE4Y2YwZmEiLCJqdGkiOiJjNTY3ZmM2Mzc1NmEyNGQ5NzUzMzg5NWFlOTgzZGFhYmFiNjhlZWUyMGJkOTljZDRiM2M4MDZhNmYwNjlmNDQ1OTBiMTE0ZWY2OGI4NWViZiIsImlhdCI6MTY2OTg3Nzc4MSwibmJmIjoxNjY5ODc3NzgxLCJleHAiOjE3MDE0MTM3ODEsInN1YiI6IjU1Iiwic2NvcGVzIjpbXX0.HG1XsJ6P_U7Pq17DyTTxMBwrJv3XDx0xi6uqoaR8UyCONnID8LwUi1kRaJLwJOxpeI7KhhOr7Qsc-mLvCKdlwcP-M9m9YfJApq_ukZXiSmUrkTYVOQuuwk7_XfHur2PF90OOIgrdR465-UwDO_XAvYAX32hnKV3LQ7HJLDKMCl6wobBGnQCDrudp9F0E7nKXkf1PqMeTZXkhpKAJC-GeAD7YOZ1f8eDN36H5Wgue7HQA_V1qkwkpvhGoVgHuiXG_oMl-mCsJPjGbyPr-xpxI0B0UHa5o42mqWxbfJSOGb11mw25iKqugrUwa6LMCSWY3UNVhzp1UeZjn7l6qeYz3OCfCvoqnzGykG6mqjn8OsGbChPzy3IDT9xd8t9u5iSij1C5ig8cXoIh52frlTAD5juw8E91Kz_52THMTQuJAHoMBGUfyKqQSbMHP42s3dGxagKX9AvJ6WdKUEK3uPSDpCTl6C3i2weha_6qpmqYQG9ZsMy8gEizAxxa1jOoMROC5nU7y7A1oOtIZEqrrP16n5K9rUVu4z19bbphn9Hcvm5-owwlgsBCbvNFaqcK5kLJteVS1lASnSIsmybZBq4T9V3PrFKTqksbjY44ozlEn3o2FGs5J_aedApX0mHfvfAD_CW8wK1jHHhiG36qPmEjhQMOQjNeWoDhyuooOdixI028"
    }
}
*
* */
class LoginResponse2 {
    @SerializedName("code")
    int code;
    @SerializedName("success")
    boolean success;
    @SerializedName("message")
    String message;

    @SerializedName("data")
    Data data;

    class Data {
        @SerializedName("id")
        int id;

        @SerializedName("name")
        String name;

        @SerializedName("email")
        String email;

        @SerializedName("phone")
        String phone;

        @SerializedName("token")
        String token;
    }

}
