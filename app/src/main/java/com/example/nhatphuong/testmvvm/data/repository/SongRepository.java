package com.example.nhatphuong.testmvvm.data.repository;

import com.example.nhatphuong.testmvvm.data.DataCallBack;
import com.example.nhatphuong.testmvvm.data.model.Sonng;
import com.example.nhatphuong.testmvvm.data.source.RepositoryDataSoure;
import com.example.nhatphuong.testmvvm.data.source.remote.RemoteDataSource;
import java.util.List;

public class SongRepository implements RepositoryDataSoure.RemoteDataSource {

    private static SongRepository sInstance;
    private RemoteDataSource mSongRemoteDataSource;

    private SongRepository(RemoteDataSource remoteDataSource) {
        mSongRemoteDataSource = remoteDataSource;
    }

    public static SongRepository getsInstance(RemoteDataSource remoteDataSource) {

        sInstance = new SongRepository(remoteDataSource);
        return sInstance;
    }

    @Override
    public void getDataSong(String genre, DataCallBack dataCallBack) {
        mSongRemoteDataSource.getDataSong(genre,dataCallBack);
    }
}
