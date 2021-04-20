package dda.es.ulpgc.kilian.garcia106.tripko.idioma_alfabeto;

import androidx.fragment.app.FragmentActivity;

import java.lang.ref.WeakReference;

import dda.es.ulpgc.kilian.garcia106.tripko.R;
import dda.es.ulpgc.kilian.garcia106.tripko.app.AppMediator;

public class Idioma_AlfabetoScreen {

    public static void configure(Idioma_AlfabetoContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        String data = context.get().getString(R.string.app_name);

        AppMediator mediator = AppMediator.getInstance();

        Idioma_AlfabetoContract.Presenter presenter = new Idioma_AlfabetoPresenter(mediator);
        Idioma_AlfabetoContract.Model model = new Idioma_AlfabetoModel(data);
        presenter.injectModel(model);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}