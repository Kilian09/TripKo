package dda.es.ulpgc.kilian.garcia106.tripko.ciudades_principales;

public class Ciudades_PrincipalesModel implements Ciudades_PrincipalesContract.Model {

    public static String TAG = Ciudades_PrincipalesModel.class.getSimpleName();

    private String data;

    public Ciudades_PrincipalesModel(String data) {
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