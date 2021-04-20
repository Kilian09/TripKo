package dda.es.ulpgc.kilian.garcia106.tripko.menu_principal;

import java.lang.ref.WeakReference;

public interface Menu_PrincipalContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void onDataUpdated(Menu_PrincipalViewModel viewModel);

        //void navigateToNextScreen();

        void navigateToSobreCoreaScreen();

        void navigateToIdiomaScreen();

        void navigateToConversionDeMonedaScreen();

        void navigateToTransporteScreen();

        void navigateToEntretenimientoScreen();

        void navigateToGastronomiaScreen();

        void navigateToSitiosTuristicosScreen();

        void navigateToContactosScreen();

        //void navigateToScreen();
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

        void onMenuOptionClicked(int option);
    }

    interface Model {
        String getStoredData();

        void onDataFromNextScreen(String data);

        void onRestartScreen(String data);

        void onDataFromPreviousScreen(String data);
    }

}