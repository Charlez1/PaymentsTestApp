package com.stu.paymentstestapp.di

import com.stu.paymentstestapp.network.PaymentSource
import com.stu.paymentstestapp.network.PaymentSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class SourceModule {

    @Binds
    abstract fun bindPaymentSource(
        firestoreMessagesSource: PaymentSourceImpl
    ): PaymentSource

}