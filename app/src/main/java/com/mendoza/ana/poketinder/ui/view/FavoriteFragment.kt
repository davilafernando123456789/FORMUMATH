

package com.mendoza.ana.poketinder.ui.view

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.mendoza.ana.poketinder.R
import com.mendoza.ana.poketinder.databinding.FragmentFavoriteBinding
import com.mendoza.ana.poketinder.ui.adapter.SubjectAdapter
import com.mendoza.ana.poketinder.ui.model.Subject
import com.mendoza.ana.poketinder.ui.viewmodel.SubjectsViewModel

class FavoriteFragment : Fragment(R.layout.fragment_favorite) {
    private lateinit var binding: FragmentFavoriteBinding
    private lateinit var subjectsViewModel: SubjectsViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFavoriteBinding.bind(view)
        subjectsViewModel = ViewModelProvider(requireActivity()).get(SubjectsViewModel::class.java)
        // Desactiva la flecha de regreso cuando se muestra el fragmento
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)

        val subjectAdapter = SubjectAdapter(emptyList(), subjectsViewModel) { subject ->
            navigateToTopicList(subject)
        }
        binding.rvFavorites.layoutManager = LinearLayoutManager(context)
        binding.rvFavorites.adapter = subjectAdapter

        subjectsViewModel.favorites.observe(viewLifecycleOwner) { favorites ->
            subjectAdapter.updateSubjects(favorites)
            if (favorites.isEmpty()) {
                binding.tvNoFavorites.visibility = View.VISIBLE  // Mostrar el mensaje
                Log.d("FavoriteFragment", "No favorites found.")
            } else {
                binding.tvNoFavorites.visibility = View.GONE  // Ocultar el mensaje
                Log.d("FavoriteFragment", "Favorites observed: ${favorites.size}")
            }
        }
    }

    private fun navigateToTopicList(subject: Subject) {
        val bundle = Bundle().apply {
            putParcelable("subject", subject)
        }
        findNavController().navigate(R.id.action_favoriteFragment_to_topicListFragment, bundle)
    }
}

/*
class FavoriteFragment : Fragment(R.layout.fragment_favorite) {
    private lateinit var binding: FragmentFavoriteBinding
    private lateinit var subjectsViewModel: SubjectsViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFavoriteBinding.bind(view)
        // Usando requireActivity() para asegurar la misma instancia de ViewModel
        subjectsViewModel = ViewModelProvider(requireActivity()).get(SubjectsViewModel::class.java)

        val subjectAdapter = SubjectAdapter(emptyList(), subjectsViewModel) { subject ->
            navigateToTopicList(subject)
        }
        binding.rvFavorites.layoutManager = LinearLayoutManager(context)
        binding.rvFavorites.adapter = subjectAdapter

        subjectsViewModel.favorites.observe(viewLifecycleOwner) { favorites ->
            subjectAdapter.updateSubjects(favorites)
            if (favorites.isEmpty()) {
                Log.d("FavoriteFragment", "No favorites found.")
            } else {
                Log.d("FavoriteFragment", "Favorites observed: ${favorites.size}")
            }
        }
    }
    private fun navigateToTopicList(subject: Subject) {
        val bundle = Bundle().apply {
            putParcelable("subject", subject)
        }
        findNavController().navigate(R.id.action_favoriteFragment_to_topicListFragment, bundle)
    }


}*/
/*
    subjectsViewModel = ViewModelProvider(requireActivity()).get(SubjectsViewModel::class.java)

        val subjectAdapter = SubjectAdapter(emptyList(), subjectsViewModel) { subject ->
            // Lógica de navegación si es necesaria
        }
        binding.rvFavorites.layoutManager = LinearLayoutManager(context)
        binding.rvFavorites.adapter = subjectAdapter

        subjectsViewModel.favorites.observe(viewLifecycleOwner) { favorites ->
            subjectAdapter.updateSubjects(favorites)
            if (favorites.isEmpty()) {
                Log.d("FavoriteFragment", "No favorites found.")
            } else {
                Log.d("FavoriteFragment", "Favorites observed: ${favorites.size}")
            }
        }
    }
}
}*/



