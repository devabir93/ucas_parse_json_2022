package ucas.edu.android.parsejson.model;

import java.util.ArrayList;

/**
 * Created by abeer on 01,November,2022
 */
public class UserListResponse {
    int page;
    int total;
    ArrayList<User> userArrayList;


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

    public ArrayList<User> getUserArrayList() {
        return userArrayList;
    }

    public void setUserArrayList(ArrayList<User> userArrayList) {
        this.userArrayList = userArrayList;
    }

}

