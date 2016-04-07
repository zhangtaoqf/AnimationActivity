package com.qf.zt.animationactivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

/**
 * Activity的转场动画
 * 1、普通的转场动画
 *      在调用startActivtiy或者finish之后调用overridePendingTransition(R.anim.start_ac,R.anim.end_ac);
 * 2、Design包退出的动画
 *  1.将Style添加在Values/stylev21.文件中
 *      激活新特性事务动画
 *<item name="android:windowContentTransitions">true</item>
 *      添加界面进入，退出动画
 *      进入
 <item name="android:windowEnterTransition">@android:transition/fade</item>
        退出
 <item name="android:windowExitTransition">@android:transition/fade</item>

        getWindow().setEnterTransition(new Explode()); == 上面的进入动画
        getWindow().setExitTransition(new Explode()); ==  上面的退出动画

        说明：
        1.fade【淡入淡出】
        2.slide_bottom,left,top,right【滑动动画】
        3.explode【爆炸性的】
 *  2.给activity设置主题样式为上面的style
 *  3.startActivity(new Intent(this,Main2Activity.class), ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
 * 扩展
 * Fragment转场动画 调用fragment.setTransition(Animation);
 *
 *
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*getWindow().setEnterTransition(new Explode());
        getWindow().setExitTransition(new Explode());
        */
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void goToAnotherAc(View view) {


        //startActivity(new Intent(this,Main2Activity.class));
        //overridePendingTransition(R.anim.start_ac,R.anim.end_ac);
        startActivity(new Intent(this,Main2Activity.class), ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
    }
}
