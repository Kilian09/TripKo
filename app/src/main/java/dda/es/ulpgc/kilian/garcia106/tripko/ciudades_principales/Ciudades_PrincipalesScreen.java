package dda.es.ulpgc.kilian.garcia106.tripko.ciudades_principales;

import androidx.fragment.app.FragmentActivity;

import java.lang.ref.WeakReference;

import dda.es.ulpgc.kilian.garcia106.tripko.R;
import dda.es.ulpgc.kilian.garcia106.tripko.app.AppMediator;

public class Ciudades_PrincipalesScreen {

    public static void configure(Ciudades_PrincipalesContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        String data = context.get().getString(R.string.app_name);

        AppMediator mediator = AppMediator.getInstance();

        Ciudades_PrincipalesContract.Presenter presenter = new Ciudades_PrincipalesPresenter(mediator);
        Ciudades_PrincipalesContract.Model model = new Ciudades_PrincipalesModel(data);
        presenter.injectModel(model);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
