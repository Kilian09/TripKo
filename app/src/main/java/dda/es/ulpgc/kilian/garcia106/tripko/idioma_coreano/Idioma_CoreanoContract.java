package dda.es.ulpgc.kilian.garcia106.tripko.idioma_coreano;

import java.lang.ref.WeakReference;

public interface Idioma_CoreanoContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void navigateToMenuScreen();

        void displayData(Idioma_CoreanoViewModel viewModel);

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

        void navigateToMenuScreen();
    }

    interface Model {

    }

}