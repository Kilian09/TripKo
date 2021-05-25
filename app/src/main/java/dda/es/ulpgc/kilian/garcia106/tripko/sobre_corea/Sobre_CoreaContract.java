package dda.es.ulpgc.kilian.garcia106.tripko.sobre_corea;

import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;

import java.lang.ref.WeakReference;

public interface Sobre_CoreaContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void onDataUpdated(Sobre_CoreaViewModel viewModel);

        void navigateToMenuScreen();

        void navigateToClimaScreen();

        void navigateToCiudadesPrincipalesScreen();

        void navigateToCulturaScreen();
    }

    interface Presenter {
        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void onResume();

        void onStart();

        void onRestart();

        void onBackPressed();

        void onPause();

        void onDestroy();

        Sobre_CoreaState getDataFromPreviousScreen();

        void onSobreCoreaOptionClicked(int option);

        void navigateToMenuScreen();
    }

    interface Model {
        String getStoredData();

        void onDataFromNextScreen(String data);

        void onRestartScreen(String data);

        void onDataFromPreviousScreen(String data);
    }

}