package com.example.administrator.fragmenttext.maillist;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SectionIndexer;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.fragmenttext.R;
import com.example.administrator.fragmenttext.toast.ToastUtil;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MailListActivity extends Activity {
    private RecyclerView sortListView;
    private SideBar sideBar;
    private TextView dialog;
    private mySortAdapter adapter;
    private EditText mClearEditText;

    /**
     * 汉字转换成拼音的类
     */
    private CharacterParser characterParser;
    private List<SortModel> SourceDateList;

    /**
     * 根据拼音来排列ListView里面的数据类
     */
    private PinyinComparator pinyinComparator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mail_list);
        initViews();
    }

    private void initViews() {
        // 实例化汉字转拼音类
        characterParser = CharacterParser.getInstance();

        pinyinComparator = new PinyinComparator();

        sideBar = (SideBar) findViewById(R.id.sidrbar);
        dialog = (TextView) findViewById(R.id.dialog);
        sideBar.setTextView(dialog);

        // 设置右侧触摸监听
        sideBar.setOnTouchingLetterChangedListener(new SideBar.OnTouchingLetterChangedListener() {

            @Override
            public void onTouchingLetterChanged(String s) {
                // 该字母首次出现的位置
                int position = adapter.getPositionForSection(s.charAt(0));
                if (position != -1) {
                    //  sortListView.setSelection(position);
//                    sortListView.smoothScrollToPosition(23);
                    // sortListView.scrollToPosition(position);
                    sortListView.getLayoutManager().scrollToPosition(position);
                    //                   LinearLayoutManager linearLayoutManager=new LinearLayoutManager().scrollToPositionWithOffset(position,0);
                }

            }
        });

        sortListView = (RecyclerView) findViewById(R.id.country_lvcountry);
        sortListView.setLayoutManager(new LinearLayoutManager(this));
       /* sortListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // 这里要利用adapter.getItem(position)来获取当前position所对应的对象
                Toast.makeText(getApplication(),
                        ((SortModel) adapter.getItem(position)).getName(),
                        Toast.LENGTH_SHORT).show();
            }
        });*/

        SourceDateList = filledData(getResources().getStringArray(R.array.date));

        // 根据a-z进行排序源数据
        Collections.sort(SourceDateList, pinyinComparator);
        adapter = new mySortAdapter();
        sortListView.setAdapter(adapter);

        mClearEditText = (EditText) findViewById(R.id.filter_edit);

        // 根据输入框输入值的改变来过滤搜索
        mClearEditText.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                // 当输入框里面的值为空，更新为原来的列表，否则为过滤数据列表
                filterData(s.toString());
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {

            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    /**
     * 为ListView填充数据
     *
     * @param date
     * @return
     */
    private List<SortModel> filledData(String[] date) {
        List<SortModel> mSortList = new ArrayList<SortModel>();

        for (int i = 0; i < date.length; i++) {
            SortModel sortModel = new SortModel();
            sortModel.setName(date[i]);
            // 汉字转换成拼音
            String pinyin = characterParser.getSelling(date[i]);
            String sortString = pinyin.substring(0, 1).toUpperCase();
            // 正则表达式，判断首字母是否是英文字母
            if (sortString.matches("[A-Z]")) {
                sortModel.setSortLetters(sortString.toUpperCase());
            } else {
                sortModel.setSortLetters("#");
            }

            mSortList.add(sortModel);
        }
        return mSortList;

    }

    /**
     * 根据输入框中的值来过滤数据并更新ListView
     *
     * @param filterStr
     */
    private void filterData(String filterStr) {
        List<SortModel> filterDateList = new ArrayList<SortModel>();

        if (TextUtils.isEmpty(filterStr)) {
            SourceDateList = filledData(getResources().getStringArray(R.array.date));
            filterDateList = SourceDateList;
        } else {
            filterDateList.clear();
            for (SortModel sortModel : SourceDateList) {
                String name = sortModel.getName();
                if (name.indexOf(filterStr.toString()) != -1
                        || characterParser.getSelling(name).startsWith(
                        filterStr.toString())) {
                    filterDateList.add(sortModel);
                }
            }
        }

        // 根据a-z进行排序
        Collections.sort(filterDateList, pinyinComparator);
        adapter.updateListView(filterDateList);
 //       adapter.notifyDataSetChanged();
    }


    class mySortAdapter extends RecyclerView.Adapter<ViewHolder> implements SectionIndexer {
        public void updateListView(List<SortModel> list) {
          /*  SourceDateList.clear();*/
            SourceDateList = list;
            notifyDataSetChanged();
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(MailListActivity.this).inflate(R.layout.item, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, final int position) {
            // 根据position获取分类的首字母的Char ascii值
            int section = getSectionForPosition(position);
            // 如果当前位置等于该分类首字母的Char的位置 ，则认为是第一次出现
            if (position == getPositionForSection(section)) {
                holder.tvLetter.setVisibility(View.VISIBLE);
                holder.tvLetter.setText(SourceDateList.get(position).getSortLetters().toString());
                holder.topLineView.setVisibility(View.VISIBLE);
            } else {
                holder.tvLetter.setVisibility(View.GONE);
                holder.bottomLineView.setVisibility(View.GONE);
                holder.bottomLineView.setVisibility(View.VISIBLE);
                holder.topLineView.setVisibility(View.GONE);
            }

            holder.tvTitle.setText(SourceDateList.get(position).getName().toString());
            holder.tvTitle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ToastUtil.showSuccessToast(SourceDateList.get(position).getName().toString(), MailListActivity.this);
                }
            });
        }

        @Override
        public int getItemCount() {
            return SourceDateList.size();
        }

        @Override
        public Object[] getSections() {
            return new Object[0];
        }

        /**
         * 根据分类的首字母的Char ascii值获取其第一次出现该首字母的位置
         */
        @Override
        public int getPositionForSection(int section) {
            for (int i = 0; i < SourceDateList.size(); i++) {
                String sortStr = SourceDateList.get(i).getSortLetters();
                char firstChar = sortStr.toUpperCase().charAt(0);
                if (firstChar == section) {
                    return i;
                }
            }

            return -1;
        }

        /**
         * 根据ListView的当前位置获取分类的首字母的Char ascii值
         */
        @Override
        public int getSectionForPosition(int position) {
            return SourceDateList.get(position).getSortLetters().charAt(0);
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvLetter;
        TextView tvTitle;
        ImageView topLineView;
        ImageView theMiddleline;
        ImageView splitLineView;
        ImageView bottomLineView;

        public ViewHolder(View itemView) {
            super(itemView);
            tvTitle = (TextView) itemView.findViewById(R.id.title);
            tvLetter = (TextView) itemView.findViewById(R.id.catalog);
            topLineView = (ImageView) itemView.findViewById(R.id.topLineView);
            theMiddleline = (ImageView) itemView.findViewById(R.id.theMiddleline);
            splitLineView = (ImageView) itemView.findViewById(R.id.splitLineView);
            bottomLineView = (ImageView) itemView.findViewById(R.id.bottomLineView);
        }
    }
}