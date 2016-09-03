package com.example.android.criclite;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;

/**
 * Created by RAFI on 28-03-2016.
 */
public class MatchDataOutput extends AsyncTask<Object, Integer, List<HashMap<String, String>>> {

    JSONObject matchDataJson;
//    GoogleMap googleMap;

    @Override
    protected List<HashMap<String, String>> doInBackground(Object... inputObj) {

        List<HashMap<String, String>> matchDataList = null;
        JsonToList placeJsonParser = new JsonToList();

        try {
//            googleMap = (GoogleMap) inputObj[0];
            matchDataJson = new JSONObject((String) inputObj[0]);
            matchDataList = placeJsonParser.parse(matchDataJson);
        } catch (Exception e) {
            Log.d("Exception", e.toString());
        }
        return matchDataList;
    }

    @Override
    protected void onPostExecute(List<HashMap<String, String>> list) {
//        googleMap.clear();
        for (int i = 0; i < list.size(); i++) {
//            MarkerOptions markerOptions = new MarkerOptions();
            HashMap<String, String> matchData = list.get(i);
//            double lat = Double.parseDouble(matchData.get("lat"));
//            double lng = Double.parseDouble(googlePlace.get("lng"));
            String matchId = matchData.get("match_id");
            String t1 = matchData.get("t1");
            String t2 = matchData.get("t2");
//            LatLng t2 = new LatLng(lat, lng);
//            markerOptions.position(latLng);
//            markerOptions.title(placeName);
//            markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.places));
//            markerOptions.title(placeName + " : " + vicinity);
//            markerOptions.snippet(placeId);

//            googleMap.addMarker(markerOptions).setTag(placeId);
        }
    }
}
