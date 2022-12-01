package ucas.edu.android.parsejson;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by abeer on 06,October,2022
 */
class LoginResponse implements Parcelable {

    String studentId;
    String user_id;
    Data data;

    public LoginResponse() {
    }

    public LoginResponse(String studentId, String user_id, Data data) {
        this.studentId = studentId;
        this.user_id = user_id;
        this.data = data;
    }

    protected LoginResponse(Parcel in) {
        studentId = in.readString();
        user_id = in.readString();
        data = in.readParcelable(Data.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(studentId);
        dest.writeString(user_id);
        dest.writeParcelable(data, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<LoginResponse> CREATOR = new Creator<LoginResponse>() {
        @Override
        public LoginResponse createFromParcel(Parcel in) {
            return new LoginResponse(in);
        }

        @Override
        public LoginResponse[] newArray(int size) {
            return new LoginResponse[size];
        }
    };

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "studentId='" + studentId + '\'' +
                ", user_id='" + user_id + '\'' +
                ", data=" + data +
                '}';
    }
}

class Data implements Parcelable{
    String notificationCount;
    OpenLibrarySub openLibrarySub;
    ArrayList<LandingPageItem> landingPageItemArrayList;
    ArrayList<MainMenu> mainMenuArrayList;
    ArrayList<Product> productArrayList;

    public Data() {
    }

    public Data(String notificationCount, OpenLibrarySub openLibrarySub, ArrayList<LandingPageItem> landingPageItemArrayList, ArrayList<MainMenu> mainMenuArrayList, ArrayList<Product> productArrayList) {
        this.notificationCount = notificationCount;
        this.openLibrarySub = openLibrarySub;
        this.landingPageItemArrayList = landingPageItemArrayList;
        this.mainMenuArrayList = mainMenuArrayList;
        this.productArrayList = productArrayList;
    }

    protected Data(Parcel in) {
        notificationCount = in.readString();
        openLibrarySub = in.readParcelable(OpenLibrarySub.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(notificationCount);
        dest.writeParcelable(openLibrarySub, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Data> CREATOR = new Creator<Data>() {
        @Override
        public Data createFromParcel(Parcel in) {
            return new Data(in);
        }

        @Override
        public Data[] newArray(int size) {
            return new Data[size];
        }
    };

    public String getNotificationCount() {
        return notificationCount;
    }

    public void setNotificationCount(String notificationCount) {
        this.notificationCount = notificationCount;
    }

    public OpenLibrarySub getOpenLibrarySub() {
        return openLibrarySub;
    }

    public void setOpenLibrarySub(OpenLibrarySub openLibrarySub) {
        this.openLibrarySub = openLibrarySub;
    }

    public ArrayList<LandingPageItem> getLandingPageItemArrayList() {
        return landingPageItemArrayList;
    }

    public void setLandingPageItemArrayList(ArrayList<LandingPageItem> landingPageItemArrayList) {
        this.landingPageItemArrayList = landingPageItemArrayList;
    }

    public ArrayList<MainMenu> getMainMenuArrayList() {
        return mainMenuArrayList;
    }

    public void setMainMenuArrayList(ArrayList<MainMenu> mainMenuArrayList) {
        this.mainMenuArrayList = mainMenuArrayList;
    }

    public ArrayList<Product> getProductArrayList() {
        return productArrayList;
    }

    public void setProductArrayList(ArrayList<Product> productArrayList) {
        this.productArrayList = productArrayList;
    }

    @Override
    public String toString() {
        return "Data{" +
                "notificationCount='" + notificationCount + '\'' +
                ", openLibrarySub=" + openLibrarySub +
                ", landingPageItemArrayList=" + landingPageItemArrayList +
                ", mainMenuArrayList=" + mainMenuArrayList +
                ", productArrayList=" + productArrayList +
                '}';
    }

}

class OpenLibrarySub implements Parcelable{
    ByLevel byLevel;

    public OpenLibrarySub() {
    }

    protected OpenLibrarySub(Parcel in) {
        byLevel = in.readParcelable(ByLevel.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(byLevel, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<OpenLibrarySub> CREATOR = new Creator<OpenLibrarySub>() {
        @Override
        public OpenLibrarySub createFromParcel(Parcel in) {
            return new OpenLibrarySub(in);
        }

        @Override
        public OpenLibrarySub[] newArray(int size) {
            return new OpenLibrarySub[size];
        }
    };

    public ByLevel getByLevel() {
        return byLevel;
    }

    public void setByLevel(ByLevel byLevel) {
        this.byLevel = byLevel;
    }

    @Override
    public String toString() {
        return "OpenLibrarySub{" +
                "byLevel=" + byLevel +
                '}';
    }
}

class ByLevel implements Parcelable{
    String key;

    public ByLevel() {
    }

    protected ByLevel(Parcel in) {
        key = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(key);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ByLevel> CREATOR = new Creator<ByLevel>() {
        @Override
        public ByLevel createFromParcel(Parcel in) {
            return new ByLevel(in);
        }

        @Override
        public ByLevel[] newArray(int size) {
            return new ByLevel[size];
        }
    };

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "ByLevel{" +
                "key='" + key + '\'' +
                '}';
    }

}
class LandingPageItem{
    String id;
    String title;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "LandingPageItem{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
class MainMenu{
    String id;
    String title;
    String status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "MainMenu{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
class Product{
    String productId;
    String productName;

    public Product() {
    }

    public Product(String productId, String productName) {
        this.productId = productId;
        this.productName = productName;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                '}';
    }
}
