package au.com.marshal.paterson.opt.app.modules.reward.ui

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import au.com.marshal.paterson.opt.R
import au.com.marshal.paterson.opt.app.modules.reward.viewmodel.RewardViewModel

class RewardFragment : Fragment() {

    companion object {
        fun newInstance() =
            RewardFragment()
    }

    private lateinit var viewModel: RewardViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.reward_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(RewardViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
