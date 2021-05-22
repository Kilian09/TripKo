package dda.es.ulpgc.kilian.garcia106.tripko.conversor_moneda;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
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

    private TextView tripkoTitleText, cantidadText, divisaText, pasarAText, resultadoText;
    private Spinner divisaSpinner, pasarASpinner;
    private Button calcularButton;
    private EditText cantidadEditText;
    private String  divisa, pasarA;

    private double cantidad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversor_moneda);


        toolbar = findViewById(R.id.toolbar_top);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.conversorMonedaDrawerLayout);

        tripkoTitleText = findViewById(R.id.tripkoText);
        tripkoTitleText.setText(R.string.app_name);

        cantidadText = findViewById(R.id.cantidadTextView);
        divisaText = findViewById(R.id.divisaTextView);
        pasarAText = findViewById(R.id.pasarATextView);
        resultadoText = findViewById(R.id.resultadoTextView);

        divisaSpinner = findViewById(R.id.divisaSpinner);
        pasarASpinner = findViewById(R.id.pasarASpinner);

        cantidadEditText = findViewById(R.id.cantidadInputEditText);

        calcularButton = findViewById(R.id.calcularButton);

        calcularButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cantidad = Double.parseDouble(cantidadEditText.getText().toString().trim());

                divisa = divisaSpinner.getSelectedItem().toString();
                pasarA = pasarASpinner.getSelectedItem().toString();

                presenter.onCalcularClicked(cantidad,divisa, pasarA);
            }
        });
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
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onDataUpdated(Conversor_MonedaViewModel viewModel) {
        //Log.e(TAG, "onDataUpdated()");

        // deal with the data
        ((TextView) findViewById(R.id.cantidadTextView)).setText(R.string.cantidad_text_view);
        ((TextView) findViewById(R.id.divisaTextView)).setText(R.string.divisa_text);
        ((TextView) findViewById(R.id.pasarATextView)).setText(R.string.pasar_a_text);
        ((TextView) findViewById(R.id.resultadoTextView)).setText(viewModel.resultado);
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