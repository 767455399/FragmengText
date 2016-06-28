package cn.pocketwallet.pocketwallet.ui.activity.common;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;

import com.umeng.analytics.MobclickAgent;

import cn.pocketwallet.pocketwallet.R;
import cn.pocketwallet.pocketwallet.base.BaseActivity;
import cn.pocketwallet.pocketwallet.ui.fragment.common.LoanRecordAllFragment;
import cn.pocketwallet.pocketwallet.ui.fragment.common.LoanRecordArrearsFragment;
import cn.pocketwallet.pocketwallet.ui.fragment.common.LoanRecordOverdueFragment;
import cn.pocketwallet.pocketwallet.ui.fragment.common.LoanRecordPaidFragment;
import cn.pocketwallet.pocketwallet.util.viewpageradapter.fragment.FragmentPagerItemAdapter;
import cn.pocketwallet.pocketwallet.util.viewpageradapter.fragment.FragmentPagerItems;

public class LoanRecordActivity extends BaseActivity {


    private static final String TAG = "LoanRecordActivity";

    //    private SmartTabLayout loanRecordSmartTabLayout;
    private TabLayout loanRecordTabLayout;
    private ViewPager loanRecordViewPager;


    @Override
    protected void initViews() {
        setContentView(R.layout.activity_loan_record);
        loanRecordTabLayout = (TabLayout) findViewById(R.id.loanRecordTabLayout);
        loanRecordViewPager = (ViewPager) findViewById(R.id.loanRecordViewPager);

        FragmentPagerItemAdapter fragmentPagerItemAdapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(), FragmentPagerItems.with(cn.pocketwallet.pocketwallet.ui.activity.common.LoanRecordActivity.this)
                .add(getString(R.string.title_fragment_loan_record_all), LoanRecordAllFragment.class)
                .add(getString(R.string.title_fragment_loan_record_overdue), LoanRecordOverdueFragment.class)
                .add(getString(R.string.title_fragment_loan_record_arrears), LoanRecordArrearsFragment.class)
                .add(getString(R.string.title_fragment_loan_record_paid), LoanRecordPaidFragment.class)
                .create());

        loanRecordViewPager.setAdapter(fragmentPagerItemAdapter);
        loanRecordTabLayout.setupWithViewPager(loanRecordViewPager);
    }

    @Override
    protected void setListeners() {

    }

    @Override
    protected void loadData() {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_loan_record, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            startActivity(new Intent(cn.pocketwallet.pocketwallet.ui.activity.common.LoanRecordActivity.this, TransactionDetailActivity.class));
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
