package com.example.kantai.vieweaxmple;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    /**
     * 講義：
     * http://epaper.gotop.com.tw/PDFSample/AEL016331.pdf
     *
     * 採用：
     * https://github.com/Bearded-Hen/Android-Bootstrap
     */

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
            case R.id.main_button_framAnimation:
                // 賦予 Intent(意圖) 事件的起始地、目的地
                intent.setClass(this, frameAnimationActivity.class);
                break;

            // 如果這個 R.id 是 R.id.main_button_gridView
            case R.id.main_button_gridView:
                // 賦予 Intent(意圖) 事件的起始地、目的地
                intent.setClass(this, gridViewActivity.class);
                break;

            // 如果這個 R.id 是 R.id.main_button_listView
            case R.id.main_button_listView:
                // 賦予 Intent(意圖) 事件的起始地、目的地
                intent.setClass(this, listViewActivity.class);
                break;

            // 如果這個 R.id 是 R.id.main_button_recyclerCardView
            case R.id.main_button_recyclerCardView:
                // 賦予 Intent(意圖) 事件的起始地、目的地
                intent.setClass(this, recyclerCardViewActivity.class);
                break;

            // 如果這個 R.id 是 R.id.main_button_spinner
            case R.id.main_button_spinner:
                // 賦予 Intent(意圖) 事件的起始地、目的地
                intent.setClass(this, spinnerActivity.class);
                break;

            // 如果這個 R.id 是 R.id.main_button_tweenAnimation
            case R.id.main_button_tweenAnimation:
                // 賦予 Intent(意圖) 事件的起始地、目的地
                intent.setClass(this, tweenAnimationActivity.class);
                break;

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
