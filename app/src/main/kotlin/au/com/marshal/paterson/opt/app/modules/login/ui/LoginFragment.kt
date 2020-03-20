package au.com.marshal.paterson.opt.app.modules.login.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import au.com.marshal.paterson.opt.R
import au.com.marshal.paterson.opt.app.modules.login.viewmodel.LoginViewModel
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.login_fragment.*
import javax.inject.Inject


class LoginFragment : DaggerFragment() {

    @Inject
    lateinit var loginModelFactory: ViewModelProvider.Factory

    var status: String = ""
    private val viewModel by viewModels<LoginViewModel> { loginModelFactory }

    companion object {
        fun newInstance() = LoginFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.login_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val loginObserver = Observer<String> { newstatus ->
            status = newstatus
            result.text = status
        }
        viewModel.login.observe(viewLifecycleOwner, loginObserver)

        loginBtn.setOnClickListener {
            print("this")
            viewModel.doLogin()
        }
    }
}
