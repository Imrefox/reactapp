package io.codemagic.reactapp

import android.app.Application
import com.facebook.react.PackageList
import com.facebook.react.ReactApplication
import com.facebook.react.ReactHost
import com.facebook.react.ReactNativeApplicationEntryPoint.loadReactNative
import com.facebook.react.defaults.DefaultReactHost.getDefaultReactHost


// 1. Import the plugin class.
import com.microsoft.codepush.react.CodePush

class MainApplication : Application(), ReactApplication {

    override val reactHost: ReactHost by lazy {
        getDefaultReactHost(
            context = applicationContext,
            packageList = PackageList(this).packages.apply {
                // Packages that cannot be autolinked yet can be added manually here
                // add(MyReactNativePackage())
            },
            // 2. Set jsBundleFilePath so CodePush resolves the JS bundle at startup
            jsBundleFilePath = CodePush.getJSBundleFile(),
        )
    }

    override fun onCreate() {
        super.onCreate()
        loadReactNative(this)
    }
}
