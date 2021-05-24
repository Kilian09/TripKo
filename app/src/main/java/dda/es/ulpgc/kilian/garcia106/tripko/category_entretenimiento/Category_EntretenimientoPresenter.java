package dda.es.ulpgc.kilian.garcia106.tripko.category_entretenimiento;

import java.lang.ref.WeakReference;

import dda.es.ulpgc.kilian.garcia106.tripko.app.AppMediator;

public class Category_EntretenimientoPresenter implements Category_EntretenimientoContract.Presenter {

    public static String TAG = Category_EntretenimientoPresenter.class.getSimpleName();

    private WeakReference<Category_EntretenimientoContract.View> view;
    private Category_EntretenimientoState state;
    private Category_EntretenimientoContract.Model model;
    private AppMediator mediator;

    public Category_EntretenimientoPresenter(AppMediator mediator) {
        this.mediator = mediator;
        //state = mediator.getCategory_EntretenimientoState();
    }

    @Override
    public void onStart() {
        // Log.e(TAG, "onStart()");

        // initialize the state if is necessary
        if (state == null) {
            state = new Category_EntretenimientoState();
        }

        // call the model and update the state
        state.data = model.getStoredData();

        // use passed state if is necessary
        /*
        Category_EntretenimientoState savedState = getStateFromPreviousScreen();
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
/*
        // use passed state if is necessary
        Category_EntretenimientoState savedState = getStateFromNextScreen();
        if (savedState != null) {

            // update the model if is necessary
            model.onDataFromNextScreen(savedState.data);

            // update the state if is necessary
            state.data = savedState.data;
        }
 */

        // call the model and update the state
        //state.data = model.getStoredData();

        // update the view
        view.get().onDataUpdated(state);

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

    private void passStateToNextScreen(Category_EntretenimientoState category_entretenimientoState) {
        mediator.setCategory_EntretenimientoState(category_entretenimientoState);
    }

/*
    private NextToCategory_EntretenimientoState getStateFromNextScreen() {
        return mediator.getNextCategory_EntretenimientoScreenState();
    }

    private void passStateToPreviousScreen(Category_EntretenimientoToPreviousState state) {
        mediator.setPreviousCategory_EntretenimientoScreenState(state);
    }

    private PreviousToCategory_EntretenimientoState getStateFromPreviousScreen() {
        return mediator.getPreviousCategory_EntretenimientoScreenState();
    }

 */

    @Override
    public void injectView(WeakReference<Category_EntretenimientoContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(Category_EntretenimientoContract.Model model) {
        this.model = model;
    }

}
