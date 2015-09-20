package com.example.administrator.viewtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2015/9/13.
 */
public class FruitAdapter extends ArrayAdapter<Fruit>{
    private int resourceId;
    public FruitAdapter(Context context,int textViewResourceId,List<Fruit> objects){
        super(context,textViewResourceId,objects);
        resourceId = textViewResourceId;
    }
    @Override
    public View getView(int position,View convertView,ViewGroup parent){
        Fruit fruit = getItem(position);
        View view;
        ViewHolder viewHolder;
        if (convertView ==null){
            view =LayoutInflater.from(getContext()).inflate(resourceId, null);
            viewHolder = new ViewHolder();
            viewHolder.fruitImage = (ImageView)view.findViewById(R.id.image_view);
            viewHolder.fruitText = (TextView) view.findViewById(R.id.fruit_name);
            view.setTag(viewHolder);
        }
        else {
            view =convertView;
            viewHolder = (ViewHolder) view.getTag();

        }
        ImageView fruitImage = (ImageView) view.findViewById(R.id.image_view);
        TextView fruitName = (TextView) view.findViewById(R.id.fruit_name);
        fruitImage.setImageResource(fruit.getImageId());
        fruitName.setText(fruit.getName());
        return view;

    }
    class ViewHolder{
        ImageView fruitImage;
        TextView fruitText;
    }
}
