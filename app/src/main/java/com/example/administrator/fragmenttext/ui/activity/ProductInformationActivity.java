package com.example.administrator.fragmenttext.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.fragmenttext.LoadDate.NetWork;
import com.example.administrator.fragmenttext.R;
import com.example.administrator.fragmenttext.base.BaseActivity;
import com.example.administrator.fragmenttext.base.myCallBack;
import com.example.administrator.fragmenttext.model.ProductInformationModle;

import java.util.ArrayList;
import java.util.List;

public class ProductInformationActivity extends BaseActivity {
    private RecyclerView productInformationRecyclerView;
    private ProductInformationAdapter productInformationAdapter;
    private List<List<String>>productInformationList=new ArrayList<>();
    private String path="http://www.jutongbao.com/jtb/phone/score_mainXsdcSjmc.action?companyCode=05710001&typeId=57E8963F-43D5-469A-B1AA-FEF6F0BCFBCA&scoreType=9&userId=131D5455-C4DD-410E-8EDE-8BD1A4E371E4&yearMonthInfo=2015-01-06";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initView() {
        setContentView(R.layout.activity_product_information);
        productInformationRecyclerView=(RecyclerView)findViewById(R.id.productInformationRecyclerView);
        productInformationRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void loadDate() {
        productInformationAdapter=new ProductInformationAdapter();
        productInformationRecyclerView.setAdapter(productInformationAdapter);
        getData();

    }

    @Override
    protected void mobclickAgentStart() {

    }

    @Override
    protected void mobclickAgentEnd() {

    }

    private void getData() {
        NetWork.getProductInformation(path, new myCallBack<ProductInformationModle>() {
            @Override
            public void Success(ProductInformationModle productInformationModle) {
                productInformationList.addAll(productInformationModle.getScoreList());
                productInformationAdapter.notifyDataSetChanged();
            }

            @Override
            public void Fail(String fail) {

            }
        });
    }

    class ProductInformationAdapter extends RecyclerView.Adapter<ViewHolder>{

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view= LayoutInflater.from(ProductInformationActivity.this).inflate(R.layout.item_product_information,parent,false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            if(TextUtils.isEmpty(productInformationList.get(position).get(1)))
            holder.productName.setText("商品名称："+productInformationList.get(position).get(1));
            holder.productNum.setText("商品现价："+productInformationList.get(position).get(2));
            holder.productPrice.setText("商品原价："+productInformationList.get(position).get(3));
        }

        @Override
        public int getItemCount() {
            return productInformationList.size();
        }
    }
    class ViewHolder extends RecyclerView.ViewHolder{
        private TextView productName;
        private TextView productPrice;
        private TextView productNum;

        public ViewHolder(View itemView) {
            super(itemView);
            productName=(TextView)itemView.findViewById(R.id.productName);
            productPrice=(TextView)itemView.findViewById(R.id.productPrice);
            productNum=(TextView)itemView.findViewById(R.id.productNum);
        }
    }
}
