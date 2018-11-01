package io.github.louistsaitszho.loft

import com.facebook.flipper.android.AndroidFlipperClient
import com.facebook.flipper.android.utils.FlipperUtils
import com.facebook.flipper.plugins.inspector.DescriptorMapping
import com.facebook.flipper.plugins.inspector.InspectorFlipperPlugin
import com.facebook.flipper.plugins.network.NetworkFlipperPlugin
import com.facebook.soloader.SoLoader

class FlipperWrapperImpl : FlipperWrapper {
    override fun init(app: App) {
        SoLoader.init(app, false)
        if (BuildConfig.DEBUG && FlipperUtils.shouldEnableFlipper(app)) {
            AndroidFlipperClient.getInstance(app).run {
                addPlugin(InspectorFlipperPlugin(app, DescriptorMapping.withDefaults()))
                addPlugin(NetworkFlipperPlugin())
                start()
            }
        }
    }
}