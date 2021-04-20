package dda.es.ulpgc.kilian.garcia106.tripko.transporte_category;

import java.lang.ref.WeakReference;

import dda.es.ulpgc.kilian.garcia106.tripko.app.AppMediator;

public class Transporte_CategoryPresenter implements Transporte_CategoryContract.Presenter {

    public static String TAG = Transporte_CategoryPresenter.class.getSimpleName();

    private WeakReference<Transporte_CategoryContract.View> view;
    private Transporte_CategoryState state;
    private Transporte_CategoryContract.Model model;
    private AppMediator mediator;

    public Transporte_CategoryPresenter(AppMediator mediator) {
        this.mediator = mediator;
        state = mediator.getTransporte_CategoryState();
    }

    @Override
    public void onStart() {
        // Log.e(TAG, "onStart()");

        // initialize the state if is necessary
        if (state == null) {
            state = new Transporte_CategoryState();
        }

        // call the model and update the state
        state.data = model.getStoredData();

        // use passed state if is necessary
/*        PreviousToTransporte_CategoryState savedState = getStateFromPreviousScreen();
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

        // use passed state if is necessary
/*        NextToTransporte_CategoryState savedState = getStateFromNextScreen();
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

/*    private NextToTransporte_CategoryState getStateFromNextScreen() {
        return mediator.getNextTransporte_CategoryScreenState();
    }

    private void passStateToNextScreen(Transporte_CategoryToNextState state) {
        mediator.setNextTransporte_CategoryScreenState(state);
    }

    private void passStateToPreviousScreen(Transporte_CategoryToPreviousState state) {
        mediator.setPreviousTransporte_CategoryScreenState(state);
    }

    private PreviousToTransporte_CategoryState getStateFromPreviousScreen() {
        return mediator.getPreviousTransporte_CategoryScreenState();
    }*/

    @Override
    public void injectView(WeakReference<Transporte_CategoryContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(Transporte_CategoryContract.Model model) {
        this.model = model;
    }

}