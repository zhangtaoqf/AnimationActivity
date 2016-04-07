package com.qf.zt.animationactivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.ImageView;

public class Main2Activity extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        imageView = ((ImageView) findViewById(R.id.imageViewId));
    }

    public void show(View view)
    {
        /**
         * 参数一：要执行动画的控件
         * 参数二、三：表示圆心坐标
         * 参数四、五：表示执行动画的开始半径和终止半径
         */
        Animator circularReveal = ViewAnimationUtils.createCircularReveal(imageView, imageView.getWidth() / 2, imageView.getHeight() / 2, 0, imageView.getWidth() / 2);

        circularReveal.setDuration(2000);

        circularReveal.addListener(new AnimatorListenerAdapter() {
            /**
             * 开始动画的监听
             * @param animation
             */
            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                imageView.setVisibility(View.VISIBLE);
            }
        });

        circularReveal.start();
    }


    public void hide(View view)
    {
        /**
         * 参数一：要执行动画的控件
         * 参数二、三：表示圆心坐标
         * 参数四、五：表示执行动画的开始半径和终止半径
         */
        Animator circularReveal = ViewAnimationUtils.createCircularReveal(imageView, imageView.getWidth() / 2, imageView.getHeight() / 2, imageView.getWidth() / 2, 0);

        circularReveal.setDuration(2000);

        circularReveal.addListener(new AnimatorListenerAdapter() {

            /**
             * 结束动画的回调
             * @param animation
             */
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                imageView.setVisibility(View.GONE);
            }
        });
        circularReveal.start();
    }
}
