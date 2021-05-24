package dda.es.ulpgc.kilian.garcia106.tripko.entretenimiento_detail;

import androidx.fragment.app.FragmentActivity;

import java.lang.ref.WeakReference;

import dda.es.ulpgc.kilian.garcia106.tripko.R;
import dda.es.ulpgc.kilian.garcia106.tripko.app.AppMediator;

public class Entretenimiento_DetailScreen {

    public static void configure(Entretenimiento_DetailContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        String data = context.get().getString(R.string.app_name);

        AppMediator mediator = AppMediator.getInstance();

        Entretenimiento_DetailContract.Presenter presenter = new Entretenimiento_DetailPresenter(mediator);
        Entretenimiento_DetailContract.Model model = new Entretenimiento_DetailModel(data);
        presenter.injectModel(model);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
