package com.example.kantai.vieweaxmple;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import java.util.ArrayList;
import java.util.List;

public class spinnerActivity extends AppCompatActivity {

    protected Spinner spinner;
    protected SpinnerAdapter spinnerAdapter;
    protected List<String> adapterData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        // 利用 for 迴圈去新增 Adapter 的資料
        for (int i = 0; i <= 20; i++)
            this.adapterData.add(String.valueOf(i));

               
        this.spinner = (Spinner) findViewById(R.id.spinnerActivity_spinner);
//        this.spinnerAdapter =
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }
}
