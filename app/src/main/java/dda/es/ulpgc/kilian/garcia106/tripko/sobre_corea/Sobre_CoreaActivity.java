package dda.es.ulpgc.kilian.garcia106.tripko.sobre_corea;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import dda.es.ulpgc.kilian.garcia106.tripko.R;
import dda.es.ulpgc.kilian.garcia106.tripko.ciudades_principales.Ciudades_PrincipalesActivity;
import dda.es.ulpgc.kilian.garcia106.tripko.clima.ClimaActivity;
import dda.es.ulpgc.kilian.garcia106.tripko.cultura.CulturaActivity;
import dda.es.ulpgc.kilian.garcia106.tripko.idioma_alfabeto.Idioma_AlfabetoActivity;
import dda.es.ulpgc.kilian.garcia106.tripko.idioma_coreano.Idioma_CoreanoActivity;
import dda.es.ulpgc.kilian.garcia106.tripko.idioma_expresiones_category.Idioma_Expresiones_CategoryActivity;
import dda.es.ulpgc.kilian.garcia106.tripko.menu_principal.Menu_PrincipalActivity;

public class Sobre_CoreaActivity
        extends AppCompatActivity implements Sobre_CoreaContract.View {

    public static String TAG = Sobre_CoreaActivity.class.getSimpleName();

    private Sobre_CoreaContract.Presenter presenter;

    private Toolbar toolbar;

    private DrawerLayout drawerLayout;

    private TextView tripkoTitleText,sobreCoreaTitle,sobreCoreaDescription,sobreCoreaText2;
    private ImageButton ciudadesButton,climaButton, culturaButton;
    private ImageView sobreCoreaImage1,sobreCoreaImage2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobre_corea);
  //      getSupportActionBar().setTitle(R.string.app_name);


        toolbar = findViewById(R.id.toolbar_top);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.sobreCorea_DrawerLayout);

        tripkoTitleText = findViewById(R.id.tripkoText);
        tripkoTitleText.setText(R.string.app_name);

        ciudadesButton= findViewById(R.id.ciudadesPrincipalesButton);
        climaButton=findViewById(R.id.climaButton);
        culturaButton=findViewById(R.id.culturaButton);

        sobreCoreaTitle=findViewById(R.id.sobreCoreaTitle);
        sobreCoreaTitle.setText(R.string.sobre_corea_title);

        sobreCoreaDescription=findViewById(R.id.sobreCoreaDescriptionText);
        sobreCoreaDescription.setText(R.string.sobre_corea_text);
        sobreCoreaText2=findViewById(R.id.sobreCoreaText2);
        sobreCoreaText2.setText(R.string.sobre_corea_text2);

        sobreCoreaImage1=findViewById(R.id.sobreCoreaImage1);
        sobreCoreaImage2=findViewById(R.id.sobreCoreaImage2);

        climaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { presenter.onSobreCoreaOptionClicked(0);
            }
        });

        ciudadesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { presenter.onSobreCoreaOptionClicked(1);
            }
        });

        culturaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { presenter.onSobreCoreaOptionClicked(2);
            }
        });

    /*
    if(savedInstanceState == null) {
      AppMediator.resetInstance();
    }
    */

        // do the setup
        Sobre_CoreaScreen.configure(this);

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
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void navigateToClimaScreen() {
        Intent intent = new Intent(this, ClimaActivity.class);
        startActivity(intent);
    }

    @Override
    public void navigateToCiudadesPrincipalesScreen() {
        Intent intent = new Intent(this, Ciudades_PrincipalesActivity.class);
        startActivity(intent);
    }

    @Override
    public void navigateToCulturaScreen() {
        Intent intent = new Intent(this, CulturaActivity.class);
        startActivity(intent);
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
    public void onDataUpdated(Sobre_CoreaViewModel viewModel) {
        //Log.e(TAG, "onDataUpdated()");

        // deal with the data
    //    ((TextView) findViewById(R.id.data)).setText(viewModel.data);
    }

    @Override
    public void injectPresenter(Sobre_CoreaContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void navigateToMenuScreen() {
        Intent intent = new Intent(this, Menu_PrincipalActivity.class);
        startActivity(intent);
    }
}
