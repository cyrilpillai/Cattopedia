package com.cyrilpillai.cattopedia.core.network.di

import com.cyrilpillai.cattopedia.BuildConfig
import com.cyrilpillai.cattopedia.core.network.ApiService
import com.cyrilpillai.cattopedia.core.network.result.NetworkResultCallAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val HEADER_API_KEY = "x-api-key"

    @Provides
    @Singleton
    fun provideHeaderInterceptor(): Interceptor = Interceptor {
        it.run {
            proceed(
                request()
                    .newBuilder()
                    .addHeader(HEADER_API_KEY, BuildConfig.API_KEY)
                    .build()
            )
        }
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(interceptor: Interceptor): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .build()

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.API_BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(MoshiConverterFactory.create())
        .addCallAdapterFactory(NetworkResultCallAdapterFactory.create())
        .build()

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)
}