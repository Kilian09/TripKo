package dda.es.ulpgc.kilian.garcia106.tripko.menu_principal;

import java.lang.ref.WeakReference;

import dda.es.ulpgc.kilian.garcia106.tripko.app.AppMediator;

public class Menu_PrincipalPresenter implements Menu_PrincipalContract.Presenter {

    public static String TAG = Menu_PrincipalPresenter.class.getSimpleName();

    private WeakReference<Menu_PrincipalContract.View> view;
    private Menu_PrincipalState state;
    private Menu_PrincipalContract.Model model;
    private AppMediator mediator;

    public Menu_PrincipalPresenter(AppMediator mediator) {
        this.mediator = mediator;
        state = mediator.getMenuPrincipalState();
    }

    @Override
    public void onStart() {
        // Log.e(TAG, "onStart()");

        // initialize the state if is necessary
        if (state == null) {
            state = new Menu_PrincipalState();
        }

        // call the model and update the state
        state.data = model.getStoredData();

        /*// use passed state if is necessary
        PreviousToMenuPrincipalState savedState = getStateFromPreviousScreen();
        if (savedState != null) {

            // update the model if is necessary
            model.onDataFromPreviousScreen(savedState.data);

            // update the state if is necessary
            state.data = savedState.data;*/
        //}
    }

    @Override
    public void onRestart() {
        // Log.e(TAG, "onRestart()");

        // update the model if is necessary
        model.onRestartScreen(state.data);
    }

    @Override
    public void onResume() {
        // Log.e(TAG, "onResume()");
/*
        // use passed state if is necessary
        NextToMenuPrincipalState savedState = getStateFromNextScreen();
        if (savedState != null) {

            // update the model if is necessary
            model.onDataFromNextScreen(savedState.data);

            // update the state if is necessary
            state.data = savedState.data;
        }

        // call the model and update the state
        //state.data = model.getStoredData();

        // update the view
        view.get().onDataUpdated(state);*/

    }

    @Override
    public void onBackPressed() {
        // Log.e(TAG, "onBackPressed()");
    }

    @Override
    public void onPause() {
        // Log.e(TAG, "onPause()");
    }

    @Override
    public void onDestroy() {
        // Log.e(TAG, "onDestroy()");
    }

    @Override
    public void onMenuOptionClicked(int option) {
        switch (option){
            case 0:
                view.get().navigateToSobreCoreaScreen();
                break;
            case 1:
                view.get().navigateToIdiomaScreen();
                break;
            case 2:
                view.get().navigateToConversionDeMonedaScreen();
                break;
            case 3:
                view.get().navigateToTransporteScreen();
                break;
            case 4:
                view.get().navigateToEntretenimientoScreen();
                break;
            case 5:
                view.get().navigateToGastronomiaScreen();
                break;
            case 6:
                view.get().navigateToSitiosTuristicosScreen();
                break;
            case 7:
                view.get().navigateToContactosScreen();
                break;
            default:
                break;
        }
    }

    @Override
    public void injectView(WeakReference<Menu_PrincipalContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(Menu_PrincipalContract.Model model) {
        this.model = model;
    }

}