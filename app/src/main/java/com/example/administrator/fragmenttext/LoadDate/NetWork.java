package com.example.administrator.fragmenttext.LoadDate;

import android.os.Handler;
import android.os.Looper;

import com.example.administrator.fragmenttext.base.myCallBack;
import com.example.administrator.fragmenttext.model.CheckWorkAttendanceModle;
import com.example.administrator.fragmenttext.model.DisplayStandardModle;
import com.example.administrator.fragmenttext.model.FamousQuotesModle;
import com.example.administrator.fragmenttext.model.MMMNetWorkModle;
import com.example.administrator.fragmenttext.model.NbaEventModle;
import com.example.administrator.fragmenttext.model.ProductInformationModle;
import com.example.administrator.fragmenttext.model.SupermarketModle;
import com.example.administrator.fragmenttext.model.NewNetWorkModle;
import com.example.administrator.fragmenttext.model.WeatherModle;
import com.example.administrator.fragmenttext.model.weather.VoiceSMSModle;
import com.google.gson.Gson;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

/**
 * 项目名称：FragmentText
 * 类描述：
 * 创建人：WangQing
 * 创建时间：2016/1/19 10:37
 * 修改人：WangQing
 * 修改时间：2016/1/19 10:37
 * 修改备注：
 */
public class NetWork {

