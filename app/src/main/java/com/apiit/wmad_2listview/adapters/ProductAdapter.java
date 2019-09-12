package com.apiit.wmad_2listview.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.apiit.wmad_2listview.R;
import com.apiit.wmad_2listview.models.Product;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ProductAdapter extends ArrayAdapter<Product> {

    private ArrayList<Product> dataSet;
    Context mContext;

    // View lookup cache
    private static class ViewHolder {
        TextView txtName;
        TextView txtPrice;
        ImageView image;
    }

    public ProductAdapter(ArrayList<Product> data, Context context) {
        super(context, R.layout.product_item, data);
        this.dataSet = data;
        this.mContext = context;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Product dataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.product_item, parent, false);
            viewHolder.txtName = convertView.findViewById(R.id.name);
            viewHolder.txtPrice = convertView.findViewById(R.id.price);
            viewHolder.image = convertView.findViewById(R.id.image);
            result = convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

        Picasso.get().load(dataModel.getImageUrl()).into(viewHolder.image);

        viewHolder.txtName.setText(dataModel.getName());
        viewHolder.txtPrice.setText(dataModel.getPrice().toString());

        return convertView;
    }
}
