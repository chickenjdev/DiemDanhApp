package com.app.model;

import android.util.Log;

import java.util.Map;

public class userInfo {
    private static String username;
    private static String name;
    private static String code;
    private static String dob;
    private static String faculty;
    private static String full_name = "Ho va ten";
    private static String phone;
    private static String year_code;

    public userInfo(Map<String, Object> data){

        setFull_name((String) data.get("full_name"));
        setUsername((String) data.get("code"));
        setCode((String) data.get("code"));
        setDob((String) data.get("dob"));
        setFaculty((String) data.get("faculty"));
        setPhone((String) data.get("phone"));
        setYear_code((String) data.get("year_code"));
        Log.d("CRE",getFull_name() +"");
    }

    public static String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public static String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public static String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public static String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public static String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public static String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public static String getYear_code() {
        return year_code;
    }

    public void setYear_code(String year_code) {
        this.year_code = year_code;
    }


}