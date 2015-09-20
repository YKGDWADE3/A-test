package com.example.administrator.uicustomerview;

import android.app.Activity;
import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by Administrator on 2015/9/13.
 */
public class TitleLayout extends LinearLayout {
    public TitleLayout(Context context,AttributeSet attr){
        super(context, attr);
        LayoutInflater.from(context).inflate(R.layout.title, this);
        Button titleBack = (Button) findViewById(R.id.goBack);
        titleBack.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                ((Activity) getContext()).finish();
            }
        });
        Button titleEdit = (Button) findViewById(R.id.edit);
        titleEdit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"you click edit",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
