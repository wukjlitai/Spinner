package com.example.administrator.myspinnerpopupwindow;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2016/5/6.
 */
public class NormalSpinnerAdapter extends BaseAdapter {

    private Context mcontext;
    private List<String> list_string;
    private NormalSpinnerAdapter.ViewHolder viewHolder;

    public NormalSpinnerAdapter(Context context, List list_string) {
        mcontext = context;
        this.list_string = list_string;
    }

    @Override


    public int getCount() {
        return list_string.size();
    }

    @Override
    public Object getItem(int position) {
        return list_string.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(mcontext).inflate(R.layout.spiner_item_layout, null);
            viewHolder.textView = (TextView) convertView.findViewById(R.id.textView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.textView.setText(list_string.get(position));
        return convertView;
    }


    class ViewHolder {

        private TextView textView;
    }
}
