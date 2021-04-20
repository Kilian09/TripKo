package dda.es.ulpgc.kilian.garcia106.tripko.idioma_expresiones_detail_list;

import java.lang.ref.WeakReference;

import dda.es.ulpgc.kilian.garcia106.tripko.app.AppMediator;

public class Idioma_Expresiones_Detail_ListPresenter implements Idioma_Expresiones_Detail_ListContract.Presenter {

    public static String TAG = Idioma_Expresiones_Detail_ListPresenter.class.getSimpleName();

    private WeakReference<Idioma_Expresiones_Detail_ListContract.View> view;
    private Idioma_Expresiones_Detail_ListState state;
    private Idioma_Expresiones_Detail_ListContract.Model model;
    private AppMediator mediator;

    public Idioma_Expresiones_Detail_ListPresenter(AppMediator mediator) {
        this.mediator = mediator;
        state = mediator.getIdioma_Expresiones_Detail_ListState();
    }

    @Override
    public void onStart() {
        // Log.e(TAG, "onStart()");

        // initialize the state if is necessary
        if (state == null) {
            state = new Idioma_Expresiones_Detail_ListState();
        }

        // call the model and update the state
        state.data = model.getStoredData();

/*        // use passed state if is necessary
        PreviousToIdioma_Expresiones_Detail_ListState savedState = getStateFromPreviousScreen();
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

/*
        // use passed state if is necessary
        NextToIdioma_Expresiones_Detail_ListState savedState = getStateFromNextScreen();
        if (savedState != null) {

            // update the model if is necessary
            model.onDataFromNextScreen(savedState.data);

            // update the state if is necessary
            state.data = savedState.data;
        }
*/

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

/*    private NextToIdioma_Expresiones_Detail_ListState getStateFromNextScreen() {
        return mediator.getNextIdioma_Expresiones_Detail_ListScreenState();
    }

    private void passStateToNextScreen(Idioma_Expresiones_Detail_ListToNextState state) {
        mediator.setNextIdioma_Expresiones_Detail_ListScreenState(state);
    }

    private void passStateToPreviousScreen(Idioma_Expresiones_Detail_ListToPreviousState state) {
        mediator.setPreviousIdioma_Expresiones_Detail_ListScreenState(state);
    }

    private PreviousToIdioma_Expresiones_Detail_ListState getStateFromPreviousScreen() {
        return mediator.getPreviousIdioma_Expresiones_Detail_ListScreenState();
    }*/

    @Override
    public void injectView(WeakReference<Idioma_Expresiones_Detail_ListContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(Idioma_Expresiones_Detail_ListContract.Model model) {
        this.model = model;
    }

}