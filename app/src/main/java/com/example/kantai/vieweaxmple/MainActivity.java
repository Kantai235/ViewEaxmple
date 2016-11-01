package com.example.kantai.vieweaxmple;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // 如果首頁 Button 被點擊了，就觸發這項事件。
    public void main_Button_Click(View view) {
        // 建立 Intent 元件（應用程式的意圖或使用者的意圖）
        Intent intent = new Intent();
        // 篩選 view 傳入的 R.id
        switch (view.getId()) {
            // 如果這個 R.id 是 R.id.main_button_autoCompleteTextView
            case R.id.main_button_autoCompleteTextView:
                // 賦予 Intent(意圖) 事件的起始地、目的地
                intent.setClass(this, autoCompleteTextViewActivity.class);
                break;

            // 如果這個 R.id 是 R.id.main_button_draw2d
            case R.id.main_button_draw2d:
                // 賦予 Intent(意圖) 事件的起始地、目的地
                intent.setClass(this, draw2dActivity.class);
                break;

            // 如果這個 R.id 是 R.id.main_button_framAnimation
//            case R.id.main_button_framAnimation:
//                break;

            // 如果這個 R.id 是 R.id.main_button_gridView
//            case R.id.main_button_gridView:
//                break;

            // 如果這個 R.id 是 R.id.main_button_listView
//            case R.id.main_button_listView:
//                break;

            // 如果這個 R.id 是 R.id.main_button_recyclerCardView
//            case R.id.main_button_recyclerCardView:
//                break;

            // 如果這個 R.id 是 R.id.main_button_spinner
//            case R.id.main_button_spinner:
//                break;

            // 如果這個 R.id 是 R.id.main_button_tweenAnimation
//            case R.id.main_button_tweenAnimation:
//                break;

            // 如果這個 R.id 都不是以上的種類
            default:
                // 賦予 Intent(意圖) 事件的起始地、目的地
                intent.setClass(this, MainActivity.class);
                break;
        }
        // 啟動換頁活動
        startActivity(intent);
        // 結束當前的這一頁活動
        finish();
    }
}
