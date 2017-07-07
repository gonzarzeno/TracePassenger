package com.tracepassenger.adapters;

import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tracepassenger.app.R;
import com.tracepassenger.domain.Passenger;
import com.tracepassenger.fragments.FPassenger;

import java.security.acl.Group;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gonzalo on 4/7/2017.
 */

public class APassenger extends RecyclerView.Adapter<APassenger.DataObjectHolder> {

    private List<Passenger> dataSet;


    public static class DataObjectHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {

        TextView txtName;
        TextView txtSurname;
        CardView cardView;
        public DataObjectHolder(final View itemView){
            super(itemView);
            txtName = (TextView) itemView.findViewById(R.id.txtName);
            txtSurname = (TextView) itemView.findViewById(R.id.txtSurname);
            cardView = (CardView) itemView.findViewById(R.id.card_view);
        }

        @Override
        public void onClick(View v) {

        }
    }

    public APassenger(List<Passenger> dataList)
    {
        this.dataSet = dataList;
    }

    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cview_passenger, parent, false);
        DataObjectHolder dataObjectHolder = new DataObjectHolder(view);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(DataObjectHolder holder, int position) {
        final Passenger passenger = dataSet.get(position);
        holder.txtName.setText(passenger.getName());
        holder.txtSurname.setText(passenger.getSurname());

    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }


}
