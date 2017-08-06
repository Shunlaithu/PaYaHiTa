package com.smarthair.forever.payahita.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.smarthair.forever.payahita.R;
import com.smarthair.forever.payahita.models.PhoneModel;
import com.smarthair.forever.payahita.models.SchoolModel;

import java.util.List;

/**
 *
 */

public class PhoneAdapter extends RecyclerView.Adapter<PhoneAdapter.ViewHolder> {

    private List<PhoneModel> modelList;
    private OnItemClickListener onItemClickListener;

    public PhoneAdapter(List<PhoneModel> modelList) {
        this.modelList = modelList;
    }

    @Override
    public PhoneAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_ph,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PhoneAdapter.ViewHolder holder, int position) {
        PhoneModel model = modelList.get(position);
        holder.name.setText(model.getName());
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
        private TextView phone;



        public ViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.tv_ph_name);
            phone = (TextView) itemView.findViewById(R.id.tv_ph_ph);


            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            onItemClickListener.onItemClick(v,getAdapterPosition());

        }
    }



}
