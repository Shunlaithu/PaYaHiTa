package com.smarthair.forever.payahita.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.smarthair.forever.payahita.R;
import com.smarthair.forever.payahita.models.OrganModel;
import com.smarthair.forever.payahita.models.PhoneModel;
import com.smarthair.forever.payahita.models.SchoolModel;

import java.util.List;

/**
 *
 */

public class OrganAdapter extends RecyclerView.Adapter<OrganAdapter.ViewHolder> {

    private List<OrganModel> modelList;
    private OnItemClickListener onItemClickListener;

    public OrganAdapter(List<OrganModel> modelList) {
        this.modelList = modelList;
    }

    @Override
    public OrganAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_organ,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(OrganAdapter.ViewHolder holder, int position) {
        OrganModel model = modelList.get(position);
        holder.name.setText(model.getName());

    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public interface OnItemClickListener{
        void onItemClick(View view,int postition);
    }

    public void setOnItemClickListener(final OnItemClickListener itemClickListener){
        this.onItemClickListener = itemClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView name;

        public ViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.tv_organ_name);

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            onItemClickListener.onItemClick(v,getAdapterPosition());

        }
    }



}
