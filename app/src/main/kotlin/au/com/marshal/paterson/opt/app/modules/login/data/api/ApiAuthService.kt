package au.com.marshal.paterson.opt.app.modules.login.data.api

import au.com.marshal.paterson.opt.app.modules.login.model.Login
import au.com.marshal.paterson.opt.app.modules.login.viewmodel.LoginViewModel
import com.google.gson.Gson
import okhttp3.*
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

private val client = OkHttpClient()

@Singleton
class ApiAuthService {

    @Inject
    lateinit var viewModel: LoginViewModel

    fun run(url: String, search: String, viewMobelAttr: LoginViewModel) {
        viewModel = viewMobelAttr
        val json = """
        {
            "code":"${search}"
        }
        """.trimIndent()

        val body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json)
        val request = Request.Builder()
            .url(url)
            .post(body)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: okhttp3.Call, e: IOException) {
                print(e.message)

                /// The Backend API has been disabled/ Mock a successful response. Once setup remove below.
                viewModel.login.postValue("ok")
            }

            override fun onResponse(call: okhttp3.Call, response: Response) {

                /// Backend API has been disabled, though when setup you can use the response below.
//                try {
//                    var gson = Gson()
//                    var jsonString = response.body()?.string()
//                    var login = gson.fromJson(jsonString, Login::class.java)
//                    viewModel.login.postValue(login.status)
//
//                } catch (e: Exception) {
//                    viewModel.login.postValue("Failed to login, please try again.")
//                }
            }
        })
    }
}

