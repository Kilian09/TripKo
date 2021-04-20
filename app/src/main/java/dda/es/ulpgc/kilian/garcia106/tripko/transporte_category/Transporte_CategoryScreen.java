package dda.es.ulpgc.kilian.garcia106.tripko.transporte_category;

import androidx.fragment.app.FragmentActivity;

import java.lang.ref.WeakReference;

import dda.es.ulpgc.kilian.garcia106.tripko.R;
import dda.es.ulpgc.kilian.garcia106.tripko.app.AppMediator;

public class Transporte_CategoryScreen {

    public static void configure(Transporte_CategoryContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        String data = context.get().getString(R.string.app_name);

        AppMediator mediator = AppMediator.getInstance();

        Transporte_CategoryContract.Presenter presenter = new Transporte_CategoryPresenter(mediator);
        Transporte_CategoryContract.Model model = new Transporte_CategoryModel(data);
        presenter.injectModel(model);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}