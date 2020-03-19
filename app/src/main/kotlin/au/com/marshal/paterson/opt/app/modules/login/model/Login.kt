package au.com.marshal.paterson.opt.app.modules.login.model

import com.google.gson.annotations.SerializedName

data class LoginResponseModel(
    val loginItem: Login? = null
) {
    fun toLogin() = loginItem?: String
}

data class Login (
    @SerializedName("status")
    var status: String)