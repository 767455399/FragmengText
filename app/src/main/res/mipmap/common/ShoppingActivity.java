package cn.pocketwallet.pocketwallet.ui.activity.common;

import android.annotation.SuppressLint;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.umeng.analytics.MobclickAgent;

import cn.pocketwallet.pocketwallet.R;
import cn.pocketwallet.pocketwallet.base.BaseActivity;

public class ShoppingActivity extends BaseActivity {

    private static final String TAG = "ShoppingActivity";

    private WebView shoppingWebView;

    @Override
    protected void initViews() {
        setContentView(R.layout.activity_shopping);
        shoppingWebView = (WebView) findViewById(R.id.shoppingWebView);
        initWebView();
    }

    @Override
    protected void setListeners() {

    }

    @Override
    protected void loadData() {
        shoppingWebView.loadUrl("http://devtest.pocketwallet.cn:3000/");
    }


    @SuppressLint("SetJavaScriptEnabled")
    private void initWebView() {
        shoppingWebView.setWebViewClient(webViewClient);
        shoppingWebView.setWebChromeClient(webChromeClient);
        WebSettings webSettings = shoppingWebView.getSettings();
        webSettings.setDisplayZoomControls(false);
        webSettings.setSupportZoom(false);
        webSettings.setUseWideViewPort(true);
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);
    }

    WebViewClient webViewClient = new WebViewClient() {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, final String url) {
            view.loadUrl(url);
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
            super.onProgressChanged(view, newProgress);
        }

        @Override
        public void onReceivedTitle(WebView view, String title) {
            if (getSupportActionBar() != null) {
                getSupportActionBar().setTitle(title);
            }
            super.onReceivedTitle(view, title);
        }

        @Override
        public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
            return super.onJsAlert(view, url, message, result);
        }
    };

    @Override
    public void onBackPressed() {
        if (shoppingWebView.canGoBack()) {
            shoppingWebView.goBack();
        } else {
            super.onBackPressed();
        }
    }

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
}
