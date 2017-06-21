package com.example.dontworry.p2p.activity;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.dontworry.p2p.MyApplcattion.AppManager;
import com.example.dontworry.p2p.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SplashActivity extends AppCompatActivity {

    @Bind(R.id.iv_welcome_icon)
    ImageView ivWelcomeIcon;
    @Bind(R.id.splash_tv_version)
    TextView splashTvVersion;
    @Bind(R.id.activity_splash)
    RelativeLayout activitySplash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);

        initView();
        initData();
        initListener();
    }

    private void initListener() {

    }

    private void initData() {
        AlphaAnimation aa = new AlphaAnimation(0, 1);
        aa.setDuration(2000);

        aa.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if (isLogin()) {
                    Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                    startActivity(intent);

                } else {
                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                }
                //清除动画
                ivWelcomeIcon.clearAnimation();
                //关闭动画
                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }

        });

        ivWelcomeIcon.startAnimation(aa);

    }

    private boolean isLogin() {
        return false;
    }

    private void initView() {
        splashTvVersion.setText(getVersionCode());
    }

    private String getVersionCode() {
        try {
            PackageInfo info = getPackageManager().getPackageInfo(getPackageName(), 0);
            //应用市场区分是否有新版本更新
            int versionCode = info.versionCode;
            //给用户看的
            String versionName = info.versionName;
            return versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }


        return "3";
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        AppManager.getInstance().removeActivity(this);
    }
}
