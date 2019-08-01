package com.example.expandablerecyclerviewex.Utils;

import android.content.Context;

import com.example.expandablerecyclerviewex.Models.NewsPaperModel;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author USER
 * @date 30-Jul-19
 */
public class JsonHelper {


    private List newspaperList;
    private Context mContext;

    public JsonHelper(Context context) {
        super();
        mContext = context;
    }

    public String loadJSONFromAssert()  {
        String json = null;
        try {
            InputStream inputStream;

        inputStream = this.mContext.getAssets().open("data.json");
        int size = inputStream.available();
        byte[] buffer = new byte[size];
        inputStream.read(buffer);
        inputStream.close();
        json = new String(buffer, "UTF-8");
        }catch (IOException e){
            e.printStackTrace();
            return null;
        }
        return json;
    }

    public List getNewsPaperData(){
       if (this.newspaperList == null) {
           this.newspaperList = new ArrayList();
       }
           try {
               JSONObject jsonObject = new JSONObject(loadJSONFromAssert());
               JSONArray jsonArray = jsonObject.getJSONArray("news_papers");
               int k = jsonArray.length();
               int i = 0;
               for (int j = k;  i<j; ++i){
        //           HeadlinesModel headlinesModel = new HeadlinesModel();
                   JSONObject jsonObjectHeadlines = jsonArray.getJSONObject(i);
                   String tempJsonObject = jsonArray.getJSONObject(i).toString();
                   String jsonv = jsonArray.getJSONObject(i).toString();

                   String Name = jsonObjectHeadlines.getString("name");

                   Gson gson = new Gson();
                   NewsPaperModel newsPaper = (NewsPaperModel)gson.fromJson(tempJsonObject, NewsPaperModel.class);

                   List headLines = this.newspaperList;
                   if (headLines!=null){
                       headLines.add(newsPaper);
                   }

               }
               return this.newspaperList;
           } catch (JSONException e) {
               e.printStackTrace();
               return null;
           }
       }

    }

