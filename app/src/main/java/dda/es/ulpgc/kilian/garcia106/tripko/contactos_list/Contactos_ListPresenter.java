package dda.es.ulpgc.kilian.garcia106.tripko.contactos_list;

import java.lang.ref.WeakReference;

import dda.es.ulpgc.kilian.garcia106.tripko.app.AppMediator;

public class Contactos_ListPresenter implements Contactos_ListContract.Presenter {

    public static String TAG = Contactos_ListPresenter.class.getSimpleName();

    private WeakReference<Contactos_ListContract.View> view;
    private Contactos_ListState state;
    private Contactos_ListContract.Model model;
    private AppMediator mediator;

    public Contactos_ListPresenter(AppMediator mediator) {
        this.mediator = mediator;
        state = mediator.getContactos_ListState();
    }

    @Override
    public void onStart() {
        // Log.e(TAG, "onStart()");

        // initialize the state if is necessary
        if (state == null) {
            state = new Contactos_ListState();
        }

        // call the model and update the state
        state.data = model.getStoredData();

    /*    // use passed state if is necessary
        PreviousToContactos_ListState savedState = getStateFromPreviousScreen();
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
        NextToContactos_ListState savedState = getStateFromNextScreen();
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

/*    private NextToContactos_ListState getStateFromNextScreen() {
        return mediator.getNextContactos_ListScreenState();
    }

    private void passStateToNextScreen(Contactos_ListToNextState state) {
        mediator.setNextContactos_ListScreenState(state);
    }

    private void passStateToPreviousScreen(Contactos_ListToPreviousState state) {
        mediator.setPreviousContactos_ListScreenState(state);
    }

    private PreviousToContactos_ListState getStateFromPreviousScreen() {
        return mediator.getPreviousContactos_ListScreenState();
    }*/

    @Override
    public void injectView(WeakReference<Contactos_ListContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(Contactos_ListContract.Model model) {
        this.model = model;
    }

}