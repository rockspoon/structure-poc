package com.example.poc.core.ui.common

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

// There was multiple attempts to make a glorious lazy extension Fragment.viewBiding(). Many
// developers tried with the lifecycle callbacks, all failed to produce one bug free extension,
// which explain why such extension was not promptly created by the Android Team. It's not as
// trivial as it looks and some weird bugs happens when you try to, for example, change device's
// orientation. For now we will have to stick with inheritance or manually do it.
abstract class BindableFragment<T : ViewBinding> : Fragment() {

    private var _binding: T? = null
    val binding by lazy { _binding!! }

    /**
     * Override this with the T.inflate(LayoutInflater) method.
     *
     * e.g.: MyFragmentBinding.inflate(layoutInflater)
     */
    abstract fun viewBindingInflate(): T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = viewBindingInflate()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = binding.root

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}