package dda.es.ulpgc.kilian.garcia106.tripko.clima;

import java.lang.ref.WeakReference;

public interface ClimaContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void onDataUpdated(ClimaViewModel viewModel);

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

        ClimaState getDataFromPreviousScreen();
    }

    interface Model {
        String getStoredData();

        void onDataFromNextScreen(String data);

        void onRestartScreen(String data);

        void onDataFromPreviousScreen(String data);
    }

}