package com.example.pstocks

import android.app.Activity
import android.app.Application
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import com.example.pstocks.utils.Sessions.stringEvent
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.system.exitProcess

@HiltAndroidApp
class AppController : Application() {
    var activeActivity: Activity? = null
    init {
        instance = this
    }

    private fun initUnCaughtExceptionHandler() {
        val defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler()
        val unCaughtExceptionHandler = Thread.UncaughtExceptionHandler { thread, ex ->
            try {
                defaultUncaughtExceptionHandler?.uncaughtException(thread, ex)
            } catch (e: Throwable) {
                Log.i("errors", e.message.toString());
            } finally {
                restartApp();
            }
        }
        Thread.setDefaultUncaughtExceptionHandler(unCaughtExceptionHandler)
    }

    private fun restartApp() {
        activeActivity?.let { context ->
            val packageManager: PackageManager = packageManager
            val intent = packageManager.getLaunchIntentForPackage(context.packageName)
            val componentName = intent?.component
            val mainIntent = Intent.makeRestartActivityTask(componentName)
            context.startActivity(mainIntent)
            exitProcess(2)
        }
    }

    private fun eventHandler() {
        val ioScope = CoroutineScope(Dispatchers.IO + Job())

        ioScope.launch {
            stringEvent.collect { value ->
                when(value){
                    "restart_app" -> restartApp()
                }
            }
        }
    }

    private fun setupActivityListener() {
        registerActivityLifecycleCallbacks(object : ActivityLifecycleCallbacks {
            override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {}
            override fun onActivityStarted(activity: Activity) {}
            override fun onActivityResumed(activity: Activity) {
                activeActivity = activity
            }

            override fun onActivityPaused(activity: Activity) {
                activeActivity = null
            }

            override fun onActivityStopped(activity: Activity) {}
            override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {}
            override fun onActivityDestroyed(activity: Activity) {}
        })
    }

    companion object {
        @Volatile private var instance: AppController? = null

        @Synchronized fun getInstance(): AppController {
            return instance as AppController
        }
    }

}