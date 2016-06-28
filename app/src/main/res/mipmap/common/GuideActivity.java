package cn.pocketwallet.pocketwallet.ui.activity.common;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jack.anim.JackAnim;
import com.jack.anim.Techniques;
import com.jack.anim.circualreveal.SupportAnimator;
import com.umeng.analytics.MobclickAgent;

import cn.pocketwallet.pocketwallet.R;
import cn.pocketwallet.pocketwallet.api.common.AppApi;
import cn.pocketwallet.pocketwallet.base.BaseActivity;
import cn.pocketwallet.pocketwallet.util.ColorAnimationUtil;
import cn.pocketwallet.pocketwallet.util.RevealAnimUtil;
import rx.Subscriber;


public class GuideActivity extends BaseActivity {

    private static final String TAG = "GuideActivity";

    private static final int BACKGROUND_ANIM_DURATION = 1000;
    private static final int TEXT_ANIM_DURATION_SHORT = 400;
    private static final int TEXT_ANIM_DURATION_NORMAL = 600;
    private static final int TEXT_ANIM_DURATION_LONG = 800;
    private static final int TEXT_COLOR_ANIM_DURATION = 800;
    private static final int REVEAL_ANIM_DURATION = 600;


    private ViewPager guideViewPager;
    private RelativeLayout guideCircleRelativeLayout;
    private RelativeLayout guideCircleTextRelativeLayout;
    private View rootAnimColorView;

    private TextView guideAnim1TextView;
    private TextView guideAnim2TextView;

    private View indicator1;
    private View indicator2;
    private View indicator3;
    private View indicator4;
    private TextView guideCircleTextView;


    private RelativeLayout guideLastRelativeLayout;

    private TextView guideLastTextView1;
    private TextView guideLastTextView2;
    private TextView guideLastTextView3;
    private TextView guideLastTextView4;


    private ProgressBar guideProgressBar;


    private View lastTriangleView1;
    private View lastTriangleView2;

    private SupportAnimator supportAnimator;


    @Override
    protected void initViews() {
        setContentView(R.layout.activity_guide);


        guideViewPager = (ViewPager) findViewById(R.id.guideViewPager);
        guideCircleTextView = (TextView) findViewById(R.id.guideCircleTextView);
        guideAnim1TextView = (TextView) findViewById(R.id.guideAnim1TextView);
        guideAnim2TextView = (TextView) findViewById(R.id.guideAnim2TextView);
        guideCircleRelativeLayout = (RelativeLayout) findViewById(R.id.guideCircleRelativeLayout);
        guideCircleTextRelativeLayout = (RelativeLayout) findViewById(R.id.guideCircleTextRelativeLayout);
        rootAnimColorView = findViewById(R.id.rootAnimColorView);
        indicator1 = findViewById(R.id.indicator1);
        indicator2 = findViewById(R.id.indicator2);
        indicator3 = findViewById(R.id.indicator3);
        indicator4 = findViewById(R.id.indicator4);


        guideLastRelativeLayout = (RelativeLayout) findViewById(R.id.guideLastRelativeLayout);

        guideProgressBar = (ProgressBar) findViewById(R.id.guideProgressBar);
        guideProgressBar.setMax(1000);

        guideLastRelativeLayout.setAlpha(0);


        guideLastTextView1 = (TextView) findViewById(R.id.guideLastTextView1);
        guideLastTextView2 = (TextView) findViewById(R.id.guideLastTextView2);
        guideLastTextView3 = (TextView) findViewById(R.id.guideLastTextView3);
        guideLastTextView4 = (TextView) findViewById(R.id.guideLastTextView4);


        lastTriangleView1 = findViewById(R.id.lastTriangleView1);
        lastTriangleView2 = findViewById(R.id.lastTriangleView2);

//        GuideCircularAnimUtil anim1 = new GuideCircularAnimUtil(80, 40, new WeakReference<View>(guideCircleRelativeLayout));
//        anim1.startAnim();
//        GuideCircularAnimUtil anim2 = new GuideCircularAnimUtil(40, 40, new WeakReference<View>(guideCircleTextRelativeLayout));
//        anim2.startAnim();
        animText(getString(R.string.guide_text_1), guideAnim1TextView, TEXT_ANIM_DURATION_NORMAL);
        animText(getString(R.string.guide_text_4), guideAnim2TextView, TEXT_ANIM_DURATION_LONG);
    }

