package dda.es.ulpgc.kilian.garcia106.tripko.entretenimiento_list;

public class Entretenimiento_ListModel implements Entretenimiento_ListContract.Model {

    public static String TAG = Entretenimiento_ListModel.class.getSimpleName();

    private String data;

    public Entretenimiento_ListModel(String data) {
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