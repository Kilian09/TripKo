package dda.es.ulpgc.kilian.garcia106.tripko.gastronomia;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;

import dda.es.ulpgc.kilian.garcia106.tripko.R;
import dda.es.ulpgc.kilian.garcia106.tripko.data.GastronomiaItem;
import dda.es.ulpgc.kilian.garcia106.tripko.menu_principal.Menu_PrincipalActivity;

public class Gastronomia_ListActivity
        extends AppCompatActivity implements Gastronomia_ListContract.View {

    public static String TAG = Gastronomia_ListActivity.class.getSimpleName();

    private Gastronomia_ListContract.Presenter presenter;

    private Toolbar toolbar;

    private DrawerLayout drawerLayout;

    private Gastronomia_ListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gastronomia_list);

        toolbar = findViewById(R.id.toolbar_top);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.gastronomiaDrawerLayout);

        listAdapter = new Gastronomia_ListAdapter(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                GastronomiaItem item = (GastronomiaItem) view.getTag();
                presenter.selectGastronomiaListData(item);
            }
        });

        RecyclerView recyclerView = findViewById(R.id.gastronomiaList);
        recyclerView.setAdapter(listAdapter);

        // do the setup
        Gastronomia_ListScreen.configure(this);

        // do some work
        presenter.fetchGastronomiaListData();
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
    protected void onResume() {
        super.onResume();

        // load the data
        presenter.onResume();
    }


    @Override
    public void displayGastronomiaListData(Gastronomia_ListViewModel viewModel) {
        //Log.e(TAG, "onDataUpdated()");

        runOnUiThread(new Runnable() {

            @Override
            public void run() {

                // deal with the data
                listAdapter.setItems(viewModel.gastronomias);
            }

        });
    }

    @Override
    public void navigateToMenuScreen() {
        Intent intent = new Intent(this, Menu_PrincipalActivity.class);
        startActivity(intent);
    }

    @Override
    public void injectPresenter(Gastronomia_ListContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
