package com.example.nhatphuong.testmvvm.data.source.remote.retrofit_config;

public class APIUntils {
    public static final String BASE_URL = "https://api.soundcloud.com/";
    private static DataClient mDataClient;

    public static DataClient getData() {
        if (mDataClient == null) {
            mDataClient = RetrofitClient.getClient(BASE_URL).create(DataClient.class);
        }
        return mDataClient;
    }
}
