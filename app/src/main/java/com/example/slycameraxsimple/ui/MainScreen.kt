package com.example.slycameraxsimple.ui

import androidx.compose.runtime.Composable
import com.example.slycameraxsimple.ui.camera.CameraScreen
import com.example.slycameraxsimple.ui.no_permission.NoPermissionScreen
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionState
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState



@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun MainScreen(){

    val cameraPermissionState: PermissionState = rememberPermissionState(permission = android.Manifest.permission.CAMERA)

    MainContent(
        hasPermission = cameraPermissionState.status.isGranted,
        onRequestPermission = cameraPermissionState::launchPermissionRequest
    )
}


@Composable
private fun MainContent(
    hasPermission: Boolean,
    onRequestPermission: ()-> Unit
) {

    if(hasPermission){
        CameraScreen()
    } else {
        NoPermissionScreen(onRequestPermission)
    }

}