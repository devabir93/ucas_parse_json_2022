package ucas.edu.android.parsejson;

/**
 * Created by abeer on 04,October,2022
 */
class JsonClass2 {

    String name;
    int id;
    String country;

    public JsonClass2(String name, int id, String country) {
        this.name = name;
        this.id = id;
        this.country = country;
    }

    public JsonClass2() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "JsonClass2{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", country='" + country + '\'' +
                '}';
    }
}