    public String netWork(String path) {
        //创建okHttpClient对象
        OkHttpClient mOkHttpClient = new OkHttpClient();
        //创建一个Request
        final Request request = new Request.Builder()
                .url(path)
                .build();
        //new call
        Call call = mOkHttpClient.newCall(request);
        //请求加入调度
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(final Response response) throws IOException {

                String htmlStr = response.body().string();
            }
        });
        return null;
    }


    public static void getCheckWorkAttendance(String path, final myCallBack<CheckWorkAttendanceModle> mycallback) {
        //创建okHttpClient对象
        OkHttpClient mOkHttpClient = new OkHttpClient();
        //创建一个Request
        final Request request = new Request.Builder()
                .url(path)
                .build();
        //new call
        final Call call = mOkHttpClient.newCall(request);
        //请求加入调度
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, final IOException e) {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        mycallback.Fail(e.toString());
                    }
                });

            }

            @Override
            public void onResponse(final Response response) throws IOException {

                final String htmlStr = response.body().string();
               /* 由于数据请求是在子线程中进行的，所以这里要将线程切换到主线程中，然后将数据返回*/
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                       /* 这里我们直接用Gson解析返回的数据；*/
                        mycallback.Success(new Gson().fromJson(htmlStr, CheckWorkAttendanceModle.class));
                    }
                });
            }
        });


    }

    public static void getSupermarket(String path, final myCallBack<SupermarketModle> mycallback) {
        //创建okHttpClient对象
        OkHttpClient mOkHttpClient = new OkHttpClient();
        //创建一个Request
        final Request request = new Request.Builder()
                .url(path)
                .build();
        //new call
        final Call call = mOkHttpClient.newCall(request);
        //请求加入调度
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, final IOException e) {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        mycallback.Fail(e.toString());
                    }
                });

            }

            @Override
            public void onResponse(final Response response) throws IOException {

                final String htmlStr = response.body().string();
               /* 由于数据请求是在子线程中进行的，所以这里要将线程切换到主线程中，然后将数据返回*/
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                       /* 这里我们直接用Gson解析返回的数据；*/
                        mycallback.Success(new Gson().fromJson(htmlStr, SupermarketModle.class));
                    }
                });
            }
        });
    }

    public static void getProductInformation(String path, final myCallBack<ProductInformationModle> mycallback) {
        //创建okHttpClient对象
        OkHttpClient mOkHttpClient = new OkHttpClient();
        //创建一个Request
        final Request request = new Request.Builder()
                .url(path)
                .build();
        //new call
        final Call call = mOkHttpClient.newCall(request);
        //请求加入调度
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, final IOException e) {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        mycallback.Fail(e.toString());
                    }
                });

            }

            @Override
            public void onResponse(final Response response) throws IOException {

                final String htmlStr = response.body().string();
               /* 由于数据请求是在子线程中进行的，所以这里要将线程切换到主线程中，然后将数据返回*/
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                       /* 这里我们直接用Gson解析返回的数据；*/
                        mycallback.Success(new Gson().fromJson(htmlStr, ProductInformationModle.class));
                    }
                });
            }
        });
    }

    public static void getNetWork(String path, int pageindex, final myCallBack<NewNetWorkModle> mycallback) {
        path = path + pageindex;
        //创建okHttpClient对象
        OkHttpClient mOkHttpClient = new OkHttpClient();
        //创建一个Request
        final Request request = new Request.Builder()
                .url(path)
                .build();
        //new call
        final Call call = mOkHttpClient.newCall(request);
        //请求加入调度
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, final IOException e) {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        mycallback.Fail(e.toString());
                    }
                });

            }

            @Override
            public void onResponse(final Response response) throws IOException {

                final String htmlStr = response.body().string();
               /* 由于数据请求是在子线程中进行的，所以这里要将线程切换到主线程中，然后将数据返回*/
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                       /* 这里我们直接用Gson解析返回的数据；*/
                        mycallback.Success(new Gson().fromJson(htmlStr, NewNetWorkModle.class));
                    }
                });
            }
        });
    }

    public static void getNewNetWork(String path, int pageindex, final myCallBack<MMMNetWorkModle> mycallback) {
        path = path + pageindex;
        //创建okHttpClient对象
        OkHttpClient mOkHttpClient = new OkHttpClient();
        //创建一个Request
        final Request request = new Request.Builder()
                .url(path)
                .build();
        //new call
        final Call call = mOkHttpClient.newCall(request);
        //请求加入调度
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, final IOException e) {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        mycallback.Fail(e.toString());
                    }
                });

            }

            @Override
            public void onResponse(final Response response) throws IOException {

                final String htmlStr = response.body().string();
               /* 由于数据请求是在子线程中进行的，所以这里要将线程切换到主线程中，然后将数据返回*/
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                       /* 这里我们直接用Gson解析返回的数据；*/
                        mycallback.Success(new Gson().fromJson(htmlStr, MMMNetWorkModle.class));
                    }
                });
            }
        });
    }

    public static void getNetWorkInformation(String path, final myCallBack<DisplayStandardModle> mycallback) {
        //创建okHttpClient对象
        OkHttpClient mOkHttpClient = new OkHttpClient();
        //创建一个Request
        final Request request = new Request.Builder()
                .url(path)
                .build();
        //new call
        final Call call = mOkHttpClient.newCall(request);
        //请求加入调度
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, final IOException e) {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        mycallback.Fail(e.toString());
                    }
                });

            }

            @Override
            public void onResponse(final Response response) throws IOException {

                final String htmlStr = response.body().string();
               /* 由于数据请求是在子线程中进行的，所以这里要将线程切换到主线程中，然后将数据返回*/
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                       /* 这里我们直接用Gson解析返回的数据；*/
                        mycallback.Success(new Gson().fromJson(htmlStr, DisplayStandardModle.class));
                    }
                });
            }
        });
    }

    public static void getNbaEvent(String path, final myCallBack<NbaEventModle> mycallback) {
        //创建okHttpClient对象
        OkHttpClient mOkHttpClient = new OkHttpClient();
        //创建一个Request
        final Request request = new Request.Builder()
                .url(path)
                .build();
        //new call
        final Call call = mOkHttpClient.newCall(request);
        //请求加入调度
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, final IOException e) {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        mycallback.Fail(e.toString());
                    }
                });

            }

            @Override
            public void onResponse(final Response response) throws IOException {

                final String htmlStr = response.body().string();
               /* 由于数据请求是在子线程中进行的，所以这里要将线程切换到主线程中，然后将数据返回*/
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                       /* 这里我们直接用Gson解析返回的数据；*/
                        mycallback.Success(new Gson().fromJson(htmlStr, NbaEventModle.class));
                    }
                });
            }
        });
    }

    public static void getFamousQuotes(String path, String famousQuotes, int page, int num, final myCallBack<FamousQuotesModle> mycallback) {
        try {
            //将中文转为UTF-8
            String famousQuotes1 = URLEncoder.encode(famousQuotes, "UTF-8");
            //     String famousQuotesPath= "http://api.avatardata.cn/MingRenMingYan/LookUp?key=971664cc1223444084716f2ff4d9b31b&keyword=%E5%A4%A9%E6%89%8D&page=1&rows=5";
          String  famousQuotesPath=path+"&keyword="+famousQuotes1+"&page="+page+"&rows="+num;
            //创建okHttpClient对象
            OkHttpClient mOkHttpClient = new OkHttpClient();
            //创建一个Request
            final Request request = new Request.Builder()
                    .url(famousQuotesPath)
                    .build();
            //new call
            final Call call = mOkHttpClient.newCall(request);
            //请求加入调度
            call.enqueue(new Callback() {
                @Override
                public void onFailure(Request request, final IOException e) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        @Override
                        public void run() {
                            mycallback.Fail(e.toString());
                        }
                    });

                }

                @Override
                public void onResponse(final Response response) throws IOException {

                    final String htmlStr = response.body().string();
               /* 由于数据请求是在子线程中进行的，所以这里要将线程切换到主线程中，然后将数据返回*/
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        @Override
                        public void run() {
                       /* 这里我们直接用Gson解析返回的数据；*/
                            mycallback.Success(new Gson().fromJson(htmlStr, FamousQuotesModle.class));
                        }
                    });
                }
            });
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }
    public static void getWeather(String path, String place, final myCallBack<WeatherModle> mycallback) {
        try {
            //讲中文转为UTF-8
            String weatherPlace = URLEncoder.encode(place, "UTF-8");
            String  weatherPath=path+weatherPlace;
            //创建okHttpClient对象
            OkHttpClient mOkHttpClient = new OkHttpClient();
            //创建一个Request
            final Request request = new Request.Builder()
                    .url(weatherPath)
                    .build();
            //new call
            final Call call = mOkHttpClient.newCall(request);
            //请求加入调度
            call.enqueue(new Callback() {
                @Override
                public void onFailure(Request request, final IOException e) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        @Override
                        public void run() {
                            mycallback.Fail(e.toString());
                        }
                    });

                }

                @Override
                public void onResponse(final Response response) throws IOException {

                    final String htmlStr = response.body().string();
               /* 由于数据请求是在子线程中进行的，所以这里要将线程切换到主线程中，然后将数据返回*/
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        @Override
                        public void run() {
                       /* 这里我们直接用Gson解析返回的数据；*/
                            mycallback.Success(new Gson().fromJson(htmlStr, WeatherModle.class));
                        }
                    });
                }
            });
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }


    public static void getVoiceSMS(String path, final myCallBack<VoiceSMSModle> mycallback) {
        //创建okHttpClient对象
        OkHttpClient mOkHttpClient = new OkHttpClient();
        //创建一个Request
        final Request request = new Request.Builder()
                .url(path)
                .build();
        //new call
        final Call call = mOkHttpClient.newCall(request);
        //请求加入调度
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, final IOException e) {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        mycallback.Fail(e.toString());
                    }
                });

            }

            @Override
            public void onResponse(final Response response) throws IOException {

                final String htmlStr = response.body().string();
               /* 由于数据请求是在子线程中进行的，所以这里要将线程切换到主线程中，然后将数据返回*/
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                       /* 这里我们直接用Gson解析返回的数据；*/
                        mycallback.Success(new Gson().fromJson(htmlStr, VoiceSMSModle.class));
                    }
                });
            }
        });
    }
}
