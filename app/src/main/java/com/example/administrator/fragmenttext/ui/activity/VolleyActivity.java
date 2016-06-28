package com.example.administrator.fragmenttext.ui.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.administrator.fragmenttext.R;
import com.example.administrator.fragmenttext.base.BaseActivity;

/**
 * 项目名称：FragmentText
 * 类描述：
 * 创建人：WangQing
 * 创建时间：2016/1/8 15:38
 * 修改人：WangQing
 * 修改时间：2016/1/8 15:38
 * 修改备注：
 */
public class VolleyActivity extends BaseActivity implements View.OnClickListener {
    private Button requestDataButton;
    private TextView dataTextView;
    RequestQueue mQueue;
    StringRequest stringRequest;
    String mydate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initView() {
        setContentView(R.layout.activity_volley);
        requestDataButton = (Button) findViewById(R.id.requestDataButton);
        requestDataButton.setOnClickListener(this);
        dataTextView = (TextView) findViewById(R.id.dataTextView);
        mQueue = Volley.newRequestQueue(VolleyActivity.this);
        stringRequest = new StringRequest("http://www.jutongbao.com/jtb/phone/newshop_list.action?companyCode=05710001&userId=131D5455-C4DD-410E-8EDE-8BD1A4E371E4&pageIndex=0",
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response)
                    {
                        mydate=response.toString();
                        dataTextView.setText(mydate);
                                     /* Log.d("TAG", response);
                                        System.out.println("response="+response);
                                       Status status = gson.fromJson(response, Status.class);
                                     System.out.println("status="+status);
                                        System.out.println("-------------------------------------");
                                        List<Results> result = status.getResults();
                                       System.out.println("result="+result);*/

                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {
                        Log.e("TAG", error.getMessage(), error);
                    }

                });
    }

    @Override
    protected void setListener() {

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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.requestDataButton:
                mQueue.add(stringRequest);
                break;
            default:
                break;
        }
    }






}
