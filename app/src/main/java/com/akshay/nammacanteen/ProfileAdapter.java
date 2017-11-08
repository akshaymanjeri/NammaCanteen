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
 * Created by admin on 01-Nov-17.
 */

public class ProfileAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mCtx;
    private List<Profile> profileList;
    private static final int TYPE_FOOTER = 1;
    private static final int TYPE_PROFILE = 2;
    public ProfileAdapter(Context mCtx, List<Profile> profileList){
        this.mCtx=mCtx;
        this.profileList=profileList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType==TYPE_PROFILE) {
            View v = LayoutInflater.from(mCtx).inflate(R.layout.profile_layout, parent, false);
            return new ProfileViewHolder(v);
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
        if (holder instanceof FooterViewHolder) {
            FooterViewHolder footerHolder = (FooterViewHolder) holder;
            footerHolder.footerText.setText("Logout");
        }
        else if (holder instanceof ProfileViewHolder) {
            ProfileViewHolder profileViewHolder = (ProfileViewHolder) holder;
            Profile profile = profileList.get(position);
            profileViewHolder.Username.setText(profile.getUsername());
            profileViewHolder.hno.setText(String.valueOf(profile.getHno()));
            profileViewHolder.street.setText(profile.getStreet());
            profileViewHolder.city.setText(profile.getCity());
        }

    }
    @Override
    public int getItemViewType(int position) {
        if (position == profileList.size()) {
            return TYPE_FOOTER;
        }
        else
            return TYPE_PROFILE;
    }

    @Override
    public int getItemCount() {
        return profileList.size()+1;
    }

    public class ProfileViewHolder extends RecyclerView.ViewHolder {
        TextView Username,street,city,hno;

        public ProfileViewHolder(View profileView) {
            super(profileView);
            Username=(TextView)profileView.findViewById(R.id.uname);
            street=(TextView)profileView.findViewById(R.id.street);
            city=(TextView)profileView.findViewById(R.id.city);
            hno=(TextView)profileView.findViewById(R.id.hno);
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
                    String type="ULogout";
                    bg7(type);
                }
            });
        }
    }
    private void bg7(String type) {
        BackgroundWorker2 mtask=new BackgroundWorker2(mCtx);
        mtask.execute(type);
    }
}
