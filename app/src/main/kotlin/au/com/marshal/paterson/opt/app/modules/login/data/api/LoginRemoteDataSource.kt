package au.com.marshal.paterson.opt.app.modules.login.data.api

import au.com.marshal.paterson.opt.app.modules.login.model.Login
import androidx.lifecycle.MediatorLiveData
import au.com.marshal.paterson.opt.app.modules.login.data.LoginDataSource
import au.com.marshal.paterson.opt.app.modules.login.model.LoginResponseModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LoginRemoteDataSource @Inject constructor(
    private val apiAuthService: ApiAuthService
) :
    LoginDataSource {
    override fun getLogin(): MediatorLiveData<Login> {
        val result = MediatorLiveData<Login>()

        apiAuthService.getLogin()
            .enqueue(object : Callback<LoginResponseModel> {
                override fun onFailure(call: Call<LoginResponseModel>, t: Throwable) {
                    //result.value = //Result.failure(t)
                    print(result.value)
                }

                override fun onResponse(
                    call: Call<LoginResponseModel>,
                    response: Response<LoginResponseModel>
                ) {
                    response.body()?.let {
                       // result.value = //Result.success(it.toLogin())
                        print(result.value)
                    } ?: run {
                        //TODO Provide detailed error info later once the backend is done with error message structure
                        //result.value =  //Result.Error(Exception("Server Error"))
                        print(result.value)
                    }
                }
            })
        return result
    }


    companion object
}