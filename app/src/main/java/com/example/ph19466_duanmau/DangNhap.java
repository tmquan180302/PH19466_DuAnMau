 package com.example.ph19466_duanmau;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.ph19466_duanmau.dao.ThuThuDAO;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class DangNhap extends AppCompatActivity {
    TextInputLayout txt_tk,txt_mk;
    Button btn_dangNhap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);
        txt_tk = findViewById(R.id.txt_tk);
        txt_mk = findViewById(R.id.txt_mk);
        btn_dangNhap =findViewById(R.id.btn_dangNhap);

        ThuThuDAO thuThuDAO = new ThuThuDAO(this);

        btn_dangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user,pass;
                user = txt_tk.getEditText().getText().toString();
                pass = txt_mk.getEditText().getText().toString();

                if (thuThuDAO.checkDangNhap(user,pass)){
                    SharedPreferences sharedPreferences = getSharedPreferences("THONGTIN",MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("matt",user);
                    editor.commit();
                    startActivity( new Intent(DangNhap.this,MainActivity.class));
                }else {
                    txt_mk.setError("Tài khoản hoặc mật khẩu không đúng");
                }
            }
        });
    }
}