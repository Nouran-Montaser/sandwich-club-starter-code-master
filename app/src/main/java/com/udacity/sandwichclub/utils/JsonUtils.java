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

        JSONArray AlsoKnownAsArray = new JSONArray(name.getString("alsoKnownAs"));
        List<String> alsoKnownAs = new ArrayList<>();
        if (AlsoKnownAsArray != null) {
            for (int i=0;i<AlsoKnownAsArray.length();i++){
                alsoKnownAs.add(AlsoKnownAsArray.getString(i));
            }
        }

        String placeOfOrigin=jsonObj.getString("placeOfOrigin");
        String description=jsonObj.getString("description");
        String image=jsonObj.getString("image");

        JSONArray IngredientsArray = new JSONArray(jsonObj.getString("ingredients"));
        List<String> ingredients = new ArrayList<>();
        if (IngredientsArray != null) {
            for (int i=0;i<IngredientsArray.length();i++){
                ingredients.add(IngredientsArray.getString(i));
            }
        }


        Sandwich sandwich_detail = new Sandwich(MainName,alsoKnownAs,placeOfOrigin,description,image,ingredients
        );

        return sandwich_detail;
    }
}