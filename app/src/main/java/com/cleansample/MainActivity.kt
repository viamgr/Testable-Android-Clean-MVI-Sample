package com.cleansample

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.cleansample.api_android.location.contract.LocationApiContract
import com.cleansample.navigation.AppNavigator
import com.cleansample.ui_theme.AppMaterialTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var locationApiContract: LocationApiContract

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppMaterialTheme {
                AppNavigator()
            }
        }
    }

    private fun sampleToast(locations: List<String>) {
        Toast.makeText(this@MainActivity, locations.toString(), Toast.LENGTH_LONG).show()
    }

}
