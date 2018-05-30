package com.example.sujinv2px.evolvemvvm.domain.interactors

import com.example.sujinv2px.evolvemvvm.data.remote.impl.PostRemoteRepository
import com.example.sujinv2px.evolvemvvm.di.qualifier.Remote
import javax.inject.Inject

class FetchPostRemoteUseCase @Inject constructor(
        @Remote private val postRemoteRepository: PostRemoteRepository
) {
}