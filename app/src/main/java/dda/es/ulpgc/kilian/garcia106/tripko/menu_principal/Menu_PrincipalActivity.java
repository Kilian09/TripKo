package dda.es.ulpgc.kilian.garcia106.tripko.menu_principal;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import dda.es.ulpgc.kilian.garcia106.tripko.R;

public class Menu_PrincipalActivity
        extends AppCompatActivity implements Menu_PrincipalContract.View {

    public static String TAG = Menu_PrincipalActivity.class.getSimpleName();

    private Menu_PrincipalContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
        getSupportActionBar().setTitle(R.string.app_name);

    /*
    if(savedInstanceState == null) {
      AppMediator.resetInstance();
    }
    */

        // do the setup
        Menu_PrincipalScreen.configure(this);

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
    public void onDataUpdated(Menu_PrincipalViewModel viewModel) {
        //Log.e(TAG, "onDataUpdated()");

        // deal with the data
        //((TextView) findViewById(R.id.data)).setText(viewModel.data);
    }

    @Override
    public void navigateToSobreCoreaScreen() {
        //Intent intent = new Intent(this, Sobre_CoreaActivity.class);
        //startActivity(intent);
    }

    @Override
    public void navigateToIdiomaScreen() {
        //Intent intent = new Intent(this, IdiomaActivity.class);
        //startActivity(intent);
    }

    @Override
    public void navigateToConversionDeMonedaScreen() {
        //Intent intent = new Intent(this, Conversor_MonedaActivity.class);
        //startActivity(intent);
    }

    @Override
    public void navigateToTransporteScreen() {
        //Intent intent = new Intent(this, Transporte_CategoryActivity.class);
        //startActivity(intent);
    }

    @Override
    public void navigateToEntretenimientoScreen() {
        //Intent intent = new Intent(this, EntretenimientoActivity.class);
        //startActivity(intent);
    }

    @Override
    public void navigateToGastronomiaScreen() {
        //Intent intent = new Intent(this, Gastronomia_ListActivity.class);
        //startActivity(intent);
    }

    @Override
    public void navigateToSitiosTuristicosScreen() {
        //Intent intent = new Intent(this, Sitios_TuristicosActivity.class);
        //startActivity(intent);
    }

    @Override
    public void navigateToContactosScreen() {
        //Intent intent = new Intent(this, ContactosActivity.class);
        //startActivity(intent);
    }

    @Override
    public void injectPresenter(Menu_PrincipalContract.Presenter presenter) {
        this.presenter = presenter;
    }
}