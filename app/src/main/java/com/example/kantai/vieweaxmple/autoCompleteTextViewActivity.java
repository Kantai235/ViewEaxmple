package com.example.kantai.vieweaxmple;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import java.util.ArrayList;

public class autoCompleteTextViewActivity extends AppCompatActivity {

    // 建立全域 AutoCompleteTextView 元件
    private AutoCompleteTextView textView;
    // 建立全域 ArrayAdapter<String> 轉接器元件
    private ArrayAdapter<String> arrayAdapter;
    // 建立全域 ArrayList<String> 存值的元件
    private ArrayList<String> countries = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_complete_text_view);
        // 設定 ArrayAdapter，採用系統預設的 android.R.layout.simple_dropdown_item_1line 樣式，並賦予資料 this.countries
        this.arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, this.countries);
        // 指定全域 AutoCompleteTextView 元件
        this.textView = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextViewActivity_autoCompleteTextView);
        // 指定閾值的實數
        this.textView.setThreshold(1);
        // 指定元件的橋接器(Adapter)
        this.textView.setAdapter(this.arrayAdapter);
        // 指定元件的 Item 如果被點擊的事件
        this.textView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            // 複寫
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // 取得被指定 Item 的內容
                String item = parent.getItemAtPosition(position).toString();
                // 利用吐司訊息 show 出被點擊的內容
                Toast.makeText(autoCompleteTextViewActivity.this, item, Toast.LENGTH_SHORT).show();
            }
        });
    }

    //
    public void autoCompleteTextView_Button_Click(View view) {
        // 取得 AutoCompleteTextView 輸入框的內容
        String editText = this.textView.getText().toString();
        // 將 AutoCompleteTextView 輸入框的內容設定為空 ""
        this.textView.setText("");
        // 如果輸入的內容為空
        if (editText.isEmpty()) {
            // 利用吐司訊息告知
            Toast.makeText(this, "內容不得為空。", Toast.LENGTH_SHORT).show();
            // 利用 checkData() 來確認輸入的內容是否重複
        } else if (this.checkData(editText)) {
            // 利用吐司訊息告知
            Toast.makeText(this, editText + " 這個內容已經存在了。", Toast.LENGTH_SHORT).show();
            // 如果輸入的內容不為空，且不重複
        } else {
            // 在 全域 ArrayList<String> 新增資料
            this.countries.add(editText);
        }
        // 刷新 Adapter 橋接器的資料
        updatedData(this.countries);
    }

    // 更新 Adapter 橋接器的資料
    private void updatedData(ArrayList<String> itemsArrayList) {
        // 刪除 Adapter 底層的資料
        this.arrayAdapter.clear();
        // 如果 itemsArrayList 不是空的
        if (itemsArrayList != null) {
            // 利用 foreach 探索所有 itemsArrayList 的值
            for (String str : itemsArrayList) {
                // 新增資料到 arrayAdapter 底層
                this.arrayAdapter.insert(str, this.arrayAdapter.getCount());
            }
        }
        // 更新 this.arrayAdapter 的資料
        this.arrayAdapter.notifyDataSetChanged();
    }

    // 確認 this.countries 的值是否重複，如果重複則回傳 true，如果沒有則回傳 false。
    private boolean checkData(String _str) {
        // 利用 foreach 探索所有 this.countries 的值
        for (String str : this.countries) {
            // 判斷 _str 是否等同 str
            if (_str.equals(str)) {
                // 回傳 true
                return true;
            }
        }
        // 回傳 false
        return false;
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