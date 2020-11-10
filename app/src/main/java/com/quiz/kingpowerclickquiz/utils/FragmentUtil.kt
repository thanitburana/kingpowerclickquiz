package com.quiz.kingpowerclickquiz.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

object FragmentUtil {
    fun add(fragmentActivity: FragmentActivity, tag: String, view: Int, fragment: Fragment) {
        fragmentActivity.supportFragmentManager.beginTransaction().add(
            view, fragment, tag
        ).commit()
    }

    fun replace(fragmentActivity: FragmentActivity, tag: String, view: Int, fragment: Fragment){
        fragmentActivity.supportFragmentManager.beginTransaction().replace(
            view,fragment,tag
        ).addToBackStack(null).commit()
    }

    fun remove(fragmentActivity: FragmentActivity, tag: String){
       val fragment =  fragmentActivity.supportFragmentManager.findFragmentByTag(tag) as Fragment
        fragmentActivity.supportFragmentManager.beginTransaction().remove(
            fragment
        ).commit()
    }

    fun addChild(fragmentMain: Fragment, tag: String, view: Int, fragment: Fragment) {
        fragmentMain.childFragmentManager.beginTransaction().add(
            view, fragment, tag
        ).commit()
    }

    fun replaceChild(fragmentMain: Fragment, tag: String, view: Int, fragment: Fragment){
        fragmentMain.childFragmentManager.beginTransaction().replace(
            view,fragment,tag
        ).addToBackStack(null).commit()
    }

    fun removeChild(fragmentMain: Fragment, tag: String){
        val fragment =  fragmentMain.childFragmentManager.findFragmentByTag(tag) as Fragment
        fragmentMain.childFragmentManager.beginTransaction().remove(
            fragment
        ).commit()
    }
}