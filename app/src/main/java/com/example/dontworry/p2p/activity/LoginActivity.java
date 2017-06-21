package com.example.dontworry.p2p.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.dontworry.p2p.MyApplcattion.AppManager;
import com.example.dontworry.p2p.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        AppManager.getInstance().addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        AppManager.getInstance().removeActivity(this);
    }
}
