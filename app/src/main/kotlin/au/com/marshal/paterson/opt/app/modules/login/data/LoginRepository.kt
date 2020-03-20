package au.com.marshal.paterson.opt.app.modules.login.data

import au.com.marshal.paterson.opt.app.modules.login.data.api.ApiAuthService
import au.com.marshal.paterson.opt.app.modules.login.viewmodel.LoginViewModel
import javax.inject.Singleton

@Singleton
class LoginRepository(url: String, search: String, viewModel: LoginViewModel) {
    var api = ApiAuthService().run(url, search, viewModel)
}