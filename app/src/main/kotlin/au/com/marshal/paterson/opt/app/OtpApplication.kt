package au.com.marshal.paterson.opt.app

import android.app.Activity
import android.app.Application
import android.content.Context
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import au.com.marshal.paterson.opt.app.modules.login.data.api.ApiAuthService
import au.com.marshal.paterson.opt.app.modules.login.di.LoginModule
import au.com.marshal.paterson.opt.app.modules.login.ui.LoginActivity
import dagger.*
import dagger.android.*
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton
import kotlin.reflect.KClass

@Module
class AppModule()
{
    @Provides
    @Singleton
    fun provideApplication(app : OtpApplication):Context = app
}

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract fun bindMainActivity (): LoginActivity
}

@Singleton
@Component(modules= [
    AppModule::class,
    AndroidInjectionModule::class,
    ViewModelModule::class,
    ActivityBuilder::class,
    LoginModule::class])

interface AppComponent {

    @Component.Builder
    interface Builder
    {
        @BindsInstance
        fun application(application:OtpApplication): Builder

        fun build(): AppComponent

//        @Component.Builder
//        abstract class Builder : AndroidInjector.Builder<OtpApplication>()
    }

    fun inject(app:OtpApplication)
    fun inject(loginActivity: LoginActivity)
}

@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER
)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class ViewModelKey(val value: KClass<out ViewModel>)


public class OtpApplication : Application(), HasAndroidInjector {
    @Inject
    lateinit var androidInjector : DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder().application(this).build().inject(this)

    }

    override fun androidInjector(): AndroidInjector<Any> {
        return androidInjector
    }


}

@Singleton
class ViewModelFactory @Inject constructor(
    private val creators: @JvmSuppressWildcards Map<Class<out ViewModel>, Provider<ViewModel>>
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        var creator: Provider<out ViewModel>? = creators[modelClass]
        if (creator == null) {
            for ((key, value) in creators) {
                if (modelClass.isAssignableFrom(key)) {
                    creator = value
                    break
                }
            }
        }
        if (creator == null) {
            throw IllegalArgumentException("Unknown model class: $modelClass")
        }
        try {
            @Suppress("UNCHECKED_CAST")
            return creator.get() as T
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }
}

@Module
internal abstract class ViewModelBuilder {
    @Binds
    internal abstract fun bindViewModelFactory(
        factory: ViewModelFactory
    ): ViewModelProvider.Factory
}

@Module
abstract class ViewModelModule {
    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

}
