package com.example.viewpager2biometricauthentication.fragment

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.biometric.BiometricManager
import androidx.biometric.BiometricManager.Authenticators.BIOMETRIC_STRONG
import androidx.biometric.BiometricManager.Authenticators.DEVICE_CREDENTIAL
import androidx.biometric.BiometricPrompt
import androidx.core.content.ContextCompat
import com.example.viewpager2biometricauthentication.databinding.FragmentTouchIdBinding
import java.util.concurrent.Executor

class TouchIdFragment : Fragment() {

    private lateinit var binding: FragmentTouchIdBinding
    private lateinit var executor: Executor
    private lateinit var biometricPrompt: BiometricPrompt
    private lateinit var promptInfo: BiometricPrompt.PromptInfo

    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTouchIdBinding.inflate(inflater, container, false)


        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.P)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.authButton.setOnClickListener {
            if (isBiometricAvailable()) {
                authButtonClicked()
            }
        }
    }


    fun isBiometricAvailable(): Boolean {
        val biometricManager = BiometricManager.from(requireContext())
        return when (biometricManager.canAuthenticate(BIOMETRIC_STRONG or DEVICE_CREDENTIAL)) {
            BiometricManager.BIOMETRIC_SUCCESS -> {
                notifyUser("BIOMETRIC_SUCCESS")
                true
            }

            BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE -> {
                notifyUser("BIOMETRIC_ERROR_NO_HARDWARE")
                false
            }

            BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE -> {
                notifyUser("BIOMETRIC_ERROR_HW_UNAVAILABLE")
                false
            }
            else -> false
        }
    }

    fun notifyUser(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    @RequiresApi(Build.VERSION_CODES.P)
    fun authButtonClicked() {

        executor = ContextCompat.getMainExecutor(requireContext())
        biometricPrompt = BiometricPrompt(this, executor,
            object : BiometricPrompt.AuthenticationCallback() {
                override fun onAuthenticationError(
                    errorCode: Int,
                    errString: CharSequence
                ) {
                    super.onAuthenticationError(errorCode, errString)
                    Toast.makeText(
                        requireContext(),
                        "$errString", Toast.LENGTH_SHORT
                    )
                        .show()
                }

                override fun onAuthenticationSucceeded(
                    result: BiometricPrompt.AuthenticationResult
                ) {
                    super.onAuthenticationSucceeded(result)
                    Toast.makeText(
                        requireContext(),
                        "BAŞARILI!", Toast.LENGTH_SHORT
                    )
                        .show()
                }

                override fun onAuthenticationFailed() {
                    super.onAuthenticationFailed()
                    Toast.makeText(
                        requireContext(), "BAŞARISIZ!",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                }
            })

        promptInfo = BiometricPrompt.PromptInfo.Builder()
            .setTitle("Touch ID")
            .setSubtitle("Lütfen sensöre parak izinizi okutunuz.")
            .setNegativeButtonText("VAZGEÇ")
            .setDescription("Bu app TouchID implemantasyonunu denemek için yapılmıştır.")
            .build()


        biometricPrompt.authenticate(promptInfo)
    }

}