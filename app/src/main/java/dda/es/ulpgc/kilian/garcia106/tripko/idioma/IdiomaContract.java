package dda.es.ulpgc.kilian.garcia106.tripko.idioma;

import java.lang.ref.WeakReference;

public interface IdiomaContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void navigateToMenuScreen();

        void navigateToIdiomaCoreanoScreen();

        void navigateToAlfabetoScreen();

        void navigateToExpresionesCategoryScreen();
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

        void onIdiomaOptionClicked(int option);

        void navigateToMenuScreen();
    }

    interface Model {

    }

}