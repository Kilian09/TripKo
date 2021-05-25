package dda.es.ulpgc.kilian.garcia106.tripko.sobre_corea;

import java.lang.ref.WeakReference;

import dda.es.ulpgc.kilian.garcia106.tripko.app.AppMediator;

public class Sobre_CoreaPresenter implements Sobre_CoreaContract.Presenter {

    public static String TAG = Sobre_CoreaPresenter.class.getSimpleName();

    private WeakReference<Sobre_CoreaContract.View> view;
    private Sobre_CoreaState state;
    private Sobre_CoreaContract.Model model;
    private AppMediator mediator;

    public Sobre_CoreaPresenter(AppMediator mediator) {
        this.mediator = mediator;
        state = mediator.getSobre_CoreaState();
    }

    @Override
    public void onStart() {
        // Log.e(TAG, "onStart()");

        // initialize the state if is necessary
        if (state == null) {
            state = new Sobre_CoreaState();
        }

        // call the model and update the state
        state.data = model.getStoredData();

        // use passed state if is necessary
        Sobre_CoreaState savedState = getDataFromPreviousScreen();
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
        Sobre_CoreaState savedState = getDataFromPreviousScreen();
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

    @Override
    public Sobre_CoreaState getDataFromPreviousScreen() {
        Sobre_CoreaState state = mediator.getSobre_CoreaState();
        return state;
    }
    @Override
    public void onSobreCoreaOptionClicked(int option) {
        switch (option){
            case 0:
                view.get().navigateToClimaScreen();
                break;
            case 1:
                view.get().navigateToCiudadesPrincipalesScreen();
                break;
            case 2:
                view.get().navigateToCulturaScreen();
                break;
            default:
                break;
        }
    }
    public void navigateToMenuScreen() {
        view.get().navigateToMenuScreen();
    }
    @Override
    public void injectView(WeakReference<Sobre_CoreaContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(Sobre_CoreaContract.Model model) {
        this.model = model;
    }

}
