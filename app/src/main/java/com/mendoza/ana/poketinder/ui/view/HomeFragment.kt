package com.mendoza.ana.poketinder.ui.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.mendoza.ana.poketinder.R
import com.mendoza.ana.poketinder.databinding.FragmentHomeBinding
import com.mendoza.ana.poketinder.ui.adapter.SubjectAdapter
import com.mendoza.ana.poketinder.ui.model.Subject
import com.mendoza.ana.poketinder.ui.viewmodel.SubjectsViewModel


class HomeFragment : Fragment(R.layout.fragment_home) {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var subjectsViewModel: SubjectsViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)
        subjectsViewModel = ViewModelProvider(requireActivity()).get(SubjectsViewModel::class.java)

        // Configuración del adaptador y el RecyclerView
        val subjectAdapter = SubjectAdapter(emptyList(), subjectsViewModel) { subject ->
            navigateToTopicList(subject)
        }
        binding.rvSubjects.layoutManager = LinearLayoutManager(context)
        binding.rvSubjects.adapter = subjectAdapter

        // Observador para los subjects filtrados
        subjectsViewModel.filteredSubjects.observe(viewLifecycleOwner) { subjects ->
            subjectAdapter.updateSubjects(subjects)
        }

        // Iniciar el filtro para activar la carga de datos
        subjectsViewModel.setFilter("")

        // Configuración de la SearchView para manejar la entrada de búsqueda en tiempo real
        binding.searchViewSubject.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                subjectsViewModel.setFilter(query ?: "")
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                subjectsViewModel.setFilter(newText ?: "")
                return true
            }
        })
    }

    private fun navigateToTopicList(subject: Subject) {
        val bundle = Bundle().apply {
            putParcelable("subject", subject)
        }
        findNavController().navigate(R.id.action_homeFragment_to_topicListFragment, bundle)
    }
}


/*
class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var subjectsViewModel: SubjectsViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)
        subjectsViewModel = ViewModelProvider(requireActivity()).get(SubjectsViewModel::class.java)
        val subjectAdapter = SubjectAdapter(emptyList(), subjectsViewModel) { subject ->
            navigateToTopicList(subject)
        }
        binding.rvSubjects.layoutManager = LinearLayoutManager(context)
        binding.rvSubjects.adapter = subjectAdapter

        binding.searchViewSubject.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean = true
            override fun onQueryTextChange(newText: String?): Boolean {
                subjectsViewModel.setFilter(newText ?: "")
                return true
            }
        })

        subjectsViewModel.filteredSubjects.observe(viewLifecycleOwner) { subjects ->
            subjectAdapter.updateSubjects(subjects)
        }
    }

    private fun navigateToTopicList(subject: Subject) {
        val bundle = Bundle().apply {
            putParcelable("subject", subject)
        }
        findNavController().navigate(R.id.action_homeFragment_to_topicListFragment, bundle)
    }

}*/
/*
  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)
        // Cambio aquí para asegurar que se usa la misma instancia del ViewModel.
        subjectsViewModel = ViewModelProvider(requireActivity()).get(SubjectsViewModel::class.java)

        val subjectAdapter = SubjectAdapter(emptyList(), subjectsViewModel) { subject ->
            navigateToTopicList(subject)
        }
        binding.rvSubjects.layoutManager = LinearLayoutManager(context)
        binding.rvSubjects.adapter = subjectAdapter

        subjectsViewModel.subjects.observe(viewLifecycleOwner) { subjects ->
            subjectAdapter.updateSubjects(subjects)
        }
    }


    private fun navigateToTopicList(subject: Subject) {
        val bundle = Bundle().apply {
            putParcelable("subject", subject)
        }
        findNavController().navigate(R.id.action_homeFragment_to_topicListFragment, bundle)
    }
}*/