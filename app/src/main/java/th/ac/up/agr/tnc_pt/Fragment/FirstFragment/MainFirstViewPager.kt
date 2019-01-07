package th.ac.up.agr.tnc_pt.Fragment.FirstFragment

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.fragment_main_first.*
import kotlinx.android.synthetic.main.fragment_main_first.view.*
import th.ac.up.agr.tnc_pt.Fragment.MainFirstFragment
import th.ac.up.agr.tnc_pt.MainActivity


class MainFirstViewPager(val activity: MainActivity, val rootFragment: MainFirstFragment) {


    init {
        setupViewPager()
    }

    fun setupViewPager() {

        //Log.e("STATUS", "ViewPager")

        //activity.programFragment.fab = activity.program_main_activity_fab

        val viewPager = rootFragment.fragmentView.main_first_fragment_viewpager
        setupViewPager(viewPager)

        val pageListener = PageListener()
        viewPager.setOnPageChangeListener(pageListener)

        rootFragment.fragmentView.main_first_fragment_tabbar.setupWithViewPager(viewPager)

    }

    private fun setupViewPager(viewPager: ViewPager) {
        //val adapter = ViewPagerAdapter(myContext.supportFragmentManager)
        val adapter = ViewPagerAdapter(activity.supportFragmentManager)
        //adapter.addFragment(activity.programFragment, "รายการ")
        adapter.addFragment(rootFragment.firstAtFirstFragment, "รายการ")
        //adapter.addFragment(activity.notificationFragment, "แจ้งเตือน")
        adapter.addFragment(rootFragment.secondAtFirstFragment, "แจ้งเตือน")
        //adapter.addFragment(activity.historyFragment, "ประวัติ")
        adapter.addFragment(rootFragment.thirdAtFirstFragment, "ประวัติ")

        viewPager.adapter = adapter
        viewPager.offscreenPageLimit = 3

        //OverScrollDecoratorHelper.setUpOverScroll(viewPager)

    }

    private inner class PageListener : ViewPager.SimpleOnPageChangeListener() {
        override fun onPageSelected(position: Int) {
            //Log.e("PAGE", "page selected $position")

            //activity.programFragment.fab = activity.program_main_activity_fab
            /*
            if (position == 0) {
                activity.fab.show()
                //Log.e("PAGE", "0")
                activity.historyFragment.onStop()
                activity.notificationFragment.onStop()
            } else if (position == 1){
                activity.fab.hide()
                //Log.e("PAGE", "1")
                activity.notificationFragment.onLoad()
                activity.programFragment.onStop()
                activity.historyFragment.onStop()
            } else if(position == 2){
                activity.fab.hide()
                //Log.e("PAGE", "2")
                activity.programFragment.onStop()
                activity.notificationFragment.onStop()
            }
*/


            /*
            if (position == 0) {
                activity.fab.show()
                //Log.e("PAGE", "0")
                //activity.historyFragment.onStop()
                //activity.notificationFragment.onStop()
            } else if (position == 1){
                activity.fab.hide()
                //Log.e("PAGE", "1")
                //activity.notificationFragment.onLoad()
                //activity.programFragment.onStop()
                //activity.historyFragment.onStop()
            } else if(position == 2){
                activity.fab.hide()
                //Log.e("PAGE", "2")
                //activity.programFragment.onStop()
                //activity.notificationFragment.onStop()
            }
            */


/*
            when (position) {
                0 -> {
                    activity.notificationFragment.reset()
                    activity.historyFragment.reset()
                }
                1 -> {
                    activity.programFragment.reset()
                    activity.historyFragment.reset()
                }
                2 -> {
                    activity.notificationFragment.reset()
                    activity.programFragment.reset()
                }
            }
            */
            //resetAll()
            //currentPage = position
        }
    }

    private inner class ViewPagerAdapter(manager: FragmentManager) : FragmentPagerAdapter(manager) {
        private val mFragmentList = ArrayList<Fragment>()
        private val mFragmentTitleList = ArrayList<String>()

        override fun getItem(position: Int): Fragment {
            return mFragmentList[position]
        }

        override fun getCount(): Int {
            return mFragmentList.size
        }

        fun addFragment(fragment: Fragment, title: String) {
            mFragmentList.add(fragment)
            mFragmentTitleList.add(title)
            //Log.e("Test", title)
        }

        override fun getPageTitle(position: Int): CharSequence {
            return mFragmentTitleList[position]
        }
    }


}