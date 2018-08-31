package com.example.nhatphuong.testmvvm.data.source.remote.retrofit_config;

import com.example.nhatphuong.testmvvm.data.model.Sonng;
import io.reactivex.Observable;
import java.util.List;
import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface DataClient {
        @GET("tracks?client_id=d3bb97412667a7812924715ea66498af")
        Call<List<Sonng>> getDataTrack(@Query("genre") String genre);

        @GET("tracks")
        Observable<List<Sonng>> getDataById(@Query("client_id") String id,
                @Query("genre") String genre);


        //Test phương thức post

        /**
         *
         * @param photo
         * @return
         */
        @Multipart
        @POST("quanlyanh.php")
        Call<String> UploadPhoto(@Part MultipartBody.Part photo);

        @FormUrlEncoded
        @POST("insert.php")
        Call<String> InsertData(@Field("taikhoan") String Taikhoan,
                @Field("matkhau") String Matkhau, @Field("hinhanh") String hinhanh);

        @POST("insert.php")
        Call<Sonng> InsertSinhVien(@Body Sonng sinhvien);

}
