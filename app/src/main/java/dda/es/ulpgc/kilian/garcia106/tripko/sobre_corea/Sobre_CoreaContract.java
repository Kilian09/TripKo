package dda.es.ulpgc.kilian.garcia106.tripko.sobre_corea;

import java.lang.ref.WeakReference;

public interface Sobre_CoreaContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void onDataUpdated(Sobre_CoreaViewModel viewModel);

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

        void passDataToNextScreen(Sobre_CoreaState state);

        Sobre_CoreaState getDataFromPreviousScreen();
    }

    interface Model {
        String getStoredData();

        void onDataFromNextScreen(String data);

        void onRestartScreen(String data);

        void onDataFromPreviousScreen(String data);
    }

}