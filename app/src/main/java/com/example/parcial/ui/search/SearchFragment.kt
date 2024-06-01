package com.example.parcial.ui.search

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.parcial.databinding.FragmentSearchBinding
import java.text.SimpleDateFormat
import java.util.*

class SearchFragment : Fragment() {

    companion object {
        fun newInstance() = SearchFragment()
    }

    private val viewModel: SearchViewModel by viewModels()
    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Configuración del EditText para la fecha
        val editTextDepartureDate: EditText = binding.editTextDepartureDate
        editTextDepartureDate.setOnClickListener {
            showDatePickerDialog(editTextDepartureDate)
        }

        // Configuración de los Spinners
        setupSpinners()
    }

    private fun showDatePickerDialog(editText: EditText) {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(requireContext(), { _, selectedYear, selectedMonth, selectedDay ->
            val selectedDate = Calendar.getInstance()
            selectedDate.set(selectedYear, selectedMonth, selectedDay)
            val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.US)
            editText.setText(dateFormat.format(selectedDate.time))
        }, year, month, day)

        datePickerDialog.show()
    }

    private fun setupSpinners() {
        // Configuración del spinner de pasajeros
        val passengersArray = arrayOf("1", "2", "3", "4")
        val passengersAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, passengersArray)
        passengersAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerPassengers.adapter = passengersAdapter

        // Configuración del spinner de clase
        val classArray = arrayOf("Economy", "Premium", "First")
        val classAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, classArray)
        classAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerClass.adapter = classAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
