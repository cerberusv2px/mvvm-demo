package com.example.sujinv2px.evolvemvvm.di.modules

import android.app.Application
import android.content.Context
import com.example.sujinv2px.evolvemvvm.data.Constants
import com.example.sujinv2px.evolvemvvm.data.local.DatabaseManager
import com.example.sujinv2px.evolvemvvm.data.remote.ApiService
import com.example.sujinv2px.evolvemvvm.di.scope.PerApplication
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
open class ApplicationModule {

    @Provides
    @PerApplication
    fun provideContext(application: Application): Context {
        return application
    }

    @Provides
    @PerApplication
    fun provideDatabaseManager(context: Context): DatabaseManager {
        return DatabaseManager(context)
    }

    @Provides
    @PerApplication
    fun provideGson(): Gson {
        return GsonBuilder().setLenient().create()
    }

    @Provides
    @PerApplication
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        return logging
    }

    @Provides
    @PerApplication
    fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
                .apply {
                    addInterceptor(httpLoggingInterceptor)
                    connectTimeout(Constants.connectTimeout, TimeUnit.SECONDS)
                    readTimeout(Constants.readTimeout, TimeUnit.SECONDS)
                }
                .build()
    }

    @Provides
    @PerApplication
    fun provideApiService(okHttpClient: OkHttpClient, gson: Gson): ApiService {
        val retrofit = Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()

        return retrofit.create(ApiService::class.java)
    }
}