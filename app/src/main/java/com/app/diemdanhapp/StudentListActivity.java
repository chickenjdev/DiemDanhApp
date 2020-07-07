package com.app.diemdanhapp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.app.adapter.CustomListAdapter;
import com.app.diemdanhapp.R;
import com.app.model.Student;
import com.app.model.getStudentList;
import com.app.model.userInfo;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class StudentListActivity extends Activity {
    FirebaseFirestore db;
    ListView listStd;
    Button btnBack;
    TabLayout tablayoutDashBoard;
    String classCode;

    String[] stdList = null;
    List<Student> stdListOfClass;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        classCode = getIntent().getStringExtra("CLASS_CODE");

        setContentView(R.layout.stdlist);


        listStd = findViewById(R.id.listStd);
        tablayoutDashBoard = findViewById(R.id.tablayoutDashBoard);
        btnBack = findViewById(R.id.btnBack);


        tablayoutDashBoard.getTabAt(0).setText(classCode);


        listStd.setAdapter(new CustomListAdapter(StudentListActivity.this, getStudentList.listStdForTeacher));

        for(int i=0;i<getStudentList.listStdForTeacher.size();i++){
            Log.d("CRE",getStudentList.listStdForTeacher.get(i).getStdCode());
        }
//        getListData();

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        listStd.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Object obj = listStd.getItemAtPosition(position);
                Student std = (Student) obj;
                Toast.makeText(StudentListActivity.this, "Selected :" + " " + std, Toast.LENGTH_LONG).show();
            }
        });

    }


}
