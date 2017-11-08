package com.akshay.nammacanteen;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by admin on 06-Nov-17.
 */

public class OrderAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mCtx;
    private List<Order> orderList;
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;

    public OrderAdapter(Context mCtx, List<Order> orderList) {
        this.mCtx = mCtx;
        this.orderList = orderList;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == TYPE_HEADER) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.header_recent_layout, parent, false);
            return new HeaderViewHolder(v);
        }
        else if(viewType==TYPE_ITEM) {
            View v = LayoutInflater.from(mCtx).inflate(R.layout.order1_layout, parent, false);
            return new OrderViewHolder(v);
        }
        else
            return null;
    }
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof HeaderViewHolder) {
            HeaderViewHolder headerHolder = (HeaderViewHolder) holder;
            headerHolder.headerText.setText("List of your Previous Orders");
        }
        else if (holder instanceof OrderViewHolder) {
            OrderViewHolder orderViewHolder=(OrderViewHolder) holder;
            Order order = orderList.get(position);
            orderViewHolder.orderid.setText(order.getOrderid());
            orderViewHolder.orderon.setText(order.getOrderon());
            orderViewHolder.phoneno.setText(order.getPhoneno());
            orderViewHolder.OrderAmt.setText(order.getOrderAmt());
        }
    }
    @Override
    public int getItemViewType(int position) {
        if(position == 0){
            return TYPE_HEADER;
        }
        else
            return TYPE_ITEM;
    }
    @Override
    public int getItemCount() {
        return orderList.size();
    }

    class OrderViewHolder extends RecyclerView.ViewHolder {
        TextView orderid,orderon,phoneno,OrderAmt;

        public OrderViewHolder(final View reviewView) {
            super(reviewView);
            orderid = (TextView) reviewView.findViewById(R.id.orderid);
            phoneno = (TextView) reviewView.findViewById(R.id.phno);
            orderon = (TextView) reviewView.findViewById(R.id.orderon);
            OrderAmt = (TextView) reviewView.findViewById(R.id.orderamt);
        }
    }
    private class HeaderViewHolder extends RecyclerView.ViewHolder {
        TextView headerText;

        public HeaderViewHolder(View view) {
            super(view);
            headerText=(TextView)view.findViewById(R.id.header_text);
        }
    }
}
