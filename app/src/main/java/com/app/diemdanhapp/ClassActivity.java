package com.app.diemdanhapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.app.model.userInfo;
import com.app.service.gpsService;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class ClassActivity extends Activity {

    FirebaseFirestore db;
    TextView txtSubCode, txtTittle, txtSubName, txtSubTime, txtTchName, txtStdCount;
    Button btnDiemdanh;
    TabLayout tablayoutDashBoard;

    String[] stdList = null;
    String classCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thongtinmonhoc);

        txtSubCode = (TextView) findViewById(R.id.txtSubCode);
        txtTittle = (TextView) findViewById(R.id.txtTittle);
        txtSubName = (TextView) findViewById(R.id.txtSubname);
        txtSubTime = (TextView) findViewById(R.id.txtSubTime);
        txtTchName = (TextView) findViewById(R.id.txtTchName);
        txtStdCount = (TextView) findViewById(R.id.txtStdCount);
        btnDiemdanh = (Button) findViewById(R.id.btnDiemdanh);
        tablayoutDashBoard = (TabLayout) findViewById(R.id.tablayoutDashBoard);

        classCode = getIntent().getStringExtra("CLASS_CODE");
        Object classInfo = (Object) getIntent().getSerializableExtra("CLASS_INFO");

        txtSubCode.setText(classCode);
        txtSubName.setText(((String[]) classInfo)[1]);
        txtSubTime.setText(((String[]) classInfo)[2]);

        tablayoutDashBoard.getTabAt(0).setText(classCode);

        // If teacher
        if (userInfo.getType().equals("teacher")) {
            //get student list
            stdList = getStudentList((((String[]) classInfo)[3]));

            txtStdCount.setText("Số lượng: " + stdList.length);

            checkClass(classCode);

        } else {
            txtStdCount.setText("Danh sách điểm danh ");
        }

        btnDiemdanh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (userInfo.getType().equals("std")) {
                    Intent attend = new Intent(ClassActivity.this, AttendActivity.class);
                    attend.putExtra("CLASS_CODE",classCode);
                    startActivity(attend);
                }else {
                    Intent attendCre = new Intent(ClassActivity.this, AttendCreActivity.class);
                    attendCre.putExtra("CLASS_CODE",classCode);
                    startActivity(attendCre);
                }
            }
        });

    }

    public String[] getStudentList(String str) {
        JSONArray jsonArray = null;
        try {
            jsonArray = new JSONArray(str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String[] strArr = new String[jsonArray.length()];
        for (int i = 0; i < jsonArray.length(); i++) {
            try {
                strArr[i] = jsonArray.getString(i);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return strArr;
    }

    public void checkClass(final String classCode) {
        db = FirebaseFirestore.getInstance();
        final DocumentReference docRef = db.collection("enroll").document(classCode);
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        Log.d("CRE", "class enroll data: " + document.getData());

//                        updateUI(1);

                    } else {
                        Log.d("CRE", "Khong tim thay enroll data " + classCode);
                        createEnrollClass(classCode);
                    }
                } else {
                    Log.d("CRE", "get failed with ", task.getException());
                }
            }
        });
    }

    public void createEnrollClass(final String classCode) {
        db = FirebaseFirestore.getInstance();

        // Add session data
        final Map<String, Object> enrollData = new HashMap<>();
        enrollData.put("session", 0);
        enrollData.put("sessionCount", 0);

        db.collection("enroll").document(classCode)
                .set(enrollData)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d("CRE", classCode + " Enroll Class successfully written!");

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w("CRE", "Error writing document", e);
                    }
                });

        // Add enroll class student info

        Map<String, Object> student_info = new HashMap<>();
//        student_info.put("code","khoideptraitest");
//        student_info.put("location","10.0001010,101.010923");

        Map<String, Object> std_attend = new HashMap<>();
//        std_attend.put("17520650",student_info);

        final Map<String, Object> sessionDataStd = new HashMap<>();
        sessionDataStd.put("std_attend", std_attend);
        sessionDataStd.put("student", new ArrayList<>());

        db.collection("enroll").document(classCode).collection("std").document("0")
                .set(sessionDataStd)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d("CRE", classCode + " Enroll Class successfully written!");

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w("CRE", "Error writing document", e);
                    }
                });

        final Map<String, Object> sessionDataTch = new HashMap<>();
        sessionDataTch.put("code", "khoideptraitest");
        sessionDataTch.put("day", "05/07/2020");
        sessionDataTch.put("inactive", true);
        sessionDataTch.put("location", "10.1231451,102.32342621");

        db.collection("enroll").document(classCode).collection("teacher").document("0")
                .set(sessionDataTch)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d("CRE", classCode + " Enroll Class successfully written!");

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w("CRE", "Error writing document", e);
                    }
                });

    }
}
