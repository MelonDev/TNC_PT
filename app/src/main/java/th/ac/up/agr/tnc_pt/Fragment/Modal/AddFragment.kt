package th.ac.up.agr.tnc_pt.Fragment.Modal


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_add.view.*
import th.ac.up.agr.tnc_pt.MainActivity

import th.ac.up.agr.tnc_pt.R


class AddFragment : Fragment() {

    lateinit var rootFragment: View
    lateinit var thisFragment: View
    lateinit var act: MainActivity

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        thisFragment = inflater.inflate(R.layout.fragment_add, container, false)
        act = activity as MainActivity
        rootFragment = act.firstFragment.fragmentView

        this.thisFragment.add_fragment_cancel_btn.setOnClickListener {
            act.closeAddModal()
        }

        return thisFragment
    }


}
