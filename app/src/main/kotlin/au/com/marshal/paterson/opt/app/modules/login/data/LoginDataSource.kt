package au.com.marshal.paterson.opt.app.modules.login.data

import androidx.lifecycle.MediatorLiveData
import au.com.marshal.paterson.opt.app.modules.login.model.Login

interface LoginDataSource {
    fun getLogin(): MediatorLiveData<Login>
}

