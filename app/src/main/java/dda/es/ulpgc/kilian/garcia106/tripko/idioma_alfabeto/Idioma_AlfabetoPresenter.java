package dda.es.ulpgc.kilian.garcia106.tripko.idioma_alfabeto;

import java.lang.ref.WeakReference;

import dda.es.ulpgc.kilian.garcia106.tripko.app.AppMediator;

public class Idioma_AlfabetoPresenter implements Idioma_AlfabetoContract.Presenter {

    public static String TAG = Idioma_AlfabetoPresenter.class.getSimpleName();

    private WeakReference<Idioma_AlfabetoContract.View> view;
    private Idioma_AlfabetoState state;
    private Idioma_AlfabetoContract.Model model;
    private AppMediator mediator;

    public Idioma_AlfabetoPresenter(AppMediator mediator) {
        this.mediator = mediator;
        state = mediator.getIdioma_AlfabetoState();
    }

    @Override
    public void onStart() {
        // Log.e(TAG, "onStart()");

        // initialize the state if is necessary
        if (state == null) {
            state = new Idioma_AlfabetoState();
        }

/*        // call the model and update the state
        state.data = model.getStoredData();

        // use passed state if is necessary
        PreviousToIdioma_AlfabetoState savedState = getStateFromPreviousScreen();
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
/*        NextToIdioma_AlfabetoState savedState = getStateFromNextScreen();
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

/*    private NextToIdioma_AlfabetoState getStateFromNextScreen() {
        return mediator.getNextIdioma_AlfabetoScreenState();
    }

    private void passStateToNextScreen(Idioma_AlfabetoToNextState state) {
        mediator.setNextIdioma_AlfabetoScreenState(state);
    }

    private void passStateToPreviousScreen(Idioma_AlfabetoToPreviousState state) {
        mediator.setPreviousIdioma_AlfabetoScreenState(state);
    }

    private PreviousToIdioma_AlfabetoState getStateFromPreviousScreen() {
        return mediator.getPreviousIdioma_AlfabetoScreenState();
    }*/

    @Override
    public void injectView(WeakReference<Idioma_AlfabetoContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(Idioma_AlfabetoContract.Model model) {
        this.model = model;
    }

}