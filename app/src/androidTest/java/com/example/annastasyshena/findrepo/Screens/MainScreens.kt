package com.example.annastasyshena.findrepo.Screens

import android.support.test.espresso.Espresso
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.matcher.ViewMatchers
import com.example.annastasyshena.findrepo.R
import junit.framework.Assert

/**
 * Created by maluy on 3/31/18.
 */
class MainScreens:Settings() {
    private val firstField= Espresso.onView(ViewMatchers.withId(R.id.SearchEditText))
    private val serchButton= Espresso.onView(ViewMatchers.withId(R.id.searchButton))
    private val secondField=Espresso.onView(ViewMatchers.withId(R.id.userRepoEditText))
    private val viewButton=Espresso.onView(ViewMatchers.withId(R.id.userRepoButton))

    public fun sendTextToFirstField(text:String){
        firstField.perform(ViewActions.typeText(text))
    }
    public fun clickOnSearchButton():Reposcreens{
        serchButton.perform(ViewActions.click())
        return Reposcreens()
    }
    public fun sendTextToSecondField(text:String){
        secondField.perform(ViewActions.typeText(text))
    }
    public fun clickOnViewButton(): Reposcreens {
        viewButton.perform(ViewActions.click())
        return Reposcreens()
    }
}