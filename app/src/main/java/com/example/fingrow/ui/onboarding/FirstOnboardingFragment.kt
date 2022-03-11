package com.example.fingrow.ui.onboarding

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.fingrow.databinding.FragmentFirstOnboardingBinding

class FirstOnboardingFragment : Fragment() {

    object Constants {
        const val MY_POS = 1
    }

    private var _binding: FragmentFirstOnboardingBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val onboardingViewModel =
            ViewModelProvider(requireActivity())[OnboardingViewModel::class.java]

        _binding = FragmentFirstOnboardingBinding.inflate(inflater, container, false)

        onboardingViewModel.setPos(Constants.MY_POS)
        onboardingViewModel.setValid(binding.toggleGroup.checkedButtonIds.isNotEmpty())

        binding.toggleGroup.addOnButtonCheckedListener { _, _, isChecked ->
            if (isChecked) {
                onboardingViewModel.setValid(true)
            }
        }

        return binding.root
    }
}