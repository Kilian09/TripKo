package dda.es.ulpgc.kilian.garcia106.tripko.transporte_detail_list;

public class Transporte_Detail_ListModel implements Transporte_Detail_ListContract.Model {

    public static String TAG = Transporte_Detail_ListModel.class.getSimpleName();

    private String data;

    public Transporte_Detail_ListModel(String data) {
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