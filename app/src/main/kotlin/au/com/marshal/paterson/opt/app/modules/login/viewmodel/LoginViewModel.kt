package au.com.marshal.paterson.opt.app.modules.login.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MediatorLiveData
import au.com.marshal.paterson.opt.app.modules.login.data.LoginRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LoginViewModel @Inject constructor() : AndroidViewModel(Application()) {

  //  var searchText: String = ""
    val login: MediatorLiveData<String> by lazy {
        MediatorLiveData<String>()
    }

    fun doLogin(searchText:String) {
            LoginRepository(
                "http://floral-cherry-7673.getsandbox.com/login",
                searchText,
                this
            ).api
    }
}

