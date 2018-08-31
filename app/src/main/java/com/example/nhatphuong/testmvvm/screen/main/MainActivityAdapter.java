package com.example.nhatphuong.testmvvm.screen.main;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.example.nhatphuong.testmvvm.R;
import com.example.nhatphuong.testmvvm.data.model.Sonng;
import com.example.nhatphuong.testmvvm.databinding.SongBinding;
import java.util.ArrayList;
import java.util.List;

public class MainActivityAdapter extends RecyclerView.Adapter<MainActivityAdapter.Holder> {
    private  List<Sonng> mSonngs = new ArrayList<>();
    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        SongBinding songBinding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                        R.layout.item_recycleview, parent, false);
        return new Holder(songBinding);
    }
    protected MainActivityAdapter() {
    }
    public void updateSong(List<Sonng> songList) {
        if (mSonngs != null) {
            mSonngs.clear();
        }
        mSonngs.addAll(songList);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.bind(mSonngs.get(position));
    }


    @Override
    public int getItemCount() {
        return mSonngs !=null ? mSonngs.size() : 0;
    }


    public class Holder extends RecyclerView.ViewHolder {
    private SongBinding mSongBinding;

        public Holder(SongBinding songBinding) {
            super(songBinding.getRoot());
            mSongBinding = songBinding;
        }
        public void bind(Sonng sonng){
            mSongBinding.setSong(sonng);
            mSongBinding.executePendingBindings();
        }
    }
}
