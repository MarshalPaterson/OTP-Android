package au.com.marshal.paterson.opt.app.modules.login.data.api

import au.com.marshal.paterson.opt.app.modules.login.model.LoginResponseModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiAuthService {

    @POST("/api/rest/casino/v2/jackpot?req=content&dw=320")
    fun getLogin(): Call<LoginResponseModel>

}