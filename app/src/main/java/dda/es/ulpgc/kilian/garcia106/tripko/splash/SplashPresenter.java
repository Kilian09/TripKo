package dda.es.ulpgc.kilian.garcia106.tripko.splash;

import java.lang.ref.WeakReference;

import dda.es.ulpgc.kilian.garcia106.tripko.app.AppMediator;

public class SplashPresenter implements SplashContract.Presenter {

    public static String TAG = SplashPresenter.class.getSimpleName();

    private WeakReference<SplashContract.View> view;
    private SplashState state;
    private SplashContract.Model model;
    private AppMediator mediator;

    public SplashPresenter(AppMediator mediator) {
        this.mediator = mediator;
    }


    @Override
    public void injectView(WeakReference<SplashContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(SplashContract.Model model) {
        this.model = model;
    }

}
