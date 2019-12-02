package com.example.mobdevdogs.di

import android.content.Context
import android.content.SharedPreferences
import android.net.ConnectivityManager
import com.example.mobdevdogs.URL_BASE_API
import com.example.mobdevdogs.data.remote.net.BreedsRemoteApi
import com.example.mobdevdogs.data.remote.source.BreedsRemoteDataSource
import com.example.mobdevdogs.data.repository.BreedsRepository
import com.example.mobdevdogs.domain.usecase.GetBreedsUseCase
import com.example.mobdevdogs.presentation.viewmodel.BreedsViewModel
import com.example.mobdevdogs.util.AppPreferences
import com.squareup.picasso.Picasso
import okhttp3.OkHttpClient

import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


val appModule = module {


    /* Android Services */
    single {
        androidContext().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    }
    single<SharedPreferences> {
        androidContext().getSharedPreferences(
            AppPreferences.SHARED_PREFERENCES_NAME,
            Context.MODE_PRIVATE
        )
    }

    /* Retrofit */
    single {
        OkHttpClient.Builder()
            .callTimeout(1, TimeUnit.MINUTES)
            .connectTimeout(1, TimeUnit.MINUTES)
            .readTimeout(1, TimeUnit.MINUTES)
            .writeTimeout(1, TimeUnit.MINUTES)
            .build()
    }

    single {
        Retrofit.Builder()
            .baseUrl(URL_BASE_API)
            .client(get())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single { get<Retrofit>().create(BreedsRemoteApi::class.java) as BreedsRemoteApi }
   // single { get<Retrofit>().create(MatchesRemoteApi::class.java) as MatchesRemoteApi }

    /* Database */
 /*   single {
        Room.databaseBuilder(
            androidApplication(),
            AppDatabase::class.java,
            DATABASE_NAME
        ).fallbackToDestructiveMigration().build()
    }
*/
    /* Dao Interfaces */
   // factory { get<AppDatabase>().matchesDao() }

    /* DataSource */
   factory { BreedsRemoteDataSource(get()) }
   // factory { MatchesRemoteDataSource(get()) }
    /* Repositories */
    factory { BreedsRepository(get()) }
   // factory { MatchesRepository(get()) }
    /* View models */
    viewModel { BreedsViewModel(get()) }
  //  viewModel { MatchesViewModel(get()) }
    /* UseCases */
    factory { GetBreedsUseCase(get()) }
  //  factory { GetMatchesUseCase(get()) }

    /* Picasso */
    single {
        Picasso.get()
    }

}