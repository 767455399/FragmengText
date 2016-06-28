package com.example.administrator.fragmenttext.ui.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import com.example.administrator.fragmenttext.R;
import com.example.administrator.fragmenttext.base.BaseActivity;
import com.example.administrator.fragmenttext.ui.fragment.BasicDocumentFragment;
import com.example.administrator.fragmenttext.ui.fragment.ConditionOfAssetsFragment;
import com.example.administrator.fragmenttext.ui.fragment.ContactInformationFragment;
import com.example.administrator.fragmenttext.ui.fragment.CreditInformationFragment;
import com.example.administrator.fragmenttext.ui.fragment.EducationalBackgroundInformationFragment;
import com.example.administrator.fragmenttext.ui.fragment.WorkInformationFragment;

/**
 * 项目名称：FragmentText
 * 类描述：
 * 创建人：WangQing
 * 创建时间：2015/12/16 14:36
 * 修改人：WangQing
 * 修改时间：2015/12/16 14:36
 * 修改备注：
 */
public class JobInformationActivity extends BaseActivity implements View.OnClickListener {
    private LinearLayout basicDocumentLinearLayout,contactInformationLinearLayout,
            educationalBackgroundInformationLinearLayout,workInformationLinearLayout,
            conditionOfAssetsLinearLayout,creditInformationLinearLayout;
    private BasicDocumentFragment basicDocumentFragment;
    private ContactInformationFragment contactInformationFragment;
    private EducationalBackgroundInformationFragment educationalBackgroundInformationFragment;
    private WorkInformationFragment workInformationFragment;
    private ConditionOfAssetsFragment conditionOfAssetsFragment;
    private CreditInformationFragment creditInformationFragment;


    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(savedInstanceState==null){
            FragmentManager fm=getFragmentManager();
            FragmentTransaction ft=fm.beginTransaction();
            basicDocumentFragment=new BasicDocumentFragment();
            ft.add(R.id.messageFragment,basicDocumentFragment);
            ft.commit();
        }

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
    protected void setListener() {
        basicDocumentLinearLayout.setOnClickListener(this);
        contactInformationLinearLayout.setOnClickListener(this);
        educationalBackgroundInformationLinearLayout.setOnClickListener(this);
        workInformationLinearLayout.setOnClickListener(this);
        conditionOfAssetsLinearLayout.setOnClickListener(this);
        creditInformationLinearLayout.setOnClickListener(this);

    }

    @Override
    protected void initView() {
        setContentView(R.layout.activity_job_information);
        basicDocumentLinearLayout=(LinearLayout)findViewById(R.id.basicDocumentLinearLayout);
        contactInformationLinearLayout=(LinearLayout)findViewById(R.id.contactInformationLinearLayout);
        educationalBackgroundInformationLinearLayout=(LinearLayout)findViewById(R.id.educationalBackgroundInformationLinearLayout);
        workInformationLinearLayout=(LinearLayout)findViewById(R.id.workInformationLinearLayout);
        conditionOfAssetsLinearLayout=(LinearLayout)findViewById(R.id.conditionOfAssetsLinearLayout);
        creditInformationLinearLayout=(LinearLayout)findViewById(R.id.creditInformationLinearLayout);

    }

    @Override
    public void onClick(View v) {
        FragmentManager fragmentManager=getFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        switch (v.getId()){
            case R.id.basicDocumentLinearLayout:
                if(basicDocumentFragment==null){
                    basicDocumentFragment=new BasicDocumentFragment();
                }
                    fragmentTransaction.replace(R.id.messageFragment,basicDocumentFragment);
                    fragmentTransaction.commit();
                break;
            case R.id.contactInformationLinearLayout:
                if(contactInformationFragment==null){
                    contactInformationFragment=new ContactInformationFragment();
                }
                    fragmentTransaction.replace(R.id.messageFragment,contactInformationFragment);
                    fragmentTransaction.commit();
                break;
            case R.id.educationalBackgroundInformationLinearLayout:
                if(educationalBackgroundInformationFragment==null){
                    educationalBackgroundInformationFragment=new EducationalBackgroundInformationFragment();
                }
                    fragmentTransaction.replace(R.id.messageFragment,educationalBackgroundInformationFragment);
                    fragmentTransaction.commit();
                break;
            case R.id.workInformationLinearLayout:
                if(workInformationFragment==null){
                    workInformationFragment=new WorkInformationFragment();
                }
                    fragmentTransaction.replace(R.id.messageFragment,workInformationFragment);
                    fragmentTransaction.commit();
                break;
            case R.id.conditionOfAssetsLinearLayout:
                if(conditionOfAssetsFragment==null){
                    conditionOfAssetsFragment=new ConditionOfAssetsFragment();
                }
                    fragmentTransaction.replace(R.id.messageFragment,conditionOfAssetsFragment);
                    fragmentTransaction.commit();
                break;
            case R.id.creditInformationLinearLayout:
                if(creditInformationFragment==null){
                    creditInformationFragment=new CreditInformationFragment();
                }
                    fragmentTransaction.replace(R.id.messageFragment,creditInformationFragment);
                    fragmentTransaction.commit();
                break;
        }
    }
}
