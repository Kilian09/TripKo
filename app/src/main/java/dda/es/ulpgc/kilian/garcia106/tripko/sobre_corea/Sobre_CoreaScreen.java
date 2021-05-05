package dda.es.ulpgc.kilian.garcia106.tripko.sobre_corea;

import androidx.fragment.app.FragmentActivity;

import java.lang.ref.WeakReference;

import dda.es.ulpgc.kilian.garcia106.tripko.R;
import dda.es.ulpgc.kilian.garcia106.tripko.app.AppMediator;

public class Sobre_CoreaScreen {

    public static void configure(Sobre_CoreaContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        String data = context.get().getString(R.string.app_name);

        AppMediator mediator = AppMediator.getInstance();

        Sobre_CoreaContract.Presenter presenter = new Sobre_CoreaPresenter(mediator);
        Sobre_CoreaContract.Model model = new Sobre_CoreaModel(data);
        presenter.injectModel(model);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
