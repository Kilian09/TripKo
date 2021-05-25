package dda.es.ulpgc.kilian.garcia106.tripko.sitios_turisticos_list;

import java.lang.ref.WeakReference;

import dda.es.ulpgc.kilian.garcia106.tripko.app.AppMediator;

public class Sitios_Turisticos_ListPresenter implements Sitios_Turisticos_ListContract.Presenter {

    public static String TAG = Sitios_Turisticos_ListPresenter.class.getSimpleName();

    private WeakReference<Sitios_Turisticos_ListContract.View> view;
    private Sitios_Turisticos_ListState state;
    private Sitios_Turisticos_ListContract.Model model;
    private AppMediator mediator;

    public Sitios_Turisticos_ListPresenter(AppMediator mediator) {
        this.mediator = mediator;
        state = mediator.getSitios_Turisticos_ListState();
    }

    @Override
    public void onStart() {
        // Log.e(TAG, "onStart()");

        // initialize the state if is necessary
        if (state == null) {
            state = new Sitios_Turisticos_ListState();
        }

        // call the model and update the state
        state.data = model.getStoredData();

        // use passed state if is necessary
        Sitios_Turisticos_ListState savedState = getStateFromPreviousScreen();
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
        Sitios_Turisticos_ListState savedState = getStateFromPreviousScreen();
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

    private void passStateToNextScreen(Sitios_Turisticos_ListState sitios_turisticos_listState) {
        mediator.setSitios_Turisticos_ListState(sitios_turisticos_listState);
    }

    private Sitios_Turisticos_ListState getStateFromPreviousScreen() {
        return mediator.getSitios_Turisticos_ListState();
    }
    /*
    private NextToSitios_Turisticos_ListState getStateFromNextScreen() {
        return mediator.getNextSitios_Turisticos_ListScreenState();
    }
    private void passStateToPreviousScreen(Sitios_Turisticos_ListToPreviousState state) {
        mediator.setPreviousSitios_Turisticos_ListScreenState(state);
    }
     */

    @Override
    public void injectView(WeakReference<Sitios_Turisticos_ListContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(Sitios_Turisticos_ListContract.Model model) {
        this.model = model;
    }

}
