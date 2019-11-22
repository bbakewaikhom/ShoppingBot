package com.crown.shoppingbot.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.crown.shoppingbot.R;
import com.crown.shoppingbot.ShoppingListAdapter;
import com.crown.shoppingbot.models.ListItem;
import com.crown.shoppingbot.models.ShoppingItem;
import com.crown.shoppingbot.models.ShoppingLabel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String PARCELABLE_TAG_SELECTED_ITEM = "selected_items";

    private RecyclerView recyclerView;
    private ShoppingListAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rv_rvl_shopping_items);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new ShoppingListAdapter(getDataSet());
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.shopping_item_list_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.m_silm_done) {
            int selectedItemCount = mAdapter.getSelectedItems().length;
            if (selectedItemCount == 0) {
                Toast.makeText(getApplicationContext(), "No item selected", Toast.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent(this, SelectedItemListActivity.class);
                intent.putExtra(PARCELABLE_TAG_SELECTED_ITEM, mAdapter.getSelectedItems());
                startActivity(intent);

                Toast.makeText(getApplicationContext(), selectedItemCount + " items selected", Toast.LENGTH_SHORT).show();
            }
        }
        return super.onOptionsItemSelected(item);
    }

    List<ListItem> getDataSet() {
        List<ListItem> list = new ArrayList<>();
        list.add(new ShoppingLabel("Foods"));
        list.add(new ShoppingItem("Chips", 1));
        list.add(new ShoppingItem("Juice", 1));

        list.add(new ShoppingLabel("Electronics"));
        list.add(new ShoppingItem("Batteries", 2));
        list.add(new ShoppingItem("USB", 2));

        list.add(new ShoppingLabel("Clothes"));
        list.add(new ShoppingItem("Jeans", 3));
        list.add(new ShoppingItem("Socks", 3));

        list.add(new ShoppingLabel("Apparels"));
        list.add(new ShoppingItem("Shoes", 4));
        list.add(new ShoppingItem("Bags", 4));

        list.add(new ShoppingLabel("Forfeitures"));
        list.add(new ShoppingItem("Tables", 5));
        list.add(new ShoppingItem("Chairs", 5));

        list.add(new ShoppingLabel("Crockery"));
        list.add(new ShoppingItem("Spoons", 6));
        list.add(new ShoppingItem("Forks", 6));

        list.add(new ShoppingLabel("Tools"));
        list.add(new ShoppingItem("Drill gun", 7));
        list.add(new ShoppingItem("Spanners", 7));

        return list;
    }
}
