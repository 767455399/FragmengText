package cn.pocketwallet.pocketwallet.ui.activity.common;

import android.content.Intent;
import android.os.Handler;
import android.util.Log;

import java.util.List;

import cn.pocketwallet.pocketwallet.R;
import cn.pocketwallet.pocketwallet.base.BaseActivity;
import cn.pocketwallet.pocketwallet.widget.PatternView;

public class PatternActivity extends BaseActivity {


    private PatternView patternView;

    private String correctPattern = "123456789";


    @Override
    protected void initViews() {
        setContentView(R.layout.activity_pattern);
        patternView = (PatternView) findViewById(R.id.patternView);
        patternView.setOnPatternListener(new PatternView.OnPatternListener() {
            @Override
            public void onPatternDetected(List<PatternView.Cell> pattern, String simplePattern) {
                Log.e("simplePattern", simplePattern);
                if (!simplePattern.equals(correctPattern)) {
                    patternView.setDisplayMode(PatternView.DisplayMode.Wrong);
                } else {
                    doOnCorrect();
                }
                super.onPatternDetected(pattern, simplePattern);
            }
        });
    }

    @Override
    protected void setListeners() {

    }

    @Override
    protected void loadData() {

    }

    private void doOnCorrect() {
        patternView.setEnabled(false);
        patternView.setDisplayMode(PatternView.DisplayMode.Correct);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                patternView.setEnabled(true);
                finish();
            }
        }, 300);
    }


    @Override
    public void onBackPressed() {
        Intent home = new Intent(Intent.ACTION_MAIN);
        home.addCategory(Intent.CATEGORY_HOME);
        startActivity(home);
    }
}
