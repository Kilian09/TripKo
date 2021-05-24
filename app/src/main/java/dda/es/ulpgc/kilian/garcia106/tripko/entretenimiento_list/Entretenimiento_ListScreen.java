package dda.es.ulpgc.kilian.garcia106.tripko.entretenimiento_list;

import androidx.fragment.app.FragmentActivity;

import java.lang.ref.WeakReference;

import dda.es.ulpgc.kilian.garcia106.tripko.R;
import dda.es.ulpgc.kilian.garcia106.tripko.app.AppMediator;

public class Entretenimiento_ListScreen {

    public static void configure(Entretenimiento_ListContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        String data = context.get().getString(R.string.app_name);

        AppMediator mediator = AppMediator.getInstance();

        Entretenimiento_ListContract.Presenter presenter = new Entretenimiento_ListPresenter(mediator);
        Entretenimiento_ListContract.Model model = new Entretenimiento_ListModel(data);
        presenter.injectModel(model);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
