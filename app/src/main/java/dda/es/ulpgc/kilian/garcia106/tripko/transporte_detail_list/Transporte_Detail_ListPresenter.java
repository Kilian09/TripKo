package dda.es.ulpgc.kilian.garcia106.tripko.transporte_detail_list;

import java.lang.ref.WeakReference;

import dda.es.ulpgc.kilian.garcia106.tripko.app.AppMediator;

public class Transporte_Detail_ListPresenter implements Transporte_Detail_ListContract.Presenter {

    public static String TAG = Transporte_Detail_ListPresenter.class.getSimpleName();

    private WeakReference<Transporte_Detail_ListContract.View> view;
    private Transporte_Detail_ListState state;
    private Transporte_Detail_ListContract.Model model;
    private AppMediator mediator;

    public Transporte_Detail_ListPresenter(AppMediator mediator) {
        this.mediator = mediator;
        state = mediator.getTransporte_Detail_ListState();
    }

    @Override
    public void onStart() {
        // Log.e(TAG, "onStart()");

        // initialize the state if is necessary
        if (state == null) {
            state = new Transporte_Detail_ListState();
        }

        // call the model and update the state
        state.data = model.getStoredData();

/*        // use passed state if is necessary
        PreviousToTransporte_Detail_ListState savedState = getStateFromPreviousScreen();
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
        NextToTransporte_Detail_ListState savedState = getStateFromNextScreen();
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

/*    private NextToTransporte_Detail_ListState getStateFromNextScreen() {
        return mediator.getNextTransporte_Detail_ListScreenState();
    }

    private void passStateToNextScreen(Transporte_Detail_ListToNextState state) {
        mediator.setNextTransporte_Detail_ListScreenState(state);
    }

    private void passStateToPreviousScreen(Transporte_Detail_ListToPreviousState state) {
        mediator.setPreviousTransporte_Detail_ListScreenState(state);
    }

    private PreviousToTransporte_Detail_ListState getStateFromPreviousScreen() {
        return mediator.getPreviousTransporte_Detail_ListScreenState();
    }*/

    @Override
    public void injectView(WeakReference<Transporte_Detail_ListContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(Transporte_Detail_ListContract.Model model) {
        this.model = model;
    }

}