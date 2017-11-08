package com.akshay.nammacanteen;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by admin on 05-Nov-17.
 */

public class ReviewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mCtx;
    private List<Review> reviewList;
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;

    public ReviewAdapter(Context mCtx, List<Review> reviewList) {
        this.mCtx = mCtx;
        this.reviewList = reviewList;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == TYPE_HEADER) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.header_review_layout, parent, false);
            return new HeaderViewHolder(v);
        }
        else if(viewType==TYPE_ITEM) {
            View v = LayoutInflater.from(mCtx).inflate(R.layout.review_layout, parent, false);
            return new ReviewViewHolder(v);
        }
        else
            return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof HeaderViewHolder) {
            HeaderViewHolder headerHolder = (HeaderViewHolder) holder;
            headerHolder.headerText.setText("List of User Reviews");
        }
        else if (holder instanceof ReviewViewHolder) {
            ReviewViewHolder reviewViewHolder=(ReviewViewHolder) holder;
            Review review = reviewList.get(position);
            reviewViewHolder.review.setText(review.getReview());
            reviewViewHolder.rtype.setText(review.getRetype());
            reviewViewHolder.phno.setText(String.valueOf(review.getPhno()));
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
        return reviewList.size();
    }


    class ReviewViewHolder extends RecyclerView.ViewHolder {
        TextView review,rtype,phno;

        public ReviewViewHolder(final View reviewView) {
            super(reviewView);
            review = (TextView) reviewView.findViewById(R.id.review);
            rtype = (TextView) reviewView.findViewById(R.id.rtype);
            phno = (TextView) reviewView.findViewById(R.id.phno);
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
