package me.sheepyang.rxandroiddemo.activity;

import android.os.Bundle;
import android.view.View;

import java.io.IOException;

import butterknife.OnClick;
import me.sheepyang.rxandroiddemo.R;
import me.sheepyang.rxandroiddemo.api.TestService;
import me.sheepyang.rxandroiddemo.util.LogUtils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import rx.Observable;
import rx.Subscriber;

public class MainActivity extends BaseActivity implements View.OnClickListener {


    @Override
    public int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        rxAndroidTest();
    }


    private void getTaskList() {
        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("http://106.3.227.33/pulamsi/")
                .baseUrl("http://114.215.115.221:9080/ele-app/app/")
                //增加返回值为String的支持
                .addConverterFactory(ScalarsConverterFactory.create())
                //增加返回值为Gson的支持(以实体类返回)
                .addConverterFactory(GsonConverterFactory.create())
                //增加返回值为Oservable<T>的支持
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();


        TestService service = retrofit.create(TestService.class);
        service.getTask("1", "10", "", "", "国网重庆市电力公司江北供电分公司", "", "", "", "desc").enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                LogUtils.i("Call tag -> " + call.request().tag());
                LogUtils.i("Call isHttps -> " + call.request().isHttps());
                LogUtils.i("Call url -> " + call.request().url());
                LogUtils.i("Call headers -> " + call.request().headers());
                LogUtils.i("Call header currentPage -> " + call.request().headers("currentPage"));
                try {
                    LogUtils.i("Call body contentLength -> " + call.request().body().contentLength());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                LogUtils.i("Call body contentType -> " + call.request().body().contentType());
                LogUtils.i("Call body toString -> " + call.request().body().toString());
                LogUtils.i("Call method -> " + call.request().method() + "\n\n");

                LogUtils.i("Response isSuccessful -> " + response.isSuccessful());
                LogUtils.i("Response raw -> " + response.raw());
                LogUtils.i("Response headers -> " + response.headers());
                LogUtils.i("Response body -> " + response.body());
                showToast(response.body());
                LogUtils.i("Response message -> " + response.message());
                LogUtils.i("Response errorBody -> " + response.errorBody());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });
    }

    private void rxAndroidTest() {
        Subscriber subscriber = new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String msg) {
                log(msg);
            }
        };
        String[] words = {"Hello", "Hi", "Aloha"};
//        Observable observable = Observable.just(words);
        Observable observable = Observable.from(words);
        observable.subscribe(subscriber);
    }

    @Override
    @OnClick({R.id.btn_city, R.id.btn_upload, R.id.btn_task})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_city:
                showToast("获取城市信息");
                break;
            case R.id.btn_upload:
                showToast("上传文件");
                break;
            case R.id.btn_task:
                getTaskList();
                break;
            default:
                break;
        }
    }
}
