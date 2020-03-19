package au.com.marshal.paterson.opt.app.modules.login.di

import androidx.lifecycle.ViewModel
import au.com.marshal.paterson.opt.app.ViewModelKey
import au.com.marshal.paterson.opt.app.modules.login.data.api.ApiAuthService
import au.com.marshal.paterson.opt.app.modules.login.ui.LoginFragment
import au.com.marshal.paterson.opt.app.modules.login.viewmodel.LoginViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import javax.inject.Named
import javax.inject.Qualifier
import javax.inject.Singleton

@Module(includes = [LoginModuleBinds::class])
class LoginModule


@Module
abstract class LoginModuleBinds {

    @ContributesAndroidInjector
    abstract fun bindLoginFragment(): LoginFragment

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    abstract fun bindLoginViewModel(loginViewModel: LoginViewModel): ViewModel

}