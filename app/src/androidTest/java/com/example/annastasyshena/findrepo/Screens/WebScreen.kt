package com.example.annastasyshena.findrepo.Screens

import android.support.test.InstrumentationRegistry
import android.support.test.uiautomator.*
import com.example.annastasyshena.findrepo.Tests
import org.junit.Before
import java.util.regex.Pattern


/**
 * Created by maluy on 3/31/18.
 */
 open class WebScreen{
    val texts="^https:\\/\\/github.com.*".toRegex().toPattern()
    val wait=1500L
        protected val uiDevice:UiDevice= UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
        val urlBar= uiDevice.findObject(UiSelector().resourceId("com.android.chrome:id/url_bar"))
        val urlBar2=UiCollection(UiSelector().resourceId("com.android.chrome:id/url_bar"))
        fun getUrlText():String{
            val urlBarText= urlBar.text

            return urlBarText
        }
        fun waitForTextInUrlBar(text:Pattern):UiObject2{
            val urlField:UiObject2=uiDevice.wait(Until.findObject(By.text(text)),wait)
           // uiDevice.findObject(urlBar2.selector.text(text)).waitForExists(wait)
            return urlField
    }

}