package com.akshay.nammacanteen;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

/**
 * Created by admin on 02-Nov-17.
 */

public class SalesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mCtx;
    private List<Sales> salesList;
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_FOOTER = 1;
    private static final int TYPE_ITEM = 2;

    public SalesAdapter(Context mCtx, List<Sales> salesList) {
        this.mCtx = mCtx;
        this.salesList = salesList;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == TYPE_HEADER) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.header_sales_layout, parent, false);
            return new HeaderViewHolder(v);
        }
        else if(viewType==TYPE_ITEM) {
            View v = LayoutInflater.from(mCtx).inflate(R.layout.sales_layout, parent, false);
            return new SalesViewHolder(v);
        }
        else if(viewType==TYPE_FOOTER) {
            View v = LayoutInflater.from(mCtx).inflate(R.layout.footer_layout, parent, false);
            return new FooterViewHolder(v);
        }
        else
            return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof HeaderViewHolder) {
            HeaderViewHolder headerHolder = (HeaderViewHolder) holder;
            headerHolder.headerText.setText("List of Sales");
        }
        else if (holder instanceof FooterViewHolder) {
            FooterViewHolder footerHolder = (FooterViewHolder) holder;
            footerHolder.footerText.setText("Logout");
        }
        else if (holder instanceof SalesViewHolder) {
            SalesViewHolder saleViewHolder = (SalesViewHolder) holder;
            Sales sales = salesList.get(position);
            saleViewHolder.salesid.setText(sales.getSalesid());
            saleViewHolder.soldon.setText(String.valueOf(sales.getSoldon()));
            saleViewHolder.quantity.setText(String.valueOf(sales.getQuantity()));
            saleViewHolder.total.setText(String.valueOf(sales.getTotal()));
            saleViewHolder.itemname.setText(sales.getItemname());
        }
    }
    @Override
    public int getItemViewType(int position) {
        if(position == 0){
            return TYPE_HEADER;
        }
        else if (position == salesList.size()) {
            return TYPE_FOOTER;
        }
        else
            return TYPE_ITEM;
    }



    @Override
    public int getItemCount() {
        return salesList.size()+1;
    }


    class SalesViewHolder extends RecyclerView.ViewHolder {
        TextView salesid, itemname, quantity, total, soldon;

        public SalesViewHolder(final View saleView) {
            super(saleView);
            salesid = (TextView) saleView.findViewById(R.id.orderid);
            total = (TextView) saleView.findViewById(R.id.rtype);
            quantity = (TextView) saleView.findViewById(R.id.orderon);
            itemname = (TextView) saleView.findViewById(R.id.orderamt);
            soldon = (TextView) saleView.findViewById(R.id.phno);


        }
    }
    private class HeaderViewHolder extends RecyclerView.ViewHolder {
        TextView headerText;

        public HeaderViewHolder(View view) {
            super(view);
            headerText=(TextView)view.findViewById(R.id.header_text);
        }
    }

    private class FooterViewHolder extends RecyclerView.ViewHolder {
        Button footerText;

        public FooterViewHolder(View view) {
            super(view);
            footerText=(Button)view.findViewById(R.id.footer_text);
            footerText.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(mCtx);
                    alertDialog.setTitle("Status");
                    alertDialog.setMessage("Logout Successful");
                    alertDialog.show();
                    Intent i= new Intent(mCtx,homeActivity.class);
                    mCtx.startActivity(i);
                }
            });
        }
    }
}

