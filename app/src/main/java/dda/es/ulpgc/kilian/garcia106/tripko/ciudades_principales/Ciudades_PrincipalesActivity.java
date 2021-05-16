package dda.es.ulpgc.kilian.garcia106.tripko.ciudades_principales;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import dda.es.ulpgc.kilian.garcia106.tripko.R;

public class Ciudades_PrincipalesActivity
        extends AppCompatActivity implements Ciudades_PrincipalesContract.View {

    public static String TAG = Ciudades_PrincipalesActivity.class.getSimpleName();

    private Ciudades_PrincipalesContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ciudades_principales);
        getSupportActionBar().setTitle(R.string.app_name);

    /*
    if(savedInstanceState == null) {
      AppMediator.resetInstance();
    }
    */

        // do the setup
        Ciudades_PrincipalesScreen.configure(this);

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
    public void onDataUpdated(Ciudades_PrincipalesViewModel viewModel) {
        //Log.e(TAG, "onDataUpdated()");

        // deal with the data
        //((TextView) findViewById(R.id.data)).setText(viewModel.data);
    }


    @Override
    public void navigateToNextScreen() {
        Intent intent = new Intent(this, Ciudades_PrincipalesActivity.class);
        startActivity(intent);
    }

    @Override
    public void injectPresenter(Ciudades_PrincipalesContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
