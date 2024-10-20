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
import com.dza.registerv2.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment() {
    private lateinit var binding: FragmentRegisterBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            btnRegister.setOnClickListener {
                val username = txtUser.text.toString()
                val password = txtPassword.text.toString()
                val email = txtEmail.text.toString()
                val phone = txtEmail.text.toString()

                if (username.isNotEmpty() && password.isNotEmpty()) {
                    val intent = Intent(activity, SecondActivity::class.java)
                    intent.putExtra("USERNAME", username)
                    intent.putExtra("EMAIL", email)
                    intent.putExtra("PHONE", phone)
                    intent.putExtra("PASSWORD", password)
                    startActivity(intent)
                } else {
                    Toast.makeText(requireContext(), "Input tidak boleh kosong", Toast.LENGTH_SHORT).show()
                }
            }
            txtLogin.setOnClickListener {
                activity?.findViewById<ViewPager2>(R.id.view_pager)?.currentItem = 1 // Pindah ke tab login (index 1)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        with(binding) {
            txtUser.text?.clear()
            txtEmail.text?.clear()
            txtPhone.text?.clear()
            txtPassword.text?.clear()
            checkbox.isChecked = false
        }
    }
}