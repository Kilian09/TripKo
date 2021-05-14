package dda.es.ulpgc.kilian.garcia106.tripko.cultura;

import androidx.fragment.app.FragmentActivity;

import java.lang.ref.WeakReference;

import dda.es.ulpgc.kilian.garcia106.tripko.R;
import dda.es.ulpgc.kilian.garcia106.tripko.app.AppMediator;

public class CulturaScreen {

    public static void configure(CulturaContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        String data = context.get().getString(R.string.app_name);

        AppMediator mediator = AppMediator.getInstance();

        CulturaContract.Presenter presenter = new CulturaPresenter(mediator);
        CulturaContract.Model model = new CulturaModel(data);
        presenter.injectModel(model);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
