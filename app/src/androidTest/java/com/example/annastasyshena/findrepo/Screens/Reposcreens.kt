package com.example.annastasyshena.findrepo.Screens

import android.support.test.espresso.DataInteraction
import android.support.test.espresso.Espresso
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.uiautomator.UiCollection
import android.support.test.uiautomator.UiSelector
import com.example.annastasyshena.findrepo.R
import com.example.annastasyshena.findrepo.Tests
import org.hamcrest.CoreMatchers

/**
 * Created by maluy on 3/31/18.
 */
class Reposcreens:WebScreen() {
    private val elementsInSecondScreen=UiCollection(UiSelector().resourceId("com.example.annastasyshena.findrepo:id/repoListView"))
    private val elementInSecondScreen=UiSelector().resourceId("com.example.annastasyshena.findrepo:id/linearLayout")
    private val errorMessage=uiDevice.findObject(UiSelector().resourceId("com.example.annastasyshena.findrepo:id/snackbar_text"))

    fun getTextFromErrorMessage():String{
        return errorMessage.text
    }

    private fun textInListView(number:Int): DataInteraction {
        val text= Espresso.onData(CoreMatchers.anything()).
                inAdapterView(ViewMatchers.withId(R.id.repoListView)).
                atPosition(number).onChildView(ViewMatchers.withId(R.id.linearLayout)).
                onChildView(ViewMatchers.withId(R.id.repoTextView))
    return text
}

    fun clickOnTextInListView(number:Int){
        textInListView(number).perform(ViewActions.click())
    }

    fun waitUntilListInAView(){
       elementsInSecondScreen.getChildByInstance(elementInSecondScreen,4).waitForExists(wait)


       // elementInSecondScreen.waitForExists(wait)
    }




    }
