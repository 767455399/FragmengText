package com.example.administrator.fragmenttext.post;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.fragmenttext.R;
import com.example.administrator.fragmenttext.base.BaseActivity;
import com.example.administrator.fragmenttext.toast.ToastUtil;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class PostActivity extends BaseActivity {
    private Button post;
    private Button get;
    private TextView textView;
    private String path = "http://www.jutongbao.com/jtb/phone/user_login.action?companyCode=05710000&account=18964922435&passwd=123&imei=A100003A779FD7";
    private String baseURL = "http://www.jutongbao.com/jtb/phone/user_login.action";
    private String xiaotailehuo = "http://devtest.pocketwallet.cn/account/";

    @Override
    protected void initView() {
        setContentView(R.layout.activity_post);
        post = (Button) findViewById(R.id.post);
        get = (Button) findViewById(R.id.get);
        textView = (TextView) findViewById(R.id.textView);
    }

    public Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            textView.setText(msg.obj.toString());
           /* try {
                JSONObject jsonObject = new JSONObject(msg.obj.toString());
                if (jsonObject.getBoolean("success")) {
                    String name = String.valueOf(jsonObject.get("realName"));
                    ToastUtil.showSuccessToast(name, PostActivity.this);
                }
                JSONArray jsonArray = jsonObject.getJSONArray("dataList");
                String name = (String) jsonArray.get(0);
                ToastUtil.showSuccessToast(name + "", PostActivity.this);
            } catch (JSONException e) {
                e.printStackTrace();
            }*/
        }
    };

    @Override
    protected void setListener() {
        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new PostMyThread()).start();
            }
        });
        get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new GetMyThread()).start();
            }
        });
    }

    @Override
    protected void loadDate() {

    }

    @Override
    protected void mobclickAgentStart() {

    }

    @Override
    protected void mobclickAgentEnd() {

    }

    public class GetMyThread implements Runnable {
        @Override
        public void run() {
            // 使用GET方法发送请求,需要把参数加在URL后面，用？连接，参数之间用&分隔
            // 生成请求对象
            HttpGet httpGet = new HttpGet(path);
            HttpClient httpClient = new DefaultHttpClient();

            // 发送请求
            try {

                HttpResponse response = httpClient.execute(httpGet);

                // 显示响应
                showResponseResult(response);// 一个私有方法，将响应结果显示出来

            } catch (Exception e) {
                e.printStackTrace();
            }


        }
    }

  /*  http://devtest.pocketwallet.cn/account/phone,,password*/

    public class PostMyThread implements Runnable {
        @Override
        public void run() {
            NameValuePair pair1 = new BasicNameValuePair("phone", "15500000023");
            NameValuePair pair2 = new BasicNameValuePair("account", "123456");
           /* NameValuePair pair1 = new BasicNameValuePair("companyCode", "05710000");
            NameValuePair pair2 = new BasicNameValuePair("account", "18964922435");
            NameValuePair pair3 = new BasicNameValuePair("passwd", "123");
            NameValuePair pair4 = new BasicNameValuePair("imei", "A100003A779FD7");*/
            List<NameValuePair> pairList = new ArrayList<NameValuePair>();
            pairList.add(pair1);
            pairList.add(pair2);
           /* pairList.add(pair3);
            pairList.add(pair4);*/
            try {
                HttpEntity requestHttpEntity = new UrlEncodedFormEntity(
                        pairList);
                // URL使用基本URL即可，其中不需要加参数
                HttpPost httpPost = new HttpPost(xiaotailehuo);
                // 将请求体内容加入请求中
                httpPost.setEntity(requestHttpEntity);
                // 需要客户端对象来发送请求
                HttpClient httpClient = new DefaultHttpClient();
                // 发送请求
                HttpResponse response = httpClient.execute(httpPost);
                // 显示响应
                showResponseResult(response);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    /**
     * 显示响应结果到命令行和TextView
     *
     * @param response
     */
    private void showResponseResult(HttpResponse response) {
        if (null == response) {
            return;
        }
        HttpEntity httpEntity = response.getEntity();
        try {
            InputStream inputStream = httpEntity.getContent();
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    inputStream));
            String result = "";
            String line = "";
            while (null != (line = reader.readLine())) {
                result += line;
            }
            System.out.println(result);
            Message message = new Message();
            message.obj = result;
            handler.sendMessage(message);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
