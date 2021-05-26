package dda.es.ulpgc.kilian.garcia106.tripko.ciudades_principales;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import dda.es.ulpgc.kilian.garcia106.tripko.R;
import dda.es.ulpgc.kilian.garcia106.tripko.menu_principal.Menu_PrincipalActivity;

public class Ciudades_PrincipalesActivity
        extends AppCompatActivity implements Ciudades_PrincipalesContract.View {

    public static String TAG = Ciudades_PrincipalesActivity.class.getSimpleName();

    private Ciudades_PrincipalesContract.Presenter presenter;

    private Toolbar toolbar;

    private DrawerLayout drawerLayout;

    private NavigationView navigationView;

    private TextView ciudadesPrincipalesTitle, tripkoTitleText;
    private ImageView seulImage, busanImage, incheonImage, deaguImage, daejeonImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ciudades_principales);

        toolbar = findViewById(R.id.toolbar_top);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.conversorMonedaDrawerLayout);

        tripkoTitleText = findViewById(R.id.tripkoText);
        tripkoTitleText.setText(R.string.app_name);

        ciudadesPrincipalesTitle = findViewById(R.id.ciudadesPrincipalesTitle);
        ciudadesPrincipalesTitle.setText(R.string.ciudades_principales_title);


        seulImage=findViewById(R.id.n1_seul);
        busanImage=findViewById(R.id.n2_busan);
        incheonImage=findViewById(R.id.n3_incheon);
        deaguImage=findViewById(R.id.n4_daegu);
        daejeonImage=findViewById(R.id.n5_daejeon);

    /*
    if(savedInstanceState == null) {
      AppMediator.resetInstance();
    }
    */
        // do the setup
        Ciudades_PrincipalesScreen.configure(this);

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
    public void onDataUpdated(Ciudades_PrincipalesViewModel viewModel) {
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
    public void navigateToMenuScreen() {
        Intent intent = new Intent(this, Menu_PrincipalActivity.class);
        startActivity(intent);
    }

    @Override
    public void injectPresenter(Ciudades_PrincipalesContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
