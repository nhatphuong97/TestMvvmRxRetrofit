package com.example.nhatphuong.testmvvm.screen.main;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import com.example.nhatphuong.testmvvm.R;
import com.example.nhatphuong.testmvvm.data.model.Sonng;
import com.example.nhatphuong.testmvvm.data.repository.SongRepository;
import com.example.nhatphuong.testmvvm.data.source.remote.RemoteDataSource;
import com.example.nhatphuong.testmvvm.databinding.ActivityMainBinding;
import es.dmoral.toasty.Toasty;
import java.util.List;

public class MainActivity extends AppCompatActivity implements CallBackHome{
    List<Sonng> mSonngs;
    private MainViewModel mMainViewModel;
    private MainActivityAdapter mMainActivityAdapter = new MainActivityAdapter();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SongRepository songRepository = SongRepository.getsInstance(new RemoteDataSource());
        mMainViewModel = new MainViewModel(this, songRepository,mMainActivityAdapter);
        ActivityMainBinding activityMainBinding =
                DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.setViewModel(mMainViewModel);
    }

    @Override
    public void onSuccess(List<Sonng> sonngs) {
        mSonngs = sonngs;
    }

    @Override
    public void onStart() {
        super.onStart();
        mMainViewModel.onStart();
    }

    @Override
    public void onError(String eror) {
        Toasty.error(this,eror,Toast.LENGTH_SHORT).show();
    }
}
