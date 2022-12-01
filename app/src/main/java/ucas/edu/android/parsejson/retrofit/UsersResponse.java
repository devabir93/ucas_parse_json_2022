package ucas.edu.android.parsejson.retrofit;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by abeer on 01,December,2022
 */
class UsersResponse {
    @SerializedName("page")
    int page;

    @SerializedName("total")
    int total;

    @SerializedName("data")
    ArrayList<UserData> userDataArrayList;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public ArrayList<UserData> getUserDataArrayList() {
        return userDataArrayList;
    }

    public void setUserDataArrayList(ArrayList<UserData> userDataArrayList) {
        this.userDataArrayList = userDataArrayList;
    }

    class UserData {
        @SerializedName("id")
        int id;

        @SerializedName("first_name")
        String firstName;

        @SerializedName("last_name")
        String lastName;
        @SerializedName("email")
        String email;
        @SerializedName("avatar")
        String avatar;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }
    }
}
