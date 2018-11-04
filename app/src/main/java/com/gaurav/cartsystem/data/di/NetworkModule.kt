package com.gaurav.cartsystem.data.di

import android.content.Context
import com.gaurav.cartsystem.app.utils.Constants
import com.gaurav.cartsystem.domain.repository.CartRepository
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    fun provideOkHttpClient( context: Context): OkHttpClient {
        val okHttpBuilder =  OkHttpClient.Builder()
        return  okHttpBuilder.build()
    }


    @Singleton
    @Provides
    fun provideGson(): Gson {
        return GsonBuilder()
                .setLenient()
                .create()
    }


    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient, gson: Gson): Retrofit {
        return Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()

    }

    @Provides
    @Singleton
    fun provideCartApiService(retrofit: Retrofit): CartRepository {
        return retrofit.create(CartRepository::class.java)
    }

}