package com.example.administrator.myspinnerpopupwindow;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/5/6.
 */
public class SpinnerPopupWindow extends PopupWindow implements AdapterView.OnItemClickListener {

    private Context mContext;
    private List<String> list_string;
    private ListView mListView;
    private BaseAdapter mAdapter;
    private AdapterItemClick adapterItemClick;

    public SpinnerPopupWindow(Context context, AdapterItemClick adapterItemClick) {
        mContext = context;
        list_string = new ArrayList<String>();
        this.adapterItemClick = adapterItemClick;
        init();
    }

    public void setItemClick(AdapterItemClick adapterItemClick) {

        this.adapterItemClick = adapterItemClick;
    }

    private void init() {
        View view = LayoutInflater.from(mContext).inflate(R.layout.spiner_window_layout, null);
        this.setContentView(view);
        setFocusable(false);
        setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        mListView = (ListView) view.findViewById(R.id.listview);
        mAdapter = new NormalSpinnerAdapter(mContext, list_string);
        mListView.setAdapter(mAdapter);
        mListView.setOnItemClickListener(this);


    }


    public void addData(String string_content, int position) {
        list_string.add(position, string_content);
    }


    public void addData(String string_content) {
        list_string.add(string_content);
    }

    public void addData(List<String> list) {
        if (list == null && list.size() != 0) {
            list_string.addAll(list);
        }
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        adapterItemClick.itemClick(list_string.get(position));
    }
}
