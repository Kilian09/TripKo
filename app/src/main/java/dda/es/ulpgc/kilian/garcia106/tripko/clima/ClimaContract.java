package dda.es.ulpgc.kilian.garcia106.tripko.clima;

import java.lang.ref.WeakReference;

import dda.es.ulpgc.kilian.garcia106.tripko.sobre_corea.Sobre_CoreaViewModel;

public interface ClimaContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void navigateToMenuScreen();

        void onDataUpdated(ClimaViewModel viewModel);
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

        ClimaState getDataFromPreviousScreen();

        void navigateToMenuScreen();
    }

    interface Model {
        String getStoredData();

        void onDataFromNextScreen(String data);

        void onRestartScreen(String data);

        void onDataFromPreviousScreen(String data);
    }

}