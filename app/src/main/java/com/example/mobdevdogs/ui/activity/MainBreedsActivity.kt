package com.example.mobdevdogs.ui.activity

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.core.extension.observe
import com.example.mobdevdogs.R
import com.example.core.coroutines.Result
import com.example.mobdevdogs.databinding.ActivityMainBreedsBinding
import com.example.mobdevdogs.domain.model.Breeds
import com.example.mobdevdogs.presentation.viewmodel.BreedsViewModel
import com.example.mobdevdogs.ui.interfaces.FragmentHandling
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainBreedsActivity : BaseActivity(), FragmentHandling {
    private val viewModel: BreedsViewModel by viewModel()
    lateinit var binding: ActivityMainBreedsBinding
    private var breedsList: List<String> = listOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.initAdapter(breeds = breedsList)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main_breeds)
        binding.lifecycleOwner = this
        with(viewModel) {
            observe(breedsLiveData, ::breedsObserver)
        }


        viewModel.getBreeds()

    }


    private fun breedsObserver(result: Result<Breeds>?) {
        when (result) {
            is Result.OnSuccess -> {
                if (result.value.message.isNotEmpty()) {
                    breedsList = result.value.message
                    viewModel.updateBreeds(breedsList)


                }else {

                }
            }
            is Result.OnLoading -> onLoading()
            is Result.OnError -> onError()
            else -> onUnexpectedError()
        }
    }


    private fun breedsClicked(breeds: String, viewId: Int) {
        when (viewId) {
            R.id.cardBreeds -> {
               /* val auditMatchFragment =
                    AuditMatchFragment.newInstance(matches.time_match, matches.date)
                auditMatchFragment.show(fragmentManager!!, "audit match")
*/

            }

        }
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