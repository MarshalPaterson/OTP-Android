package au.com.marshal.paterson.opt

import au.com.marshal.paterson.opt.app.modules.login.model.Login
import au.com.marshal.paterson.opt.app.modules.login.viewmodel.LoginViewModel
import org.junit.Test

class LoginViewModelTest {

    @Test
    fun viewModelDoLogin() {
        var l = LoginViewModel()
        assert(l.doLogin("1234") != null)
    }

    @Test
    fun login() {
        var l = Login("ok")
        assert(l.status != null)
        assert(l.status == "ok")

        var mockLoginError = Login("error")
        assert(mockLoginError.status != "ok")
    }

}