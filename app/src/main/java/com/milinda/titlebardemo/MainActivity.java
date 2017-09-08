package com.milinda.titlebardemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.milinda.titlebar.TitleBar;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TitleBar titleBar=(TitleBar) findViewById(R.id.titleBar);
        titleBar.setTitleContent("标题栏");
        titleBar.setEditContent("编辑");
    }
}
