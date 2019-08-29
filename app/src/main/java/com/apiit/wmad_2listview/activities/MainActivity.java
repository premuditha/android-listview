package com.apiit.wmad_2listview.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.apiit.wmad_2listview.R;
import com.apiit.wmad_2listview.adapters.ProductAdapter;
import com.apiit.wmad_2listview.models.Product;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Product> dataModels;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list);

        dataModels = new ArrayList<>();

        dataModels.add(new Product("Product A", 120.50, 10, "Description A", 0));
        dataModels.add(new Product("Product B", 130.50, 20, "Description B", 0));
        dataModels.add(new Product("Product C", 140.50, 30, "Description C", 0));
        dataModels.add(new Product("Product D", 150.50, 40, "Description D", 0));
        dataModels.add(new Product("Product E", 160.50, 50, "Description E", 0));
        dataModels.add(new Product("Product F", 170.50, 60, "Description F", 0));
        dataModels.add(new Product("Product G", 180.50, 70, "Description G", 0));
        dataModels.add(new Product("Product H", 190.50, 80, "Description H", 0));
        dataModels.add(new Product("Product I", 220.50, 90, "Description I", 0));
        dataModels.add(new Product("Product J", 320.50, 100, "Description J", 0));
        dataModels.add(new Product("Product K", 420.50, 1100, "Description K", 0));

        ProductAdapter adapter = new ProductAdapter(dataModels, getApplicationContext());

        listView.setAdapter(adapter);
    }
}
