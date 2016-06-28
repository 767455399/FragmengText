package com.example.administrator.fragmenttext.ui.adapter;

import android.os.CountDownTimer;
import android.widget.Button;

/**
 * 项目名称：FragmentText
 * 类描述：
 * 创建人：WangQing
 * 创建时间：2015/12/15 14:09
 * 修改人：WangQing
 * 修改时间：2015/12/15 14:09
 * 修改备注：
 */
public class CountDown extends CountDownTimer{
    private Button button;
    /**
     * @param millisInFuture    The number of millis in the future from the call
     *                          to {@link #start()} until the countdown is done and {@link #onFinish()}
     *                          is called.
     * @param countDownInterval The interval along the way to receive
     *                          {@link #onTick(long)} callbacks.
     */
   /* 总倒计时：millisInFuture
      执行间隔：countDownInterval*/
    public CountDown(long millisInFuture, long countDownInterval,Button button) {
        super(millisInFuture, countDownInterval);
        this.button=button;
    }
  /*  执行倒计时*/

    @Override
    public void onTick(long millisUntilFinished) {
        button.setEnabled(false);
        button.setText((millisUntilFinished/1000)+"秒后重新发送");
    }
    /*倒计时结束时调用*/
    @Override
    public void onFinish() {
        button.setEnabled(true);
        button.setText("重发验证码");
    }
}
