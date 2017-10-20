package com.viviwidy.newasyncinternet;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Vivi Widyawati on 10/13/2017.
 */

public class downloadImageTask extends AsyncTask<String,Void,Bitmap> {

    @Override
    protected Bitmap doInBackground(String... strings) {

        String s1 = strings[0];
        InputStream in;


        try {
            URL myURL = new URL(s1);
            HttpURLConnection myConn = (HttpURLConnection) myURL.openConnection();
            myConn.setReadTimeout(10000);
            myConn.setConnectTimeout(20000);
            myConn.setRequestMethod("GET");
            myConn.connect();

            in = myConn.getInputStream();

            Bitmap myMap = BitmapFactory.decodeStream(in);

            return myMap;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        MainActivity.myImage.setImageBitmap(bitmap);
    }
}

