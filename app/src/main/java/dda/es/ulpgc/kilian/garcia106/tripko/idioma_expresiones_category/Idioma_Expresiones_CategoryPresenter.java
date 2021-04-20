package dda.es.ulpgc.kilian.garcia106.tripko.idioma_expresiones_category;

import java.lang.ref.WeakReference;

import dda.es.ulpgc.kilian.garcia106.tripko.app.AppMediator;

public class Idioma_Expresiones_CategoryPresenter implements Idioma_Expresiones_CategoryContract.Presenter {

    public static String TAG = Idioma_Expresiones_CategoryPresenter.class.getSimpleName();

    private WeakReference<Idioma_Expresiones_CategoryContract.View> view;
    private Idioma_Expresiones_CategoryState state;
    private Idioma_Expresiones_CategoryContract.Model model;
    private AppMediator mediator;

    public Idioma_Expresiones_CategoryPresenter(AppMediator mediator) {
        this.mediator = mediator;
        state = mediator.getIdioma_Expresiones_CategoryState();
    }

    @Override
    public void onStart() {
        // Log.e(TAG, "onStart()");

        // initialize the state if is necessary
        if (state == null) {
            state = new Idioma_Expresiones_CategoryState();
        }

        // call the model and update the state
        state.data = model.getStoredData();

/*        // use passed state if is necessary
        PreviousToIdioma_Expresiones_CategoryState savedState = getStateFromPreviousScreen();
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
        NextToIdioma_Expresiones_CategoryState savedState = getStateFromNextScreen();
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

/*    private NextToIdioma_Expresiones_CategoryState getStateFromNextScreen() {
        return mediator.getNextIdioma_Expresiones_CategoryScreenState();
    }

    private void passStateToNextScreen(Idioma_Expresiones_CategoryToNextState state) {
        mediator.setNextIdioma_Expresiones_CategoryScreenState(state);
    }

    private void passStateToPreviousScreen(Idioma_Expresiones_CategoryToPreviousState state) {
        mediator.setPreviousIdioma_Expresiones_CategoryScreenState(state);
    }

    private PreviousToIdioma_Expresiones_CategoryState getStateFromPreviousScreen() {
        return mediator.getPreviousIdioma_Expresiones_CategoryScreenState();
    }*/

    @Override
    public void injectView(WeakReference<Idioma_Expresiones_CategoryContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(Idioma_Expresiones_CategoryContract.Model model) {
        this.model = model;
    }

}