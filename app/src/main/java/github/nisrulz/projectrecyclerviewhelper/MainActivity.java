package github.nisrulz.projectrecyclerviewhelper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import github.nisrulz.recyclerviewhelper.RVHItemClickListener;
import github.nisrulz.recyclerviewhelper.RVHItemDividerDecoration;
import github.nisrulz.recyclerviewhelper.RVHItemTouchHelperCallback;

public class MainActivity extends AppCompatActivity {

    RecyclerView myrecyclerview;
    ArrayList<String> data;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myrecyclerview = (RecyclerView) findViewById(R.id.rv_fruits);

        data = new ArrayList<>();
        data.add("Apple");
        data.add("Banana");
        data.add("Peach");
        data.add("Pineapple");
        data.add("Orange");
        data.add("Strawberry");
        data.add("Grapes");
        data.add("Apricot");
        data.add("Avocado");
        data.add("Raisin");
        data.add("Guava");
        data.add("Papaya");
        data.add("Pear");
        data.add("Blueberry");
        data.add("Lychee");
        data.add("Date");
        data.add("Fig");

        adapter = new MyAdapter(data);
        myrecyclerview.hasFixedSize();
        myrecyclerview.setLayoutManager(new LinearLayoutManager(this));
        myrecyclerview.setAdapter(adapter);


        // Setup onItemTouchHandler
        ItemTouchHelper.Callback callback = new RVHItemTouchHelperCallback(adapter, true, true,
                true);
        ItemTouchHelper helper = new ItemTouchHelper(callback);
        helper.attachToRecyclerView(myrecyclerview);

        // Set the divider
        myrecyclerview.addItemDecoration(new RVHItemDividerDecoration(this, LinearLayoutManager.VERTICAL));

        // Set On Click
        myrecyclerview.addOnItemTouchListener(new RVHItemClickListener(this, new RVHItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                String value = "Clicked Item " + data.get(position) + " at " + position;

                Log.d("TAG", value);
                Toast.makeText(MainActivity.this, value, Toast.LENGTH_SHORT).show();
            }
        }));

    }
}
