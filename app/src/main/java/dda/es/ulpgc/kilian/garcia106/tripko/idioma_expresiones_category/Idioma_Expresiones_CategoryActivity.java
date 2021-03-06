package dda.es.ulpgc.kilian.garcia106.tripko.idioma_expresiones_category;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import dda.es.ulpgc.kilian.garcia106.tripko.R;

public class Idioma_Expresiones_CategoryActivity
        extends AppCompatActivity implements Idioma_Expresiones_CategoryContract.View {

    public static String TAG = Idioma_Expresiones_CategoryActivity.class.getSimpleName();

    private Idioma_Expresiones_CategoryContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_idioma_expresiones_category);
        getSupportActionBar().setTitle(R.string.app_name);

    /*
    if(savedInstanceState == null) {
      AppMediator.resetInstance();
    }
    */

        // do the setup
        Idioma_Expresiones_CategoryScreen.configure(this);

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
    public void onDataUpdated(Idioma_Expresiones_CategoryViewModel viewModel) {
        //Log.e(TAG, "onDataUpdated()");

        // deal with the data
        //((TextView) findViewById(R.id.data)).setText(viewModel.data);
    }


    @Override
    public void navigateToNextScreen() {
        Intent intent = new Intent(this, Idioma_Expresiones_CategoryActivity.class);
        startActivity(intent);
    }

    @Override
    public void injectPresenter(Idioma_Expresiones_CategoryContract.Presenter presenter) {
        this.presenter = presenter;
    }
}