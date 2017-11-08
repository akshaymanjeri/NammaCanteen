package com.akshay.nammacanteen;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;


//Task to be performed in the background
public class BackgroundWorker2 extends AsyncTask<String,Void,String> {
    Context mctx;
    updateFragment container;
    userreviewFragment ctx;
    AlertDialog.Builder alertDialog;
    BackgroundWorker2(Context ctx){this.mctx=ctx;}
    BackgroundWorker2(userreviewFragment ctx){
        this.ctx=ctx;
    }
    BackgroundWorker2(updateFragment ctx){
        this.container= ctx;
    }
    String totalprice;

    @Override
    protected String doInBackground(String... params) {
        String type = params[0];
        String insert_url = "https://nammacanteen.000webhostapp.com/php_codes/canteen_insert.php";
        String insert2_url = "https://nammacanteen.000webhostapp.com/php_codes/canteen_insert2.php";
        String delete_url = "https://nammacanteen.000webhostapp.com/php_codes/canteen_delete.php";
        String delete2_url = "https://nammacanteen.000webhostapp.com/php_codes/canteen_delete2.php";
        String review_url= "https://nammacanteen.000webhostapp.com/php_codes/canteen_ureview.php";
        String order_url= "https://nammacanteen.000webhostapp.com/php_codes/canteen_orderAmt.php";
        String logout_url= "https://nammacanteen.000webhostapp.com/php_codes/canteen_uLogout.php";

        //Posting Itemid, Itemname, Price and Cid
        if (type.equals("add2")) {
            try {
                String itemid = params[1];
                String itemname = params[2];
                String price = params[3];
                String cid = params[4];
                URL url = new URL(insert_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("itemid","UTF-8")+"="+URLEncoder.encode(itemid,"UTF-8")+"&"
                        +URLEncoder.encode("itemname","UTF-8")+"="+URLEncoder.encode(itemname,"UTF-8")+"&"
                        +URLEncoder.encode("price","UTF-8")+"="+URLEncoder.encode(price,"UTF-8")+"&"
                        +URLEncoder.encode("cid","UTF-8")+"="+URLEncoder.encode(cid,"UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //Posting Review rating and Review
        else if(type.equals("review")) {
            try {
                String reviewtype = params[1];
                String review=params[2];
                URL url = new URL(review_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("review","UTF-8")+"="+URLEncoder.encode(review,"UTF-8")+"&"
                        +URLEncoder.encode("retype","UTF-8")+"="+URLEncoder.encode(reviewtype,"UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String result="";
                String line="";
                while((line = bufferedReader.readLine())!= null) {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //When User Logs out
        else if(type.equals("ULogout")) {
            try {
                URL url = new URL(logout_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String result="";
                String line="";
                while((line = bufferedReader.readLine())!= null) {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //Posting Total price and List of Ordered items
        else if(type.equals("itemSubmit")) {
            try {
                totalprice = params[1];
                String data =params[2];
                URL url = new URL(order_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("total","UTF-8")+"="+URLEncoder.encode(totalprice,"UTF-8")+"&"
                        +URLEncoder.encode("json","UTF-8")+"="+URLEncoder.encode(data,"UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String result="";
                String line="";
                while((line = bufferedReader.readLine())!= null) {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //Posting Cid and Cname
        else if (type.equals("add1")) {
            try {
                String cid = params[1];
                String cname = params[2];
                URL url = new URL(insert2_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("cid","UTF-8")+"="+URLEncoder.encode(cid,"UTF-8")+"&"
                        +URLEncoder.encode("cname","UTF-8")+"="+URLEncoder.encode(cname,"UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //Posting Cid
        else if (type.equals("delete1")) {
            try {
                String cid = params[1];
                URL url = new URL(delete_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("cid","UTF-8")+"="+URLEncoder.encode(cid,"UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //Posting Itemid
        else if (type.equals("delete2")) {
            try {
                String itemid = params[1];
                URL url = new URL(delete2_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("itemid","UTF-8")+"="+URLEncoder.encode(itemid,"UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    protected void onPostExecute(String result) {
        if(result.equals("Insert Successful")) {

            //Alert when Insert is successful
            alertDialog = new AlertDialog.Builder(container.getActivity());
            alertDialog.setTitle("Insert Status");
            alertDialog.setMessage(result);
            alertDialog.show();
        }
        else if(result.equals("Review Posted")){

            //Alert when Review is posted successfully
            AlertDialog.Builder builder =new AlertDialog.Builder(ctx.getActivity());
            builder.setTitle("Review Status");
            builder.setMessage("Review submitted successfully. Thank you");
            builder.setNegativeButton("close", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }
        else if(result.equals("Order Submitted")){

            //Alert when Order is submitted
            AlertDialog.Builder builder =new AlertDialog.Builder(mctx);
            builder.setTitle("Order status");
            builder.setMessage("Order Placed\nYour order amount is "+totalprice+"\nThanks for Ordering\nWe hope to see you again");
            builder.setPositiveButton("Next", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent i =new Intent(mctx,mainPage.class);
                    mctx.startActivity(i);
                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }
        else if(result.equals("Delete Successful")) {

            //Alert when Delete is successful
            alertDialog = new AlertDialog.Builder(container.getActivity());
            alertDialog.setTitle("Delete Status");
            alertDialog.setMessage(result);
            alertDialog.show();
        }
        else if(result.equals("Logout Successful")) {

            //Alert when Logged out
            alertDialog = new AlertDialog.Builder(mctx);
            alertDialog.setTitle("Status");
            alertDialog.setMessage(result);
            alertDialog.show();
            Intent i= new Intent(mctx,homeActivity.class);
            mctx.startActivity(i);
        }
    }
    protected void onProgressUpdate(Void... values)
    {
        super.onProgressUpdate(values);
    }

    protected void onPreExecute(){
    }
}


