package com.smarthair.forever.payahita.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.smarthair.forever.payahita.R;
import com.smarthair.forever.payahita.models.SchoolModel;

import java.util.List;

/**
 *
 */

public class SchoolAdapter extends RecyclerView.Adapter<SchoolAdapter.ViewHolder> {

    private List<SchoolModel> modelList;
    private OnItemClickListener onItemClickListener;

    public SchoolAdapter(List<SchoolModel> modelList) {
        this.modelList = modelList;
    }

    @Override
    public SchoolAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_school,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SchoolAdapter.ViewHolder holder, int position) {
        SchoolModel model = modelList.get(position);
        holder.name.setText(model.getName());
        holder.location.setText(model.getLocation());
        holder.phone.setText(model.getPhone());
        holder.founder.setText(model.getFounder());
        holder.description.setText(model.getDescription());

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
        private TextView founder;
        private TextView description;


        public ViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.tv_school_name);
            location = (TextView) itemView.findViewById(R.id.tv_school_location);
            phone = (TextView) itemView.findViewById(R.id.tv_school_phone);
            founder = (TextView) itemView.findViewById(R.id.tv_founder);
            description = (TextView) itemView.findViewById(R.id.tv_school_description);

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
                onItemClickListener.onItemClick(v,getAdapterPosition());

        }
    }



}
