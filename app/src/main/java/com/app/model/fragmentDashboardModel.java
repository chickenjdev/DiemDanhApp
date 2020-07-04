package com.app.model;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.app.diemdanhapp.ClassActivity;
import com.app.diemdanhapp.DashboardActivity;
import com.app.diemdanhapp.ProfileActivity;
import com.app.diemdanhapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class fragmentDashboardModel {

    List<Object> subListMyClass;
    List<Object> subListAllClass;
    Context context;

    FirebaseFirestore db;

    public fragmentDashboardModel(Context context) {
        this.context = context;
        db = FirebaseFirestore.getInstance();


    }

    public void getDataMyClass(final LinearLayout scrollLayout){
        subListMyClass = new ArrayList<Object>();
            Log.d("FIRE","get class for "+ userInfo.getCode());
           db.collection("class").whereArrayContains("student", userInfo.getCode().replace("@uit.edu.vn",""))
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d("FIRE", "Class : ========= "+ document.getId()+" " + document.getData());

                                String time = "Thứ "+((HashMap<String,Number>)document.getData().get("time")).get("day")+" : "
                                        +((HashMap<String,Number>)document.getData().get("time")).get("time")+" Giờ, "
                                        +((HashMap<String,Number>)document.getData().get("time")).get("duration")+" Tiết";

                                String [] obj = {document.getId()
                                        ,(String)document.getData().get("sub_name")
                                        ,time};

                                subListMyClass.add(obj);
                            }

//                            for (int i = 0;i < subListMyClass.size(); i++) {
//                                Log.d("FIRE",((String[])subListMyClass.get(i))[0]+"-"+((String[])subListMyClass.get(i))[1]+"-"+((String[])subListMyClass.get(i))[2]);
//                            }
                            addSubject(scrollLayout,subListMyClass);
                        } else {
                            Log.w("FIRE", "Error getting documents.", task.getException());
                        }
                    }
                });


    }
    public void getDataAllClass(final LinearLayout scrollLayout){
        subListAllClass = new ArrayList<Object>();
        db.collection("class").limit(20)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d("FIRE", "Class : ========= "+ document.getId()+" " + document.getData());
                                try {
                                    String time = "Thứ "+((HashMap<String,Number>)document.getData().get("time")).get("day")+" : "
                                            +((HashMap<String,Number>)document.getData().get("time")).get("time")+" Giờ, "
                                            +((HashMap<String,Number>)document.getData().get("time")).get("duration")+" Tiết";

                                    String [] obj = {document.getId()
                                            ,(String)document.getData().get("sub_name")
                                            ,time};

                                    subListAllClass.add(obj);
                                }catch (Exception e){

                                };
                            }

//                            for (int i = 0;i < subListMyClass.size(); i++) {
//                                Log.d("FIRE",((String[])subListMyClass.get(i))[0]+"-"+((String[])subListMyClass.get(i))[1]+"-"+((String[])subListMyClass.get(i))[2]);
//                            }
                            addSubject(scrollLayout,subListAllClass);
                        } else {
                            Log.w("FIRE", "Error getting documents.", task.getException());
                        }
                    }
                });
    }

    public void getDataClassTeacher(final LinearLayout scrollLayout){
        subListMyClass = new ArrayList<Object>();
        Log.d("FIRE","get class for "+ userInfo.getCode());
        db.collection("class").whereEqualTo("teacher", userInfo.getCode().replace("@uit.edu.vn",""))
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d("FIRE", "Class : ========= "+ document.getId()+" " + document.getData());

                                String time = "Thứ "+((HashMap<String,Number>)document.getData().get("time")).get("day")+" : "
                                        +((HashMap<String,Number>)document.getData().get("time")).get("time")+" Giờ, "
                                        +((HashMap<String,Number>)document.getData().get("time")).get("duration")+" Tiết";

                                String [] obj = {document.getId()
                                        ,(String)document.getData().get("sub_name")
                                        ,time};

                                subListMyClass.add(obj);
                            }

//                            for (int i = 0;i < subListMyClass.size(); i++) {
//                                Log.d("FIRE",((String[])subListMyClass.get(i))[0]+"-"+((String[])subListMyClass.get(i))[1]+"-"+((String[])subListMyClass.get(i))[2]);
//                            }
                            addSubject(scrollLayout,subListMyClass);
                        } else {
                            Log.w("FIRE", "Error getting documents.", task.getException());
                        }
                    }
                });


    }

    public void addSubject(LinearLayout scrollLayout,List<Object> subList){
        for(int index = 0; index < subList.size(); index++) {

            LinearLayout newCardView = new LinearLayout(this.context);

            newCardView.setPadding(20,30,0,0);
            newCardView.setOrientation(LinearLayout.VERTICAL);


            if (index % 2 == 0) {
//                newCardView.setBackgroundResource(R.drawable.rounded_corner);
                newCardView.setBackgroundColor(Color.parseColor("#ff7f00"));
            } else {
//                newCardView.setBackgroundResource(R.drawable.rounded_corner2);
                newCardView.setBackgroundColor(Color.parseColor("#00a1ff"));
            }


            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.height = 250;
//            params.setMargins(50,10,50,10);
            newCardView.setLayoutParams(params);

            final TextView txtCode = new TextView(this.context);
            txtCode.setText(((String[])subList.get(index))[0]);
            txtCode.setPadding(20,10,10,10);
            txtCode.setTextColor(Color.WHITE);
            txtCode.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);

            final TextView txtName = new TextView(this.context);
            txtName.setText(((String[])subList.get(index))[1]);
            txtName.setPadding(20,10,10,10);
            txtName.setTextColor(Color.WHITE);

            final TextView txtTime = new TextView(this.context);
            txtTime.setText(((String[])subList.get(index))[2]);
            txtTime.setPadding(20,10,30,0);
            txtTime.setTextColor(Color.WHITE);
            txtTime.setGravity(Gravity.RIGHT);

            LinearLayout.LayoutParams dimTxt = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(10,10,10,10);

            txtCode.setLayoutParams(dimTxt);
            txtName.setLayoutParams(dimTxt);

            newCardView.addView(txtCode,0);
            newCardView.addView(txtName,1);
            newCardView.addView(txtTime,2);

            newCardView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v) {
                    View code = ((ViewGroup)v).getChildAt(0);
                    String textCode = ((TextView) code).getText().toString();
                    Toast.makeText(context,"click " + textCode,Toast.LENGTH_LONG).show();
                    boolean enrolled = false;
                    int i = 0;
                    while (!enrolled && i<subListMyClass.size()){
                        if(((String[])subListMyClass.get(i))[0].equals(textCode)){
                            enrolled = true;
                        }
                        i++;
                    }
                   if(enrolled){
                       Log.d("CRE","enrolled");
                       Intent classActivity = new Intent(context, ClassActivity.class);
                       classActivity.putExtra("CLASS_CODE", textCode);
                       context.startActivity(classActivity);
                   }else {
                       Log.d("CRE","new class");
                   }
                }

            });

            scrollLayout.addView(newCardView);
        }
    }

}
