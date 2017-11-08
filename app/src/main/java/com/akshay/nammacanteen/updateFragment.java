package com.akshay.nammacanteen;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnClickListener;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link updateFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link updateFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class updateFragment extends Fragment {
    Button add1,add2,delete1,delete2;
    EditText cid1,cid2,cid3,itemid1,itemid2,price,itemname,cname;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public updateFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment updateFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static updateFragment newInstance(String param1, String param2) {
        updateFragment fragment = new updateFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_update, container, false);
        cid1= (EditText) v.findViewById(R.id.cid_1);
        cid2= (EditText) v.findViewById(R.id.cid_2);
        cid3= (EditText) v.findViewById(R.id.cid_3);
        cname=(EditText)v.findViewById(R.id.cname_1);
        itemid1= (EditText) v.findViewById(R.id.itemid_1);
        itemid2= (EditText) v.findViewById(R.id.itemid_2);
        price =(EditText) v.findViewById(R.id.price);
        itemname=(EditText) v.findViewById(R.id.itemname);
        add1=(Button)v.findViewById(R.id.add_1);
        add2=(Button)v.findViewById(R.id.add_2);
        delete1=(Button)v.findViewById(R.id.delete_1);
        delete2=(Button)v.findViewById(R.id.delete_2);
        add2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                String Cid1 = cid2.getText().toString();
                String Itemid1 = itemid1.getText().toString();
                String Itemname = itemname.getText().toString();
                String Price = price.getText().toString();
                String type = "add2";
                bg(type,Itemid1,Itemname,Price,Cid1);
            }
        });
        add1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                String Cid1 = cid1.getText().toString();
                String Cname=cname.getText().toString();
                String type = "add1";
                bg1(type,Cid1,Cname);
            }
        });
        delete1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                String Cid1 = cid3.getText().toString();
                String type = "delete1";
                bg2(type,Cid1);
            }
        });
        delete2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                String itemid = itemid2.getText().toString();
                String type = "delete2";
                bg3(type,itemid);
            }
        });
        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    protected void bg(String type, String a, String b, String c, String d){

        BackgroundWorker2 mtask=new BackgroundWorker2(this);
        mtask.execute(type,a,b,c,d);


    }
    protected void bg1(String type, String a, String b){

        BackgroundWorker2 mtask1=new BackgroundWorker2(this);
        mtask1.execute(type,a,b);


    }
    protected void bg2(String type, String a){

        BackgroundWorker2 mtask1=new BackgroundWorker2(this);
        mtask1.execute(type,a);


    }
    protected void bg3(String type, String a){

        BackgroundWorker2 mtask1=new BackgroundWorker2(this);
        mtask1.execute(type,a);


    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        }
    }


    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
