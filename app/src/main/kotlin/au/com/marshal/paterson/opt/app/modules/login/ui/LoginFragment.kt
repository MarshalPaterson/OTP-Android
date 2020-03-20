package au.com.marshal.paterson.opt.app.modules.login.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import au.com.marshal.paterson.opt.R
import au.com.marshal.paterson.opt.app.modules.login.viewmodel.LoginViewModel
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.login_fragment.*
import javax.inject.Inject


class LoginFragment : DaggerFragment() {

    @Inject
    lateinit var loginModelFactory: ViewModelProvider.Factory

    //var status: String = ""
    private val viewModel by viewModels<LoginViewModel> { loginModelFactory }
    private var gotoFlag: Boolean = false

    companion object {
        fun newInstance() = LoginFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.login_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        result.text = ""
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val loginObserver = Observer<String> { newstatus ->

            if (newstatus == "ok" && !gotoFlag) {
                result.text = ""
                gotoFlag = true
                goto()
            } else {
                result.text = newstatus
                progress_loader.visibility = View.GONE
            }
        }
        viewModel.login.observe(viewLifecycleOwner, loginObserver)

        loginBtn.setOnClickListener {
            showLoading()
            gotoFlag = false
            viewModel.doLogin(otpNumber.text.toString())
        }

    }

    fun showLoading() {
        progress_loader.visibility = View.VISIBLE
    }

    fun goto() {
        view?.findNavController()?.navigate(R.id.action_loginFragment_to_rewardFragment)
        progress_loader.visibility = View.GONE
    }
}
