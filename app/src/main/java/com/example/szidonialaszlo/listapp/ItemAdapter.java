package com.example.szidonialaszlo.listapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by szidonia.laszlo on 2017. 10. 24..
 */

public class ItemAdapter extends BaseAdapter {

    LayoutInflater mInflater;
    String [] items;
    String [] prices;
    String [] descriptions;

    public ItemAdapter(Context c, String [] i, String [] p, String [] d){
        items = i;
        prices=p;
        descriptions=d;
        mInflater=(LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }
    @Override
    public int getCount() {
        return items.length;
    }

    @Override
    public Object getItem(int i) {
        return items[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View v = mInflater.inflate(R.layout.my_listview_detail,null);
        TextView nameTextView = (TextView) v.findViewById(R.id.nameTextView);
        TextView priceTextView = (TextView) v.findViewById(R.id.priceTextView);
        TextView descriptionTextView = (TextView) v.findViewById(R.id.descriptionTextView);

        String name = items[i];
        String price = prices[i];
        String description = descriptions[i];

        nameTextView.setText(name);
        priceTextView.setText(price);
        descriptionTextView.setText(description);


        return v;
    }
}
