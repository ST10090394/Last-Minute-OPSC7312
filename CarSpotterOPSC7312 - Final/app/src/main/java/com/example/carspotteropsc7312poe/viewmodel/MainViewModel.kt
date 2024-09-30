package com.example.carspotteropsc7312poe.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.carspotteropsc7312poe.networking.ApiConfig
import com.example.carspotteropsc7312poe.networking.SignUpRequest
import com.example.carspotteropsc7312poe.networking.SignUpResponse
import com.example.carspotteropsc7312poe.networking.LoginRequest
import com.example.carspotteropsc7312poe.networking.LoginResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading

    private val _isError = MutableLiveData<Boolean>()
    val isError: LiveData<Boolean> get() = _isError

    var errorMessage: String = ""
        private set

    private val _signUpResponse = MutableLiveData<SignUpResponse?>()
    val signUpResponse: LiveData<SignUpResponse?> get() = _signUpResponse

    private val _loginResponse = MutableLiveData<LoginResponse?>()
    val loginResponse: LiveData<LoginResponse?> get() = _loginResponse

    fun signUpUser(signUpRequest: SignUpRequest) {
        _isLoading.value = true
        _isError.value = false

        val client = ApiConfig.getApiService().signUpUser(signUpRequest)

        client?.enqueue(object : Callback<SignUpResponse?> {
            override fun onResponse(
                call: Call<SignUpResponse?>,
                response: Response<SignUpResponse?>
            ) {
                _isLoading.value = false
                if (response.isSuccessful) {
                    _signUpResponse.postValue(response.body())
                } else {
                    onError("Sign up failed")
                }
            }

            override fun onFailure(call: Call<SignUpResponse?>, t: Throwable) {
                onError(t.message)
                t.printStackTrace()
            }
        })
    }

    fun loginUser(loginRequest: LoginRequest) {
        _isLoading.value = true
        _isError.value = false

        val client = ApiConfig.getApiService().loginUser(loginRequest)

        client?.enqueue(object : Callback<LoginResponse?> {
            override fun onResponse(
                call: Call<LoginResponse?>,
                response: Response<LoginResponse?>
            ) {
                _isLoading.value = false
                if (response.isSuccessful) {
                    _loginResponse.postValue(response.body())
                } else {
                    onError("Login failed")
                }
            }

            override fun onFailure(call: Call<LoginResponse?>, t: Throwable) {
                onError(t.message)
                t.printStackTrace()
            }
        })
    }

    private fun onError(inputMessage: String?) {
        val message = if (inputMessage.isNullOrBlank()) "Unknown Error" else inputMessage
        errorMessage = "ERROR: $message. Some data may not be displayed properly."
        _isError.value = true
        _isLoading.value = false
    }
}
