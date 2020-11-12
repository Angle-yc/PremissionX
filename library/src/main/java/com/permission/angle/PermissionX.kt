package com.permission.angle

import androidx.fragment.app.FragmentActivity

/**
 *  作者    angle
 *  时间    2020/11/12 3:34 PM
 *  文件    PermissionX
 *  描述
 */
object PermissionX {
    private const val TAG = "InvisibleFragment"


    fun request(activity: FragmentActivity, vararg permission: String,callback: PermissionCallback){
        val fragmenManager = activity.supportFragmentManager
        val existedFragment = fragmenManager.findFragmentByTag(TAG)
        val fragment = if (existedFragment != null){
            existedFragment as InvisibleFragment
        } else {
            val invisibleFragment = InvisibleFragment()
            fragmenManager.beginTransaction().add(invisibleFragment, TAG).commitNow()
            invisibleFragment
        }
        fragment.requestNow(callback,*permission)
    }
}