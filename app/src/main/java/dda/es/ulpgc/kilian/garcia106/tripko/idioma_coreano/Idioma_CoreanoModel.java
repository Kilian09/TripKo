package dda.es.ulpgc.kilian.garcia106.tripko.idioma_coreano;

public class Idioma_CoreanoModel implements Idioma_CoreanoContract.Model {

    public static String TAG = Idioma_CoreanoModel.class.getSimpleName();

    private String data;

    public Idioma_CoreanoModel(String data) {
        this.data = data;
    }

    @Override
    public String getStoredData() {
        // Log.e(TAG, "getStoredData()");
        return data;
    }

    @Override
    public void onRestartScreen(String data) {
        // Log.e(TAG, "onRestartScreen()");
    }

    @Override
    public void onDataFromNextScreen(String data) {
        // Log.e(TAG, "onDataFromNextScreen()");
    }

    @Override
    public void onDataFromPreviousScreen(String data) {
        // Log.e(TAG, "onDataFromPreviousScreen()");
    }
}