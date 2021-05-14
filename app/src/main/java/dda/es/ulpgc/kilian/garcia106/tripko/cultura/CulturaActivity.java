package dda.es.ulpgc.kilian.garcia106.tripko.cultura;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import dda.es.ulpgc.kilian.garcia106.tripko.R;

public class CulturaActivity
        extends AppCompatActivity implements CulturaContract.View {

    public static String TAG = CulturaActivity.class.getSimpleName();

    private CulturaContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cultura);
        getSupportActionBar().setTitle(R.string.app_name);

    /*
    if(savedInstanceState == null) {
      AppMediator.resetInstance();
    }
    */

        // do the setup
        CulturaScreen.configure(this);

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
    public void onDataUpdated(CulturaViewModel viewModel) {
        //Log.e(TAG, "onDataUpdated()");

        // deal with the data
        //((TextView) findViewById(R.id.data)).setText(viewModel.data);
    }


    @Override
    public void navigateToNextScreen() {
        Intent intent = new Intent(this, CulturaActivity.class);
        startActivity(intent);
    }

    @Override
    public void injectPresenter(CulturaContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
