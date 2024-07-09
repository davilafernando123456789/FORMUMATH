package com.mendoza.ana.poketinder.ui.view

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.mendoza.ana.poketinder.R
import com.mendoza.ana.poketinder.databinding.FragmentSettingsBinding
import com.mendoza.ana.poketinder.ui.adapter.SettingItem
import com.mendoza.ana.poketinder.ui.adapter.SettingsAdapter
import com.mendoza.ana.poketinder.util.LocaleHelper

class SettingsFragment : Fragment(R.layout.fragment_settings) {
    private lateinit var binding: FragmentSettingsBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSettingsBinding.bind(view)
        // Desactiva la flecha de regreso cuando se muestra el fragmento
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)

        val settingsItems = listOf(
            SettingItem(R.drawable.ic_theme, getString(R.string.theme), getThemeText()),
            SettingItem(R.drawable.ic_language, getString(R.string.language), getCurrentLanguageText()),
            SettingItem(R.drawable.ic_share, getString(R.string.share), ""),
            SettingItem(R.drawable.ic_info_24, getString(R.string.info), "")
        )

        val settingsAdapter = SettingsAdapter(settingsItems) { settingItem ->
            when (settingItem.title) {
                getString(R.string.theme) -> {
                    toggleTheme()
                    updateThemeText()
                }
                getString(R.string.language) -> {
                    toggleLanguage()
                }
                getString(R.string.share) -> {
                    shareApp()
                }
                getString(R.string.info) -> {
                    navigateToInformation()
                }
            }
        }

        binding.rvSettings.layoutManager = LinearLayoutManager(context)
        binding.rvSettings.adapter = settingsAdapter
    }

    private fun navigateToInformation() {
        val bundle = Bundle().apply {
            putString("infoKey", "Example Information")
        }
        //findNavController().navigate(R.id.action_settingsFragment_to_informationFragment, bundle)
        findNavController().navigate(R.id.navigation_information)
    }

    private fun toggleTheme() {
        val currentNightMode = resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
        if (currentNightMode == Configuration.UI_MODE_NIGHT_NO) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
    }

    private fun updateThemeText() {
        binding.rvSettings.adapter?.notifyDataSetChanged()
    }

    private fun getThemeText(): String {
        val currentNightMode = resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
        return if (currentNightMode == Configuration.UI_MODE_NIGHT_NO) {
            getString(R.string.theme_light)
        } else {
            getString(R.string.theme_dark)
        }
    }

    private fun getCurrentLanguageText(): String {
        return if (LocaleHelper.getLocale(requireContext()) == "es") {
            getString(R.string.language_spanish)
        } else {
            getString(R.string.language_english)
        }
    }

    private fun shareApp() {
        val shareIntent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, getString(R.string.check_out_app))
            type = "text/plain"
        }
        startActivity(Intent.createChooser(shareIntent, null))
    }

    private fun toggleLanguage() {
        val newLocale = if (LocaleHelper.getLocale(requireContext()) == "es") "en" else "es"
        LocaleHelper.setLocale(requireContext(), newLocale)
        activity?.recreate()
    }
}


/*
class SettingsFragment : Fragment(R.layout.fragment_settings) {
    private lateinit var binding: FragmentSettingsBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSettingsBinding.bind(view)
        // Desactiva la flecha de regreso cuando se muestra el fragmento
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)

        val settingsItems = listOf(
            SettingItem(R.drawable.ic_theme, getString(R.string.theme), getThemeText()),
            SettingItem(R.drawable.ic_language, getString(R.string.language), getString(R.string.language_spanish)),
            SettingItem(R.drawable.ic_share, getString(R.string.share), ""),
            SettingItem(R.drawable.ic_info_24, getString(R.string.info), "")
        )

        val settingsAdapter = SettingsAdapter(settingsItems) { settingItem ->
            when (settingItem.title) {
                getString(R.string.theme) -> {
                    toggleTheme()
                    updateThemeText()
                }
                getString(R.string.language) -> {
                    toggleLanguage()
                }
                getString(R.string.share) -> {
                    shareApp()
                }
                getString(R.string.info) -> {
                    navigateToInformation()
                }
            }
        }

        binding.rvSettings.layoutManager = LinearLayoutManager(context)
        binding.rvSettings.adapter = settingsAdapter
    }

    private fun navigateToInformation() {
        val bundle = Bundle().apply {
            putString("infoKey", "Example Information")
        }
        //findNavController().navigate(R.id.action_settingsFragment_to_informationFragment, bundle)
        findNavController().navigate(R.id.navigation_information)
    }
    private fun toggleTheme() {
        val currentNightMode = resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
        if (currentNightMode == Configuration.UI_MODE_NIGHT_NO) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
    }

    private fun updateThemeText() {
        binding.rvSettings.adapter?.notifyDataSetChanged()
    }

    private fun getThemeText(): String {
        val currentNightMode = resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
        return if (currentNightMode == Configuration.UI_MODE_NIGHT_NO) {
            getString(R.string.theme_light)
        } else {
            getString(R.string.theme_dark)
        }
    }

    private fun shareApp() {
        val shareIntent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, getString(R.string.check_out_app))
            type = "text/plain"
        }
        startActivity(Intent.createChooser(shareIntent, null))
    }
    private fun toggleLanguage() {
        // Implementa la lógica para cambiar el idioma
        // Por ejemplo:
        //LocaleHelper.setLocale(requireContext(), newLocale)
        //activity?.recreate()
    }
}
 */
