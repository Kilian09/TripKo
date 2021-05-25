package dda.es.ulpgc.kilian.garcia106.tripko.idioma_alfabeto;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import dda.es.ulpgc.kilian.garcia106.tripko.R;
import dda.es.ulpgc.kilian.garcia106.tripko.menu_principal.Menu_PrincipalActivity;

public class Idioma_AlfabetoActivity
        extends AppCompatActivity implements Idioma_AlfabetoContract.View {

    public static String TAG = Idioma_AlfabetoActivity.class.getSimpleName();

    private Idioma_AlfabetoContract.Presenter presenter;

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;

    private LinearLayout alfabetoInfo;
    private TextView tripkoTitleText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_idioma_alfabeto);

    /*
    if(savedInstanceState == null) {
      AppMediator.resetInstance();
    }
    */

        toolbar = findViewById(R.id.toolbar_top);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.alfabetoDrawerLayout);

        tripkoTitleText = findViewById(R.id.tripkoText);
        tripkoTitleText.setText(R.string.app_name);

        alfabetoInfo = findViewById(R.id.alfabeto_info);

        // do the setup
        Idioma_AlfabetoScreen.configure(this);

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
    public void onDataUpdated(Idioma_AlfabetoViewModel viewModel) {
        //Log.e(TAG, "onDataUpdated()");

        // deal with the data
        //((TextView) findViewById(R.id.data)).setText(viewModel.data);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_home:
                presenter.navigateToMenuScreen();
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }

    @Override
    public void navigateToMenuScreen() {
        Intent intent = new Intent(this, Menu_PrincipalActivity.class);
        startActivity(intent);
    }


    @Override
    public void navigateToNextScreen() {
        Intent intent = new Intent(this, Idioma_AlfabetoActivity.class);
        startActivity(intent);
    }

    @Override
    public void injectPresenter(Idioma_AlfabetoContract.Presenter presenter) {
        this.presenter = presenter;
    }
}