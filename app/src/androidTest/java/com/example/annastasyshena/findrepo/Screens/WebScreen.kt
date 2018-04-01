package com.example.annastasyshena.findrepo.Screens

import android.support.test.InstrumentationRegistry
import android.support.test.uiautomator.UiDevice
import android.support.test.uiautomator.UiSelector
import org.junit.Before


/**
 * Created by maluy on 3/31/18.
 */
class WebScreen{
  protected lateinit var  uiDevice: UiDevice

  @Before
  fun initalazed(){
    uiDevice= UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
  }

    fun getUrlText():String{
      val urlBar= uiDevice.findObject(UiSelector().resourceId("com.android.chrome:id/url_bar")).text

     return urlBar
    }

}