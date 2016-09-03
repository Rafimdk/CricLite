package com.example.android.criclite;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by RAFI on 28-03-2016.
 */
public class JsonToList {

    public List<HashMap<String, String>> parse(JSONObject jsonObject) {
        JSONArray jsonArray = null;
        try {
            jsonArray = jsonObject.getJSONArray("");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return getMatchData(jsonArray);
    }

    private List<HashMap<String, String>> getMatchData(JSONArray jsonArray) {
        int matchCount = jsonArray.length();
        List<HashMap<String, String>> matchList = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> singleMatchData = null;

        for (int i = 0; i < matchCount; i++) {
            try {
                singleMatchData = getSingleMatch((JSONObject) jsonArray.get(i));
                matchList.add(singleMatchData);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return matchList;
    }

    private HashMap<String, String> getSingleMatch(JSONObject matchDataJson) {
        HashMap<String, String> singleMatch = new HashMap<String, String>();
        String matchId = "";
        String t1 = "";
        String t2 = "";
//        String longitude = "";
//        String reference = "";
//        String placeId = "";
        try {
            if (!matchDataJson.isNull("id")) {
                matchId = matchDataJson.getString("id");
            }
            if (!matchDataJson.isNull("vicinity")) {
                t1 = matchDataJson.getString("t1");
            }
            if (!matchDataJson.isNull("t2")) {
                t2 = matchDataJson.getString("t2");
            }
//            latitude = googlePlaceJson.getJSONObject("geometry").getJSONObject("location").getString("lat");
//            longitude = googlePlaceJson.getJSONObject("geometry").getJSONObject("location").getString("lng");
//            reference = googlePlaceJson.getString("reference");
//            placeId = googlePlaceJson.getString("place_id");
            singleMatch.put("match_id", matchId);
            singleMatch.put("t1", t1);
            singleMatch.put("t2", t2);
//            googlePlaceMap.put("lng", longitude);
//            googlePlaceMap.put("reference", reference);
//            googlePlaceMap.put("place_id",placeId);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return singleMatch;
    }
}
