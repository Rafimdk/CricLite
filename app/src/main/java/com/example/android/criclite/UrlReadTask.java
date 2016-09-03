package com.example.android.criclite;

import android.os.AsyncTask;
import android.util.Log;

/**
 * Created by RAFI on 28-03-2016.
 */
public class UrlReadTask extends AsyncTask<Object, Integer, String> {
    String cricApiReadData = null;

    public returnResponse delegate = null;

    @Override
    protected String doInBackground(Object... inputObj) {
        try {

            String cricApiURL = (String) inputObj[0];
            Http http = new Http();
            cricApiReadData = http.read(cricApiURL);
        } catch (Exception e) {
            Log.d("Google Place Read Task", e.toString());
        }
        return cricApiReadData;
    }

    @Override
    protected void onPostExecute(String result) {
        MatchDataOutput matchDataOutput = new MatchDataOutput();
        Object[] toPass = new Object[1];

        toPass[0] = result;
        matchDataOutput.execute(toPass);

//        delegate.processFinish(result);
    }
}
