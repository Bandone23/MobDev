package com.example.mobdevdogs.ui.activity

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.mobdevdogs.R
import com.example.mobdevdogs.ui.interfaces.FragmentHandling

class MainBreedsActivity : BaseActivity(), FragmentHandling {


    /*   private var fragmentpartidos: MatchFragment? = null
       private var fragmentresult : ResultMatchFragment? = null*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_breeds)

    }


    override fun addFromFragment(fragment: Fragment, text: String) {
        addFragmentToBackStack(fragment, text)
    }

    override fun replaceFromFragment(fragment: Fragment) {
        replaceFragment(fragment)
    }
    private fun replaceFragment(fragment: Fragment) {
//        fm.beginTransaction().hide(active).show(fragment).commit()
//        active = fragment
    }



}