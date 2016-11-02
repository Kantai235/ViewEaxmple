package com.example.kantai.vieweaxmple;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class gridViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);

        // 指定在頁面當中的 GridView 元件
        GridView gridView = (GridView) findViewById(R.id.activity_grid_view_gridView);
        // 賦予 GridView 一個 Adapter 元件
        gridView.setAdapter(new PostAdapter(this));
        // 賦予 OnItemClick 選項被點擊的事件
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // 取得被點擊的 Item(Cell)
                Post post = (Post) parent.getItemAtPosition(position);
                // 建立一個 ImageView
                ImageView imageView = new ImageView(gridViewActivity.this);
                // 把被點擊的 Image 放到剛剛建立的 ImageView 當中
                imageView.setImageResource(post.getImage());
                // 新建一個 Toast(吐司訊息)
                Toast toast = new Toast(gridViewActivity.this);
                // 把 ImageView 塞到 Toast(吐司訊息) 當中
                toast.setView(imageView);
                // 設定 Toast(吐司訊息) 的顯示持續時間
                toast.setDuration(Toast.LENGTH_SHORT);
                // 讓 Toast(吐司訊息) show 在畫面上
                toast.show();
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