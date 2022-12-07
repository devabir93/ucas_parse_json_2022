package ucas.edu.android.parsejson.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by abeer on 06,December,2022
 */
public class LoginRequest {
    String email;
    @SerializedName("username")
    String username;
    @SerializedName("password")
    String password;
    @SerializedName("os")
    String os;
    @SerializedName("version")
    String version;
    @SerializedName("user_type")
    String user_type;
    @SerializedName("os_version")
    String os_version;
    @SerializedName("device_token")
    String device_token;
    @SerializedName("device_id")
    String device_id;

//    public LoginRequest() {
//    }


    public LoginRequest(String email,String password) {
        this.email = email;
        this.password = password;
    }

    public LoginRequest(String username, String password, String os, String version, String user_type, String os_version, String device_token, String device_id) {
        this.username = username;
        this.password = password;
        this.os = os;
        this.version = version;
        this.user_type = user_type;
        this.os_version = os_version;
        this.device_token = device_token;
        this.device_id = device_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    public String getOs_version() {
        return os_version;
    }

    public void setOs_version(String os_version) {
        this.os_version = os_version;
    }

    public String getDevice_token() {
        return device_token;
    }

    public void setDevice_token(String device_token) {
        this.device_token = device_token;
    }

    public String getDevice_id() {
        return device_id;
    }

    public void setDevice_id(String device_id) {
        this.device_id = device_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginRequest{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", os='" + os + '\'' +
                ", version='" + version + '\'' +
                ", user_type='" + user_type + '\'' +
                ", os_version='" + os_version + '\'' +
                ", device_token='" + device_token + '\'' +
                ", device_id='" + device_id + '\'' +
                '}';
    }
}
