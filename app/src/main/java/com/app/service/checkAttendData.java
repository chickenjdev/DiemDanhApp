package com.app.service;

import android.util.Log;

public class checkAttendData {
    String strCode, strLocation, strTchCode, strTchLocation;
    int dochinhxac = 4;
    int chenhlech = 10;

    public checkAttendData(String strCode, String strLocation, String strTchCode, String strTchLocation) {
        this.strCode = strCode;
        this.strLocation = strLocation;
        this.strTchCode = strTchCode;
        this.strTchLocation = strTchLocation;
    }

    public boolean check() {
        if (checkCode() && checkLocation()) return true;
        else
            return false;
    }

    public boolean checkCode() {
        if (strCode.equals(strTchCode)) return true;
        else
            return false;
    }

    public boolean checkLocation() {

        String lat = strLocation.split(",")[0];
        String lng = strLocation.split(",")[1];
//        Log.d("CRE", "check " + lat.split("\\.")[0]);


        int blat = Integer.parseInt(lat.split("\\.")[0]);
        int elat = Integer.parseInt(lat.split("\\.")[1].substring(0, dochinhxac));

        int blng = Integer.parseInt(lng.split("\\.")[0]);
        int elng = Integer.parseInt(lng.split("\\.")[1].substring(0, dochinhxac));

        String latT = strTchLocation.split(",")[0];
        String lngT = strTchLocation.split(",")[1];

        int blatT = Integer.parseInt(latT.split("\\.")[0]);
        int elatT = Integer.parseInt(latT.split("\\.")[1].substring(0, dochinhxac));

        int blngT = Integer.parseInt(lngT.split("\\.")[0]);
        int elngT = Integer.parseInt(lngT.split("\\.")[1].substring(0, dochinhxac));

        Log.d("CRE", "check " + blat + "=" + blatT + "," + blng + "=" + blngT + "," + elat + "=" + elatT + "," + elng + "=" + elngT);
        Log.d("CRE", "check " + Math.abs(elat - elatT) + '-' + Math.abs(elng - elngT));
        if (blat == blatT && blng == blngT) {
            if (Math.abs(elat - elatT) <= chenhlech
                    && Math.abs(elng - elngT) <= chenhlech) {
                return true;
            }
        } else return false;
        return false;
    }
}
