package dda.es.ulpgc.kilian.garcia106.tripko.entretenimiento_list;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NavUtils;
import androidx.recyclerview.widget.RecyclerView;

import dda.es.ulpgc.kilian.garcia106.tripko.R;
import dda.es.ulpgc.kilian.garcia106.tripko.data.CategoryEntretenimientoItem;
import dda.es.ulpgc.kilian.garcia106.tripko.data.EntretenimientoItem;
import dda.es.ulpgc.kilian.garcia106.tripko.entretenimiento_detail.Entretenimiento_DetailActivity;

public class Entretenimiento_ListActivity
        extends AppCompatActivity implements Entretenimiento_ListContract.View {

    public static String TAG = Entretenimiento_ListActivity.class.getSimpleName();

    private Entretenimiento_ListContract.Presenter presenter;

    private Entretenimiento_ListAdapter listAdapter;

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entretenimiento_list);

        toolbar = findViewById(R.id.toolbar_top);
        setSupportActionBar(toolbar);

        listAdapter = new Entretenimiento_ListAdapter(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                EntretenimientoItem item = (EntretenimientoItem) view.getTag();
                presenter.selectEntretenimientoListData(item);
            }
        });

        RecyclerView recyclerView = findViewById(R.id.entretenimiento_list);
        recyclerView.setAdapter(listAdapter);

        // do the setup
        Entretenimiento_ListScreen.configure(this);

        // do some work
        presenter.fetchEntretenimientoListData();
    }


    @Override
    public void displayProductListData(Entretenimiento_ListViewModel viewModel) {

        runOnUiThread(new Runnable() {

            @Override
            public void run() {

                // deal with the data
                listAdapter.setItems(viewModel.entretenimientos);
            }
        });
    }


    @Override
    public void navigateToEntretenimientoDetailScreen() {
        Intent intent = new Intent(this, Entretenimiento_DetailActivity.class);
        startActivity(intent);
    }

    @Override
    public void injectPresenter(Entretenimiento_ListContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            NavUtils.navigateUpFromSameTask(this);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
