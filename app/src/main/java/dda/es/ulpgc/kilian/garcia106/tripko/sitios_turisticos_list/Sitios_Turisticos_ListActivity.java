package dda.es.ulpgc.kilian.garcia106.tripko.sitios_turisticos_list;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import dda.es.ulpgc.kilian.garcia106.tripko.R;

public class Sitios_Turisticos_ListActivity
        extends AppCompatActivity implements Sitios_Turisticos_ListContract.View {

    public static String TAG = Sitios_Turisticos_ListActivity.class.getSimpleName();

    private Sitios_Turisticos_ListContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sitios_turisticos_list);
        getSupportActionBar().setTitle(R.string.app_name);

    /*
    if(savedInstanceState == null) {
      AppMediator.resetInstance();
    }
    */

        // do the setup
        Sitios_Turisticos_ListScreen.configure(this);

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
    public void onDataUpdated(Sitios_Turisticos_ListViewModel viewModel) {
        //Log.e(TAG, "onDataUpdated()");

        // deal with the data
        //((TextView) findViewById(R.id.data)).setText(viewModel.data);
    }


    @Override
    public void navigateToNextScreen() {
        Intent intent = new Intent(this, Sitios_Turisticos_ListActivity.class);
        startActivity(intent);
    }

    @Override
    public void injectPresenter(Sitios_Turisticos_ListContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
