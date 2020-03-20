package au.com.marshal.paterson.opt.app.modules.reward.ui

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavHostController
import androidx.navigation.findNavController
import au.com.marshal.paterson.opt.R
import au.com.marshal.paterson.opt.app.modules.login.viewmodel.LoginViewModel
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.reward_fragment.*
import javax.inject.Inject

class RewardFragment : Fragment() {

    companion object {
        fun newInstance() =
            RewardFragment()
    }

//    @Inject
//    lateinit var rewardModelFactory: ViewModelProvider.Factory
//    private val viewModel by viewModels<RewardViewModel> { rewardModelFactory }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.reward_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        back.setOnClickListener {
           view?.findNavController()?.popBackStack()
           // view?.findNavController()?.navigate(R.id.action_rewardFragment_to_loginFragment)
        }
    }

}
