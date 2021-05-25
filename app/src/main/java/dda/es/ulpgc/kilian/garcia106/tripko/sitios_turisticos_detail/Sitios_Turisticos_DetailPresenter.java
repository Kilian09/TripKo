package dda.es.ulpgc.kilian.garcia106.tripko.sitios_turisticos_detail;

import java.lang.ref.WeakReference;

import dda.es.ulpgc.kilian.garcia106.tripko.app.AppMediator;

public class Sitios_Turisticos_DetailPresenter implements Sitios_Turisticos_DetailContract.Presenter {

    public static String TAG = Sitios_Turisticos_DetailPresenter.class.getSimpleName();

    private WeakReference<Sitios_Turisticos_DetailContract.View> view;
    private Sitios_Turisticos_DetailState state;
    private Sitios_Turisticos_DetailContract.Model model;
    private AppMediator mediator;

    public Sitios_Turisticos_DetailPresenter(AppMediator mediator) {
        this.mediator = mediator;
        state = mediator.getSitios_Turisticos_DetailState();
    }

    @Override
    public void onStart() {
        // Log.e(TAG, "onStart()");

        // initialize the state if is necessary
        if (state == null) {
            state = new Sitios_Turisticos_DetailState();
        }

        // call the model and update the state
        state.data = model.getStoredData();

        // use passed state if is necessary
        Sitios_Turisticos_DetailState savedState = getStateFromPreviousScreen();
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
        Sitios_Turisticos_DetailState savedState = getStateFromPreviousScreen();
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

    private Sitios_Turisticos_DetailState getStateFromPreviousScreen() {
        return mediator.getSitios_Turisticos_DetailState();
    }

/*
    private NextToSitios_Turisticos_DetailState getStateFromNextScreen() {
        return mediator.getNextSitios_Turisticos_DetailScreenState();
    }

    private void passStateToNextScreen(Sitios_Turisticos_DetailToNextState state) {
        mediator.setNextSitios_Turisticos_DetailScreenState(state);
    }

    private void passStateToPreviousScreen(Sitios_Turisticos_DetailToPreviousState state) {
        mediator.setPreviousSitios_Turisticos_DetailScreenState(state);
    }

    private PreviousToSitios_Turisticos_DetailState getStateFromPreviousScreen() {
        return mediator.getPreviousSitios_Turisticos_DetailScreenState();
    }
 */

    @Override
    public void injectView(WeakReference<Sitios_Turisticos_DetailContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(Sitios_Turisticos_DetailContract.Model model) {
        this.model = model;
    }

}
