package dda.es.ulpgc.kilian.garcia106.tripko.sobre_corea;

public class Sobre_CoreaModel implements Sobre_CoreaContract.Model {

    public static String TAG = Sobre_CoreaModel.class.getSimpleName();

    private String data;

    public Sobre_CoreaModel(String data) {
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