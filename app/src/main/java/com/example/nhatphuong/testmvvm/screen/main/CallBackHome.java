package com.example.nhatphuong.testmvvm.screen.main;

import com.example.nhatphuong.testmvvm.data.model.Sonng;
import java.util.List;

public interface CallBackHome {

    void onSuccess(List<Sonng> sonngs);
    void onError(String eror);
}
