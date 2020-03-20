package au.com.marshal.paterson.opt.app.modules.login.ui

import android.content.Context
import android.os.Bundle
import au.com.marshal.paterson.opt.R
import dagger.android.AndroidInjection
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class LoginActivity : DaggerAppCompatActivity() {
    @Inject
    lateinit var app: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        if (supportActionBar != null)
            supportActionBar?.hide()
    }
}
