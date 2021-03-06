package dda.es.ulpgc.kilian.garcia106.tripko.conversor_moneda;

import java.lang.ref.WeakReference;

import dda.es.ulpgc.kilian.garcia106.tripko.app.AppMediator;

public class Conversor_MonedaPresenter implements Conversor_MonedaContract.Presenter {

    public static String TAG = Conversor_MonedaPresenter.class.getSimpleName();

    private WeakReference<Conversor_MonedaContract.View> view;
    private Conversor_MonedaState state;
    private Conversor_MonedaContract.Model model;
    private AppMediator mediator;

    public Conversor_MonedaPresenter(AppMediator mediator) {
        this.mediator = mediator;
        state = mediator.getConversor_MonedaState();
    }

    @Override
    public void onStart() {
        // Log.e(TAG, "onStart()");

        // initialize the state
        state = new Conversor_MonedaState();

        // call the model and update the state


    }

    @Override
    public void onRestart() {

    }


    @Override
    public void onResume() {
        // Log.e(TAG, "onResume()");

        // use passed state if is necessary


        // update the view
        view.get().onDataUpdated(state);

    }


    @Override
    public void onCalcularClicked(double cantidad, String divisa, String pasarA) {
        model.convertirDivisa(cantidad,divisa,pasarA);

        state.resultado = String.valueOf(model.getResultado());

        view.get().onDataUpdated(state);
    }

    @Override
    public void navigateToMenuScreen() {
        view.get().navigateToMenuScreen();
    }


    @Override
    public void injectView(WeakReference<Conversor_MonedaContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(Conversor_MonedaContract.Model model) {
        this.model = model;
    }

}