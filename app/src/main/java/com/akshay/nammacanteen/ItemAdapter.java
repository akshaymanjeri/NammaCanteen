package com.akshay.nammacanteen;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by admin on 31-Oct-17.
 */

public class ItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mCtx;
    private List<Item> itemList;
    private Item item;
    private int totalPrice;
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_FOOTER = 1;
    private static final int TYPE_ITEM = 2;

    public ItemAdapter(Context mCtx, List<Item> itemList) {
        this.mCtx = mCtx;
        this.itemList = itemList;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == TYPE_HEADER) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.header_layout, parent, false);
            return new HeaderViewHolder(v);
        }
        else if(viewType==TYPE_ITEM) {
            View v = LayoutInflater.from(mCtx).inflate(R.layout.order_layout, parent, false);
            return new ItemViewHolder(v);
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
            headerHolder.headerText.setText("Make Your Order");
        }
        else if (holder instanceof FooterViewHolder) {
            FooterViewHolder footerHolder = (FooterViewHolder) holder;
            footerHolder.footerText.setText("Submit");
        }
        else if (holder instanceof ItemViewHolder) {
            ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
            Item item = itemList.get(position);
            itemViewHolder.title.setText(item.getItemname());
            itemViewHolder.price.setText(String.valueOf(item.getPrice()));
            itemViewHolder.quantity.setText(String.valueOf(item.getCount()));
        }
    }

    private int grandTotal(List<Item> itemList) {
        int tP = 0;
        for(int i = 0 ; i < itemList.size(); i++) {
            tP += ((itemList.get(i).getPrice())*(itemList.get(i).getCount()));
        }

        return tP;

    }

    @Override
    public int getItemViewType(int position) {
        if(position == 0){
            return TYPE_HEADER;
        }
        else if (position == itemList.size()) {
            return TYPE_FOOTER;
        }
        else
            return TYPE_ITEM;
    }

    @Override
    public int getItemCount() {return itemList.size()+1;}



    class ItemViewHolder extends RecyclerView.ViewHolder {
        private int mcounter;
        TextView title,quantity,price;
        Button add,sub;
        public ItemViewHolder(final View itemView) {
            super(itemView);
            title= (TextView) itemView.findViewById(R.id.orderid);
            quantity= (TextView) itemView.findViewById(R.id.item_quantity);
            price= (TextView) itemView.findViewById(R.id.phno);
            add= (Button) itemView.findViewById(R.id.add_button);
            sub= (Button) itemView.findViewById(R.id.sub_button);

            add.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    item=itemList.get(getAdapterPosition());
                    mcounter=item.getCount();
                    mcounter++;
                    item.setCount(mcounter);
                    itemList.set(getAdapterPosition(),item);
                    notifyItemChanged(getAdapterPosition());
                }
            });
            sub.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    item=itemList.get(getAdapterPosition());
                    mcounter=item.getCount();
                    if(mcounter>0) {
                        mcounter--;
                        item.setCount(mcounter);
                        itemList.set(getAdapterPosition(), item);
                        notifyItemChanged(getAdapterPosition());
                    }
                }
            });

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
            footerText = (Button) view.findViewById(R.id.footer_text);
            footerText.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    String type="itemSubmit";
                    totalPrice=grandTotal(itemList);
                    JSONArray itemarray = new JSONArray();
                    for(int i=0;i<itemList.size();i++) {
                        item = itemList.get(i);
                        if (item.getCount() > 0) {
                            String name = item.getItemname();
                            int quantity=item.getCount();
                            Double cost= (quantity*(item.getPrice()));
                            String qn=String.valueOf(quantity);
                            String cs=String.valueOf(cost);
                            JSONObject itemobj=new JSONObject();
                            try {
                                itemobj.put("itemname",name);
                                itemobj.put("quantity",qn);
                                itemobj.put("cost",cs);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            itemarray.put(itemobj);
                        }
                    }
                    String datatosend = itemarray.toString();
                    String tt= String.valueOf(totalPrice);
                    bg6(type,tt,datatosend);
                }
            });
        }
    }
    private void bg6(String type, String totalPrice, String data) {
        BackgroundWorker2 mtask=new BackgroundWorker2(mCtx);
        mtask.execute(type,totalPrice,data);
    }
}
