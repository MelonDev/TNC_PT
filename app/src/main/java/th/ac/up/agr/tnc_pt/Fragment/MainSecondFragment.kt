package th.ac.up.agr.tnc_pt.Fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import th.ac.up.agr.tnc_pt.MainActivity

import th.ac.up.agr.tnc_pt.R

class MainSecondFragment : Fragment() {


    lateinit var fragmentView: View
    lateinit var act: MainActivity

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        fragmentView = inflater.inflate(R.layout.fragment_main_second, container, false)
        act = activity as MainActivity





        return fragmentView
    }


}
