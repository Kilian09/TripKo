package dda.es.ulpgc.kilian.garcia106.tripko.category_sitios_turisticos;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import dda.es.ulpgc.kilian.garcia106.tripko.R;

public class Category_Sitios_TuristicosActivity
        extends AppCompatActivity implements Category_Sitios_TuristicosContract.View {

    public static String TAG = Category_Sitios_TuristicosActivity.class.getSimpleName();

    private Category_Sitios_TuristicosContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_sitios_turisticos_list);
        getSupportActionBar().setTitle(R.string.app_name);

    /*
    if(savedInstanceState == null) {
      AppMediator.resetInstance();
    }
    */

        // do the setup
        Category_Sitios_TuristicosScreen.configure(this);

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
    public void onDataUpdated(Category_Sitios_TuristicosViewModel viewModel) {
        //Log.e(TAG, "onDataUpdated()");

        // deal with the data
        //((TextView) findViewById(R.id.data)).setText(viewModel.data);
    }


    @Override
    public void navigateToNextScreen() {
        Intent intent = new Intent(this, Category_Sitios_TuristicosActivity.class);
        startActivity(intent);
    }

    @Override
    public void injectPresenter(Category_Sitios_TuristicosContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
