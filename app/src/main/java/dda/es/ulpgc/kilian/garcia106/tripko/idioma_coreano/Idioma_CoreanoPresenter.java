package dda.es.ulpgc.kilian.garcia106.tripko.idioma_coreano;

import java.lang.ref.WeakReference;

import dda.es.ulpgc.kilian.garcia106.tripko.app.AppMediator;

public class Idioma_CoreanoPresenter implements Idioma_CoreanoContract.Presenter {

    public static String TAG = Idioma_CoreanoPresenter.class.getSimpleName();

    private WeakReference<Idioma_CoreanoContract.View> view;
    private Idioma_CoreanoState state;
    private Idioma_CoreanoContract.Model model;
    private AppMediator mediator;

    public Idioma_CoreanoPresenter(AppMediator mediator) {
        this.mediator = mediator;
        state = mediator.getIdioma_CoreanoState();
    }

    @Override
    public void onStart() {
        // Log.e(TAG, "onStart()");

        // initialize the state if is necessary
        if (state == null) {
            state = new Idioma_CoreanoState();
        }

/*        // call the model and update the state
        state.data = model.getStoredData();

        // use passed state if is necessary
        PreviousToIdioma_CoreanoState savedState = getStateFromPreviousScreen();
        if (savedState != null) {

            // update the model if is necessary
            model.onDataFromPreviousScreen(savedState.data);

            // update the state if is necessary
            state.data = savedState.data;
        }*/
        view.get().displayData(state);
    }

    @Override
    public void onRestart() {
        // Log.e(TAG, "onRestart()");

        // update the model if is necessary
        //model.onRestartScreen(state.data);
    }

    @Override
    public void onResume() {
        // Log.e(TAG, "onResume()");
/*
        // use passed state if is necessary
        NextToIdioma_CoreanoState savedState = getStateFromNextScreen();
        if (savedState != null) {

            // update the model if is necessary
            model.onDataFromNextScreen(savedState.data);

            // update the state if is necessary
            state.data = savedState.data;
        }*/

        // call the model and update the state
        //state.data = model.getStoredData();

        // update the view
        view.get().displayData(state);

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
    public void navigateToMenuScreen() {
        view.get().navigateToMenuScreen();
    }

    @Override
    public void injectView(WeakReference<Idioma_CoreanoContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(Idioma_CoreanoContract.Model model) {
        this.model = model;
    }

}