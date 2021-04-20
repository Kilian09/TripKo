package dda.es.ulpgc.kilian.garcia106.tripko.contactos_list;

public class Contactos_ListModel implements Contactos_ListContract.Model {

    public static String TAG = Contactos_ListModel.class.getSimpleName();

    private String data;

    public Contactos_ListModel(String data) {
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