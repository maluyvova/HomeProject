package com.example.annastasyshena.findrepo.Screens

import android.support.test.InstrumentationRegistry
import android.support.test.uiautomator.UiDevice
import org.junit.Before

/**
 * Created by maluy on 3/31/18.
 */
open class Settings(){
    protected lateinit var  uiDevice: UiDevice
   @Before
    fun intishilazed(){
        uiDevice= UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())}
}