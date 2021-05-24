package dda.es.ulpgc.kilian.garcia106.tripko.idioma;

import java.lang.ref.WeakReference;

import dda.es.ulpgc.kilian.garcia106.tripko.app.AppMediator;

public class IdiomaPresenter implements IdiomaContract.Presenter {

    public static String TAG = IdiomaPresenter.class.getSimpleName();

    private WeakReference<IdiomaContract.View> view;
    private IdiomaState state;
    private IdiomaContract.Model model;
    private AppMediator mediator;

    public IdiomaPresenter(AppMediator mediator) {
        this.mediator = mediator;
        state = mediator.getIdiomaState();
    }

    @Override
    public void onStart() {
        // Log.e(TAG, "onStart()");

        // initialize the state if is necessary
        if (state == null) {
            state = new IdiomaState();
        }

        // call the model and update the state
        //state.data = model.getStoredData();

/*        // use passed state if is necessary
        PreviousToIdiomaState savedState = getStateFromPreviousScreen();
        if (savedState != null) {

            // update the model if is necessary
            model.onDataFromPreviousScreen(savedState.data);

            // update the state if is necessary
            state.data = savedState.data;
        }*/
    }

    @Override
    public void onRestart() {
        // Log.e(TAG, "onRestart()");

        // update the model if is necessary
        //model.onRestartScreen(state.data);
    }

    @Override
    public void onResume() {
        // Log.e(TAG, "onResume()");
/*
        // use passed state if is necessary
        NextToIdiomaState savedState = getStateFromNextScreen();
        if (savedState != null) {

            // update the model if is necessary
            model.onDataFromNextScreen(savedState.data);

            // update the state if is necessary
            state.data = savedState.data;
        }*/

        // call the model and update the state
        //state.data = model.getStoredData();

        // update the view
        //view.get().onDataUpdated(state);

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
    public void onIdiomaOptionClicked(int option) {
        switch (option){
            case 0:
                view.get().navigateToIdiomaCoreanoScreen();
                break;
            case 1:
                view.get().navigateToAlfabetoScreen();
                break;
            case 2:
                view.get().navigateToExpresionesCategoryScreen();
                break;
            default:
                break;
        }
    }

    @Override
    public void navigateToMenuScreen() {
        view.get().navigateToMenuScreen();
    }

    @Override
    public void injectView(WeakReference<IdiomaContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(IdiomaContract.Model model) {
        this.model = model;
    }

}