package cn.pocketwallet.pocketwallet.ui.activity.common;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.Toolbar.OnMenuItemClickListener;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.umeng.analytics.MobclickAgent;

import cn.pocketwallet.pocketwallet.R;
import cn.pocketwallet.pocketwallet.api.MessageApi;
import cn.pocketwallet.pocketwallet.api.common.CommonUserApi;
import cn.pocketwallet.pocketwallet.api.common.DaySignApi;
import cn.pocketwallet.pocketwallet.base.BaseActivity;
import cn.pocketwallet.pocketwallet.model.DaySignModel;
import cn.pocketwallet.pocketwallet.model.MessageReadStatusModel;
import cn.pocketwallet.pocketwallet.ui.fragment.common.DrawerFragment;
import cn.pocketwallet.pocketwallet.ui.fragment.common.FundAccountFragment;
import cn.pocketwallet.pocketwallet.ui.fragment.common.IndexFragment;
import cn.pocketwallet.pocketwallet.ui.fragment.common.MemberCenterFragment;
import cn.pocketwallet.pocketwallet.ui.fragment.common.SettingFragment;
import cn.pocketwallet.pocketwallet.util.ClickUtil;
import cn.pocketwallet.pocketwallet.util.FragmentUtil;
import cn.pocketwallet.pocketwallet.util.ToastUtil;
import rx.Subscriber;


public class MainActivity extends BaseActivity implements DrawerFragment.NavigationDrawerCallbacks {
    private static final String TAG = "MainActivity";

    private DrawerFragment drawerFragment;
    private int currentPosition = 0;
    private boolean hideMessageMenuItem = false;
    private boolean hasNewMessage = false;

    @Override
    protected void initViews() {
        setContentView(R.layout.activity_main);
        DrawerLayout drawer_layout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerFragment = (DrawerFragment) getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        drawerFragment.setUp(R.id.navigation_drawer, drawer_layout);
        switchFragment(0, false);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        int newPosition = intent.getIntExtra("drawerPosition", 0);
        switchFragment(newPosition, false);
    }

