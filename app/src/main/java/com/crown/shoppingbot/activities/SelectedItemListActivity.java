package com.crown.shoppingbot.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.crown.shoppingbot.R;
import com.crown.shoppingbot.SelectedListItemAdapter;
import com.crown.shoppingbot.models.ListItem;
import com.crown.shoppingbot.models.ShoppingItem;
import com.crown.shoppingbot.models.UtilViews;

import java.util.ArrayList;
import java.util.List;

public class SelectedItemListActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private SelectedListItemAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        Parcelable[] list = intent.getParcelableArrayExtra(MainActivity.PARCELABLE_TAG_SELECTED_ITEM);

        recyclerView = findViewById(R.id.rv_rvl_shopping_items);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new SelectedListItemAdapter(getSelectedItems(list));
        recyclerView.setAdapter(mAdapter);
    }

    private List<ListItem> getSelectedItems(Parcelable[] list) {
        List<ListItem> shoppingItems = new ArrayList<>();
        for (Parcelable parcelable : list) {
            shoppingItems.add((ShoppingItem) parcelable);
        }
        shoppingItems.add(new UtilViews(ListItem.TYPE_FOOTER));
        return shoppingItems;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
