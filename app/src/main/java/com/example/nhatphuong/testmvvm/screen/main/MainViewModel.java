package com.example.nhatphuong.testmvvm.screen.main;

import android.databinding.Observable;
import android.databinding.ObservableField;
import android.view.View;
import com.example.nhatphuong.testmvvm.data.DataCallBack;
import com.example.nhatphuong.testmvvm.data.model.Sonng;
import com.example.nhatphuong.testmvvm.data.repository.SongRepository;
import com.example.nhatphuong.testmvvm.screen.BaseViewModel;
import java.util.List;

public class MainViewModel extends BaseViewModel {
    private CallBackHome mCallBackHome;
    private SongRepository mSongRepository;
    private MainActivityAdapter mMainActivityAdapter;
    public ObservableField<String> mEditTextName = new ObservableField<>();
    public ObservableField<String> mEditTextPass = new ObservableField<>();

    private Observable.OnPropertyChangedCallback mOnPropertyChangedCallback =
            new Observable.OnPropertyChangedCallback() {

                @Override
                public void onPropertyChanged(Observable observable, int propertyId) {
                    if (observable == mEditTextName) {
                        System.out.println("11111");
                    } else if (observable == mEditTextPass) {
                        System.out.println("22222");
                    }
                }
            };

    public MainViewModel(CallBackHome callBackHome, SongRepository songRepository, MainActivityAdapter mainActivityAdapter) {
        mCallBackHome = callBackHome;
        mSongRepository = songRepository;
        mMainActivityAdapter = mainActivityAdapter;
    }


    public void onClickedButton(View v) {
        onStart();
    }

    private void getDataSong(String genre) {

        mSongRepository.getDataSong(genre, new DataCallBack() {
            @Override
            public void onSuccess(List<Sonng> sonngs) {
               mMainActivityAdapter.updateSong(sonngs);
                mCallBackHome.onSuccess(sonngs);
            }

            @Override
            public void onFail(String messeage) {

            }
        });
    }
    public MainActivityAdapter getAdapter(){
        return mMainActivityAdapter;
    }
    @Override
    protected void onStart() {
        getDataSong(mEditTextName.get());
    }

    @Override
    protected void onStop() {

    }
}
