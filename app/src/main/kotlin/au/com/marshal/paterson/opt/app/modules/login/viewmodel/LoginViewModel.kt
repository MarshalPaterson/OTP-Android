package au.com.marshal.paterson.opt.app.modules.login.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MediatorLiveData
import au.com.marshal.paterson.opt.app.modules.login.data.LoginRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LoginViewModel @Inject constructor() : AndroidViewModel(Application()) {

    /// This need to change to a backend login API
    val URL = "http://floral-cherry-7673.getsandbox.com/login"

    val login: MediatorLiveData<String> by lazy {
        MediatorLiveData<String>()
    }

    fun doLogin(searchText: String) {
        LoginRepository(
            URL,
            searchText,
            this
        ).api
    }
}

