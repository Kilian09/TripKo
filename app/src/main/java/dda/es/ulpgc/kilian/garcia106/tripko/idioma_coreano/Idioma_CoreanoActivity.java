package dda.es.ulpgc.kilian.garcia106.tripko.idioma_coreano;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import dda.es.ulpgc.kilian.garcia106.tripko.R;
import dda.es.ulpgc.kilian.garcia106.tripko.menu_principal.Menu_PrincipalActivity;

public class Idioma_CoreanoActivity
        extends AppCompatActivity implements Idioma_CoreanoContract.View {

    public static String TAG = Idioma_CoreanoActivity.class.getSimpleName();

    private Idioma_CoreanoContract.Presenter presenter;

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;

    private TextView idiomaCoreanoTitle, idiomaCoreanoTxt, idiomaCoreanoTxt2, idiomaCoreanoTxt3,
            honorificosTitle, honorificosTxt, honorificosTxt2, tripkoTitleText;
    private ImageView idiomaCoreanoImg, idiomaCoreanoImg2, honorificosImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_idioma_coreano);
    /*
    if(savedInstanceState == null) {
      AppMediator.resetInstance();
    }
    */
        toolbar = findViewById(R.id.toolbar_top);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.idioma_coreanoDrawerLayout);

        tripkoTitleText = findViewById(R.id.tripkoText);
        tripkoTitleText.setText(R.string.app_name);

        idiomaCoreanoTitle = findViewById(R.id.el_idioma_coreano_title);
        idiomaCoreanoTxt = findViewById(R.id.el_idioma_coreano_txt1);
        idiomaCoreanoTxt2 = findViewById(R.id.el_idioma_coreano_txt2);
        idiomaCoreanoTxt3 = findViewById(R.id.el_idioma_coreano_txt3);

        idiomaCoreanoImg = findViewById(R.id.idioma_coreano_img1);
        idiomaCoreanoImg2 = findViewById(R.id.idioma_coreano_img2);

        honorificosTitle = findViewById(R.id.honorificos_title);
        honorificosTxt = findViewById(R.id.honorificos_text1);
        honorificosTxt2 = findViewById(R.id.honorificos_text2);

        honorificosImg = findViewById(R.id.honorificos_img);

        // do the setup
        Idioma_CoreanoScreen.configure(this);

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
    public void displayData(Idioma_CoreanoViewModel viewModel){
    }

    @Override
    public void navigateToMenuScreen() {
        Intent intent = new Intent(this, Menu_PrincipalActivity.class);
        startActivity(intent);
    }

    @Override
    public void injectPresenter(Idioma_CoreanoContract.Presenter presenter) {
        this.presenter = presenter;
    }
}