package com.example.nhatphuong.testmvvm.data.model;

import android.arch.lifecycle.ViewModel;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Sonng extends ViewModel implements Parcelable {


    @SerializedName("title")
    @Expose
    private String mTitle;
    @SerializedName("user_id")
    @Expose
    private Integer mUserId;
    @SerializedName("artwork_url")
    @Expose
    private String mArwork;
    @SerializedName("genre")
    @Expose
    private String mGenre;

    protected Sonng(Parcel in) {
        mTitle = in.readString();
        if (in.readByte() == 0) {
            mUserId = null;
        } else {
            mUserId = in.readInt();
        }
        mArwork = in.readString();
        mGenre = in.readString();
    }

    public static final Creator<Sonng> CREATOR = new Creator<Sonng>() {
        @Override
        public Sonng createFromParcel(Parcel in) {
            return new Sonng(in);
        }

        @Override
        public Sonng[] newArray(int size) {
            return new Sonng[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mTitle);
        if (mUserId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(mUserId);
        }
        dest.writeString(mArwork);
        dest.writeString(mGenre);
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public Integer getUserId() {
        return mUserId;
    }

    public void setUserId(Integer userId) {
        mUserId = userId;
    }

    public String getArwork() {
        return mArwork;
    }

    public void setArwork(String arwork) {
        mArwork = arwork;
    }

    public String getGenre() {
        return mGenre;
    }

    public void setGenre(String genre) {
        mGenre = genre;
    }

    public static Creator<Sonng> getCREATOR() {
        return CREATOR;
    }
}