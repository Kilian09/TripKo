package dda.es.ulpgc.kilian.garcia106.tripko.entretenimiento_detail;

import java.lang.ref.WeakReference;

import dda.es.ulpgc.kilian.garcia106.tripko.app.AppMediator;

public class Entretenimiento_DetailPresenter implements Entretenimiento_DetailContract.Presenter {

    public static String TAG = Entretenimiento_DetailPresenter.class.getSimpleName();

    private WeakReference<Entretenimiento_DetailContract.View> view;
    private Entretenimiento_DetailState state;
    private Entretenimiento_DetailContract.Model model;
    private AppMediator mediator;

    public Entretenimiento_DetailPresenter(AppMediator mediator) {
        this.mediator = mediator;
        state = mediator.getEntretenimiento_DetailState();
    }

    @Override
    public void onStart() {
        // Log.e(TAG, "onStart()");

        // initialize the state if is necessary
        if (state == null) {
            state = new Entretenimiento_DetailState();
        }

        // call the model and update the state
        state.data = model.getStoredData();

        // use passed state if is necessary
        Entretenimiento_DetailState savedState = getStateFromPreviousScreen();
        if (savedState != null) {

            // update the model if is necessary
            model.onDataFromPreviousScreen(savedState.data);

            // update the state if is necessary
            state.data = savedState.data;
        }
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
        Entretenimiento_DetailState savedState = getStateFromPreviousScreen();
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

    private Entretenimiento_DetailState getStateFromPreviousScreen() {
        return mediator.getEntretenimiento_DetailState();
    }
/*
    private NextToEntretenimiento_DetailState getStateFromNextScreen() {
        return mediator.getNextEntretenimiento_DetailScreenState();
    }

    private void passStateToNextScreen(Entretenimiento_DetailToNextState state) {
        mediator.setNextEntretenimiento_DetailScreenState(state);
    }

    private void passStateToPreviousScreen(Entretenimiento_DetailToPreviousState state) {
        mediator.setPreviousEntretenimiento_DetailScreenState(state);
    }


 */

    @Override
    public void injectView(WeakReference<Entretenimiento_DetailContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(Entretenimiento_DetailContract.Model model) {
        this.model = model;
    }

}
