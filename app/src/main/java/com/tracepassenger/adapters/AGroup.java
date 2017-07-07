package com.tracepassenger.adapters;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tracepassenger.app.R;
import com.tracepassenger.app.ViewPassengersGroup;
import com.tracepassenger.domain.Journey;
import com.tracepassenger.domain.JourneyGroup;
import com.tracepassenger.fragments.FGroup;


import java.util.List;

public class AGroup extends RecyclerView.Adapter<AGroup.DataObjectHolder> {

    private List<JourneyGroup> dataSet;
    private Context mContext;
    public static boolean itemsSelected = false;
    private static String SELECTED_COLOR = "#59c8c8c8";

    public static class DataObjectHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {

        TextView txtIdentifier;
        TextView txtGroupName;
        TextView txtCoordinatorName;
        TextView txtTotalPassengers;
        CardView cardView;

        public DataObjectHolder(View itemView){
            super(itemView);
            txtIdentifier = (TextView) itemView.findViewById(R.id.txtIdentifier);
            txtGroupName = (TextView) itemView.findViewById(R.id.txtGroupName);
            txtCoordinatorName = (TextView) itemView.findViewById(R.id.txtCoordinatorName);
            txtTotalPassengers = (TextView) itemView.findViewById(R.id.txtTotalPassengers);
            cardView = (CardView) itemView.findViewById(R.id.card_view);
        }

        @Override
        public void onClick(View v) {

        }
    }

    public AGroup(List<JourneyGroup> dataList, Context context)
    {
        this.dataSet = dataList;
        this.mContext = context;
    }

    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cview_group, parent, false);
        DataObjectHolder dataObjectHolder = new DataObjectHolder(view);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(final DataObjectHolder holder, int position) {
        final JourneyGroup group = dataSet.get(position);
        holder.txtIdentifier.setText(group.getIdentifier());
        holder.txtGroupName.setText(group.getGroupName());
        holder.txtCoordinatorName.setText(group.getCoordinatorName());
        holder.txtTotalPassengers.setText("Total: X");
        holder.cardView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if(!itemsSelected)
                {
                    itemsSelected = true;
                    group.setSelected(!group.isSelected());
                    FGroup.selectedIds.add(group.getId());
                    holder.cardView.setForeground(new ColorDrawable(Color.parseColor(SELECTED_COLOR)));
                    FGroup.switchMenuItems();
                }
                return true;
            }

        });
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(itemsSelected)
                {
                    group.setSelected(!group.isSelected());
                    holder.cardView.setForeground(group.isSelected()? new ColorDrawable(Color.parseColor(SELECTED_COLOR)):null);
                    if(group.isSelected())
                    {
                        FGroup.selectedIds.add(group.getId());
                    }
                    else {
                        FGroup.selectedIds.remove(group.getId());
                    }
                    itemsSelected = FGroup.selectedIds.size() == 0 ? false:true;
                    FGroup.switchMenuItems();
                }
                else
                {
                    Intent intent = new Intent(mContext, ViewPassengersGroup.class);
                    intent.putExtra(ViewPassengersGroup.EXTRA_INTENT_ID,group.getId()+"");
                    intent.putExtra(ViewPassengersGroup.EXTRA_INTENT_NAME,group.getGroupName());
                    mContext.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

}
