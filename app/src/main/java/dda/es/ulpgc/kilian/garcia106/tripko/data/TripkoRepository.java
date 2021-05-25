package dda.es.ulpgc.kilian.garcia106.tripko.data;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripkoRepository implements RepositoryContract {

    private static TripkoRepository INSTANCE;
    private List<CategoryEntretenimientoItem> categoriesEntretenimiento;

    public static String TAG = TripkoRepository.class.getSimpleName();


    public static final String JSON_FILE = "tripko.json";
    public static final String JSON_ROOT = "categoriesEntretenimiento";

    private Context context;
    private List<CategoryEntretenimientoItem> categories;

    public static RepositoryContract getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new TripkoRepository(context);
        }

        return INSTANCE;
    }

    private TripkoRepository(Context context) {
        this.context = context;
    }

    @Override
    public void loadCategoryEntretenimiento(final FetchCategoryEntretenimientoDataCallback callback) {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                boolean error = !loadCategoryEntretenimientoFromJSON(loadJSONFromAsset());

                if (callback != null) {
                    callback.onCategoryEntretenimientoDataFetched(error);
                }
            }
        });
    }

    @Override
    public void getEntretenimientoList(final CategoryEntretenimientoItem categoryEntretenimiento, final GetEntretenimientoListCallback callback) {

        getEntretenimientoList(categoryEntretenimiento.id, callback);
    }

    @Override
    public void getEntretenimientoList(final int categoryEntretenimientoId, final GetEntretenimientoListCallback callback) {
        AsyncTask.execute(new Runnable() {

            @Override
            public void run() {
                if (callback != null) {
                    callback.setEntretenimientoList(loadEntretenimientos(categoryEntretenimientoId));
                }
            }
        });
    }

    @Override
    public void getEntretenimiento(final int id, final GetEntretenimientoCallback callback) {
        AsyncTask.execute(new Runnable() {

            @Override
            public void run() {
                if (callback != null) {
                    callback.setEntretenimiento(loadEntretenimiento(id));
                }
            }
        });
    }

    @Override
    public void getCategoryEntretenimiento(int id, GetCategoryEntretenimientoCallback callback) {

        AsyncTask.execute(new Runnable() {

            @Override
            public void run() {
                if (callback != null) {
                    callback.setCategoryEntretenimiento(loadCategoryEntretenimiento(id));
                }
            }


        });
    }

    @Override
    public void getCategoryEntretenimientoList(final GetCategoryEntretenimientoListCallback callback) {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                if (callback != null) {
                    callback.setCategoryEntretenimientoList(loadCategoriesEntretenimientos());
                }
            }
        });
    }

    private boolean loadCategoryEntretenimientoFromJSON(String json) {
        Log.e(TAG, "loadCategoryEntretenimientoFromJSON()");

        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();

        try {

            JSONObject jsonObject = new JSONObject(json);
            JSONArray jsonArray = jsonObject.getJSONArray(JSON_ROOT);

            categories = new ArrayList();

            if (jsonArray.length() > 0) {

                final List<CategoryEntretenimientoItem> categories = Arrays.asList(
                        gson.fromJson(jsonArray.toString(), CategoryEntretenimientoItem[].class)
                );


                for (CategoryEntretenimientoItem category : categories) {
                    insertCategory(category);
                }

                for (CategoryEntretenimientoItem category : categories) {
                    for (EntretenimientoItem entretenimiento : category.items) {
                        entretenimiento.categoryEntretenimientoId = category.id;
                    }
                }

                return true;
            }

        } catch (JSONException error) {
            Log.e(TAG, "error: " + error);
        }

        return false;
    }

    private String loadJSONFromAsset() {
        //Log.e(TAG, "loadJSONFromAsset()");

        String json = null;

        try {

            InputStream is = context.getAssets().open(JSON_FILE);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");

        } catch (IOException error) {
            Log.e(TAG, "error: " + error);
        }

        return json;
    }


    private List<EntretenimientoItem> loadEntretenimientos(int categoryId) {
        List<EntretenimientoItem> entretenimientos = new ArrayList();

        for (CategoryEntretenimientoItem category : categories) {
            if (category.id == categoryId) {
                entretenimientos = category.items;
            }
        }

        return entretenimientos;
    }


    private EntretenimientoItem loadEntretenimiento(int id) {
        for (CategoryEntretenimientoItem category : categories) {
            for (EntretenimientoItem product : category.items) {
                if (product.id == id) {
                    return product;
                }
            }
        }

        return null;
    }

    private CategoryEntretenimientoItem loadCategoryEntretenimiento(int id) {
        for (CategoryEntretenimientoItem category : categories) {
            if (category.id == id) {
                return category;
            }
        }

        return null;
    }

    private void insertCategory(CategoryEntretenimientoItem category) {
        categories.add(category);
    }

    private List<CategoryEntretenimientoItem> loadCategoriesEntretenimientos() {
        return categories;
    }

//------------------------------------------------------------------------------//

    @Override
    public void loadGastronomia(boolean clearFirst, FetchGastronomiaDataCallback callback) {

    }

    @Override
    public void getGastronomiaList(GetGastronomiaListCallback callback) {

    }
}
