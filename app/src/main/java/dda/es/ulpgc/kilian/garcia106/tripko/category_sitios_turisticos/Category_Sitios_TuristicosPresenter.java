package dda.es.ulpgc.kilian.garcia106.tripko.category_sitios_turisticos;

import java.lang.ref.WeakReference;

import dda.es.ulpgc.kilian.garcia106.tripko.app.AppMediator;

public class Category_Sitios_TuristicosPresenter implements Category_Sitios_TuristicosContract.Presenter {

    public static String TAG = Category_Sitios_TuristicosPresenter.class.getSimpleName();

    private WeakReference<Category_Sitios_TuristicosContract.View> view;
    private Category_Sitios_TuristicosState state;
    private Category_Sitios_TuristicosContract.Model model;
    private AppMediator mediator;

    public Category_Sitios_TuristicosPresenter(AppMediator mediator) {
        this.mediator = mediator;
        //state = mediator.getCategory_Sitios_TuristicosState();
    }

    @Override
    public void onStart() {
        // Log.e(TAG, "onStart()");

        // initialize the state if is necessary
        if (state == null) {
            state = new Category_Sitios_TuristicosState();
        }

        // call the model and update the state
        state.data = model.getStoredData();

        // use passed state if is necessary
        /*
        Category_Sitios_TuristicosState savedState = getStateFromPreviousScreen();
        if (savedState != null) {

            // update the model if is necessary
            model.onDataFromPreviousScreen(savedState.data);

            // update the state if is necessary
            state.data = savedState.data;
        }

         */
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

        // use passed state if is necessary
        /*
        Category_Sitios_TuristicosState savedState = getStateFromNextScreen();
        if (savedState != null) {

            // update the model if is necessary
            model.onDataFromNextScreen(savedState.data);

            // update the state if is necessary
            state.data = savedState.data;
        }

        // call the model and update the state
        //state.data = model.getStoredData();

        // update the view
        view.get().onDataUpdated(state);
         */

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

    private void passStateToNextScreen(Category_Sitios_TuristicosState state) {
        mediator.setCategory_Sitios_TuristicosState(state);
    }

/*
    private NextToCategory_Sitios_TuristicosState getStateFromNextScreen() {
        return mediator.getNextCategory_Sitios_TuristicosScreenState();
    }

    private void passStateToPreviousScreen(Category_Sitios_TuristicosToPreviousState state) {
        mediator.setPreviousCategory_Sitios_TuristicosScreenState(state);
    }

    private PreviousToCategory_Sitios_TuristicosState getStateFromPreviousScreen() {
        return mediator.getPreviousCategory_Sitios_TuristicosScreenState();
    }
 */

    @Override
    public void injectView(WeakReference<Category_Sitios_TuristicosContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(Category_Sitios_TuristicosContract.Model model) {
        this.model = model;
    }

}
