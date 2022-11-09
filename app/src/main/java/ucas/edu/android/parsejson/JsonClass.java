package ucas.edu.android.parsejson;

import java.util.ArrayList;

/**
 * Created by abeer on 04,October,2022
 */
class JsonClass {

    Student student;
    ArrayList<Student> studentArrayList;
    School school;
    ArrayList<String> foodArrayList;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public ArrayList<Student> getStudentArrayList() {
        return studentArrayList;
    }

    public void setStudentArrayList(ArrayList<Student> studentArrayList) {
        this.studentArrayList = studentArrayList;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public ArrayList<String> getFoodArrayList() {
        return foodArrayList;
    }

    public void setFoodArrayList(ArrayList<String> foodArrayList) {
        this.foodArrayList = foodArrayList;
    }

    @Override
    public String toString() {
        return "JsonClass{" +
                "student=" + student +
                ", studentArrayList=" + studentArrayList +
                ", school=" + school +
                ", foodArrayList=" + foodArrayList +
                '}';
    }
}

class Student{
    String name;
    int age;
    String country;


    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student(String name, int age, String country) {
        this.name = name;
        this.age = age;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", country='" + country + '\'' +
                '}';
    }
}

class School{
    String schoolName;
    int schoolId;

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public int getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(int schoolId) {
        this.schoolId = schoolId;
    }

    @Override
    public String toString() {
        return "School{" +
                "schoolName='" + schoolName + '\'' +
                ", schoolId=" + schoolId +
                '}';
    }
}
