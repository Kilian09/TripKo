package dda.es.ulpgc.kilian.garcia106.tripko.splash;


import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;


import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

import dda.es.ulpgc.kilian.garcia106.tripko.R;
import dda.es.ulpgc.kilian.garcia106.tripko.menu_principal.Menu_PrincipalActivity;

public class SplashActivity
        extends AppCompatActivity implements SplashContract.View {

    public static String TAG = SplashActivity.class.getSimpleName();

    private SplashContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        TimerTask tarea = new TimerTask(){
            @Override
            public void run(){
                Intent intent = new Intent(SplashActivity.this, Menu_PrincipalActivity.class);
                startActivity(intent);
                finish();
            }
        };

        Timer tiempo = new Timer();
        tiempo.schedule(tarea,3000);


        // do the setup
        SplashScreen.configure(this);


    }


    @Override
    public void injectPresenter(SplashContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
