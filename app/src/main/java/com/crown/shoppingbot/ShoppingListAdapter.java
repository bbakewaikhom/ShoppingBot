package com.crown.shoppingbot;

import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.crown.shoppingbot.models.ListItem;
import com.crown.shoppingbot.models.ShoppingItem;
import com.crown.shoppingbot.models.ShoppingLabel;
import com.crown.shoppingbot.models.ViewHolders;

import java.util.List;

public class ShoppingListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<ListItem> mDataset;
    private SparseArray<ShoppingItem> mSelectedItems = new SparseArray<>();

    public ShoppingListAdapter(List<ListItem> myDataset) {
        mDataset = myDataset;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView;
        if (viewType == ListItem.TYPE_LABEL) {
            rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.shopping_item_label_layout, parent, false);
            return new ViewHolders.LabelViewHolder(rootView);
        } else {
            rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.shopping_item, parent, false);
            return new ViewHolders.ShoppingItemViewHolder(rootView);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int type = getItemViewType(position);
        if (type == ListItem.TYPE_LABEL) {
            ShoppingLabel shoppingLabel = (ShoppingLabel) mDataset.get(position);
            ViewHolders.LabelViewHolder labelViewHolder = (ViewHolders.LabelViewHolder) holder;
            labelViewHolder.label.setText(shoppingLabel.getLable());
        } else if (type == ListItem.TYPE_ITEM) {
            ShoppingItem shoppingItem = (ShoppingItem) mDataset.get(position);
            ViewHolders.ShoppingItemViewHolder shoppingItemViewHolder = (ViewHolders.ShoppingItemViewHolder) holder;
            shoppingItemViewHolder.itemName.setText(shoppingItem.getName());
            if (mSelectedItems.get(position) != null) {
                shoppingItemViewHolder.selectedPinIV.setVisibility(View.VISIBLE);
            } else {
                shoppingItemViewHolder.selectedPinIV.setVisibility(View.GONE);
            }
        }

        holder.itemView.setOnClickListener(v -> onClickListItem(v, holder, position, type));
    }

    private void onClickListItem(View view, RecyclerView.ViewHolder holder, int position, int type) {
        if (type == ListItem.TYPE_LABEL)    return;
        ViewHolders.ShoppingItemViewHolder shoppingItemViewHolder = (ViewHolders.ShoppingItemViewHolder) holder;
        if (type == ListItem.TYPE_ITEM) {
            if (mSelectedItems.get(position) == null) {
                mSelectedItems.put(position, (ShoppingItem) mDataset.get(position));
                shoppingItemViewHolder.selectedPinIV.setVisibility(View.VISIBLE);
            } else {
                mSelectedItems.remove(position);
                shoppingItemViewHolder.selectedPinIV.setVisibility(View.GONE);
            }
        }
    }

    @Override
    public int getItemViewType(int position) {
        return mDataset.get(position).getType();
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public ShoppingItem[] getSelectedItems () {
        ShoppingItem[] shoppingItems = new ShoppingItem[mSelectedItems.size()];
        for (int i=0; i<mSelectedItems.size(); i++) {
            shoppingItems[i] = mSelectedItems.valueAt(i);
        }
        return shoppingItems;
    }
}
