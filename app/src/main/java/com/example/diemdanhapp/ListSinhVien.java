package com.example.diemdanhapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ListSinhVien extends AppCompatActivity {
    ArrayList<SinhVien> listSinhVien;
    SinhVienListViewAdapter sinhVienListViewAdapter;
    ListView listViewSinhVien;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listsinhvien);
        listSinhVien = new ArrayList<>();
        listSinhVien.add(new SinhVien(1, "A", 100));
        listSinhVien.add(new SinhVien(5, "B", 100));
        listSinhVien.add(new SinhVien(7, "A", 100));
        listSinhVien.add(new SinhVien(2, "A", 100));
        listSinhVien.add(new SinhVien(6, "A", 100));
        listSinhVien.add(new SinhVien(7, "A", 100));
        listSinhVien.add(new SinhVien(2, "A", 100));
        listSinhVien.add(new SinhVien(6, "A", 100));
        listSinhVien.add(new SinhVien(7, "A", 100));
        listSinhVien.add(new SinhVien(2, "A", 100));
        listSinhVien.add(new SinhVien(6, "A", 100));



        sinhVienListViewAdapter = new SinhVienListViewAdapter(listSinhVien);

        listViewSinhVien = findViewById(R.id.listproduct);
        listViewSinhVien.setAdapter(sinhVienListViewAdapter);
    }
}