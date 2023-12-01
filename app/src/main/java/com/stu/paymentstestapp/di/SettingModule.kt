package com.stu.paymentstestapp.di

import com.stu.paymentstestapp.setting.AppSettings
import com.stu.paymentstestapp.setting.SharedPreferencesAppSettings
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class SettingsModule {

    @Binds
    abstract fun bindAppSettings(
        appSettings: SharedPreferencesAppSettings
    ): AppSettings

}