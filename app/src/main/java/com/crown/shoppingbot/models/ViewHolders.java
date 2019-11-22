package com.crown.shoppingbot.models;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.crown.shoppingbot.R;

public class ViewHolders {
    public static class LabelViewHolder extends RecyclerView.ViewHolder {
        public TextView label;

        public LabelViewHolder(View v) {
            super(v);
            label = v.findViewById(R.id.tv_sill_label);
        }
    }

    public static class ShoppingItemViewHolder extends RecyclerView.ViewHolder {
        public TextView itemName;
        public ImageView selectedPinIV;

        public ShoppingItemViewHolder(View v) {
            super(v);
            itemName = v.findViewById(R.id.tv_si_name);
            selectedPinIV = v.findViewById(R.id.iv_si_item_selected_pin);
        }
    }

    public static class FooterViewHolder extends RecyclerView.ViewHolder {
        public Button navigateButton;

        public FooterViewHolder(@NonNull View itemView) {
            super(itemView);
            navigateButton = itemView.findViewById(R.id.btn_silf_navigate);
        }
    }
}
