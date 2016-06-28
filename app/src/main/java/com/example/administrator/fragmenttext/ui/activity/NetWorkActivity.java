package com.example.administrator.fragmenttext.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.administrator.fragmenttext.LoadDate.NetWork;
import com.example.administrator.fragmenttext.R;
import com.example.administrator.fragmenttext.base.BaseActivity;
import com.example.administrator.fragmenttext.base.myCallBack;
import com.example.administrator.fragmenttext.model.NewNetWorkListModle;
import com.example.administrator.fragmenttext.model.NewNetWorkModle;
import com.example.administrator.fragmenttext.network.DeviceUtil;
import com.example.administrator.fragmenttext.toast.ToastUtil;
import com.example.administrator.fragmenttext.ui.adapter.SwipeRefreshLayoutUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import it.sephiroth.android.library.picasso.Picasso;

/**
 * 项目名称：FragmentText
 * 类描述：
 * 创建人：WangQing
 * 创建时间：2016/1/25 11:40
 * 修改人：WangQing
 * 修改时间：2016/1/25 11:40
 * 修改备注：
 */
public class NetWorkActivity extends BaseActivity {
    private String path = "http://www.jutongbao.com/jtb/phone/newshop_list.action?companyCode=05710001&userId=131D5455-C4DD-410E-8EDE-8BD1A4E371E4&pageIndex=";
    private RecyclerView netWorkRecyclerView;
    private NetWorkAdapter netWorkAdapter;
    private int pageindex = 1;
    private int pagesize = 10;
    private static final int TYPE_FOOTER = 0x0001;
    private static final int TYPE_NORMAL = 0x0002;
    private SwipeRefreshLayout netWorkSwipeRefreshLayout;
    private List<NewNetWorkListModle> netWorkList = new ArrayList<>();
    private Boolean hasNextPage = false;
    private Boolean nextPageIsLoading = false;
    private String[] image = {
            "http://e.hiphotos.baidu.com/image/pic/item/0b46f21fbe096b63f28855b908338744eaf8ac41.jpg",
            "http://g.hiphotos.baidu.com/image/pic/item/023b5bb5c9ea15ce2011ebe0b2003af33b87b25f.jpg",
            "http://cdn4.hbimg.cn/store/wm/bigfiles/201301/D525DEFC99C0D0C9FE8EAAA428.jpg",
            "http://np29.yule.com.cn/html/UploadPic/2012-1/20121421514095270.jpg",
            "http://img4.duitang.com/uploads/item/201304/03/20130403233528_Nrsvy.jpeg",
            "http://cdn.duitang.com/uploads/item/201412/07/20141207100539_euAaZ.jpeg",
            "http://d.hiphotos.baidu.com/zhidao/pic/item/bd315c6034a85edfd6e28aea48540923dc547588.jpg",
            "http://heilongjiang.sinaimg.cn/2015/0403/U9108P1274DT20150403094506.jpg",
            "http://e.hiphotos.baidu.com/zhidao/pic/item/0df3d7ca7bcb0a468e6e79c46b63f6246a60affb.jpg",
            "http://img2.duitang.com/uploads/item/201209/22/20120922224106_VhEcZ.jpeg",
            "http://www.taiwan.cn/xwzx/gj/201411/W020141125552101380638.jpg",
            "http://img2.duitang.com/uploads/item/201301/01/20130101215345_AULZn.jpeg",
            "http://img4.duitang.com/uploads/item/201312/07/20131207165636_8e3hu.thumb.700_0.jpeg",
            "http://photocdn.sohu.com/20130327/Img370649936.jpg",
            "http://imgsrc.baidu.com/forum/pic/item/0ff41bd5ad6eddc4252ee20039dbb6fd5366337b.jpg",
            "http://imgsrc.baidu.com/forum/pic/item/9345d688d43f8794908be180d21b0ef41bd53a23.jpg",
            "http://imgsrc.baidu.com/forum/pic/item/c26bb351f8198618e36c1e6c4aed2e738ad4e6a4.jpg",
            "http://imgsrc.baidu.com/forum/pic/item/e850352ac65c103879eacc84b2119313b17e89db.jpg",
            "http://img5.duitang.com/uploads/item/201411/19/20141119185103_3tCVV.jpeg",
            "http://imgsrc.baidu.com/forum/pic/item/01bf38c79f3df8dc5a897e79cd11728b46102816.jpg",
            "http://imgsrc.baidu.com/forum/pic/item/a044ad345982b2b7955d265931adcbef77099b68.jpg",
            "http://www.beifuni.com/uploadfile/2015/0330/20150330075520989.jpg",
            "http://img4.duitang.com/uploads/item/201209/19/20120919132359_5jwUN.jpeg",
            "http://img4.duitang.com/uploads/item/201403/25/20140325151725_Vjtad.jpeg",
            "http://imgsrc.baidu.com/forum/pic/item/cdbf6c81800a19d877e0508533fa828ba71e464b.jpg",
            "http://img4.duitang.com/uploads/item/201403/13/20140313095842_KM4tm.thumb.700_0.jpeg",
            "http://imgsrc.baidu.com/forum/pic/item/8d739145d688d43f688dc92f7d1ed21b0ff43bb3.jpg",
            "http://image.17173.com/bbs/v1/2011/07/24/1311505127380.jpg",
            "http://fujian.people.com.cn/NMediaFile/2014/1125/FOREIGN201411251453000420927426774.jpg",
            "http://cdn.duitang.com/uploads/item/201209/30/20120930132638_WEVf2.jpeg",
            "http://i3.cqnews.net/ent/attachement/jpg/site82/2012-07-26/3110209064072953512.jpg",
            "http://imgsrc.baidu.com/forum/pic/item/cf1b9d16fdfaaf51de62d7448c5494eef11f7a43.jpg",
            "http://imgsrc.baidu.com/forum/pic/item/3bf33a87e950352a070e8e455343fbf2b2118b14.jpg",
            "http://img.67.com/upload/images/2014/01/02/bmllamlhamluZzEzODg2NDE1OTQ=_1.jpg",
            "http://cdn.duitang.com/uploads/item/201306/08/20130608212302_efeRf.thumb.600_0.jpeg",
            "http://img.67.com/upload/images/2013/07/24/bmllamlhamluZzEzNzQ2MzAyNjk=_1.jpg",
            "http://e.hiphotos.baidu.com/zhidao/pic/item/1f178a82b9014a9062511d27ab773912b31bee39.jpg",
            "http://img5.duitang.com/uploads/item/201410/05/20141005232953_ZByRS.jpeg",
            "http://img4.duitang.com/uploads/item/201504/09/20150409H2258_G4MQe.thumb.700_0.jpeg",
            "http://img5q.duitang.com/uploads/item/201507/19/20150719171424_Uckzv.jpeg",
            "http://cdn.duitang.com/uploads/blog/201311/01/20131101212825_Hx34d.jpeg",
            "http://img5q.duitang.com/uploads/item/201407/20/20140720213229_jzjdH.jpeg",
            "http://imgsrc.baidu.com/forum/pic/item/ca1349540923dd54a40722cdd109b3de9c82481b.jpg",
            "http://www.xiaoxiongbizhi.com/wallpapers/__85/1/9/19r0an0jm.jpg",
            "http://www.xiaoxiongbizhi.com/wallpapers/__85/y/w/ywzwdjof0.jpg",
            "http://pic23.nipic.com/20120812/8092962_193710223307_2.jpg",
            "http://pic3.nipic.com/20090626/1147326_144003009_2.jpg",
            "http://img.taopic.com/uploads/allimg/120105/1944-120105124125100.jpg",
            "http://img.taopic.com/uploads/allimg/120105/2014-120105115U136.jpg",
            "http://pic.nipic.com/2008-01-16/200811683222770_2.jpg",
            "http://pic.nipic.com/2007-11-08/200711822354359_2.jpg",
            "http://pic3.nipic.com/20090525/2416945_231841034_2.jpg",
            "http://pic.6188.com/upload_6188s/flashAll/s800/20121126/13539159579wiJPF.jpg",
            "http://pic7.nipic.com/20100428/4131734_110157044032_2.jpg",
            "http://www.sinaimg.cn/dy/slidenews/2_img/2012_22/786_711148_921294.jpg",
            "http://h.hiphotos.baidu.com/zhidao/pic/item/00e93901213fb80eb469f9fc34d12f2eb9389465.jpg",
            "http://images.ali213.net/picfile/pic/2013-01-22/927_p88.jpg",
            "http://i3.hoopchina.com.cn/blogfile/201401/19/BbsImg139012498921145_600*750.jpg",
            "http://a.hiphotos.baidu.com/zhidao/pic/item/a6efce1b9d16fdfae7eab400b48f8c5495ee7b5d.jpg",
            "http://img.taopic.com/uploads/allimg/121114/240498-1211141R14150.jpg",
            "http://www.bz55.com/uploads/allimg/130506/1-130506105I7.jpg",
            "http://images.ali213.net/picfile/pic/2013-01-22/927_p56.jpg",
            "http://www.wallcoo.com/sport/NBA_Warrios_1112/wallpapers/1280x800/curry_bornwarrior.jpg",
            "http://5.26923.com/download/pic/000/334/3f3f8621e7a2e36c08eca8407dcd066c.jpg",
            "http://b.hiphotos.baidu.com/zhidao/pic/item/d0c8a786c9177f3ece25db6471cf3bc79f3d5641.jpg",
            "http://images.ali213.net/picfile/pic/2013-01-22/927_p19.jpg",
            "http://img.taopic.com/uploads/allimg/121118/240505-12111Q9533274.jpg",
            "http://www.sucaitianxia.com/Photo/pic/200910/nbzbs32.jpg",
            "http://pic.6188.com/upload_6188s/flashAll/s800/20101119/1290150940LjRxxj.jpg",
            "http://img.pconline.com.cn/images/upload/upc/tx/wallpaper/1401/06/c0/30337479_1388996545345.jpg",
            "http://img.article.pchome.net/00/31/62/09/pic_lib/wm/hr_05.jpg",
            "http://pic3.bbzhi.com/tiyubizhi/kaiwenjianeitekev/design_sport_502265_11.jpg",
            "http://www.afinance.cn/new/UploadFiles_2266/201312/20131231131156126.jpg",
            "http://a1.att.hudong.com/82/62/01300000239710122122620399472.jpg",
            "http://pic3.nipic.com/20090624/2888748_001522632_2.jpg",
            "http://pic5.nipic.com/20100226/3279936_091345006264_2.jpg",
            "http://news.qiyue.com/uploadfile/2014/1007/20141007091434164.jpg",
            "http://n.sinaimg.cn/top/20160118/MPXi-fxnrahr8460719.jpg",
            "http://pic10.nipic.com/20100928/5878474_220011029659_2.jpg",
            "http://imgsrc.baidu.com/forum/pic/item/730e0cf3d7ca7bcbcbbe73aabe096b63f724a86a.jpg",
            "http://pic7.nipic.com/20100529/1866517_203719583362_2.jpg",
            "http://a1.att.hudong.com/82/62/01300000239710122122620399472.jpg",
            "http://pic3.nipic.com/20090624/2888748_001522632_2.jpg",
            "http://pic5.nipic.com/20100226/3279936_091345006264_2.jpg",
            "http://news.qiyue.com/uploadfile/2014/1007/20141007091434164.jpg",
            "http://n.sinaimg.cn/top/20160118/MPXi-fxnrahr8460719.jpg",
            "http://pic10.nipic.com/20100928/5878474_220011029659_2.jpg",
            "http://imgsrc.baidu.com/forum/pic/item/730e0cf3d7ca7bcbcbbe73aabe096b63f724a86a.jpg",
            "http://pic7.nipic.com/20100529/1866517_203719583362_2.jpg",
            "http://pic3.nipic.com/20090624/2888748_001522632_2.jpg",
            "http://pic5.nipic.com/20100226/3279936_091345006264_2.jpg",
            "http://news.qiyue.com/uploadfile/2014/1007/20141007091434164.jpg",
            "http://n.sinaimg.cn/top/20160118/MPXi-fxnrahr8460719.jpg",
            "http://pic10.nipic.com/20100928/5878474_220011029659_2.jpg",
            "http://imgsrc.baidu.com/forum/pic/item/730e0cf3d7ca7bcbcbbe73aabe096b63f724a86a.jpg",
            "http://pic7.nipic.com/20100529/1866517_203719583362_2.jpg",
            "http://a1.att.hudong.com/82/62/01300000239710122122620399472.jpg",
            "http://pic3.nipic.com/20090624/2888748_001522632_2.jpg",
            "http://pic5.nipic.com/20100226/3279936_091345006264_2.jpg",
            "http://news.qiyue.com/uploadfile/2014/1007/20141007091434164.jpg",
            "http://n.sinaimg.cn/top/20160118/MPXi-fxnrahr8460719.jpg",
            "http://pic10.nipic.com/20100928/5878474_220011029659_2.jpg",
            "http://imgsrc.baidu.com/forum/pic/item/730e0cf3d7ca7bcbcbbe73aabe096b63f724a86a.jpg",
            "http://pic7.nipic.com/20100529/1866517_203719583362_2.jpg"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initView() {
        setContentView(R.layout.activity_net_work);
        netWorkRecyclerView = (RecyclerView) findViewById(R.id.netWorkRecyclerView);
        netWorkRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        netWorkSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.netWorkSwipeRefreshLayout);
        SwipeRefreshLayoutUtil.initStyle(netWorkSwipeRefreshLayout);
    }