    @Override
    protected void setListeners() {
        guideViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                doOnPageSelected(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void doOnPageSelected(int position) {
        switch (position) {
            case 0:
                animText(getString(R.string.whenever), guideCircleTextView, TEXT_ANIM_DURATION_SHORT);
                animText(getString(R.string.guide_text_1), guideAnim1TextView, TEXT_ANIM_DURATION_NORMAL);
                animText(getString(R.string.guide_text_4), guideAnim2TextView, TEXT_ANIM_DURATION_LONG);
                ColorAnimationUtil.animBackgroundColorTo(Color.parseColor("#FFFF6766"), BACKGROUND_ANIM_DURATION, rootAnimColorView);
                ColorAnimationUtil.animBackgroundColorTo(Color.parseColor("#CCFFFFFF"), BACKGROUND_ANIM_DURATION, indicator1);
                ColorAnimationUtil.animBackgroundColorTo(Color.parseColor("#33FFFFFF"), BACKGROUND_ANIM_DURATION, indicator2);
                ColorAnimationUtil.animBackgroundColorTo(Color.parseColor("#33FFFFFF"), BACKGROUND_ANIM_DURATION, indicator3);
                ColorAnimationUtil.animBackgroundColorTo(Color.parseColor("#33FFFFFF"), BACKGROUND_ANIM_DURATION, indicator4);
                break;
            case 1:
                animText(getString(R.string.however), guideCircleTextView, TEXT_ANIM_DURATION_SHORT);
                animText(getString(R.string.guide_text_2), guideAnim1TextView, TEXT_ANIM_DURATION_NORMAL);
                animText(getString(R.string.guide_text_5), guideAnim2TextView, TEXT_ANIM_DURATION_LONG);
                ColorAnimationUtil.animBackgroundColorTo(Color.parseColor("#FFEFBC47"), BACKGROUND_ANIM_DURATION, rootAnimColorView);
                ColorAnimationUtil.animBackgroundColorTo(Color.parseColor("#33FFFFFF"), BACKGROUND_ANIM_DURATION, indicator1);
                ColorAnimationUtil.animBackgroundColorTo(Color.parseColor("#CCFFFFFF"), BACKGROUND_ANIM_DURATION, indicator2);
                ColorAnimationUtil.animBackgroundColorTo(Color.parseColor("#33FFFFFF"), BACKGROUND_ANIM_DURATION, indicator3);
                ColorAnimationUtil.animBackgroundColorTo(Color.parseColor("#33FFFFFF"), BACKGROUND_ANIM_DURATION, indicator4);
                break;
            case 2:
                animText(getString(R.string.whatever), guideCircleTextView, TEXT_ANIM_DURATION_SHORT);
                animText(getString(R.string.guide_text_3), guideAnim1TextView, TEXT_ANIM_DURATION_NORMAL);
                animText(getString(R.string.guide_text_6), guideAnim2TextView, TEXT_ANIM_DURATION_LONG);
                ColorAnimationUtil.animBackgroundColorTo(Color.parseColor("#FF4EDDAA"), BACKGROUND_ANIM_DURATION, rootAnimColorView);
                ColorAnimationUtil.animBackgroundColorTo(Color.parseColor("#33FFFFFF"), BACKGROUND_ANIM_DURATION, indicator1);
                ColorAnimationUtil.animBackgroundColorTo(Color.parseColor("#33FFFFFF"), BACKGROUND_ANIM_DURATION, indicator2);
                ColorAnimationUtil.animBackgroundColorTo(Color.parseColor("#CCFFFFFF"), BACKGROUND_ANIM_DURATION, indicator3);
                ColorAnimationUtil.animBackgroundColorTo(Color.parseColor("#33FFFFFF"), BACKGROUND_ANIM_DURATION, indicator4);
                break;
            case 3:
                guideViewPager.setVisibility(View.INVISIBLE);
                reveal();
                break;
        }
    }

    @Override
    protected void loadData() {
        guideViewPager.setAdapter(new GuideAdapter());
    }


    class GuideAdapter extends PagerAdapter {

        public GuideAdapter() {

        }

        @Override
        public int getCount() {
            return 4;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view.equals(object);
        }

        @Override
        public void destroyItem(ViewGroup view, int position, Object object) {
            view.removeView((View) object);
        }

        @Override
        public Object instantiateItem(ViewGroup view, int position) {
            View imageLayout = LayoutInflater.from(cn.pocketwallet.pocketwallet.ui.activity.common.GuideActivity.this).inflate(R.layout.item_guide_pager, view, false);
            view.addView(imageLayout, 0);
            return imageLayout;
        }
    }


    private void riseProgressBar() {
        ValueAnimator anim = ObjectAnimator.ofInt(0, 1000);
        anim.setInterpolator(new AccelerateDecelerateInterpolator());
        anim.setStartDelay(400);
        anim.setDuration(1000);
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int progress = ((Integer) animation.getAnimatedValue());
                guideProgressBar.setProgress(progress);
                if (progress == 1000) {
                    reduceProgressBar();
                }
            }
        });
        anim.start();
    }

    private void reduceProgressBar() {
        ValueAnimator anim = ObjectAnimator.ofInt(1000, 900);
        anim.setInterpolator(new DecelerateInterpolator());
        anim.setDuration(800);
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int progress = ((Integer) animation.getAnimatedValue());
                guideProgressBar.setProgress(progress);
            }
        });
        anim.start();
    }


    private void reveal() {
        guideProgressBar.setProgress(0);
        lastTriangleView1.setAlpha(0);
        lastTriangleView2.setAlpha(0);
        guideLastTextView1.setText("");
        guideLastTextView2.setText("");
        guideLastTextView3.setText("");
        guideLastTextView4.setText("");
        guideLastRelativeLayout.setAlpha(1f);

        int centerX = (guideLastRelativeLayout.getLeft() + guideLastRelativeLayout.getRight()) / 2;
        int centerY = (guideLastRelativeLayout.getTop() + guideLastRelativeLayout.getBottom()) / 4;
        int endRadius = Math.max(guideLastRelativeLayout.getWidth(), guideLastRelativeLayout.getHeight());

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Animator animator = RevealAnimUtil.getRevealAnimator(guideLastRelativeLayout, centerX, centerY, 0, endRadius);
            animator.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    doAfterReveal();
                }
            });
            animator.setDuration(REVEAL_ANIM_DURATION);
            animator.start();
        } else {
            supportAnimator = RevealAnimUtil.getSupportRevealAnimator(guideLastRelativeLayout, centerX, centerY, 0, endRadius);
            supportAnimator.addListener(new SupportAnimator.AnimatorListener() {
                @Override
                public void onAnimationStart() {

                }

                @Override
                public void onAnimationEnd() {
                    doAfterReveal();
                }

                @Override
                public void onAnimationCancel() {

                }

                @Override
                public void onAnimationRepeat() {

                }
            });
            supportAnimator.setDuration(REVEAL_ANIM_DURATION);
            supportAnimator.start();
        }
    }


    private void doAfterReveal() {
        animText(getString(R.string.guide_text_7), guideLastTextView1, TEXT_ANIM_DURATION_NORMAL);
        animText(getString(R.string.guide_text_8), guideLastTextView2, TEXT_ANIM_DURATION_NORMAL);
        animText(getString(R.string.guide_text_9), guideLastTextView3, TEXT_ANIM_DURATION_LONG);
        animText(getString(R.string.guide_text_10), guideLastTextView4, TEXT_ANIM_DURATION_LONG);
        riseProgressBar();

        Animation animation1 = AnimationUtils.loadAnimation(cn.pocketwallet.pocketwallet.ui.activity.common.GuideActivity.this, R.anim.in_from_top_right);
        Animation animation2 = AnimationUtils.loadAnimation(cn.pocketwallet.pocketwallet.ui.activity.common.GuideActivity.this, R.anim.in_from_bottom_right);
        animation1.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                lastTriangleView1.setAlpha(1f);
            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        animation2.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                lastTriangleView2.setAlpha(1f);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        AppApi.setHasBooted(new Subscriber<Void>() {
                            @Override
                            public void onCompleted() {
                                startActivity(new Intent(cn.pocketwallet.pocketwallet.ui.activity.common.GuideActivity.this, MainActivity.class));
                                cn.pocketwallet.pocketwallet.ui.activity.common.GuideActivity.this.finish();
                            }

                            @Override
                            public void onError(Throwable e) {
                                startActivity(new Intent(cn.pocketwallet.pocketwallet.ui.activity.common.GuideActivity.this, MainActivity.class));
                                cn.pocketwallet.pocketwallet.ui.activity.common.GuideActivity.this.finish();
                            }

                            @Override
                            public void onNext(Void aVoid) {

                            }
                        });
                    }
                }, 600);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        lastTriangleView1.startAnimation(animation1);
        lastTriangleView2.startAnimation(animation2);
    }


    private void animText(final String text, final TextView textView, final long duration) {
        JackAnim.with(Techniques.FadeOutUp).duration(duration).withListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                textView.setText(text);
                JackAnim.with(Techniques.FadeInUp).duration(duration).withListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {

                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                }).playOn(textView);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        }).playOn(textView);
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
