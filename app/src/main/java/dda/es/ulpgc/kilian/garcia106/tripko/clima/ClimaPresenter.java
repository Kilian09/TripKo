package dda.es.ulpgc.kilian.garcia106.tripko.clima;

import java.lang.ref.WeakReference;

import dda.es.ulpgc.kilian.garcia106.tripko.app.AppMediator;
import dda.es.ulpgc.kilian.garcia106.tripko.sobre_corea.Sobre_CoreaState;

public class ClimaPresenter implements ClimaContract.Presenter {

    public static String TAG = ClimaPresenter.class.getSimpleName();

    private WeakReference<ClimaContract.View> view;
    private ClimaState state;
    private ClimaContract.Model model;
    private AppMediator mediator;

    public ClimaPresenter(AppMediator mediator) {
        this.mediator = mediator;
        state = mediator.getClimaState();
    }

    @Override
    public void onStart() {
        // Log.e(TAG, "onStart()");

        // initialize the state if is necessary
        if (state == null) {
            state = new ClimaState();
        }

        // call the model and update the state
        state.data = model.getStoredData();

        // use passed state if is necessary
        //PreviousToClimaState savedState = getStateFromPreviousScreen();
        ClimaState savedState = getDataFromPreviousScreen();
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
        ClimaState savedState = getDataFromPreviousScreen();
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
/*
    @Override
    public void passDataToNextScreen(Sobre_CoreaState state) {
        mediator.setSobre_CoreaState(state);
    }

 */

    @Override
    public ClimaState getDataFromPreviousScreen() {
        ClimaState state = mediator.getClimaState();
        return state;
    }

    /*
    private void passStateToPreviousScreen(ClimaToPreviousState state) {
        mediator.setPreviousClimaScreenState(state);
    }

    private PreviousToClimaState getStateFromPreviousScreen() {
        return mediator.getPreviousClimaScreenState();
    }
     */

    @Override
    public void injectView(WeakReference<ClimaContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(ClimaContract.Model model) {
        this.model = model;
    }

}
