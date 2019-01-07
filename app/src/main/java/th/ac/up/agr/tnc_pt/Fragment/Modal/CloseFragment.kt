package th.ac.up.agr.tnc_pt.Fragment.Modal


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import th.ac.up.agr.tnc_pt.R

class CloseFragment : Fragment() {

    lateinit var fragmentView: View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        this.fragmentView = inflater.inflate(R.layout.fragment_close, container, false)

        this.fragmentManager!!.beginTransaction().remove(this).commit()

        return fragmentView
    }

}
