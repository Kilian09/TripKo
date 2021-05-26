package dda.es.ulpgc.kilian.garcia106.tripko.ciudades_principales;

import java.lang.ref.WeakReference;

import dda.es.ulpgc.kilian.garcia106.tripko.app.AppMediator;
import dda.es.ulpgc.kilian.garcia106.tripko.cultura.CulturaState;

public class Ciudades_PrincipalesPresenter implements Ciudades_PrincipalesContract.Presenter {

    public static String TAG = Ciudades_PrincipalesPresenter.class.getSimpleName();

    private WeakReference<Ciudades_PrincipalesContract.View> view;
    private Ciudades_PrincipalesState state;
    private Ciudades_PrincipalesContract.Model model;
    private AppMediator mediator;

    public Ciudades_PrincipalesPresenter(AppMediator mediator) {
        this.mediator = mediator;
        state = mediator.getCiudades_PrincipalesState();
    }

    @Override
    public void onStart() {
        // Log.e(TAG, "onStart()");

        // initialize the state if is necessary
        if (state == null) {
            state = new Ciudades_PrincipalesState();
        }

        // call the model and update the state
        state.data = model.getStoredData();

        // use passed state if is necessary
        Ciudades_PrincipalesState savedState = getDataFromPreviousScreen();
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
        Ciudades_PrincipalesState savedState = getDataFromPreviousScreen();
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

    public void navigateToMenuScreen() {
        view.get().navigateToMenuScreen();
    }

    @Override
    public Ciudades_PrincipalesState getDataFromPreviousScreen() {
        Ciudades_PrincipalesState state = mediator.getCiudades_PrincipalesState();
        return state;
    }

    @Override
    public void injectView(WeakReference<Ciudades_PrincipalesContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(Ciudades_PrincipalesContract.Model model) {
        this.model = model;
    }

}
