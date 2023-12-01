package com.stu.paymentstestapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.stu.paymentstestapp.features.login.repositories.AuthenticationRepository
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject lateinit var authenticationRepository: AuthenticationRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        prepareRootNavController(authenticationRepository.isSignedIn())
    }

    private fun prepareRootNavController(isSignedIn: Boolean) {
        val navController = getRootNavController()
        val graph = navController.navInflater.inflate(R.navigation.nav_graph)
        graph.setStartDestination(
            if (isSignedIn) {
                R.id.paymentListFragment
            } else {
                R.id.loginFragment
            }
        )
        navController.graph = graph
    }


    private fun getRootNavController(): NavController {
        val navHost = supportFragmentManager.findFragmentById(R.id.fragmentContainer) as NavHostFragment
        return navHost.navController
    }
}