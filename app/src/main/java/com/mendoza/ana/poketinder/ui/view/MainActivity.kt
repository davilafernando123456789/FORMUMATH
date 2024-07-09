package com.mendoza.ana.poketinder.ui.view

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.mendoza.ana.poketinder.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.let {
            it.setDisplayShowHomeEnabled(true)
            it.setDisplayUseLogoEnabled(true)
            it.setLogo(R.drawable.logo_blanco)
            it.setBackgroundDrawable(ColorDrawable(ContextCompat.getColor(this, R.color.purple_500)))
        }

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        navView.setupWithNavController(navController)

        // Escucha los cambios en el NavController para ajustar la visibilidad de la flecha de regreso
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.navigation_home -> {
                    supportActionBar?.setDisplayHomeAsUpEnabled(false)
                    navView.visibility = View.VISIBLE
                }
                R.id.navigation_topic_list,
                R.id.navigation_topic_detail -> {
                    supportActionBar?.setDisplayHomeAsUpEnabled(true)
                    navView.visibility = View.VISIBLE
                }
                R.id.navigation_information -> {  // Añade esta línea
                    supportActionBar?.setDisplayHomeAsUpEnabled(true)
                    navView.visibility = View.INVISIBLE  // Oculta la barra de navegación
                }
                else -> {
                    supportActionBar?.setDisplayHomeAsUpEnabled(true)
                    navView.visibility = View.VISIBLE
                }
            }

            // Manejo de selección de ítems en el BottomNavigationView
            if (navView.visibility == View.VISIBLE) {
                when (destination.id) {
                    R.id.navigation_home,
                    R.id.navigation_topic_list,
                    R.id.navigation_topic_detail -> navView.menu.findItem(R.id.navigation_home).isChecked = true
                    R.id.navigation_favorite -> navView.menu.findItem(R.id.navigation_favorite).isChecked = true
                    R.id.navigation_settings -> navView.menu.findItem(R.id.navigation_settings).isChecked = true
                }
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}

/*
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.let {
            it.setDisplayShowHomeEnabled(true)
            it.setDisplayUseLogoEnabled(true)
            it.setLogo(R.drawable.logo_blanco) // Asegúrate de que logo_blanco está en tus recursos drawable

            // Establecer el color de fondo de la ActionBar
            it.setBackgroundDrawable(ColorDrawable(ContextCompat.getColor(this, R.color.purple_500)))
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        navView.setupWithNavController(navController)

        // Escucha los cambios en el NavController
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.navigation_home,
                R.id.navigation_topic_list,
                R.id.navigation_topic_detail -> navView.menu.findItem(R.id.navigation_home).isChecked = true
                else -> navView.menu.findItem(destination.id).isChecked = true
            }
        }
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }



}

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.let {
            it.setDisplayShowHomeEnabled(true)
            it.setDisplayUseLogoEnabled(true)
            it.setLogo(R.drawable.logo_blanco)
            it.setBackgroundDrawable(ColorDrawable(ContextCompat.getColor(this, R.color.purple_500)))
        }

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        navView.setupWithNavController(navController)

        // Escucha los cambios en el NavController para ajustar la visibilidad de la flecha de regreso
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.navigation_home -> {
                    supportActionBar?.setDisplayHomeAsUpEnabled(false)
                }
                else -> {
                    supportActionBar?.setDisplayHomeAsUpEnabled(true)
                }
            }

            // Manejo de selección de ítems en el BottomNavigationView
            when (destination.id) {
                R.id.navigation_home,
                R.id.navigation_topic_list,
                R.id.navigation_topic_detail -> navView.menu.findItem(R.id.navigation_home).isChecked = true
                else -> navView.menu.findItem(destination.id).isChecked = true
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}

*/