    @Override
    protected void setListeners() {
        getToolbar().setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawerFragment.isDrawerOpen()) {
                    drawerFragment.closeDrawer();
                } else {
                    drawerFragment.openDrawer();
                }
            }
        });
    }

    @Override
    protected void loadData() {

    }

    public static void toMainActivity(Activity activity, MainFragments fragments) {
        Intent intent = new Intent(activity, cn.pocketwallet.pocketwallet.ui.activity.common.MainActivity.class);
        int drawerPosition = 0;
        switch (fragments) {
            case INDEX:
                drawerPosition = 0;
                break;
            case MEMBER_CENTER:
                drawerPosition = 1;
                break;
            case ACCOUNT:
                drawerPosition = 2;
                break;
            case SETTING:
                drawerPosition = 3;
                break;
        }
        intent.putExtra("drawerPosition", drawerPosition);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        activity.startActivity(intent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        Toolbar toolbar = getToolbar();
        toolbar.inflateMenu(R.menu.menu_main);
        toolbar.setOnMenuItemClickListener(onMenuItemClickListener);
        return true;
    }


    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem messageMenuItem = menu.findItem(R.id.action_main_message);
        if (messageMenuItem != null) {
            if (hideMessageMenuItem) {
                messageMenuItem.setVisible(false);
            } else {
                messageMenuItem.setVisible(true);
                if (hasNewMessage) {
                    messageMenuItem.setIcon(R.drawable.ic_action_message_dot);
                }
            }

        }
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    protected void onResume() {
        super.onResume();
        MobclickAgent.onPageStart(TAG);
        MobclickAgent.onResume(this);
        if (CommonUserApi.isLogin()) {
            getNewMessage();
            daySign();
        }
    }


    @Override
    public void onNavigationDrawerItemSelected(int position) {
        switchFragment(position, true);
    }

    private void switchFragment(int position, boolean withAnim) {
        currentPosition = position;
        switch (position) {
            case 0:
                if (withAnim) {
                    FragmentUtil.replaceWithAnim(getSupportFragmentManager(), R.id.container, new IndexFragment(), false, "IndexFragment");
                } else {
                    FragmentUtil.replace(getSupportFragmentManager(), R.id.container, new IndexFragment(), false, "IndexFragment");
                }
                hideMessageMenuItem = false;
                break;
            case 1:
                if (withAnim) {
                    FragmentUtil.replaceWithAnim(getSupportFragmentManager(), R.id.container, new MemberCenterFragment(), false, "MemberCenterFragment");
                } else {
                    FragmentUtil.replace(getSupportFragmentManager(), R.id.container, new MemberCenterFragment(), false, "MemberCenterFragment");
                }
                hideMessageMenuItem = false;
                break;
            case 2:
                if (withAnim) {
                    FragmentUtil.replaceWithAnim(getSupportFragmentManager(), R.id.container, new FundAccountFragment(), false, "FundAccountFragment");
                } else {
                    FragmentUtil.replace(getSupportFragmentManager(), R.id.container, new FundAccountFragment(), false, "FundAccountFragment");
                }
                hideMessageMenuItem = true;
                break;
            case 3:
                if (withAnim) {
                    FragmentUtil.replaceWithAnim(getSupportFragmentManager(), R.id.container, new SettingFragment(), false, "SettingFragment");
                } else {
                    FragmentUtil.replace(getSupportFragmentManager(), R.id.container, new SettingFragment(), false, "SettingFragment");
                }
                hideMessageMenuItem = true;
                break;

        }
    }

    OnMenuItemClickListener onMenuItemClickListener = new OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem item) {
            switch (item.getItemId()) {
                case R.id.action_main_message:
                    if (CommonUserApi.isLogin()) {
                        startActivity(new Intent(cn.pocketwallet.pocketwallet.ui.activity.common.MainActivity.this, cn.pocketwallet.pocketwallet.ui.activity.common.MessageCenterActivity.class));
                    } else {
                        startActivity(new Intent(cn.pocketwallet.pocketwallet.ui.activity.common.MainActivity.this, LoginActivity.class));
                    }
                    return true;
                case R.id.action_fund_account_detail:
                    if (CommonUserApi.isLogin()) {
                        startActivity(new Intent(cn.pocketwallet.pocketwallet.ui.activity.common.MainActivity.this, TransactionDetailActivity.class));
                    } else {
                        startActivity(new Intent(cn.pocketwallet.pocketwallet.ui.activity.common.MainActivity.this, LoginActivity.class));
                    }
                    return true;
            }
            return false;
        }
    };


    private void getNewMessage() {
        MessageApi.checkMessageReadStatus(new Subscriber<MessageReadStatusModel>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(MessageReadStatusModel model) {
                hasNewMessage = model.getHave();
                if (getSupportActionBar() != null) {
                    getSupportActionBar().invalidateOptionsMenu();
                }
            }
        });
    }

    private void daySign() {
        DaySignApi.sign(new Subscriber<DaySignModel>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(DaySignModel daySignModel) {
                if (daySignModel.getStatus() == DaySignModel.SignStatus.SUCCESS) {
                    ToastUtil.showDaySignToast();
                }
            }
        });
    }


    @Override
    public void onBackPressed() {
        if (drawerFragment.isDrawerOpen()) {
            drawerFragment.closeDrawer();
        } else {
            ClickUtil.doubleClickExitApp(cn.pocketwallet.pocketwallet.ui.activity.common.MainActivity.this);
        }
    }


    @Override
    protected void onPause() {
        super.onPause();
        MobclickAgent.onPageEnd(TAG);
        MobclickAgent.onPause(this);
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public enum MainFragments {
        INDEX(0),
        MEMBER_CENTER(1),
        ACCOUNT(2),
        SETTING(3);
        private int code;

        MainFragments(int code) {
            this.code = code;
        }

        public int getCode() {
            return code;
        }

        public static MainFragments fromInt(int code) {
            switch (code) {
                case 0:
                    return INDEX;
                case 1:
                    return MEMBER_CENTER;
                case 2:
                    return ACCOUNT;
                case 3:
                    return SETTING;
                default:
                    return INDEX;
            }
        }
    }

}
