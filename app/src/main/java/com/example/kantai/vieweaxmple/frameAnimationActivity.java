package com.example.kantai.vieweaxmple;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;

public class frameAnimationActivity extends AppCompatActivity {

    private AnimationDrawable animationDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_animation);

        this.animationDrawable = new AnimationDrawable();
        this.animationDrawable.setOneShot(false);

//        for (int i = 0; i <= 255; i++) {
//            this.animationDrawable.addFrame(getResources().getDrawable(R.mipmap.ic_launcher), 1);
//        }

        ImageView ivPicture = (ImageView) findViewById(R.id.frameAnimationActivity_imageView);
//        ivPicture.setBackground(animationDrawable);

//        Drawable drawable = ContextCompat.getDrawable(this, R.mipmap.ic_launcher);
//        Drawable.ConstantState state = drawable.getConstantState();
//        Drawable drawable1 = DrawableCompat.wrap(state == null ? drawable : state.newDrawable()).mutate();
//        drawable1.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
//        DrawableCompat.setTint(drawable, ContextCompat.getColor(this, R.color.bootstrap_alert_cross_default));
//        ivPicture.setImageDrawable(drawable);
//        imageView.setImageDrawable(drawable);
//        imageView1.setImageDrawable(drawable1);


        Drawable drawable = ContextCompat.getDrawable(this, R.mipmap.ic_launcher);
        int[] colors = new int[]{
                ContextCompat.getColor(this, R.color.bootstrap_brand_secondary_border),
                ContextCompat.getColor(this, R.color.bootstrap_alert_cross_default)
        };
        int[][] states = new int[2][];
        states[0] = new int[]{android.R.attr.state_pressed};
        states[1] = new int[]{};
        ColorStateList colorList = new ColorStateList(states, colors);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(states[0], drawable);//注意顺序
        stateListDrawable.addState(states[1], drawable);
        Drawable.ConstantState state = stateListDrawable.getConstantState();
        drawable = DrawableCompat.wrap(state == null ? stateListDrawable : state.newDrawable()).mutate();
        DrawableCompat.setTintList(drawable, colorList);
        ivPicture.setImageDrawable(drawable);

    }

    public void onPictureClick(View view) {
//        if (!this.animationDrawable.isRunning())
//            this.animationDrawable.start();
//        else
//            this.animationDrawable.stop();
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
