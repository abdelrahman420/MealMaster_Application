package com.example.mealmaster.presenter;

import android.os.Handler;

import com.example.mealmaster.view.activity.splah_screen.SplashScreenView;

public class SplashScreenPresenter {


        private final SplashScreenView view;

        public SplashScreenPresenter(SplashScreenView view) {
            this.view = view;
        }


        public void startSplashDelay() {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    view.navigateToMainActivity();
                }
            }, 6000); // 6 seconds delay
        }

}
