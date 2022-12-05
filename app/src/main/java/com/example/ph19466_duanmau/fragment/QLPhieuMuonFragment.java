package com.example.ph19466_duanmau.fragment;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.example.ph19466_duanmau.R;
import com.example.ph19466_duanmau.adapter.PhieuMuonAdapter;
import com.example.ph19466_duanmau.dao.PhieuMuonDAO;
import com.example.ph19466_duanmau.dao.ThanhVienDao;
import com.example.ph19466_duanmau.model.PhieuMuon;
import com.example.ph19466_duanmau.model.ThanhVien;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.HashMap;


public class QLPhieuMuonFragment extends Fragment {



    public QLPhieuMuonFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view  = inflater.inflate(R.layout.fragment_q_l_phieu_muon, container, false);
        RecyclerView recyclerViewQLPhieuMuon = view.findViewById(R.id.recycleQLPhieuMuon);
        FloatingActionButton floatingActionButton = view.findViewById(R.id.floatAdd);
        // giao diẹn

        // data
        PhieuMuonDAO phieuMuonDAO = new PhieuMuonDAO(getContext());
        ArrayList<PhieuMuon> list = phieuMuonDAO.getDSPhieuMuon();

        //adapter
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerViewQLPhieuMuon.setLayoutManager(linearLayoutManager);
        PhieuMuonAdapter adapter = new PhieuMuonAdapter(list,getContext());
        recyclerViewQLPhieuMuon.setAdapter(adapter);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });
        return view;
    }
    private  void  showDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_them_phieumuon,null);
        Spinner spnThanhVien = view.findViewById(R.id.spnThanhVien);
        Spinner spnSach = view.findViewById(R.id.spnSach);
        EditText edtTien = view.findViewById(R.id.edtTien);
        builder.setView(view);

        builder.setPositiveButton("Thêm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.setNegativeButton("Huỷ", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();


    }
    private void getDataThanhvien(Spinner spinnerThanhVien){
        ThanhVienDao thanhVienDao = new ThanhVienDao(getContext());
        ArrayList<ThanhVien> list = thanhVienDao.getDSThanhVien();

        ArrayList<HashMap<String,Object>> listHM = new ArrayList<>();

    }
}