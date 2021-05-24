package dda.es.ulpgc.kilian.garcia106.tripko.entretenimiento_list;

import java.lang.ref.WeakReference;

import dda.es.ulpgc.kilian.garcia106.tripko.app.AppMediator;

public class Entretenimiento_ListPresenter implements Entretenimiento_ListContract.Presenter {

    public static String TAG = Entretenimiento_ListPresenter.class.getSimpleName();

    private WeakReference<Entretenimiento_ListContract.View> view;
    private Entretenimiento_ListState state;
    private Entretenimiento_ListContract.Model model;
    private AppMediator mediator;

    public Entretenimiento_ListPresenter(AppMediator mediator) {
        this.mediator = mediator;
        state = mediator.getEntretenimiento_ListState();
    }

    @Override
    public void onStart() {
        // Log.e(TAG, "onStart()");

        // initialize the state if is necessary
        if (state == null) {
            state = new Entretenimiento_ListState();
        }

        // call the model and update the state
        state.data = model.getStoredData();

        // use passed state if is necessary
        /*
        Entretenimiento_ListState savedState = getStateFromPreviousScreen();
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
        Entretenimiento_ListState savedState = getStateFromNextScreen();
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

    private Entretenimiento_ListState getStateFromNextScreen() {
        return mediator.getEntretenimiento_ListState();
    }

     private void passStateToNextScreen(Entretenimiento_ListState entretenimiento_listState) {
        mediator.setEntretenimiento_ListState(entretenimiento_listState);
    }

/*
    private void passStateToPreviousScreen(entretenimiento_listToPreviousState state) {
        mediator.setPreviousentretenimiento_listScreenState(state);
    }

    private PreviousToentretenimiento_listState getStateFromPreviousScreen() {
        return mediator.getPreviousentretenimiento_listScreenState();
    }
 */

    @Override
    public void injectView(WeakReference<Entretenimiento_ListContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(Entretenimiento_ListContract.Model model) {
        this.model = model;
    }

}
