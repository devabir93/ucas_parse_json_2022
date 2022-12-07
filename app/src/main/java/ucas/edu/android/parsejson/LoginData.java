package ucas.edu.android.parsejson;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class LoginData implements Parcelable {
    String notificationCount;
    OpenLibrarySub openLibrarySub;
    ArrayList<LandingPageItem> landingPageItemArrayList;
    ArrayList<MainMenu> mainMenuArrayList;
    ArrayList<Product> productArrayList;

    public LoginData() {
    }

    public LoginData(String notificationCount, OpenLibrarySub openLibrarySub, ArrayList<LandingPageItem> landingPageItemArrayList, ArrayList<MainMenu> mainMenuArrayList, ArrayList<Product> productArrayList) {
        this.notificationCount = notificationCount;
        this.openLibrarySub = openLibrarySub;
        this.landingPageItemArrayList = landingPageItemArrayList;
        this.mainMenuArrayList = mainMenuArrayList;
        this.productArrayList = productArrayList;
    }

    protected LoginData(Parcel in) {
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

    public static final Creator<LoginData> CREATOR = new Creator<LoginData>() {
        @Override
        public LoginData createFromParcel(Parcel in) {
            return new LoginData(in);
        }

        @Override
        public LoginData[] newArray(int size) {
            return new LoginData[size];
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
