package th.ac.up.agr.tnc_pt.Fragment.FirstFragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import th.ac.up.agr.tnc_pt.MainActivity

import th.ac.up.agr.tnc_pt.R

class FirstAtFirstFragment : Fragment() {

    lateinit var rootFragment: View
    lateinit var thisFragment: View
    lateinit var act: MainActivity

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        thisFragment = inflater.inflate(R.layout.fragment_first_at_first, container, false)
        act = activity as MainActivity
        rootFragment = act.firstFragment.fragmentView



        return thisFragment
    }


}
