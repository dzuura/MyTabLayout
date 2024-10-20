package com.dza.registerv2

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import com.dza.registerv2.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            btnLogin.setOnClickListener {
                val username = binding.txtUser.text.toString()
                val password = binding.txtPassword.text.toString()

                if (username.isNotEmpty() && password.isNotEmpty()) {
                    val intent = Intent(activity, SecondActivity::class.java)
                    intent.putExtra("USERNAME", username)
                    intent.putExtra("PASSWORD", password)
                    startActivity(intent)
                } else {
                    Toast.makeText(requireContext(), "Input tidak boleh kosong", Toast.LENGTH_SHORT).show()
                }
            }
            txtRegister.setOnClickListener {
                activity?.findViewById<ViewPager2>(R.id.view_pager)?.currentItem = 0 // Pindah ke tab login (index 1)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        with(binding) {
            txtUser.text?.clear()
            txtPassword.text?.clear()
            checkbox.isChecked = false
        }
    }
}