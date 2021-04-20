package dda.es.ulpgc.kilian.garcia106.tripko.idioma;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import dda.es.ulpgc.kilian.garcia106.tripko.R;

public class IdiomaActivity
        extends AppCompatActivity implements IdiomaContract.View {

    public static String TAG = IdiomaActivity.class.getSimpleName();

    private IdiomaContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_idioma);
        getSupportActionBar().setTitle(R.string.app_name);

    /*
    if(savedInstanceState == null) {
      AppMediator.resetInstance();
    }
    */

        // do the setup
        IdiomaScreen.configure(this);

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
    public void onDataUpdated(IdiomaViewModel viewModel) {
        //Log.e(TAG, "onDataUpdated()");

        // deal with the data
        //((TextView) findViewById(R.id.data)).setText(viewModel.data);
    }


    @Override
    public void navigateToNextScreen() {
        Intent intent = new Intent(this, IdiomaActivity.class);
        startActivity(intent);
    }

    @Override
    public void injectPresenter(IdiomaContract.Presenter presenter) {
        this.presenter = presenter;
    }
}