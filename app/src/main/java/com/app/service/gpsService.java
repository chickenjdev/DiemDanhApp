package com.app.service;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.app.diemdanhapp.R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;

public class gpsService implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    private Location location;
    // Đối tượng tương tác với Google API
    private GoogleApiClient gac;
    // Hiển thị vị trí
    private TextView tvLocation;

    Context context;

    public gpsService(Context context) {
        this.context = context;
        tvLocation = (TextView) ((Activity)context).findViewById(R.id.txtlocal);
        tvLocation.setText("Your location is : ");
        if (checkPlayServices()) {
            // Building the GoogleApi client
            buildGoogleApiClient();
            gac.connect();
        }

    }

    public void dispLocation(View view) {
        getLocation();
    }

    /**
     * Phương thức này dùng để hiển thị trên UI
     */
    private void getLocation() {
        if (ActivityCompat.checkSelfPermission(this.context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // Kiểm tra quyền hạn
            ActivityCompat.requestPermissions((Activity)this.context,
                    new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, 2);
        } else {
            location = LocationServices.FusedLocationApi.getLastLocation(gac);
            if (location != null) {
                double latitude = location.getLatitude();
                double longitude = location.getLongitude();
                // Hiển thị
                tvLocation.setText(latitude + ", " + longitude);
                Log.d("CRE","Vi tri hien tai "+latitude +" "+longitude);
            } else {
                tvLocation.setText("(Không thể hiển thị vị trí. " + "Bạn đã kích hoạt location trên thiết bị chưa?)");
            }
        }
    }

    /**
     * Tạo đối tượng google api client
     */
    protected synchronized void buildGoogleApiClient() {
        if (gac == null) {
            gac = new GoogleApiClient.Builder(this.context)
                    .addConnectionCallbacks(this)
                    .addOnConnectionFailedListener(this)
                    .addApi(LocationServices.API).build();
        }
    }

    /**
     * Phương thức kiểm chứng google play services trên thiết bị
     */
    private boolean checkPlayServices() {
        int resultCode = GooglePlayServicesUtil.isGooglePlayServicesAvailable(context);
        if (resultCode != ConnectionResult.SUCCESS) {
            if (GooglePlayServicesUtil.isUserRecoverableError(resultCode)) {
                GooglePlayServicesUtil.getErrorDialog(resultCode, (Activity)this.context, 1000).show();
            } else {
                Toast.makeText(context, "Thiết bị này không hỗ trợ.", Toast.LENGTH_LONG).show();
//                finish();
            }
            return false;
        }
        return true;
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        // Đã kết nối với google api, lấy vị trí
        getLocation();
    }

    @Override
    public void onConnectionSuspended(int i) {
        gac.connect();
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Toast.makeText(this.context, "Lỗi kết nối: " + connectionResult.getErrorMessage(), Toast.LENGTH_SHORT).show();
    }

}
