package example.com;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Fruit> fruitList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFruits();
        FruitAdapter adapter =new FruitAdapter(MainActivity.this,R.layout.fruit_item,fruitList);
        ListView listview = (ListView) findViewById(R.id.list_view);
        listview.setAdapter(adapter);
    }
    private void initFruits(){
        for(int i=0;i<2;i++){
            Fruit apple =new Fruit("Apple",R.drawable.apple);
            fruitList.add(apple);
            Fruit banana =new Fruit("Banana",R.drawable.banana);
            fruitList.add(banana);
            Fruit orange =new Fruit("Orange",R.drawable.orange);
            fruitList.add(orange);
            Fruit watermelon =new Fruit("Watermelon",R.drawable.watermelon);
            fruitList.add(watermelon);
            Fruit pear =new Fruit("Pear",R.drawable.pear);
            fruitList.add(pear);
            Fruit grape =new Fruit("Grapes",R.drawable.grapes);
            fruitList.add(grape);
            Fruit pineapple =new Fruit("Pineapple",R.drawable.pineapple);
            fruitList.add(pineapple);
            Fruit strawberry =new Fruit("Strawberry",R.drawable.strawberry);
            fruitList.add(strawberry);
            Fruit cherry =new Fruit("cherry",R.drawable.cherry);
            fruitList.add(cherry);
            Fruit mango =new Fruit("mango",R.drawable.mango);
            fruitList.add(mango);
        }
    }
}