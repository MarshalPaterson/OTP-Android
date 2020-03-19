package au.com.marshal.paterson.opt.app.modules.login.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import au.com.marshal.paterson.opt.R
import au.com.marshal.paterson.opt.app.modules.login.viewmodel.LoginViewModel
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.login_fragment.*
import javax.inject.Inject


class LoginFragment : DaggerFragment() {

    @Inject
    lateinit var loginModelFactory: ViewModelProvider.Factory


    private val viewModel by viewModels<LoginViewModel> { loginModelFactory  }

    companion object {
        fun newInstance() = LoginFragment()
    }

   // private lateinit var viewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.login_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
//        viewModel = ViewModelProviders.of(this, loginModelFactory).get<LoginViewModel>(
//            LoginViewModel::class.java
//        )
     //   viewModel = ViewModelProviders.of(this).get<LoginViewModel>(LoginViewModel::class.java)
     //   viewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)

        loginBtn.setOnClickListener {
            print("this")
        }
    }
}
