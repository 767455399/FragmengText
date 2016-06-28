package com.example.administrator.fragmenttext.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.fragmenttext.LoadDate.NetWork;
import com.example.administrator.fragmenttext.R;
import com.example.administrator.fragmenttext.addresspick.DipConvertUtil;
import com.example.administrator.fragmenttext.addresspick.FullyGriView;
import com.example.administrator.fragmenttext.base.BaseFragment;
import com.example.administrator.fragmenttext.base.myCallBack;
import com.example.administrator.fragmenttext.model.DisplayStandardModle;
import com.example.administrator.fragmenttext.model.NewNetWorkListModle;
import com.example.administrator.fragmenttext.network.DeviceUtil;
import com.example.administrator.fragmenttext.toast.ToastUtil;
import com.example.administrator.fragmenttext.ui.activity.ImageViewActivity;

import java.util.ArrayList;
import java.util.List;

import it.sephiroth.android.library.picasso.Picasso;


/**
 * 项目名称：FragmentText
 * 类描述：
 * 创建人：WangQing
 * 创建时间：2016/1/26 16:03
 * 修改人：WangQing
 * 修改时间：2016/1/26 16:03
 * 修改备注：
 */
public class NetworkInformationFragment extends Fragment {
    private String path = "http://www.jutongbao.com/jtb/phone/articlereader_list.action?companyCode=05710001&userId=d4cd4ae1-a4ce-4ae8-81cc-fcce8f854942";
    private RecyclerView mynetworkRecyclerView;
    private NetworkInformationAdapter networkInformationAdapter;
    private View view;
    private ServiceAdapter serviceAdapter;
    private int pageindex;
    private List<DisplayStandardModle.TypeListModle> typeList = new ArrayList<DisplayStandardModle.TypeListModle>();
    private List<List<String>> dataList = new ArrayList<List<String>>();
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
            "http://n.sinaimg.cn/top/20160118/MPXi-fxnrahr8460719.jpg",
            "http://pic10.nipic.com/20100928/5878474_220011029659_2.jpg",
            "http://imgsrc.baidu.com/forum/pic/item/730e0cf3d7ca7bcbcbbe73aabe096b63f724a86a.jpg",
            "http://pic7.nipic.com/20100529/1866517_203719583362_2.jpg"};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_network_information, container, false);
        initView();
        loadData();
        return view;
    }

    private void loadData() {
        if (DeviceUtil.isOnline(getActivity())) {
            NetWork.getNetWorkInformation(path, new myCallBack<DisplayStandardModle>() {
                @Override
                public void Success(DisplayStandardModle displayStandardModle) {
                    typeList.addAll(displayStandardModle.getTypeList());
                    networkInformationAdapter.notifyDataSetChanged();
                }

                @Override
                public void Fail(String fail) {
                    ToastUtil.showWarningToast("获取网络数据失败", getActivity());
                }
            });
        } else {
            ToastUtil.showWarningToast("请检查网络", getActivity());
        }

    }

    private void initView() {
        mynetworkRecyclerView = (RecyclerView) view.findViewById(R.id.mynetworkRecyclerView);
        mynetworkRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        networkInformationAdapter = new NetworkInformationAdapter();
        mynetworkRecyclerView.setAdapter(networkInformationAdapter);
    }

    class NetworkInformationAdapter extends RecyclerView.Adapter<ViewHolder> {
        View view;

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            view = LayoutInflater.from(getActivity()).inflate(R.layout.item_network_information, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            final DisplayStandardModle.TypeListModle typeListModle = typeList.get(position);
            holder.id.setText("id:" + typeListModle.getId());
            holder.typeName.setText("标题:" + typeListModle.getTypeName());
            serviceAdapter = new ServiceAdapter();
            //holder.indexServiceGriView.setAdapter(serviceAdapter,holder.indexServiceGriView.getWidth()/4);
            holder.indexServiceGriView.setAdapter(serviceAdapter, 250);
            holder.indexServiceGriView.setOnItemClickListener(new FullyGriView.OnItemClickListener() {
                @Override
                public void onClick(int position) {
                    Intent intent = new Intent();
                    intent.putExtra("imagepath", image[position]);
                    intent.setClass(getActivity(), ImageViewActivity.class);
                    startActivity(intent);
                }
            });
            //      holder.imageViewRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(),3));


        }

        @Override
        public int getItemCount() {
            return typeList.size();
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView id;
        private TextView typeName;
        private FullyGriView indexServiceGriView;
        //   private RecyclerView imageViewRecyclerView;

        public ViewHolder(View itemView) {
            super(itemView);
            id = (TextView) itemView.findViewById(R.id.id);
            typeName = (TextView) itemView.findViewById(R.id.typeName);
            indexServiceGriView = (FullyGriView) itemView.findViewById(R.id.indexServiceGriView);
        }
    }

    class ServiceAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return typeList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = LayoutInflater.from(getActivity()).inflate(R.layout.item_index_service, parent, false);
            }
            ImageView itemIndexServiceImageView = (ImageView) convertView.findViewById(R.id.itemIndexServiceImageView);
            int size = DipConvertUtil.dip2px(getActivity(), 40f);
            Picasso.with(getActivity()).load(image[position]).error(R.drawable.b).placeholder(R.drawable.c).into(itemIndexServiceImageView);
            return convertView;
        }
    }
}
