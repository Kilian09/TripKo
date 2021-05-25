package dda.es.ulpgc.kilian.garcia106.tripko.cultura;

import java.lang.ref.WeakReference;

import dda.es.ulpgc.kilian.garcia106.tripko.app.AppMediator;
import dda.es.ulpgc.kilian.garcia106.tripko.clima.ClimaState;

public class CulturaPresenter implements CulturaContract.Presenter {

    public static String TAG = CulturaPresenter.class.getSimpleName();

    private WeakReference<CulturaContract.View> view;
    private CulturaState state;
    private CulturaContract.Model model;
    private AppMediator mediator;

    public CulturaPresenter(AppMediator mediator) {
        this.mediator = mediator;
        state = mediator.getCulturaState();
    }

    @Override
    public void onStart() {
        // Log.e(TAG, "onStart()");

        // initialize the state if is necessary
        if (state == null) {
            state = new CulturaState();
        }

        // call the model and update the state
        state.data = model.getStoredData();

        // use passed state if is necessary
        CulturaState savedState = getDataFromPreviousScreen();
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
        CulturaState savedState = getDataFromPreviousScreen();
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

    @Override
    public CulturaState getDataFromPreviousScreen() {
        CulturaState state = mediator.getCulturaState();
        return state;
    }
    /*
    private NextToCulturaState getStateFromNextScreen() {
        return mediator.getNextCulturaScreenState();
    }

    private void passStateToNextScreen(CulturaToNextState state) {
        mediator.setNextCulturaScreenState(state);
    }

    private void passStateToPreviousScreen(CulturaToPreviousState state) {
        mediator.setPreviousCulturaScreenState(state);
    }

    private PreviousToCulturaState getStateFromPreviousScreen() {
        return mediator.getPreviousCulturaScreenState();
    }

     */

    public void navigateToMenuScreen() {
        view.get().navigateToMenuScreen();
    }

    @Override
    public void injectView(WeakReference<CulturaContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(CulturaContract.Model model) {
        this.model = model;
    }

}
