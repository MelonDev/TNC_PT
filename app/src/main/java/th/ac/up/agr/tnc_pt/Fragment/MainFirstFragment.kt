package th.ac.up.agr.tnc_pt.Fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_main_first.view.*
import th.ac.up.agr.tnc_pt.Fragment.FirstFragment.FirstAtFirstFragment
import th.ac.up.agr.tnc_pt.Fragment.FirstFragment.MainFirstViewPager
import th.ac.up.agr.tnc_pt.Fragment.FirstFragment.SecondAtFirstFragment
import th.ac.up.agr.tnc_pt.Fragment.FirstFragment.ThirdAtFirstFragment
import th.ac.up.agr.tnc_pt.MainActivity

import th.ac.up.agr.tnc_pt.R

class MainFirstFragment : Fragment() {

    lateinit var fragmentView: View
    lateinit var act: MainActivity

    val firstAtFirstFragment :FirstAtFirstFragment = FirstAtFirstFragment()
    val secondAtFirstFragment :SecondAtFirstFragment = SecondAtFirstFragment()
    val thirdAtFirstFragment :ThirdAtFirstFragment = ThirdAtFirstFragment()



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        fragmentView = inflater.inflate(R.layout.fragment_main_first, container, false)
        act = activity as MainActivity


        MainFirstViewPager(act,this)

        fragmentView.main_first_add_btn.setOnClickListener {
            act.openAddModal()
        }



        return fragmentView
    }


}
