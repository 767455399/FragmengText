package cn.pocketwallet.pocketwallet.ui.activity.common;

import android.view.View;
import android.widget.TextView;

import com.umeng.analytics.MobclickAgent;

import cn.pocketwallet.pocketwallet.R;
import cn.pocketwallet.pocketwallet.base.BaseActivity;
import cn.pocketwallet.pocketwallet.ui.fragment.common.BankBranchProvinceFragment;
import cn.pocketwallet.pocketwallet.util.FragmentUtil;

public class BankBranchActivity extends BaseActivity {

    private static final String TAG = "BankBranchActivity";

    private TextView bankBranchProvinceTextView;
    private TextView bankBranchCityTextView;
    private TextView bankBranchNameTextView;
    private View bankBranchIndicator1;
    private View bankBranchIndicator2;

    private String bankCardId;
    private String provinceId;
    private String provinceName;
    private String cityId;
    private String cityName;
    private String branchId;


    @Override
    protected void initViews() {
        setContentView(R.layout.activity_bank_branch);
        bankCardId = getIntent().getStringExtra("bankCardId");
        bankBranchProvinceTextView = (TextView) findViewById(R.id.bankBranchProvinceTextView);
        bankBranchCityTextView = (TextView) findViewById(R.id.bankBranchCityTextView);
        bankBranchNameTextView = (TextView) findViewById(R.id.bankBranchNameTextView);
        bankBranchIndicator1 = findViewById(R.id.bankBranchIndicator1);
        bankBranchIndicator2 = findViewById(R.id.bankBranchIndicator2);
        FragmentUtil.replace(getSupportFragmentManager(), R.id.bankBranchContainer, new BankBranchProvinceFragment(), false, "BankBranchProvinceFragment");
    }

    @Override
    protected void setListeners() {

    }

    @Override
    protected void loadData() {

    }


    public void setTitle2Visible() {
        bankBranchIndicator1.setVisibility(View.VISIBLE);
        bankBranchCityTextView.setVisibility(View.VISIBLE);
    }

    public void setTitle2Invisible() {
        bankBranchIndicator1.setVisibility(View.GONE);
        bankBranchCityTextView.setVisibility(View.GONE);
    }

    public void setTitle3Visible() {
        bankBranchIndicator2.setVisibility(View.VISIBLE);
        bankBranchNameTextView.setVisibility(View.VISIBLE);
    }

    public void setTitle3Invisible() {
        bankBranchIndicator2.setVisibility(View.GONE);
        bankBranchNameTextView.setVisibility(View.GONE);
    }


    public void setTitle1Text(String str) {
        bankBranchProvinceTextView.setText(str);
    }

    public void setTitle2Text(String str) {
        bankBranchCityTextView.setText(str);
    }

    public void setTitle3Text(String str) {
        bankBranchNameTextView.setText(str);
    }


    public String getBankCardId() {
        return bankCardId;
    }


    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
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
