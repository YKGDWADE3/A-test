package com.example.administrator.viewtest;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    private List<Fruit> fruitList = new ArrayList<Fruit>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        initFruits();
        FruitAdapter adapter = new FruitAdapter(MainActivity.this,R.layout.fruit_item,fruitList);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Fruit fruit = fruitList.get(i);
                Toast.makeText(MainActivity.this,fruit.getName(),Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void initFruits(){
        Fruit apple = new Fruit("Apple",R.mipmap.ic_launcher);
        fruitList.add(apple);
        Fruit banana = new Fruit("Banana",R.mipmap.ic_launcher);
        fruitList.add(banana);
        Fruit orange = new Fruit("Orange",R.mipmap.ic_launcher);
        fruitList.add(orange);
        Fruit Watermelon = new Fruit("Watermelon",R.mipmap.ic_launcher);
        fruitList.add(Watermelon);
        Fruit Pear = new Fruit("Pear",R.mipmap.ic_launcher);
        fruitList.add(Pear);
        Fruit Grape = new Fruit("Grape",R.mipmap.ic_launcher);
        fruitList.add(Grape);
        Fruit PineApple = new Fruit("PineApple",R.mipmap.ic_launcher);
        fruitList.add(PineApple);
        Fruit Strawberry = new Fruit("Strawberry",R.mipmap.ic_launcher);
        fruitList.add(Strawberry);
        Fruit Cherry = new Fruit("Cherry",R.mipmap.ic_launcher);
        fruitList.add(Cherry);
        Fruit Mango = new Fruit("Mango",R.mipmap.ic_launcher);
        fruitList.add(Mango);
        Fruit app = new Fruit("app",R.mipmap.ic_launcher);
        fruitList.add(app);
        Fruit bat = new Fruit("bat",R.mipmap.ic_launcher);
        fruitList.add(bat);
        Fruit cat = new Fruit("cat",R.mipmap.ic_launcher);
        fruitList.add(cat);
        Fruit dog = new Fruit("dog",R.mipmap.ic_launcher);
        fruitList.add(dog);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
