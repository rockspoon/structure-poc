package com.example.poc.ui

import android.graphics.drawable.AnimatedVectorDrawable
import android.os.Bundle
import android.view.View
import com.example.poc.core.ui.common.BindableFragment
import com.example.poc.databinding.LaunchFragmentBinding

class SplashFragment : BindableFragment<LaunchFragmentBinding>() {

    override fun viewBindingInflate() = LaunchFragmentBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (binding.launcherImageView.drawable as AnimatedVectorDrawable).start()
    }

}