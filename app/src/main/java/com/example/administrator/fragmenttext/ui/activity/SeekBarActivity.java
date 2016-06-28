package com.example.administrator.fragmenttext.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import com.example.administrator.fragmenttext.R;
import com.example.administrator.fragmenttext.base.BaseActivity;

import org.adw.library.widgets.discreteseekbar.DiscreteSeekBar;

public class SeekBarActivity extends BaseActivity {
    private TextView byStagesDiscreteTextView;
    private TextView amountOfMoneyDiscreteTextView;
    public DiscreteSeekBar byStagesDiscreteSeekBar;
    public DiscreteSeekBar amountOfMoneyDiscreteSeekBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void initView() {
        setContentView(R.layout.activity_seek_bar);
        byStagesDiscreteSeekBar=(DiscreteSeekBar)findViewById(R.id.byStagesDiscreteSeekBar);
        byStagesDiscreteTextView=(TextView)findViewById(R.id.byStagesDiscreteTextView);
        byStagesDiscreteSeekBar.setIndicatorPopupEnabled(false);
        amountOfMoneyDiscreteSeekBar=(DiscreteSeekBar)findViewById(R.id.amountOfMoneyDiscreteSeekBar);
        amountOfMoneyDiscreteSeekBar.setIndicatorPopupEnabled(false);
    }

    @Override
    protected void setListener() {
        byStagesDiscreteSeekBar.setOnProgressChangeListener(new DiscreteSeekBar.OnProgressChangeListener() {
            @Override
            public void onProgressChanged(DiscreteSeekBar seekBar, int i, boolean fromUser) {
                int periods = i;
                int average = (10)*periods;
                int m=Integer.parseInt(average+"");
                byStagesDiscreteTextView.setText(i+"");
                amountOfMoneyDiscreteSeekBar.setProgress(m);
            }

            @Override
            public void onStartTrackingTouch(DiscreteSeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(DiscreteSeekBar seekBar) {

            }
        });

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
}
