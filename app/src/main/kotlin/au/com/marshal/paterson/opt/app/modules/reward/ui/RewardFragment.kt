package au.com.marshal.paterson.opt.app.modules.reward.ui

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import au.com.marshal.paterson.opt.R
import au.com.marshal.paterson.opt.app.modules.login.viewmodel.LoginViewModel
import au.com.marshal.paterson.opt.app.modules.reward.viewmodel.RewardViewModel
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class RewardFragment : DaggerFragment() {

    companion object {
        fun newInstance() =
            RewardFragment()
    }

    @Inject
    lateinit var rewardModelFactory: ViewModelProvider.Factory
    private val viewModel by viewModels<RewardViewModel> { rewardModelFactory }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.reward_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
       // viewModel = ViewModelProviders.of(this).get(RewardViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
