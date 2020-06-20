package com.example.diemdanhapp;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MonHocAdapter extends BaseAdapter {
    final ArrayList<MonHoc> listMonHoc;

    MonHocAdapter(ArrayList<MonHoc> listMonHoc) {
        this.listMonHoc = listMonHoc;
    }

    @Override
    public int getCount() {
        return listMonHoc.size();
    }

    @Override
    public Object getItem(int position) {
        return listMonHoc.get(position);
    }

    @Override
    public long getItemId(int position) {
        return listMonHoc.get(position).ID;
    }

    @SuppressLint("DefaultLocale")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View viewMonHoc;
        if (convertView == null) {
            viewMonHoc = View.inflate(parent.getContext(), R.layout.list_diemdanh, null);
        } else viewMonHoc = convertView;
        MonHoc monHoc = (MonHoc) getItem(position);
        ((TextView) viewMonHoc.findViewById(R.id.monhoc)).setText(String.format("Mon Hoc : ", monHoc.TenMon));
        ((TextView) viewMonHoc.findViewById(R.id.giangvien)).setText(String.format("Giang Vien :", monHoc.GiangVien));
        ((TextView) viewMonHoc.findViewById(R.id.id)).setText(String.format("ID :", monHoc.ID));
        return viewMonHoc;

    }
}
