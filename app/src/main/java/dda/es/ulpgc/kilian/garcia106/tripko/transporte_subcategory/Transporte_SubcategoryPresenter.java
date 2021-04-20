package dda.es.ulpgc.kilian.garcia106.tripko.transporte_subcategory;

import java.lang.ref.WeakReference;

import dda.es.ulpgc.kilian.garcia106.tripko.app.AppMediator;

public class Transporte_SubcategoryPresenter implements Transporte_SubcategoryContract.Presenter {

    public static String TAG = Transporte_SubcategoryPresenter.class.getSimpleName();

    private WeakReference<Transporte_SubcategoryContract.View> view;
    private Transporte_SubcategoryState state;
    private Transporte_SubcategoryContract.Model model;
    private AppMediator mediator;

    public Transporte_SubcategoryPresenter(AppMediator mediator) {
        this.mediator = mediator;
        state = mediator.getTransporte_SubcategoryState();
    }

    @Override
    public void onStart() {
        // Log.e(TAG, "onStart()");

        // initialize the state if is necessary
        if (state == null) {
            state = new Transporte_SubcategoryState();
        }

        // call the model and update the state
        state.data = model.getStoredData();

/*        // use passed state if is necessary
        PreviousToTransporte_SubcategoryState savedState = getStateFromPreviousScreen();
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
        model.onRestartScreen(state.data);
    }

    @Override
    public void onResume() {
        // Log.e(TAG, "onResume()");

/*        // use passed state if is necessary
        NextToTransporte_SubcategoryState savedState = getStateFromNextScreen();
        if (savedState != null) {

            // update the model if is necessary
            model.onDataFromNextScreen(savedState.data);

            // update the state if is necessary
            state.data = savedState.data;
        }*/

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

/*    private NextToTransporte_SubcategoryState getStateFromNextScreen() {
        return mediator.getNextTransporte_SubcategoryScreenState();
    }

    private void passStateToNextScreen(Transporte_SubcategoryToNextState state) {
        mediator.setNextTransporte_SubcategoryScreenState(state);
    }

    private void passStateToPreviousScreen(Transporte_SubcategoryToPreviousState state) {
        mediator.setPreviousTransporte_SubcategoryScreenState(state);
    }

    private PreviousToTransporte_SubcategoryState getStateFromPreviousScreen() {
        return mediator.getPreviousTransporte_SubcategoryScreenState();
    }*/

    @Override
    public void injectView(WeakReference<Transporte_SubcategoryContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(Transporte_SubcategoryContract.Model model) {
        this.model = model;
    }

}