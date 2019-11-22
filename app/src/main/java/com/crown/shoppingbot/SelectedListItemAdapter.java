package com.crown.shoppingbot;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.crown.shoppingbot.activities.ControlPanelActivity;
import com.crown.shoppingbot.models.ListItem;
import com.crown.shoppingbot.models.ShoppingItem;
import com.crown.shoppingbot.models.ShoppingLabel;
import com.crown.shoppingbot.models.ViewHolders;

import java.util.List;

public class SelectedListItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener {
    private List<ListItem> mDataset;

    public SelectedListItemAdapter(List<ListItem> myDataset) {
        mDataset = myDataset;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView;
        if (viewType == ListItem.TYPE_LABEL) {
            rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.shopping_item_label_layout, parent, false);
            return new ViewHolders.LabelViewHolder(rootView);
        } else if (viewType == ListItem.TYPE_ITEM) {
            rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.shopping_item, parent, false);
            return new ViewHolders.ShoppingItemViewHolder(rootView);
        } else {
            rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.selected_item_list_footer, parent, false);
            return new ViewHolders.FooterViewHolder(rootView);
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
            shoppingItemViewHolder.selectedPinIV.setVisibility(View.VISIBLE);
        } else {
            ViewHolders.FooterViewHolder footerViewHolder = (ViewHolders.FooterViewHolder) holder;
            footerViewHolder.navigateButton.setOnClickListener(this);
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

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btn_silf_navigate) {
            Intent intent = new Intent(v.getContext(), ControlPanelActivity.class);
            v.getContext().startActivity(intent);
        }
    }
}