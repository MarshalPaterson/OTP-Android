package au.com.marshal.paterson.opt.app.modules.reward.di

import androidx.lifecycle.ViewModel
import au.com.marshal.paterson.opt.app.ViewModelKey
import au.com.marshal.paterson.opt.app.modules.login.ui.LoginFragment
import au.com.marshal.paterson.opt.app.modules.login.viewmodel.LoginViewModel
import au.com.marshal.paterson.opt.app.modules.reward.ui.RewardFragment
import au.com.marshal.paterson.opt.app.modules.reward.viewmodel.RewardViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module(includes = [RewardModuleBinds::class])
class RewardModule


@Module
abstract class RewardModuleBinds {

    @ContributesAndroidInjector
    abstract fun bindRewardFragment(): RewardFragment

    @Binds
    @IntoMap
    @ViewModelKey(RewardViewModel::class)
    abstract fun bindReviewViewModel(rewardViewModel: RewardViewModel): ViewModel

}