package com.example.administrator.fragmenttext.base;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.administrator.fragmenttext.R;
import com.example.administrator.fragmenttext.widget.LoadingDialog;
import com.umeng.analytics.MobclickAgent;

/**
 * 项目名称：FragmentText
 * 类描述：
 * 创建人：WangQing
 * 创建时间：2015/12/1 14:31
 * 修改人：WangQing
 * 修改时间：2015/12/1 14:31
 * 修改备注：
 */
public abstract class BaseActivity extends AppCompatActivity {
    private TextView left, right;
    private ImageView back;
    private LoadingDialog loadingDialog;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.base);
        loadingDialog = new LoadingDialog(BaseActivity.this);
        initView();
        setListener();
        loadDate();

    }


    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        initToolBar();
    }

    private void initToolBar() {
       /* toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finishActivity();
                }
            });*/
//                toolbar.setNavigationOnClickListener(view -> finishActivity());
     /*   }*/

     /*  View statusView = findViewById(R.id.statusBarView);
       if (statusView != null) {
           if (Build.VERSION.SDK_INT == Build.VERSION_CODES.KITKAT) {
               if (android.os.Build.MANUFACTURER.equals("Xiaomi") || MeizuSmartBarUtil.hasSmartBar()) {
                   statusView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, StatusBarProxy.getStatusBarHeight(this)));
               }
           }
       }*/

    }

    protected abstract void initView();

    protected abstract void setListener();

    protected abstract void loadDate();


    protected void showLoadingDialog() {
        if (null == loadingDialog) {
            loadingDialog = new LoadingDialog(this);
        }
        if (!loadingDialog.isShowing()) {
            loadingDialog.show();
        }
    }

    protected void dismissLoadDialog() {
        if (loadingDialog != null && loadingDialog.isShowing()) {
            loadingDialog.dismiss();
        }
    }

    protected LoadingDialog getLoadingDialog() {
        return loadingDialog;
    }

    protected void finishActivity() {
        this.finish();
    }

    /**
     * 如果是fragmentActivity 这两个方法实现后，里面不需要对友盟统计实现
     */
    protected abstract void mobclickAgentStart();

    protected abstract void mobclickAgentEnd();

    @Override
    protected void onResume() {
        super.onResume();
        mobclickAgentStart();
        MobclickAgent.onResume(this);
    }


    @Override
    protected void onPause() {
        super.onPause();
        mobclickAgentEnd();
        MobclickAgent.onPause(this);
    }

}
