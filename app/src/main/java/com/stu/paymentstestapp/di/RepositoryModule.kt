package com.stu.paymentstestapp.di

import com.stu.paymentstestapp.features.login.repositories.AuthenticationRepository
import com.stu.paymentstestapp.features.login.repositories.AuthenticationRepositoryImpl
import com.stu.paymentstestapp.features.paymentlist.repositories.PaymentListRepository
import com.stu.paymentstestapp.features.paymentlist.repositories.PaymentListRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindAuthenticationRepository(
        currentChatRepositoryImpl: AuthenticationRepositoryImpl
    ): AuthenticationRepository

    @Binds
    abstract fun bindPaymentListRepository(
        currentChatRepositoryImpl: PaymentListRepositoryImpl
    ): PaymentListRepository

}