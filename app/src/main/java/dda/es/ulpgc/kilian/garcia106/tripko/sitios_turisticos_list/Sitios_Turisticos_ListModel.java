package dda.es.ulpgc.kilian.garcia106.tripko.sitios_turisticos_list;

public class Sitios_Turisticos_ListModel implements Sitios_Turisticos_ListContract.Model {

    public static String TAG = Sitios_Turisticos_ListModel.class.getSimpleName();

    private String data;

    public Sitios_Turisticos_ListModel(String data) {
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