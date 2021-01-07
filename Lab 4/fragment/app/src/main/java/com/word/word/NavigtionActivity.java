package com.word.word;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class NavigtionActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    /**
     * onCreate()是在Activity创建时被dao系统调用du，是一个Activity生命周期的开始；它主zhi要做这个activity启动时一些必dao要的初始化工作版，
     * 这个函数调用完权后，这个activity并不是说就已经启动了，或者是跳到前台了。
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigtion);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        /**
         * 此方法用于初始化菜单，其中menu参数就是即将要显示的Menu实例。 返回true则显示该menu,false 则不显示;
         * (只会在第一次初始化菜单时调用) Inflate the menu; this adds items to the action bar
         * if it is present.
         */
        getMenuInflater().inflate(R.menu.navigtion, menu);
        return true;
    }

    //后退按钮事件
    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        /**
         * 菜单项被点击时调用，也就是菜单项的监听方法。
         * 通过这几个方法，可以得知，对于Activity，同一时间只能显示和监听一个Menu 对象。 TODO Auto-generated
         * method stub
         */
        if (item.getItemId() == R.id.action_settings) {
            Intent intent = new Intent(NavigtionActivity.this, SettingActivity.class);
            //该方法的第一个参数是intent,第二个参数是请求代码。
            startActivityForResult(intent, 1);
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }

    }

    //从子Activity获取返回结果
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            //从子Activity获取返回结果
            String string = data.getStringExtra("data");
            Fragment mMainNavFragment = getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
            //获取指定的fragment
            NavController navController = NavHostFragment.findNavController(mMainNavFragment);
            int currentFragmentId = navController.getCurrentDestination().getId();
            for (Fragment fragment : mMainNavFragment.getChildFragmentManager().getFragments()) {
               if(fragment instanceof HomeActivity){
                   //在Activity调用Fragment的方法，实现Fragment与Activity的通讯
                   ((HomeActivity)fragment).onTypeClick(string);
               }
            }
        }
    }

    //定义一个方法，提供Fragment调用，实现Fragment与Activity的通讯
    public void setTitleVal(String titleVal) {
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(titleVal);
    }

}
