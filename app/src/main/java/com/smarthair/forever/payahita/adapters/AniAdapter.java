package com.smarthair.forever.payahita.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.smarthair.forever.payahita.R;
import com.smarthair.forever.payahita.models.AniModel;


import java.util.List;

/**
 *
 */

public class AniAdapter extends RecyclerView.Adapter<AniAdapter.ViewHolder> {

    private List<AniModel> modelList;
    private AniAdapter.OnItemClickListener onItemClickListener;
    public AniAdapter(List<AniModel> modelList) {
        this.modelList = modelList;
    }

    @Override
    public AniAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_ani,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AniAdapter.ViewHolder holder, int position) {
        AniModel model = modelList.get(position);
        holder.name.setText(model.getName());
        holder.location.setText(model.getLocation());
        holder.phone.setText(model.getPhone());

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
        private TextView location;
        private TextView phone;

        public ViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.tv_ani_name);
            location = (TextView) itemView.findViewById(R.id.tv_ani_location);
            phone = (TextView) itemView.findViewById(R.id.tv_ani_ph);

            itemView.setOnClickListener(this);

    }

    public void onClick(View v) {
        onItemClickListener.onItemClick(v,getAdapterPosition());

    }
    }


}
