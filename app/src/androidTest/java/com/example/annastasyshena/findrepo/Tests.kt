package com.example.annastasyshena.findrepo

import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso.onData
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import  android.support.test.espresso.Espresso.onView;
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.typeText
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import org.hamcrest.CoreMatchers.anything
import kotlin.jvm.javaClass
import android.support.test.espresso.IdlingResource
import android.support.test.uiautomator.*
import com.example.annastasyshena.findrepo.Screens.*

import org.hamcrest.CoreMatchers.containsString
import org.junit.Assert

/**
 * Created by maluy on 3/23/18.
 */
open class Tests:WebScreen(){


    @Rule @JvmField
    val mActivityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun searchForFirstField() {
        MainScreens().sendTextToFirstField("some")
       val repoScreen=MainScreens().clickOnSearchButton()
        repoScreen.waitUntilListInAView()
        repoScreen.clickOnTextInListView(1)
        val webScreen=WebScreen()
        webScreen.waitForTextInUrlBar(texts)
       val url= webScreen.getUrlText()
        Assert.assertTrue(url.toLowerCase().contains("some"))
    }
    @Test
    fun searchForSecondField(){
        MainScreens().sendTextToSecondField("jack")
        val repoScreen=MainScreens().clickOnViewButton()
        repoScreen.clickOnTextInListView(0)
        val webScreen=WebScreen()
        webScreen.waitForTextInUrlBar(texts)
        val urlBar= uiDevice.findObject(UiSelector().resourceId("com.android.chrome:id/url_bar")).text
        Assert.assertTrue(urlBar.toLowerCase().contains("jack"))
    }
    @Test
    fun searchForNotExistingUser(){
        MainScreens().sendTextToSecondField("vladBurianAAAAAAAA")
        val repoScreen=MainScreens().clickOnViewButton()
      Assert.assertFalse( uiDevice.findObject(UiSelector().resourceId("com.example.annastasyshena.findrepo:id/linearLayout")).waitForExists(wait))
    }
    @Test
    fun serchForNotExistingRepo(){
        MainScreens().sendTextToFirstField("vladBurianAAAAAAAA")
        val repoScreen=MainScreens().clickOnSearchButton()
    Assert.assertFalse( uiDevice.findObject(UiSelector().resourceId("com.example.annastasyshena.findrepo:id/linearLayout")).waitForExists(wait))
    }

}