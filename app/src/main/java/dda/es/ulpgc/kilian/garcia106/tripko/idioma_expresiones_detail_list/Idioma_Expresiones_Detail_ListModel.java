package dda.es.ulpgc.kilian.garcia106.tripko.idioma_expresiones_detail_list;

public class Idioma_Expresiones_Detail_ListModel implements Idioma_Expresiones_Detail_ListContract.Model {

    public static String TAG = Idioma_Expresiones_Detail_ListModel.class.getSimpleName();

    private String data;

    public Idioma_Expresiones_Detail_ListModel(String data) {
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