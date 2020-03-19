package au.com.marshal.paterson.opt.app.modules.login.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MediatorLiveData
import au.com.marshal.paterson.opt.app.modules.login.data.LoginRepository
import au.com.marshal.paterson.opt.app.modules.login.model.Login
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LoginViewModel @Inject constructor() : AndroidViewModel(Application()) {

    private var loginResult = LoginRepository().api

    val login: MediatorLiveData<Login> by lazy {
        MediatorLiveData<Login>()
    }

}

