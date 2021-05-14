package dda.es.ulpgc.kilian.garcia106.tripko.conversor_moneda;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import dda.es.ulpgc.kilian.garcia106.tripko.R;

public class Conversor_MonedaActivity
        extends AppCompatActivity implements Conversor_MonedaContract.View {

    public static String TAG = Conversor_MonedaActivity.class.getSimpleName();

    private Conversor_MonedaContract.Presenter presenter;

    private Toolbar toolbar;

    private DrawerLayout drawerLayout;

    private NavigationView navigationView;

    private TextView tripkoTitleText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversor_moneda);


        toolbar = findViewById(R.id.toolbar_top);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawerLayout);

        tripkoTitleText = findViewById(R.id.tripkoText);
        tripkoTitleText.setText(R.string.app_name);

        // do the setup
        Conversor_MonedaScreen.configure(this);

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
    public void onDataUpdated(Conversor_MonedaViewModel viewModel) {
        //Log.e(TAG, "onDataUpdated()");

        // deal with the data
      //  ((TextView) findViewById(R.id.data)).setText(viewModel.data);
    }


    @Override
    public void navigateToNextScreen() {
        Intent intent = new Intent(this, Conversor_MonedaActivity.class);
        startActivity(intent);
    }

    @Override
    public void injectPresenter(Conversor_MonedaContract.Presenter presenter) {
        this.presenter = presenter;
    }
}