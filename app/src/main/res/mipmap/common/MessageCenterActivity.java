package cn.pocketwallet.pocketwallet.ui.activity.common;

import com.umeng.analytics.MobclickAgent;

import cn.pocketwallet.pocketwallet.R;
import cn.pocketwallet.pocketwallet.base.BaseActivity;
import cn.pocketwallet.pocketwallet.ui.fragment.common.MessageListFragment;
import cn.pocketwallet.pocketwallet.util.FragmentUtil;

public class MessageCenterActivity extends BaseActivity {

    private static final String TAG = "MessageCenterActivity";


    @Override
    protected void initViews() {
        setContentView(R.layout.activity_message_center);
        FragmentUtil.replace(getSupportFragmentManager(),
                R.id.messageCenterContainer,
                new MessageListFragment(), false,
                "MessageListFragment");
    }

    @Override
    protected void setListeners() {

    }

    @Override
    protected void loadData() {

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
