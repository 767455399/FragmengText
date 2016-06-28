package com.example.administrator.fragmenttext.base;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 项目名称：FragmentText
 * 类描述：
 * 创建人：WangQing
 * 创建时间：2016/1/12 19:09
 * 修改人：WangQing
 * 修改时间：2016/1/12 19:09
 * 修改备注：
 */
public class LoadData {

    List<HashMap<String, String>> list = new ArrayList<>();

    private  void  LoadingData(String path, CallBack1 callBack1){
        //创建okHttpClient对象
        OkHttpClient mOkHttpClient = new OkHttpClient();
        //创建一个Request
        final Request request = new Request.Builder()
                .url(path)
                .build();
        //new call
        Call call = mOkHttpClient.newCall(request);
        //请求加入调度
        call.enqueue(new com.squareup.okhttp.Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(final Response response) throws IOException {
                String htmlStr = response.body().string();
                try {
                    JSONObject jsonObject = new JSONObject(htmlStr);
                    Boolean aa=jsonObject.getBoolean("success");
                    String  total=jsonObject.getString("total");
                    JSONArray jsonArray = jsonObject.getJSONArray("list");
                    /*这行代码一定要写在里面，不然生成的数据会全部展示最后一条
                    HashMap<String, String> item = new HashMap<String, String>();（错误写法）*/
                    for (int i = 0; i < jsonArray.length(); i++) {
                        HashMap<String, String> item = new HashMap<String, String>();
                        JSONObject object = jsonArray.getJSONObject(i);
                        item.put("sn", object.getString("sn"));
                        item.put("stn", object.getString("stn"));
                        item.put("t", object.getString("t"));
                        item.put("salesMan", object.getString("salesMan"));
                        list.add(item);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });
        callBack1.result(list);
    }
}
