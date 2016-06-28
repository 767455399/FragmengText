package cn.pocketwallet.pocketwallet.ui.activity.common;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.umeng.analytics.MobclickAgent;

import java.util.ArrayList;

import cn.pocketwallet.pocketwallet.R;
import cn.pocketwallet.pocketwallet.base.BaseActivity;
import cn.pocketwallet.pocketwallet.model.LocalContactModel;
import cn.pocketwallet.pocketwallet.util.ContactsUtil;
import fr.castorflex.android.circularprogressbar.CircularProgressBar;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * 读取手机通讯录
 */

public class ContactsListActivity extends BaseActivity {

    private static final String TAG = "ContactsListActivity";


    private RecyclerView contactsListRecyclerView;
    private CircularProgressBar contactsListCircularProgressBar;


    private ArrayList<LocalContactModel> contactModels = new ArrayList<>();
    private ContactsListAdapter contactsListAdapter;


    @Override
    protected void initViews() {
        setContentView(R.layout.activity_contacts_list);
        contactsListRecyclerView = (RecyclerView) findViewById(R.id.contactsListRecyclerView);

        contactsListCircularProgressBar = (CircularProgressBar) findViewById(R.id.contactsListCircularProgressBar);

        contactsListRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        contactsListAdapter = new ContactsListAdapter();
        contactsListRecyclerView.setAdapter(contactsListAdapter);

        contactsListRecyclerView.setVisibility(View.GONE);
        contactsListCircularProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    protected void setListeners() {

    }

    @Override
    protected void loadData() {
        loadContactList();
    }

    private void loadContactList() {
        Observable.create(new Observable.OnSubscribe<Void>() {
            @Override
            public void call(Subscriber<? super Void> subscriber) {
                contactModels.clear();
                contactModels.addAll(ContactsUtil.getContactList());
                subscriber.onNext(null);
                subscriber.onCompleted();
            }
        })
                .subscribeOn(Schedulers.io()) // 指定 subscribe() 发生在 IO 线程
                .observeOn(AndroidSchedulers.mainThread()) // 指定 Subscriber 的回调发生在主线程
                .subscribe(new Subscriber<Void>() {
                    @Override
                    public void onCompleted() {
                        contactsListRecyclerView.setVisibility(View.VISIBLE);
                        contactsListCircularProgressBar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Void v) {
                        contactsListAdapter.notifyDataSetChanged();
                    }
                });
    }


    private class ContactsListAdapter extends RecyclerView.Adapter<ViewHolder> {


        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contacts_list, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {

            final LocalContactModel localContactModel = contactModels.get(position);
            holder.contactsListItemNameTextView.setText(localContactModel.getName());
            holder.contactsListItemNumberTextView.setText(localContactModel.getPhone());

            holder.rootView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }

        @Override
        public int getItemCount() {
            return contactModels.size();
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public TextView contactsListItemNameTextView;
        public TextView contactsListItemNumberTextView;

        public ViewHolder(View v) {
            super(v);
            rootView = v;
            contactsListItemNameTextView = (TextView) v.findViewById(R.id.contactsListItemNameTextView);
            contactsListItemNumberTextView = (TextView) v.findViewById(R.id.contactsListItemNumberTextView);
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
