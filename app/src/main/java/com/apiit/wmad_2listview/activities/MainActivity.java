package com.apiit.wmad_2listview.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import com.apiit.wmad_2listview.R;
import com.apiit.wmad_2listview.adapters.ProductAdapter;
import com.apiit.wmad_2listview.models.Product;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class MainActivity extends AppCompatActivity {

    private Gson mGson = new Gson();
    private OkHttpClient mHttpClient = new OkHttpClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView mListView = findViewById(R.id.list);
        final Type productListTypeToken = new TypeToken<ArrayList<Product>>() {}.getType();

        Request request = new Request
                .Builder()
                 // replace this with your web api url.
                .url("http://192.168.43.113:8084/WebApi/products")
                .build();

        mHttpClient
                .newCall(request)
                .enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        try (ResponseBody responseBody = response.body()) {
                            if (!response.isSuccessful()) {
                                ProductAdapter adapter = new ProductAdapter(new ArrayList<Product>(), getApplicationContext());
                                mListView.setAdapter(adapter);
                            }

                            ArrayList<Product> productsToDisplay = mGson.fromJson(responseBody.string(), productListTypeToken);
                            ProductAdapter adapter = new ProductAdapter(productsToDisplay, getApplicationContext());

                            mListView.setAdapter(adapter);
                        }
                    }
                });


    }
}
