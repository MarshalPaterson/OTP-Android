package au.com.marshal.paterson.opt.app.modules.reward.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import au.com.marshal.paterson.opt.R
import kotlinx.android.synthetic.main.reward_fragment.*

class RewardFragment : Fragment() {

    companion object {
        fun newInstance() =
            RewardFragment()
    }

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
        }
    }

}
