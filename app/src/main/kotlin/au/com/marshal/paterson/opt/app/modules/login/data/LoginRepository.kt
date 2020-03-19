package au.com.marshal.paterson.opt.app.modules.login.data

import androidx.lifecycle.MediatorLiveData
import au.com.marshal.paterson.opt.app.modules.login.data.api.LoginRemoteDataSource
import au.com.marshal.paterson.opt.app.modules.login.model.Login
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

@Singleton
class LoginRepository @Inject constructor(
//    @Named("loginRemoteDataSource")
//    private val loginRemoteDataSource: LoginRemoteDataSource
) : LoginDataSource {
    override fun getLogin(): MediatorLiveData<Login> {
        return LoginRemoteDataSource().getLogin()
    }
}
