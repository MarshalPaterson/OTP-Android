package au.com.marshal.paterson.opt.app.modules.login.di

import androidx.lifecycle.ViewModel
import au.com.marshal.paterson.opt.app.ViewModelKey
import au.com.marshal.paterson.opt.app.modules.login.data.LoginDataSource
import au.com.marshal.paterson.opt.app.modules.login.data.api.ApiAuthService
import au.com.marshal.paterson.opt.app.modules.login.data.api.LoginRemoteDataSource
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

//    @Binds
//    abstract fun bindViewModelFactory(factory: LoginViewModel_Factory): ViewModelProvider.Factory

//    @Singleton
//    @LoginRemoteDataSource
//    @Provides
//    fun provideLoginRemoteDataSource(apiService: ApiAuthService): LoginDataSource {
//        //apiService
//        return au.com.marshal.paterson.opt.app.modules.login.data.api.LoginRemoteDataSource()
//    }
//
//    @Qualifier
//    @Retention(AnnotationRetention.RUNTIME)
//    annotation class LoginRemoteDataSource

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    abstract fun bindLoginViewModel(loginViewModel: LoginViewModel): ViewModel

//    @Singleton
//    @Binds
//    @Named("loginRemoteDataSource")
//    abstract fun bindLoginRemoteDataSource(repo: LoginRemoteDataSource): LoginDataSource


}