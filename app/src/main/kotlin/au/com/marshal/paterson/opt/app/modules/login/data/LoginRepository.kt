package au.com.marshal.paterson.opt.app.modules.login.data

import au.com.marshal.paterson.opt.app.modules.login.data.api.ApiAuthService
import javax.inject.Singleton

@Singleton
class LoginRepository() {
    var api = ApiAuthService().run("https://api.github.com/users/Evin1-/repos")
}