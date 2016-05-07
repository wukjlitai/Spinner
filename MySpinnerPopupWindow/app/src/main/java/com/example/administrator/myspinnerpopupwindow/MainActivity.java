package com.example.administrator.myspinnerpopupwindow;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterItemClick {

    private TextView spinner_tv;
    private SpinnerPopupWindow mSpinerPopWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner_tv = (TextView) findViewById(R.id.spinner_tv);
        spinner_tv.setOnClickListener(this);
        spinner_tv.setText("管理人员");
        mSpinerPopWindow = new SpinnerPopupWindow(getApplicationContext(), this);
        mSpinerPopWindow.addData("管理人员");
        mSpinerPopWindow.addData("普通人员");


    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            if (mSpinerPopWindow != null && mSpinerPopWindow.isShowing()) {
                mSpinerPopWindow.dismiss();
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (mSpinerPopWindow != null && mSpinerPopWindow.isShowing()) {
            mSpinerPopWindow.dismiss();
        }
        return super.onTouchEvent(event);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.spinner_tv:
                showSpinWindow();
                break;
            default:
                break;

        }
    }

    private void showSpinWindow() {
        Log.e("", "showSpinWindow");
        mSpinerPopWindow.setWidth(spinner_tv.getWidth());
        mSpinerPopWindow.showAsDropDown(spinner_tv);
    }

    @Override
    public void itemClick(String string_content) {
        spinner_tv.setText(string_content);
        mSpinerPopWindow.dismiss();
    }
}
