package dda.es.ulpgc.kilian.garcia106.tripko.splash;

import java.lang.ref.WeakReference;

public interface SplashContract {

    interface View {
        void injectPresenter(Presenter presenter);


    }

    interface Presenter {


        void injectView(WeakReference<View> view);

        void injectModel(Model model);


    }

    interface Model {

    }

}
