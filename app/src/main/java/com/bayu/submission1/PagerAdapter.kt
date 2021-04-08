package com.bayu.submission1

import android.content.Context
import android.os.Bundle
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class PagerAdapter(private val mContext: Context, fragment: FragmentManager, data: Bundle) :
    FragmentPagerAdapter(
        fragment,
        BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
    ) {

    private var fragmentBundle: Bundle

    init {
        fragmentBundle = data
    }

    @StringRes
    private val TAB_TITLE = intArrayOf(R.string.tab_1, R.string.tab_2)

    override fun getCount(): Int = 2

    override fun getItem(position: Int): Fragment {
        var fm: Fragment? = null
        when (position) {
            0 -> fm = FollowerFragment()
            1 -> fm = FollowingFragment()
        }
        fm?.arguments = this.fragmentBundle
        return fm as Fragment
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return mContext.resources.getString(TAB_TITLE[position])
    }
}