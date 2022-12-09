package ucas.edu.android.parsejson.mid_exam;

import java.util.ArrayList;

/**
 * Created by abeer on 09,December,2022
 */
public class OrdersResponse {
    int code;
    String message;
    ArrayList<OrdersData> dataArrayList;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<OrdersData> getDataArrayList() {
        return dataArrayList;
    }

    public void setDataArrayList(ArrayList<OrdersData> dataArrayList) {
        this.dataArrayList = dataArrayList;
    }
}

class OrdersData {
    int id;
    int user_id;
    String details;
    String phone;
    Work work;
    ArrayList<OrderPhoto> orderPhotoArrayList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Work getWork() {
        return work;
    }

    public void setWork(Work work) {
        this.work = work;
    }

    public ArrayList<OrderPhoto> getOrderPhotoArrayList() {
        return orderPhotoArrayList;
    }

    public void setOrderPhotoArrayList(ArrayList<OrderPhoto> orderPhotoArrayList) {
        this.orderPhotoArrayList = orderPhotoArrayList;
    }
}

 class Work {
    int id;
    String name;

     public int getId() {
         return id;
     }

     public void setId(int id) {
         this.id = id;
     }

     public String getName() {
         return name;
     }

     public void setName(String name) {
         this.name = name;
     }
 }

class OrderPhoto{
    String photo;

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
