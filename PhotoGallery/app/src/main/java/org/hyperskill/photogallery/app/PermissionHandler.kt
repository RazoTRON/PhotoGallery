package org.hyperskill.photogallery.app

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.provider.Settings
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat

private const val TAG = "PermissionsHandler"

@Composable
fun PermissionsHandler(whenGranted: @Composable () -> Unit) {
    Log.e(TAG, "Running Permission handler...")

    val permissionList = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE)

    val context = LocalContext.current

    var allPermIsGranted by remember {
        mutableStateOf(permissionList.all {
            ContextCompat.checkSelfPermission(
                context,
                it
            ) == PackageManager.PERMISSION_GRANTED
        })
    }


    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestMultiplePermissions()
    ) { permMap ->
        permissionList.forEach { permission ->
            when (permMap[permission]) {
                true -> Log.e(TAG, "'$permission' permission granted.")
                false -> Log.e(TAG, "'$permission' permission denied.")
                else -> Log.e(TAG, "'$permission' permission NULL.")
            }
        }
        allPermIsGranted = permissionList.all { perm -> permMap[perm] == true }
    }

    if (allPermIsGranted) {
        Log.e(TAG, "All permissions accepted.")
        whenGranted()
    } else {
        Log.e(TAG, "Request permissions...")
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("These permissions are required for the app to work.")
            Row(horizontalArrangement = Arrangement.spacedBy(20.dp)) {
                Button(onClick = {
                    val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                    intent.data = Uri.parse("package:${context.packageName}")
                    context.startActivity(intent)
                }) {
                    Text("Settings")
                }
                Button(onClick = { launcher.launch(permissionList) }) {
                    Text("Accept")
                }
            }
        }
    }
}