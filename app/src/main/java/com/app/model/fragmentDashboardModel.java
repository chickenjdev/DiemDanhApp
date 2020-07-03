package com.app.model;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.app.diemdanhapp.DashboardActivity;
import com.app.diemdanhapp.R;

import java.util.ArrayList;
import java.util.List;

public class fragmentDashboardModel {

    List<Object> subList = new ArrayList<Object>();
    Context context;

    public fragmentDashboardModel(Context context){
        this.context = context;
    }

    public void getDataMyClass(){
        String [] obj1 = {"IT0010.HTCL","Android","T2-13h00"};
        subList.add(obj1);
        String [] obj2 = {"IT0012.HTCL","Datamining","T2-13h00"};
        subList.add(obj2);
        String [] obj3 = {"IT0011.HTCL","DataBase","T2-13h00"};
        subList.add(obj3);
        String [] obj4 = {"IT0016.HTCL","Web","T2-13h00"};
        subList.add(obj4);
        subList.add(obj1);

    }
    public void getDataAllClass(){
        String [] obj1 = {"IT0033.HTCL","Android","T2-13h00"};
        subList.add(obj1);
        String [] obj2 = {"IT00132.HTCL","Datamining","T2-13h00"};
        subList.add(obj2);
        String [] obj3 = {"IT0025.HTCL","DataBase","T2-13h00"};
        subList.add(obj3);
        String [] obj4 = {"IT0022.HTCL","Web","T2-13h00"};
        subList.add(obj4);
        subList.add(obj1);

    }

    public void addSubject(LinearLayout scrollLayout){
        for(int index = 0; index < subList.size(); index++) {

            LinearLayout newCardView = new LinearLayout(this.context);

            newCardView.setPadding(20,30,0,0);
            newCardView.setOrientation(LinearLayout.VERTICAL);


            if (index % 2 == 0) {
                newCardView.setBackgroundResource(R.drawable.rounded_corner);
            } else {
                newCardView.setBackgroundResource(R.drawable.rounded_corner2);
            }



            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.height = 250;
            params.setMargins(50,10,50,10);
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
                    View nextChild = ((ViewGroup)v).getChildAt(0);
                    String text = ((TextView) nextChild).getText().toString();
                    Toast.makeText(context,"click " + text,Toast.LENGTH_LONG).show();
                }

            });

            scrollLayout.addView(newCardView);
        }
    }

}
