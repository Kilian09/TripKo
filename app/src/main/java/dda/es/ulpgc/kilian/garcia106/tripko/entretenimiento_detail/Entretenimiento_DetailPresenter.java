package dda.es.ulpgc.kilian.garcia106.tripko.entretenimiento_detail;

import java.lang.ref.WeakReference;

import dda.es.ulpgc.kilian.garcia106.tripko.app.AppMediator;
import dda.es.ulpgc.kilian.garcia106.tripko.data.EntretenimientoItem;

public class Entretenimiento_DetailPresenter implements Entretenimiento_DetailContract.Presenter {

    public static String TAG = Entretenimiento_DetailPresenter.class.getSimpleName();

    private WeakReference<Entretenimiento_DetailContract.View> view;
    private Entretenimiento_DetailState state;
    private Entretenimiento_DetailContract.Model model;
    private AppMediator mediator;

    public Entretenimiento_DetailPresenter(AppMediator mediator) {
        this.mediator = mediator;
        state = mediator.getEntretenimiento_DetailState();
    }

    @Override
    public void fetchEntretenimientoDetailData() {
        // set passed state
        EntretenimientoItem entretenimiento = getDataFromEntretenimientoListScreen();
        if(entretenimiento != null) {
            state.entretenimiento = entretenimiento;
        }
        view.get().displayEntretenimientoDetailData(state);
    }

    private EntretenimientoItem getDataFromEntretenimientoListScreen() {
        return mediator.getEntretenimientoItem();
    }

    @Override
    public void injectView(WeakReference<Entretenimiento_DetailContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(Entretenimiento_DetailContract.Model model) {
        this.model = model;
    }



}
