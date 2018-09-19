package com.udacity.sandwichclub.utils;

import android.util.Log;
import android.widget.Toast;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) throws JSONException {


        JSONObject jsonObj = new JSONObject(json);
        JSONObject name=jsonObj.getJSONObject("name");

        String MainName=name.getString("mainName");

        JSONArray Also = new JSONArray(name.getString("alsoKnownAs"));
        List<String> alsoKnownAs = new ArrayList<String>();
        if (Also != null) {
            for (int i=0;i<Also.length();i++){
                alsoKnownAs.add(Also.getString(i));
            }
        }

        String placeOfOrigin=jsonObj.getString("placeOfOrigin");
        String description=jsonObj.getString("description");
        String image=jsonObj.getString("image");

        JSONArray m = new JSONArray(jsonObj.getString("ingredients"));
        List<String> ingredients = new ArrayList<String>();
        if (m != null) {
            for (int i=0;i<m.length();i++){
                ingredients.add(m.getString(i));
            }
        }


        Sandwich sandwich_detail = new Sandwich(MainName,alsoKnownAs,placeOfOrigin,description,image,ingredients
        );

        Log.i("Jsonloool",sandwich_detail+"");
        return sandwich_detail;
    }
}