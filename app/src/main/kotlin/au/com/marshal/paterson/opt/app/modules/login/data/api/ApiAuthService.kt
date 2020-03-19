package au.com.marshal.paterson.opt.app.modules.login.data.api
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.IOException
import javax.inject.Singleton

private val client = OkHttpClient()

@Singleton
class ApiAuthService {
    public fun run(url: String) {
        val request = Request.Builder()
            .url(url)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: okhttp3.Call, e: IOException) {}
            override fun onResponse(call: okhttp3.Call, response: Response) = println(response.body()?.string())
        })
    }
}
