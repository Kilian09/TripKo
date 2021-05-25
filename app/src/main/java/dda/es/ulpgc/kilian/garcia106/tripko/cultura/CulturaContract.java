package dda.es.ulpgc.kilian.garcia106.tripko.cultura;

import java.lang.ref.WeakReference;

public interface CulturaContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void onDataUpdated(CulturaViewModel viewModel);

        void navigateToMenuScreen();
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

        CulturaState getDataFromPreviousScreen();

        void navigateToMenuScreen();
    }

    interface Model {
        String getStoredData();

        void onDataFromNextScreen(String data);

        void onRestartScreen(String data);

        void onDataFromPreviousScreen(String data);
    }

}