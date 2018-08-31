package com.example.nhatphuong.testmvvm.data.model;

import java.util.List;

public class ListSong {
    List<Sonng> mSongs;

    public ListSong() {
    }

    public ListSong(List<Sonng> songs) {
        mSongs = songs;
    }

    public List<Sonng> getSongs() {
        return mSongs;
    }

    public void setSongs(List<Sonng> songs) {
        mSongs = songs;
    }
}
