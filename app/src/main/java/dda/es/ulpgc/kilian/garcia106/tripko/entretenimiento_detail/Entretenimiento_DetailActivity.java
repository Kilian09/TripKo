package dda.es.ulpgc.kilian.garcia106.tripko.entretenimiento_detail;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import dda.es.ulpgc.kilian.garcia106.tripko.R;
import dda.es.ulpgc.kilian.garcia106.tripko.data.EntretenimientoItem;
import dda.es.ulpgc.kilian.garcia106.tripko.entretenimiento_list.Entretenimiento_ListActivity;

public class Entretenimiento_DetailActivity
        extends AppCompatActivity implements Entretenimiento_DetailContract.View {

    public static String TAG = Entretenimiento_DetailActivity.class.getSimpleName();

    private Entretenimiento_DetailContract.Presenter presenter;

    private Toolbar toolbar;
    private TextView tripkoTitleText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entretenimiento_detail);


        toolbar = findViewById(R.id.toolbar_top);
        setSupportActionBar(toolbar);

        tripkoTitleText = findViewById(R.id.tripkoText);
        tripkoTitleText.setText(R.string.app_name);

        // do the setup
        Entretenimiento_DetailScreen.configure(this);

     presenter.fetchEntretenimientoDetailData();
    }

    @Override
    public void displayEntretenimientoDetailData(Entretenimiento_DetailViewModel viewModel) {
        //Log.e(TAG, "onDataUpdated()");

        // deal with the data
        EntretenimientoItem entretenimiento = viewModel.entretenimiento;

        ((TextView) findViewById(R.id.titleTextView)).setText(entretenimiento.title);
        ((TextView) findViewById(R.id.detalleTextView)).setText(entretenimiento.detail);


        }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            navigateUpTo(new Intent(this, Entretenimiento_ListActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void injectPresenter(Entretenimiento_DetailContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
