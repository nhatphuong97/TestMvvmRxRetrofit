package com.example.nhatphuong.testmvvm.data;

import com.example.nhatphuong.testmvvm.data.model.Sonng;
import java.util.List;

public interface DataCallBack {
    void onSuccess(List<Sonng> sonngs);

    void onFail(String messeage);
}