    @Override
    protected void setListener() {
        netWorkSwipeRefreshLayout.setOnRefreshListener(onRefreshListener);
        netWorkRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                LinearLayoutManager manager = (LinearLayoutManager) recyclerView.getLayoutManager();
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    int lastVisibleItem = manager.findLastVisibleItemPosition();
                    int totalItemCount = manager.getItemCount();
                    if (lastVisibleItem == (totalItemCount - 1)) {
                        if (!nextPageIsLoading && hasNextPage) {
                            loadMore();
                        }
                    }
                }
            }
        });
    }

    private void loadMore() {
        if (nextPageIsLoading) {
            return;
        }
        pageindex++;
        nextPageIsLoading = true;
        if (DeviceUtil.isOnline(NetWorkActivity.this)) {
            NetWork.getNetWork(path, pageindex, new myCallBack<NewNetWorkModle>() {
                @Override
                public void Success(NewNetWorkModle myNewNetWorkModle) {
                    if (myNewNetWorkModle.getList().size() < pagesize) {
                        hasNextPage = false;
                    } else {
                        hasNextPage = true;
                    }
                    netWorkList.addAll(myNewNetWorkModle.getList());
                    netWorkAdapter.notifyDataSetChanged();
                    nextPageIsLoading = false;
                }

                @Override
                public void Fail(String fail) {
                    dismissLoadDialog();
                    ToastUtil.showWarningToast("数据加载失败", NetWorkActivity.this);
                    nextPageIsLoading = false;
                }
            });
        } else {
            ToastUtil.showWarningToast("请检查网络", NetWorkActivity.this);
            dismissLoadDialog();
        }

    }


    SwipeRefreshLayout.OnRefreshListener onRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {

        @Override
        public void onRefresh() {
            getData();
        }
    };

    @Override
    protected void loadDate() {
        netWorkAdapter = new NetWorkAdapter();
        netWorkRecyclerView.setAdapter(netWorkAdapter);
        getData();
    }

    @Override
    protected void mobclickAgentStart() {

    }

    @Override
    protected void mobclickAgentEnd() {

    }

    private void getData() {
        pageindex = 1;
        showLoadingDialog();
        if (DeviceUtil.isOnline(NetWorkActivity.this)) {
            NetWork.getNetWork(path, pageindex, new myCallBack<NewNetWorkModle>() {
                @Override
                public void Success(NewNetWorkModle newNetWorkModle) {
                    dismissLoadDialog();
                    netWorkList.clear();
                    netWorkList.addAll(newNetWorkModle.getList());
                    if (netWorkList.size() == pagesize) {
                        hasNextPage = true;
                    }
                    netWorkAdapter.notifyDataSetChanged();
                    if (netWorkSwipeRefreshLayout.isRefreshing()) {
                        netWorkSwipeRefreshLayout.setRefreshing(false);
                    }
                }

                @Override
                public void Fail(String fail) {
                    dismissLoadDialog();
                    ToastUtil.showWarningToast("数据加载失败", NetWorkActivity.this);
                    if (netWorkSwipeRefreshLayout.isRefreshing()) {
                        netWorkSwipeRefreshLayout.setRefreshing(false);
                    }
                }
            });
        } else {
            ToastUtil.showWarningToast("请检查网络", NetWorkActivity.this);
            dismissLoadDialog();
        }


    }


    class NetWorkAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        @Override
        public int getItemViewType(int position) {
            if (position == netWorkList.size()) {
                return TYPE_FOOTER;
            } else {
                return TYPE_NORMAL;
            }
        }

        //这里的ViewHolder为RecyclerView.ViewHolder，而不是ViewHolder，否则FootHolder会报错；
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            if (viewType == TYPE_FOOTER) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_loading, parent, false);
                return new FootHolder(view);
            } else {
                View view = LayoutInflater.from(NetWorkActivity.this).inflate(R.layout.item_my_network, parent, false);
                return new ViewHolder(view);
            }
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
            if (position == netWorkList.size()) {
                if (hasNextPage) {
                    ((FootHolder) holder).itemCircularProgressBar.setVisibility(View.VISIBLE);
                    ((FootHolder) holder).itemLoadingTextView.setText("请稍等......");
                } else {
                    ((FootHolder) holder).itemCircularProgressBar.setVisibility(View.GONE);
                    ((FootHolder) holder).itemLoadingTextView.setText("没有更多了");
                }
            } else {
                final NewNetWorkListModle newNetWorkListModle = netWorkList.get(position);
                ((ViewHolder) holder).name.setText(newNetWorkListModle.getSalesMan());
                ((ViewHolder) holder).time.setText(newNetWorkListModle.getT());
                ((ViewHolder) holder).audit.setText(newNetWorkListModle.getStn());
                ((ViewHolder) holder).network.setText(newNetWorkListModle.getSn());
                Picasso.with(NetWorkActivity.this)
                        .load(image[position])
                        .placeholder(R.drawable.b)
                        .error(R.drawable.c)
                        .into(((ViewHolder) holder).imageview);
              ((ViewHolder) holder).imageview.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent();
                        intent.putExtra("imagepath",image[position]);
                        intent.setClass(NetWorkActivity.this,ImageViewActivity.class);
                        startActivity(intent);
                    }
                });
            }
        }


        @Override
        public int getItemCount() {
            return netWorkList.size() > 0 ? netWorkList.size() + 1 : 0;
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView network;
        private TextView audit;
        private TextView time;
        private ImageView imageview;

        public ViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
            network = (TextView) itemView.findViewById(R.id.network);
            audit = (TextView) itemView.findViewById(R.id.audit);
            time = (TextView) itemView.findViewById(R.id.time);
            imageview = (ImageView) itemView.findViewById(R.id.netWorkImageview);
        }
    }

    class FootHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public ProgressBar itemCircularProgressBar;
        public TextView itemLoadingTextView;

        public FootHolder(View v) {
            super(v);
            rootView = v;
            itemCircularProgressBar = (ProgressBar) v.findViewById(R.id.itemCircularProgressBar);
            itemLoadingTextView = (TextView) v.findViewById(R.id.itemLoadingTextView);
        }
    }

}
