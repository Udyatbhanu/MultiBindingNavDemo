package com.bhanu.baliyar.multibindingsnavdemo.core

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response


fun <T> safeApiCall(
    dispatcher: CoroutineDispatcher = Dispatchers.IO,
    apiCall: suspend () -> Response<T>
): Flow<ResponseWrapper<T>> {

    return flow {
        emit(ResponseWrapper.Loading)
        try {
            val response = apiCall()
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) {
                    emit(ResponseWrapper.Success(body))
                } else {
                    emit(ResponseWrapper.Error(message = "There was an error"))
                }
            } else {
                emit(ResponseWrapper.Error(message = "There was an error"))
            }
        } catch (e: Exception) {
            emit(ResponseWrapper.Error(message = "There was a network error"))
        }

    }.flowOn(dispatcher)

}