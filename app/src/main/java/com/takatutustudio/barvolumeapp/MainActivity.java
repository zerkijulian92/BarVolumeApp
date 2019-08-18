package com.takatutustudio.barvolumeapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edtWidth, edtHeight, edtLength;
    Button btnCalculate;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtWidth = findViewById(R.id.edt_width);
        edtHeight = findViewById(R.id.edt_height);
        edtLength = findViewById(R.id.edt_lenght);
        btnCalculate = findViewById(R.id.btn_calculate);
        tvResult = findViewById(R.id.tv_result);

        //Button Calculate / Hasil ketika di klik
        btnCalculate.setOnClickListener(this);
    }

    //Fungsi dari btnCalculate
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_calculate) {
            String inputLenght = edtLength.getText().toString().trim();
            String inputWidth = edtWidth.getText().toString().trim();
            String inputHeight = edtHeight.getText().toString().trim();

            boolean isEmptyFields = false;
            boolean isInvalidDouble = false;

            //Pesan error ketika Edit Text Kosong tidak di isi oleh user

            if (TextUtils.isEmpty(inputLenght)) {
                isEmptyFields = true;
                edtLength.setError("Field ini tidak boleh kosong");
            }

            if (TextUtils.isEmpty(inputWidth)) {
                isEmptyFields = true;
                edtWidth.setError("Field ini tidak boleh kosong");
            }

            if (TextUtils.isEmpty(inputHeight)) {
                isEmptyFields = true;
                edtHeight.setError("Field ini tidak boleh kosong");
            }

            //-------------

            Double length = toDouble(inputLenght);
            Double width = toDouble(inputWidth);
            Double height = toDouble(inputHeight);

            if (length == null) {
                isInvalidDouble = true;
                edtLength.setError("Field ini harus berupa nomer yang valid");
            }

            if (width == null) {
                isInvalidDouble = true;
                edtWidth.setError("Field ini harus berupa nomer yang valid");
            }

            if (height == null) {
                isInvalidDouble = true;
                edtHeight.setError("Field ini harus berupa nomer yang valid");
            }

           //Melakukan action ketika data sudah di inputkan dan tidak mengalami error
            if ( !isEmptyFields && !isInvalidDouble) {
                double volume = length * width * height;
                tvResult.setText(String.valueOf(volume));
            }
        }

    }

    //Kode untuk validasi nilai Double ( Fungsi toDouble )
    Double toDouble(String str) {
        try {
            return Double.valueOf(str);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
