package dda.es.ulpgc.kilian.garcia106.tripko.entretenimiento_detail;

import java.lang.ref.WeakReference;

public interface Entretenimiento_DetailContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayEntretenimientoDetailData(Entretenimiento_DetailViewModel viewModel);

    }

    interface Presenter {
        void injectView(WeakReference<View> view);

        void injectModel(Model model);


        void fetchEntretenimientoDetailData();
    }

    interface Model {
        String getStoredData();

        void onDataFromNextScreen(String data);

        void onRestartScreen(String data);

        void onDataFromPreviousScreen(String data);
    }

}