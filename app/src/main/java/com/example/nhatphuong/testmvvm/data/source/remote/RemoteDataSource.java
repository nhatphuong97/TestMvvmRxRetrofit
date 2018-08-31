package com.example.nhatphuong.testmvvm.data.source.remote;


import com.example.nhatphuong.testmvvm.data.DataCallBack;
import com.example.nhatphuong.testmvvm.data.model.Sonng;
import com.example.nhatphuong.testmvvm.data.source.RepositoryDataSoure;
import com.example.nhatphuong.testmvvm.data.source.remote.retrofit_config.APIUntils;
import com.example.nhatphuong.testmvvm.data.source.remote.retrofit_config.DataClient;
import com.example.nhatphuong.testmvvm.utils.Constant;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.List;

public class RemoteDataSource implements RepositoryDataSoure.RemoteDataSource {

    private List<Sonng> mSonngs;

    @Override
    public void getDataSong(String genre, final DataCallBack dataCallBack) {
        DataClient dataClient = APIUntils.getData();
        Observable<List<Sonng>> observable =
                dataClient.getDataById(Constant.KEY_API, genre);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())//Chạy trên Main Thread
                .subscribe(new Observer<List<Sonng>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(List<Sonng> value) {
                        mSonngs = value;
                        dataCallBack.onSuccess(mSonngs);
                        System.out.println("remote" + value.get(1).getTitle());
                        System.out.println("remote" + mSonngs.get(1).getTitle());
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println(e.getMessage());
                        dataCallBack.onFail(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                        System.out.println("Completed");
                    }
                });

    }
}
