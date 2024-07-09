package com.mendoza.ana.poketinder.ui.view

import android.content.ContentValues.TAG
import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.iid.FirebaseInstanceId
import com.google.firebase.iid.InstanceIdResult
import com.mendoza.ana.poketinder.R
import com.mendoza.ana.poketinder.databinding.ActivitySplashBinding
import com.mendoza.ana.poketinder.ui.viewmodel.SplashViewModel
import com.yuyakaido.android.cardstackview.Direction

class SplashActivity : BaseActivity<ActivitySplashBinding>(ActivitySplashBinding::inflate) {

    private val splashViewModel: SplashViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.let {
            it.setDisplayShowHomeEnabled(true)
            it.setDisplayUseLogoEnabled(true)
            it.setLogo(R.drawable.logo_blanco) // Asegúrate de que logo_blanco está en tus recursos drawable

            // Establecer el color de fondo de la ActionBar
            it.setBackgroundDrawable(ColorDrawable(ContextCompat.getColor(this, R.color.purple_500)))
        }
        FirebaseInstanceId.getInstance().instanceId
            .addOnCompleteListener(OnCompleteListener<InstanceIdResult> { task ->
                if (!task.isSuccessful) {
                    Log.w(TAG, "getInstanceId failed", task.exception)
                    return@OnCompleteListener
                }
                // Get new Instance ID token
                val token = task.result?.token
                Log.d("FIREBASE TOKEN", "Token: $token")
            })

        splashViewModel.getIsUnderMaintenance().observe(this) { isUnderMaintenance ->
            if (isUnderMaintenance) {
                Toast.makeText(this, "Bajo Mantenimiento", Toast.LENGTH_SHORT).show()
            } else {
                showAnimation()
            }
        }
    }

    override fun OnCardDragging(direction: Direction?, ratio: Float) {
        // Implementar si es necesario
    }

    override fun OnCardRewound() {
        // Implementar si es necesario
    }

    private fun showAnimation() {
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, 3000)
    }
}
