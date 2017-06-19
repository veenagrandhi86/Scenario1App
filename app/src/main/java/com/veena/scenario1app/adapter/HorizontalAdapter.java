package com.veena.scenario1app.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.veena.scenario1app.HorizontalAdapterInterface;
import com.veena.scenario1app.MainActivity;
import com.veena.scenario1app.R;

import java.util.List;

import layout.RecyclerViewFragment;

/**
 * Created by veena on 17/06/17.
 */

public class HorizontalAdapter extends RecyclerView.Adapter<HorizontalAdapter.MyViewHolder> {

    public static final String TAG = "HorizontalAdapter";

    private List<String> horizontalList;
    private HorizontalAdapterInterface mContext;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView txtView;

        public MyViewHolder(View view) {
            super(view);
            txtView = (TextView) view.findViewById(R.id.txtView);
        }
    }

    public HorizontalAdapter(Context context, List<String> horizontalList) {
        this.horizontalList = horizontalList;
        this.mContext = (HorizontalAdapterInterface) context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.horizontal_item_view, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.txtView.setText(horizontalList.get(position));

        holder.txtView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, holder.txtView.getText().toString());
                mContext.viewItemClicked(holder.txtView.getText().toString());
            }
        });
    }

    @Override
    public int getItemCount() {
        return horizontalList.size();
    }
}
