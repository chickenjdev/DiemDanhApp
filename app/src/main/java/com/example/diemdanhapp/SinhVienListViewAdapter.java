package com.example.diemdanhapp;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class SinhVienListViewAdapter extends BaseAdapter {
    final ArrayList<SinhVien> listSinhVien;
    SinhVienListViewAdapter(ArrayList<SinhVien> listSinhVien) {
        this.listSinhVien = listSinhVien;
    }
    @Override
    public int getCount() {
        return listSinhVien.size();
    }

    @Override
    public Object getItem(int position) {
        return listSinhVien.get(position);
    }

    @Override
    public long getItemId(int position) {
        return listSinhVien.get(position).mssv;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View viewProduct;
        if (convertView == null) {
            viewProduct = View.inflate(parent.getContext(), R.layout.sinhvienview, null);
        } else viewProduct = convertView;

        //Bind sữ liệu phần tử vào View
        SinhVien sinhVien = (SinhVien) getItem(position);
        ((TextView) viewProduct.findViewById(R.id.mssv)).setText(String.format("MSSV : %d", sinhVien.mssv));
        ((TextView) viewProduct.findViewById(R.id.name)).setText(String.format("Tên  : %s", sinhVien.name));
        ((TextView) viewProduct.findViewById(R.id.sobuoi)).setText(String.format("SOBUOIDIHOC : %d", sinhVien.sobuoidihoc));




        return viewProduct;
    }
}
