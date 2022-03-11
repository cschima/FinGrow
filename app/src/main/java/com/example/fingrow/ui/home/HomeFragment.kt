package com.example.fingrow.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.fingrow.R
import com.example.fingrow.databinding.FragmentHomeBinding
import com.example.fingrow.ui.onboarding.OnboardingActivity

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val resultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == AppCompatActivity.RESULT_OK) {
                addGoal()
            }
        }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.textHome.text = getString(
            R.string.main_heading, activity?.getSharedPreferences(
                "login",
                AppCompatActivity.MODE_PRIVATE
            )?.getString("user", "")
        )

        binding.addGoalButton.setOnClickListener {
            val intent = Intent(activity, NewGoalActivity::class.java)
            resultLauncher.launch(intent)
        }

        return binding.root
    }

    private fun addGoal() {
        // TODO
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}