package cn.pocketwallet.pocketwallet.ui.activity.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import com.umeng.analytics.MobclickAgent;

import cn.pocketwallet.pocketwallet.R;
import cn.pocketwallet.pocketwallet.api.common.CommonUserApi;
import cn.pocketwallet.pocketwallet.base.BaseActivity;
import cn.pocketwallet.pocketwallet.widget.dialog.CommonDialog;

public class WebViewActivity extends BaseActivity {

    private static final String TAG = "WebViewActivity";

    private String url;
    private String title;
    private boolean hideBar;

    private FrameLayout webViewFrameLayout;
    private WebView webView;
    private View webViewToolbarShadow;
    private ProgressBar webViewProgressBar;


    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void initViews() {
        setContentView(R.layout.activity_webview);
        webView = new WebView(getApplicationContext());
        webViewFrameLayout = (FrameLayout) findViewById(R.id.webViewFrameLayout);
        webViewFrameLayout.addView(webView);
        webViewToolbarShadow = findViewById(R.id.webViewToolbarShadow);
        webViewProgressBar = (ProgressBar) findViewById(R.id.webViewProgressBar);

        Intent intent = getIntent();
        url = intent.getStringExtra("url");
        title = intent.getStringExtra("title");
        hideBar = intent.getBooleanExtra("hideBar", false);

        if (hideBar || url.contains("HasBar")) {
            if (getSupportActionBar() != null) {
                getSupportActionBar().hide();
            }
            webViewToolbarShadow.setVisibility(View.GONE);
        }


        getSupportActionBar().setTitle(title);

        webViewProgressBar.setVisibility(View.GONE);
        webView.setWebViewClient(webViewClient);
        webView.setWebChromeClient(webChromeClient);
        WebSettings webSettings = webView.getSettings();
        webSettings.setDisplayZoomControls(false);
        webSettings.setSupportZoom(false);
        webSettings.setUseWideViewPort(true);
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);


        webView.loadUrl(url);
    }

    @Override
    protected void setListeners() {

    }

    @Override
    protected void loadData() {

    }


    public static Intent getWebViewActivityIntent(Context context, String url, String title, boolean hideBar) {
        Intent intent = new Intent();
        intent.setClass(context, cn.pocketwallet.pocketwallet.ui.activity.common.WebViewActivity.class);
        intent.putExtra("url", url);
        intent.putExtra("title", title);
        intent.putExtra("hideBar", hideBar);
        return intent;
    }


    WebViewClient webViewClient = new WebViewClient() {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, final String url) {
            Log.e("url", url);
            if (url.contains("tel:")) {
                final CommonDialog commonDialog = new CommonDialog(cn.pocketwallet.pocketwallet.ui.activity.common.WebViewActivity.this,
                        getString(R.string.call_customer_service),
                        getString(R.string.customer_service_dialog), new CommonDialog.Listener() {
                    @Override
                    public void onLeftButtonClick() {

                    }

                    @Override
                    public void onRightButtonClick() {
                        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(url));
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                    }
                });
                commonDialog.show();
            } else if (url.contains("close:")) {
                cn.pocketwallet.pocketwallet.ui.activity.common.WebViewActivity.this.finish();
            } else if (url.contains("to_client_loan_record:")) {
                if (CommonUserApi.isLogin()) {
                    startActivity(new Intent(cn.pocketwallet.pocketwallet.ui.activity.common.WebViewActivity.this, cn.pocketwallet.pocketwallet.ui.activity.common.LoanRecordActivity.class));
                } else {
                    startActivity(new Intent(cn.pocketwallet.pocketwallet.ui.activity.common.WebViewActivity.this, cn.pocketwallet.pocketwallet.ui.activity.common.LoginActivity.class));
                }
            } else if (url.contains("to_client_login:")) {
                startActivity(new Intent(cn.pocketwallet.pocketwallet.ui.activity.common.WebViewActivity.this, cn.pocketwallet.pocketwallet.ui.activity.common.LoginActivity.class));
            } else if (url.contains("to_client_message_center:")) {
                if (CommonUserApi.isLogin()) {
                    startActivity(new Intent(cn.pocketwallet.pocketwallet.ui.activity.common.WebViewActivity.this, cn.pocketwallet.pocketwallet.ui.activity.common.MessageCenterActivity.class));
                } else {
                    startActivity(new Intent(cn.pocketwallet.pocketwallet.ui.activity.common.WebViewActivity.this, cn.pocketwallet.pocketwallet.ui.activity.common.LoginActivity.class));
                }
            } else {
                view.loadUrl(url);
            }
            return true;
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
        }
    };


    WebChromeClient webChromeClient = new WebChromeClient() {
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            if (newProgress == 100) {
                webViewProgressBar.setVisibility(View.GONE);
            } else {
                if (webViewProgressBar.getVisibility() == View.GONE) {
                    webViewProgressBar.setVisibility(View.VISIBLE);
                }
                webViewProgressBar.setProgress(newProgress);
            }
            super.onProgressChanged(view, newProgress);
        }

        @Override
        public void onReceivedTitle(WebView view, String title) {
            super.onReceivedTitle(view, title);
        }


    };

    @Override
    protected void onResume() {
        super.onResume();
        MobclickAgent.onPageStart(TAG);
        MobclickAgent.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MobclickAgent.onPageEnd(TAG);
        MobclickAgent.onPause(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (webView != null) {
            webView.removeAllViews();
            webView.destroy();
        }
        webView = null;
    }
}
