package au.com.marshal.paterson.opt.app.modules.login.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import au.com.marshal.paterson.opt.app.modules.login.data.LoginRepository
import au.com.marshal.paterson.opt.app.modules.login.model.Login
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LoginViewModel @Inject constructor(
    private val worker: LoginRepository
) : AndroidViewModel(Application()) {

    private var loginResult = worker.getLogin()

    val login: MediatorLiveData<Login> by lazy {
        MediatorLiveData<Login>()
    }
}

