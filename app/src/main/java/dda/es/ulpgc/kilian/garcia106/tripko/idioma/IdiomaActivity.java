package dda.es.ulpgc.kilian.garcia106.tripko.idioma;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import dda.es.ulpgc.kilian.garcia106.tripko.R;
import dda.es.ulpgc.kilian.garcia106.tripko.idioma_alfabeto.Idioma_AlfabetoActivity;
import dda.es.ulpgc.kilian.garcia106.tripko.idioma_coreano.Idioma_CoreanoActivity;
import dda.es.ulpgc.kilian.garcia106.tripko.idioma_expresiones_category.Idioma_Expresiones_CategoryActivity;
import dda.es.ulpgc.kilian.garcia106.tripko.menu_principal.Menu_PrincipalActivity;

public class IdiomaActivity
        extends AppCompatActivity implements IdiomaContract.View {

    public static String TAG = IdiomaActivity.class.getSimpleName();

    private IdiomaContract.Presenter presenter;

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;

    private TextView tripkoTitleText;
    private LinearLayout idiomaCoreanoBtn, alfabetoBtn, expresionesBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_idioma);
        toolbar = findViewById(R.id.toolbar_top);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.idiomaDrawerLayout);

        tripkoTitleText = findViewById(R.id.tripkoText);
        tripkoTitleText.setText(R.string.app_name);

        idiomaCoreanoBtn = findViewById(R.id.idioma_coreano_btn);
        alfabetoBtn = findViewById(R.id.alfabeto_btn);
        expresionesBtn = findViewById(R.id.expresiones_btn);

        idiomaCoreanoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onIdiomaOptionClicked(0);
            }
        });

        alfabetoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onIdiomaOptionClicked(1);
            }
        });

        expresionesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onIdiomaOptionClicked(2);
            }
        });

    /*
    if(savedInstanceState == null) {
      AppMediator.resetInstance();
    }
    */

        // do the setup
        IdiomaScreen.configure(this);

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
    public void navigateToIdiomaCoreanoScreen() {
        Intent intent = new Intent(this, Idioma_CoreanoActivity.class);
        startActivity(intent);
    }

    @Override
    public void navigateToAlfabetoScreen() {
        Intent intent = new Intent(this, Idioma_AlfabetoActivity.class);
        startActivity(intent);
    }

    @Override
    public void navigateToExpresionesCategoryScreen() {
        Intent intent = new Intent(this, Idioma_Expresiones_CategoryActivity.class);
        startActivity(intent);
    }

    @Override
    public void injectPresenter(IdiomaContract.Presenter presenter) {
        this.presenter = presenter;
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
}