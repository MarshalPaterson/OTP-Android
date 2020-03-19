package au.com.marshal.paterson.opt.app.modules.login.data

import androidx.lifecycle.MediatorLiveData
import au.com.marshal.paterson.opt.app.modules.login.model.Login
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

@Singleton
class LoginRepository @Inject constructor(
    @Named("loginRemoteDataSource")
    private val loginRemoteDataSource: LoginDataSource
) : LoginDataSource {
    override fun getLogin(): MediatorLiveData<Login> {
        return loginRemoteDataSource.getLogin()
    }
}
