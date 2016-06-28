package cn.pocketwallet.pocketwallet.ui.activity.common;


import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;

import com.umeng.analytics.MobclickAgent;

import cn.pocketwallet.pocketwallet.R;
import cn.pocketwallet.pocketwallet.api.common.Urls;
import cn.pocketwallet.pocketwallet.base.BaseActivity;
import cn.pocketwallet.pocketwallet.ui.fragment.common.IntegralFragment;
import cn.pocketwallet.pocketwallet.util.FragmentUtil;

/*积分-----王清*/

public class IntegralActivity extends BaseActivity {

    private static final String TAG = "IntegralActivity";

    @Override
    protected void initViews() {
        setContentView(R.layout.activity_integral);
        FragmentUtil.replace(getSupportFragmentManager(),
                R.id.integralContainer,
                new IntegralFragment(), false,
                "IntegralFragment");
    }

    @Override
    protected void setListeners() {

    }

    @Override
    protected void loadData() {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_instructions, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.instructionsMenu) {
            Intent intent = WebViewActivity.getWebViewActivityIntent(cn.pocketwallet.pocketwallet.ui.activity.common.IntegralActivity.this,
                    Urls.INTEGRAL_URL,
                    getString(R.string.integral_use_description), false);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
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
