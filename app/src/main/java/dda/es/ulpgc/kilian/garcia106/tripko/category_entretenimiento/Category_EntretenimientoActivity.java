package dda.es.ulpgc.kilian.garcia106.tripko.category_entretenimiento;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
import dda.es.ulpgc.kilian.garcia106.tripko.data.CategoryEntretenimientoItem;
import dda.es.ulpgc.kilian.garcia106.tripko.entretenimiento_list.Entretenimiento_ListActivity;
import dda.es.ulpgc.kilian.garcia106.tripko.menu_principal.Menu_PrincipalActivity;

public class Category_EntretenimientoActivity
        extends AppCompatActivity implements Category_EntretenimientoContract.View {

    public static String TAG = Category_EntretenimientoActivity.class.getSimpleName();

    private Category_EntretenimientoContract.Presenter presenter;

    private Category_EntretenimientoAdapter listAdapter;

    private DrawerLayout drawerLayout;

    private Toolbar toolbar;
    private TextView tripkoTitleText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_entretenimiento_list);
        //getSupportActionBar().setTitle(R.string.app_name);

        toolbar = findViewById(R.id.toolbar_top);
        setSupportActionBar(toolbar);

        tripkoTitleText = findViewById(R.id.tripkoText);
        tripkoTitleText.setText(R.string.app_name);

        drawerLayout = findViewById(R.id.categoryEntretenimientoDrawerLayout);

        listAdapter = new Category_EntretenimientoAdapter(view -> {
            CategoryEntretenimientoItem item = (CategoryEntretenimientoItem) view.getTag();
            presenter.selectCategoryEntretenimientoListData(item);
        });

        RecyclerView recyclerView = findViewById(R.id.categoryEntretenimiento_list);
        recyclerView.setAdapter(listAdapter);


        // do the setup
        Category_EntretenimientoScreen.configure(this);

        presenter.fetchCategoryListData();
    }

    @Override
    public void displayCategoryListData(final Category_EntretenimientoViewModel viewModel) {
        Log.e(TAG, "displayCategoryListData()");

        runOnUiThread(new Runnable() {

            @Override
            public void run() {

                // deal with the data
                ((TextView) findViewById(R.id.entretenimientoTextView)).setText(R.string.entretenimiento_title);
                listAdapter.setItems(viewModel.categories);
            }

        });
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
    public void navigateToEntretenimientoScreen() {
        Intent intent = new Intent(this, Entretenimiento_ListActivity.class);
        startActivity(intent);
    }

    @Override
    public void navigateToMenuScreen() {
        Intent intent = new Intent(this, Menu_PrincipalActivity.class);
        startActivity(intent);
    }

    @Override
    public void injectPresenter(Category_EntretenimientoContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
