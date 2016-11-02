package com.example.kantai.vieweaxmple;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;


public class listViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        // 指定在頁面當中的 ListView 元件
        ListView listView = (ListView) findViewById(R.id.activity_list_view_listView);
        // 賦予 ListView 一個 Adapter 元件
        listView.setAdapter(new PostAdapter(this));
        // 賦予 OnItemClick 選項被點擊的事件
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // 取得被點擊的 Item(Cell)
                Post post = (Post) parent.getItemAtPosition(position);
                // 取得 Item(Cell) 當中的 Arg 與 Name
                String text = "Arg : " + post.getArg() + "\nName : " + post.getName();
                // 以 Toast(吐司訊息) show 出內容
                Toast.makeText(listViewActivity.this, text, Toast.LENGTH_SHORT).show();
            }
        });
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