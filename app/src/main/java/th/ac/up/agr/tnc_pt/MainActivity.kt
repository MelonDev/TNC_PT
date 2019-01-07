package th.ac.up.agr.tnc_pt

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

import kotlinx.android.synthetic.main.activity_main.*
import th.ac.up.agr.tnc_pt.Fragment.MainFirstFragment
import th.ac.up.agr.tnc_pt.Fragment.MainFourthFragment
import th.ac.up.agr.tnc_pt.Fragment.MainSecondFragment
import th.ac.up.agr.tnc_pt.Fragment.MainThirdFragment
import th.ac.up.agr.tnc_pt.Fragment.Modal.AddFragment
import android.graphics.Color.parseColor
import android.os.Build
import android.view.*
import androidx.core.content.ContextCompat
import android.view.View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
import android.view.View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
import th.ac.up.agr.tnc_pt.Fragment.Modal.CloseFragment


class MainActivity : AppCompatActivity() {

    lateinit var firstFragment: MainFirstFragment
    private lateinit var secondFragment: MainSecondFragment
    private lateinit var thirdFragment: MainThirdFragment
    private lateinit var fourthFragment: MainFourthFragment
    private lateinit var addFragment :AddFragment

    private lateinit var lastFragment: Fragment
    private var isCreated = false
    private lateinit var bundle: Bundle
    var ID = 0
    var color = 0
    var key = ""
    private var isModalAddOpened = false
    private var isModalSortOpened = false

    var fragmentOpen: Boolean = false



    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_first -> {
                startFragment(this.firstFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_second -> {
                startFragment(this.secondFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_third -> {
                startFragment(this.thirdFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_fourth -> {
                startFragment(this.fourthFragment)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.firstFragment = MainFirstFragment()
        this.secondFragment = MainSecondFragment()
        this.thirdFragment = MainThirdFragment()
        this.fourthFragment = MainFourthFragment()
        this.addFragment = AddFragment()


        if (ID == 0) {
            navigation.visibility = View.VISIBLE
            navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        } else if (ID == 1) {
            //key = bundle.getString("KEY")
            navigation.visibility = View.GONE
        } else if (ID == 2) {
            //key = bundle.getString("KEY")
            navigation.visibility = View.GONE
        }

        //navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

    }

    override fun onStart() {
        super.onStart()

        if (!isCreated) {
            this.isCreated = true
            startFragment(this.firstFragment)
            navigation.menu.findItem(R.id.navigation_first).isChecked = true


        } else {
            startFragment(this.lastFragment)
        }

        //startFragment(this.firstFragment)

    }

    private fun startFragment(fragment: Fragment) {

        this.lastFragment = fragment

        if (ID == 0) {
            supportFragmentManager
                .beginTransaction()
                //.setCustomAnimations(R.anim.fade_in, R.anim.fade_out)
                .replace(R.id.main_frame, fragment)
                .commit()
        } else if (ID == 1 || ID == 2) {
            supportFragmentManager
                .beginTransaction()
                //.setCustomAnimations(R.anim.fade_in, R.anim.fade_out)
                .replace(R.id.main_modal_frame, fragment)
                .commit()
        }

        supportFragmentManager
            .beginTransaction()
            //.setCustomAnimations(R.anim.fade_in, R.anim.fade_out)
            .replace(R.id.main_frame, fragment)
            .commit()


    }

    fun openAddModal() {
        this.isModalAddOpened = true

        updateStatusBarColor(R.color.colorSecondDark,false)

        supportFragmentManager.beginTransaction()
            .setCustomAnimations(R.anim.slide_up, R.anim.slide_down)
            .replace(R.id.main_modal_frame, addFragment)
            .commit()
        fragmentOpen = true
    }

    fun closeAddModal() {

        updateStatusBarColor(R.color.colorLightStatusBar,true)


        supportFragmentManager.beginTransaction()
            .setCustomAnimations(R.anim.slide_up, R.anim.slide_down)
            .replace(R.id.main_modal_frame, CloseFragment())
            .commit()
        fragmentOpen = false

    }

    override fun onBackPressed() {
        if (fragmentOpen /*|| peopleFragment.fragmentOpen*/) {
            closeAddModal()
            //closeSortModal()
            /*
            if(peopleFragment.fragmentOpen){
                peopleFragment.apply {
                    this.data.clear()
                    this.data.addAll(lastData)
                    this.notiHere()
                    this.closeSearchModal()
                }
            }
            */
        } else {
            super.onBackPressed()
        }
    }

    fun updateStatusBarColor(color: Int,lightStatusBar :Boolean) {// Color must be in hexadecimal fromat
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window = window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = ContextCompat.getColor(this,color)

            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                var flags = this.window.decorView.systemUiVisibility

                if(lightStatusBar){
                    flags = flags or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
                    this.window.decorView.systemUiVisibility = flags
                }else {
                    flags = flags xor View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
                    this.window.decorView.systemUiVisibility = flags
                }

                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
                    if(lightStatusBar){
                        flags = flags xor View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR
                        this.window.decorView.systemUiVisibility = flags
                        window.navigationBarColor = ContextCompat.getColor(this,R.color.colorPrimaryDark)

                    }else {
                        flags = flags or View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR
                        this.window.decorView.systemUiVisibility = flags
                        window.navigationBarColor = ContextCompat.getColor(this,R.color.colorLightNavigationBar)

                    }
                }else {
                    if(lightStatusBar) {
                        window.navigationBarColor = ContextCompat.getColor(this,R.color.colorPrimaryDark)
                    }else {
                        window.navigationBarColor = ContextCompat.getColor(this,R.color.colorText)
                    }
                }
            }
        }
    }


}
