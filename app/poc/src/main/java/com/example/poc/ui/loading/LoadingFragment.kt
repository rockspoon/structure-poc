package com.example.poc.ui.loading

import android.graphics.drawable.AnimatedVectorDrawable
import android.os.Bundle
import android.view.View
import com.example.poc.core.ui.common.BindableFragment
import com.example.poc.databinding.LoadingFragmentBinding

class LoadingFragment : BindableFragment<LoadingFragmentBinding>() {

    override fun viewBindingInflate() = LoadingFragmentBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (binding.launcherImageView.drawable as AnimatedVectorDrawable).start()
    }

}