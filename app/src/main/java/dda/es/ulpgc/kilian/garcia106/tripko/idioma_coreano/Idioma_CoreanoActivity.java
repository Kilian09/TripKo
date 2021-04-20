package dda.es.ulpgc.kilian.garcia106.tripko.idioma_coreano;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import dda.es.ulpgc.kilian.garcia106.tripko.R;

public class Idioma_CoreanoActivity
        extends AppCompatActivity implements Idioma_CoreanoContract.View {

    public static String TAG = Idioma_CoreanoActivity.class.getSimpleName();

    private Idioma_CoreanoContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_idioma_coreano);
        getSupportActionBar().setTitle(R.string.app_name);

    /*
    if(savedInstanceState == null) {
      AppMediator.resetInstance();
    }
    */

        // do the setup
        Idioma_CoreanoScreen.configure(this);

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

    @Override
    public void onDataUpdated(Idioma_CoreanoViewModel viewModel) {
        //Log.e(TAG, "onDataUpdated()");

        // deal with the data
       // ((TextView) findViewById(R.id.data)).setText(viewModel.data);
    }


    @Override
    public void navigateToNextScreen() {
        Intent intent = new Intent(this, Idioma_CoreanoActivity.class);
        startActivity(intent);
    }

    @Override
    public void injectPresenter(Idioma_CoreanoContract.Presenter presenter) {
        this.presenter = presenter;
    }
}