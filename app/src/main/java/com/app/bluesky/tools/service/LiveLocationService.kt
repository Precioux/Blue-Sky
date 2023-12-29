import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat

class MainActivity : ComponentActivity() {

    private lateinit var locationManager: LocationManager
    private var locationListener: LocationListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager

        setContent {
            MyApp()
        }
    }

    @Composable
    fun MyApp() {
        var locationResult by remember { mutableStateOf<Location?>(null) }
        var isPermissionGranted by remember { mutableStateOf(false) }

        val context = LocalContext.current

        DisposableEffect(context) {
            isPermissionGranted = checkLocationPermission(context)
            onDispose { }
        }

        val requestPermissionLauncher =
            registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted: Boolean ->
                if (isGranted) {
                    isPermissionGranted = true
                } else {
                    Toast.makeText(context, "Location permission denied", Toast.LENGTH_SHORT).show()
                }
            }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text("Current Location:")

            if (locationResult != null) {
                Text("Latitude: ${locationResult!!.latitude}")
                Text("Longitude: ${locationResult!!.longitude}")
            } else {
                Text("Location not available")
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    if (isPermissionGranted) {
                        startLocationUpdates()
                    } else {
                        requestPermissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
                    }
                }
            ) {
                Text("Get Location")
            }
        }
    }

    private fun startLocationUpdates() {
        if (checkLocationPermission(this)) {
            locationListener = object : LocationListener {
                override fun onLocationChanged(location: Location) {
                    // Handle location updates
                    Toast.makeText(this@MainActivity, "Location updated", Toast.LENGTH_SHORT).show()
                    // Update the UI with the location
                }

                override fun onProviderEnabled(provider: String) {}

                override fun onProviderDisabled(provider: String) {}

                override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {}
            }

            locationManager.requestLocationUpdates(
                LocationManager.GPS_PROVIDER,
                0L,
                0f,
                locationListener!!
            )
        }
    }

    private fun checkLocationPermission(context: android.content.Context): Boolean {
        return (ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED)
    }
}
