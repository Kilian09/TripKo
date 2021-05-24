package dda.es.ulpgc.kilian.garcia106.tripko.idioma;

import androidx.fragment.app.FragmentActivity;

import java.lang.ref.WeakReference;

import dda.es.ulpgc.kilian.garcia106.tripko.R;
import dda.es.ulpgc.kilian.garcia106.tripko.app.AppMediator;
import dda.es.ulpgc.kilian.garcia106.tripko.data.RepositoryContract;
import dda.es.ulpgc.kilian.garcia106.tripko.data.TripkoRepository;

public class IdiomaScreen {

    public static void configure(IdiomaContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        String data = context.get().getString(R.string.app_name);

        AppMediator mediator = AppMediator.getInstance();
        RepositoryContract repository = TripkoRepository.getInstance(context.get());

        IdiomaContract.Presenter presenter = new IdiomaPresenter(mediator);
        IdiomaContract.Model model = new IdiomaModel(repository);
        presenter.injectModel(model);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}