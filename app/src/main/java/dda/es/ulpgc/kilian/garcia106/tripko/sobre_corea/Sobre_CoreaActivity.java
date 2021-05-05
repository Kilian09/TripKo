package dda.es.ulpgc.kilian.garcia106.tripko.sobre_corea;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;


import androidx.appcompat.app.AppCompatActivity;

import dda.es.ulpgc.kilian.garcia106.tripko.R;

public class Sobre_CoreaActivity
        extends AppCompatActivity implements Sobre_CoreaContract.View {

    public static String TAG = Sobre_CoreaActivity.class.getSimpleName();

    private Sobre_CoreaContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobre_corea);
        getSupportActionBar().setTitle(R.string.app_name);

    /*
    if(savedInstanceState == null) {
      AppMediator.resetInstance();
    }
    */

        // do the setup
        Sobre_CoreaScreen.configure(this);

        if (savedInstanceState == null) {
            presenter.onStart();

        } else {
            presenter.onRestart();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        // load the data
        presenter.onResume();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        presenter.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();

        presenter.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        presenter.onDestroy();
    }
/*
    @Override
    public void onDataUpdated(Sobre_CoreaViewModel viewModel) {
        //Log.e(TAG, "onDataUpdated()");

        // deal with the data
        ((TextView) findViewById(R.id.data)).setText(viewModel.data);
    }

 */


    @Override
    public void navigateToNextScreen() {
        Intent intent = new Intent(this, Sobre_CoreaActivity.class);
        startActivity(intent);
    }

    @Override
    public void injectPresenter(Sobre_CoreaContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
