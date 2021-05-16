package dda.es.ulpgc.kilian.garcia106.tripko.ciudades_principales;

import java.lang.ref.WeakReference;

public interface Ciudades_PrincipalesContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void onDataUpdated(Ciudades_PrincipalesViewModel viewModel);

        void navigateToNextScreen();
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

        Ciudades_PrincipalesState getDataFromPreviousScreen();
    }

    interface Model {
        String getStoredData();

        void onDataFromNextScreen(String data);

        void onRestartScreen(String data);

        void onDataFromPreviousScreen(String data);
    }

}