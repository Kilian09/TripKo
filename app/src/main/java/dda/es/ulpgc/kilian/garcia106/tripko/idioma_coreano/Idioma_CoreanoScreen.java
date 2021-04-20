package dda.es.ulpgc.kilian.garcia106.tripko.idioma_coreano;

import androidx.fragment.app.FragmentActivity;

import java.lang.ref.WeakReference;

import dda.es.ulpgc.kilian.garcia106.tripko.R;
import dda.es.ulpgc.kilian.garcia106.tripko.app.AppMediator;

public class Idioma_CoreanoScreen {

    public static void configure(Idioma_CoreanoContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        String data = context.get().getString(R.string.app_name);

        AppMediator mediator = AppMediator.getInstance();

        Idioma_CoreanoContract.Presenter presenter = new Idioma_CoreanoPresenter(mediator);
        Idioma_CoreanoContract.Model model = new Idioma_CoreanoModel(data);
        presenter.injectModel(model);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}