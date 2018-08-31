package com.example.nhatphuong.testmvvm.data.source;

import com.example.nhatphuong.testmvvm.data.DataCallBack;
import com.example.nhatphuong.testmvvm.data.model.Sonng;
import java.util.List;

public interface RepositoryDataSoure {

    interface RemoteDataSource {
        void getDataSong(String genre,DataCallBack dataCallBack);
    }
}
