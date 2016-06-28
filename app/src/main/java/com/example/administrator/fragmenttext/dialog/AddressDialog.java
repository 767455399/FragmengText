package com.example.administrator.fragmenttext.dialog;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.view.Window;
import android.widget.Toast;

import com.example.administrator.fragmenttext.R;
import com.example.administrator.fragmenttext.addresspick.PlacePickerUI;
import com.example.administrator.fragmenttext.addresspick.Province;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目名称：FragmentText
 * 类描述：
 * 创建人：WangQing
 * 创建时间：2016/3/9 13:59
 * 修改人：WangQing
 * 修改时间：2016/3/9 13:59
 * 修改备注：
 */
public class AddressDialog {
    private Context mContext;
    /* private List<String> provinces;
     private List<String> cities;
     private List<String> counties;*/
    List<Province> data = new ArrayList<>();

    public void parseJson(String jsonData, Context context) {
        mContext = context;

        try {
            JSONArray jsonArray = new JSONArray(jsonData);
            for (int i = 0; i < jsonArray.length(); i++) {
                Province province = new Gson().fromJson(jsonArray.get(i).toString(), Province.class);
                data.add(province);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        android.util.Log.d("ljx", data.get(1).getName());
    }

    public void showDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        AlertDialog dialog = builder.create();
        dialog.show();
        Window window = dialog.getWindow();
        window.setContentView(R.layout.dialog_place_picker);

        PlacePickerUI mPickerUI = (PlacePickerUI) window.findViewById(R.id.place_picker);

       /* provinces = Arrays.asList(getResources().getStringArray(R.array.countries_array));
        cities = Arrays.asList(getResources().getStringArray(R.array.city_array));
        counties = Arrays.asList(getResources().getStringArray(R.array.county_array));*/

        mPickerUI.setOnClickItemPickerUIListener(
                new PlacePickerUI.PlacePickerUIItemClickListener() {

                    @Override
                    public void onItemClickPickerUI(int which, int position, String valueResult) {
                        Toast.makeText(mContext, valueResult + "第" + which + "列", Toast.LENGTH_SHORT).show();
                    }
                });

        mPickerUI.bindData(mContext, data);
        dialog.show();
    }

}
