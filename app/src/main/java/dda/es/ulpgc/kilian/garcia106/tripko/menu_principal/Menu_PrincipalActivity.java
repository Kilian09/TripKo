package dda.es.ulpgc.kilian.garcia106.tripko.menu_principal;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import dda.es.ulpgc.kilian.garcia106.tripko.R;
import dda.es.ulpgc.kilian.garcia106.tripko.category_entretenimiento.Category_EntretenimientoActivity;
import dda.es.ulpgc.kilian.garcia106.tripko.category_sitios_turisticos.Category_Sitios_TuristicosActivity;
import dda.es.ulpgc.kilian.garcia106.tripko.category_sitios_turisticos.Category_Sitios_TuristicosState;
import dda.es.ulpgc.kilian.garcia106.tripko.contactos_list.Contactos_ListActivity;
import dda.es.ulpgc.kilian.garcia106.tripko.conversor_moneda.Conversor_MonedaActivity;
import dda.es.ulpgc.kilian.garcia106.tripko.gastronomia.Gastronomia_ListActivity;
import dda.es.ulpgc.kilian.garcia106.tripko.idioma.IdiomaActivity;
import dda.es.ulpgc.kilian.garcia106.tripko.sitios_turisticos_list.Sitios_Turisticos_ListActivity;
import dda.es.ulpgc.kilian.garcia106.tripko.sobre_corea.Sobre_CoreaActivity;
import dda.es.ulpgc.kilian.garcia106.tripko.transporte_category.Transporte_CategoryActivity;

public class Menu_PrincipalActivity
        extends AppCompatActivity implements Menu_PrincipalContract.View {

    public static String TAG = Menu_PrincipalActivity.class.getSimpleName();

    private Menu_PrincipalContract.Presenter presenter;

    private Toolbar toolbar;

    private DrawerLayout drawerLayout;

    private NavigationView navigationView;

    private TextView tripkoTitleText;

    private LinearLayout sobreCoreaBtn, idiomaBtn, conversionDeMonedaBtn, transporteBtn,
            entretenimientoBtn, gastronomiaBtn, sitiosTuristicosBtn, contactosBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        toolbar = findViewById(R.id.toolbar_top);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.menuDrawerLayout);

        tripkoTitleText = findViewById(R.id.tripkoText);
        tripkoTitleText.setText(R.string.app_name);

     //   navigationView = findViewById(R.id.navigationView);

        sobreCoreaBtn = findViewById(R.id.sobreCorea_btn);
        idiomaBtn = findViewById(R.id.idioma_btn);
        conversionDeMonedaBtn = findViewById(R.id.conversion_de_moneda_btn);
        transporteBtn = findViewById(R.id.transporte_btn);
        entretenimientoBtn = findViewById(R.id.entretenimiento_btn);
        gastronomiaBtn = findViewById(R.id.gastronomia_btn);
        sitiosTuristicosBtn = findViewById(R.id.sitios_turisticos_btn);
        contactosBtn = findViewById(R.id.contactos_de_interes_btn);

        sobreCoreaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onMenuOptionClicked(0);
            }
        });
        idiomaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onMenuOptionClicked(1);
            }
        });
        conversionDeMonedaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onMenuOptionClicked(2);
            }
        });
        transporteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onMenuOptionClicked(3);
            }
        });
        entretenimientoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onMenuOptionClicked(4);
            }
        });
        gastronomiaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onMenuOptionClicked(5);
            }
        });
        sitiosTuristicosBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onMenuOptionClicked(6);
            }
        });
        contactosBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onMenuOptionClicked(7);
            }
        });

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

/*Metodo que permite ver el boton home
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        return super.onCreateOptionsMenu(menu);
    }
*/

    @Override
    public void onDataUpdated(Menu_PrincipalViewModel viewModel) {
        //Log.e(TAG, "onDataUpdated()");

        // deal with the data

    }

    @Override
    public void navigateToSobreCoreaScreen() {
        Intent intent = new Intent(this, Sobre_CoreaActivity.class);
        startActivity(intent);
    }

    @Override
    public void navigateToIdiomaScreen() {
        Intent intent = new Intent(this, IdiomaActivity.class);
        startActivity(intent);
    }

    @Override
    public void navigateToConversionDeMonedaScreen() {
        Intent intent = new Intent(this, Conversor_MonedaActivity.class);
        startActivity(intent);
    }

    @Override
    public void navigateToTransporteScreen() {
        Intent intent = new Intent(this, Transporte_CategoryActivity.class);
        startActivity(intent);
    }

    @Override
    public void navigateToEntretenimientoScreen() {
        Intent intent = new Intent(this, Category_EntretenimientoActivity.class);
        startActivity(intent);
    }

    @Override
    public void navigateToGastronomiaScreen() {
        Intent intent = new Intent(this, Gastronomia_ListActivity.class);
        startActivity(intent);
    }

    @Override
    public void navigateToSitiosTuristicosScreen() {
        Intent intent = new Intent(this, Sitios_Turisticos_ListActivity.class);
        startActivity(intent);
    }

    @Override
    public void navigateToContactosScreen() {
        Intent intent = new Intent(this, Contactos_ListActivity.class);
        startActivity(intent);
    }

    @Override
    public void injectPresenter(Menu_PrincipalContract.Presenter presenter) {
        this.presenter = presenter;
    }
}