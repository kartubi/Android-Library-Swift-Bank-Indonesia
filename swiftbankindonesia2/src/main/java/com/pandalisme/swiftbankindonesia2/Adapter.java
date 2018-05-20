package com.pandalisme.swiftbankindonesia2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by AHMAD KARTUBI on 21/05/2018.`
 * PANDALISME.COM || kartubi1@gmail.com
 */

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{

    List<Bank> banks;
    Context mContext;
    Banklist mBanklist;

    public Adapter(List<Bank> banksList, Context context, Banklist bankList){
        this.banks = banksList;
        this.mContext = context;
        this.mBanklist = bankList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_bank, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Bank bank = banks.get(position);
        holder.tvName.setText(bank.getmName());
        holder.content.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBanklist.setDataReturn(bank.getmName(),bank.getmCode());
            }
        });
    }

    @Override
    public int getItemCount() {
        return banks.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvName;
        public RelativeLayout content;

        public ViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            content = itemView.findViewById(R.id.content);
        }
    }
}
