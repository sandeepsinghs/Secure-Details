package com.ss.securedetails.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ss.securedetails.modal.ItemCategory;

import java.util.List;

public class PasswordCategoryAdapter extends RecyclerView.Adapter<PasswordCategoryAdapter.ViewHolder> {

    private Context context;
    private List<ItemCategory> categoryList;

    public PasswordCategoryAdapter(Context context, List<ItemCategory> categoryList) {
        this.context = context;
        this.categoryList = categoryList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
