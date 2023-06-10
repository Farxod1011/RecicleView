package uz.farxod.recicleview

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import uz.farxod.recicleview.R
import uz.farxod.recicleview.adapters.UserAdapter
import uz.farxod.recicleview.databinding.FragmentMenuBinding


class MenuFragment(private var spanCount: Int) : Fragment(R.layout.fragment_menu) {

    private var _binding: FragmentMenuBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMenuBinding.bind(view)

        val dataSource = DataSource()

//region sharedPref
//        // Получение контекста фрагмента
//        val context = requireContext()
//
//        // Получение экземпляра SharedPreferences
//        val sharedPreferences = context.getSharedPreferences("my_preferences", Context.MODE_PRIVATE)
//
//        // Чтение значения из SharedPreferences
//        val value = sharedPreferences.getInt("key", 1)
//        spanCount = value
//
//        // Запись значения в SharedPreferences
//        val editor = sharedPreferences.edit()
//        editor.putInt("key", spanCount)
//        editor.apply()
//endregion

        //UserAdapter dan obyekt olamiz, unga massiv sifatida (dataSource.getUsers())-massivini beramiz
        val userAdapter = UserAdapter(dataSource.getUsers(), spanCount)

        //qandey chizishni aytamiz, buni xml-ichiga bersakham bo'ladi (layoutManager="...")
        val layoutManager = GridLayoutManager(context, spanCount) //spanCount-qatori
        //val layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false) - bu kod gorizontal svayp imkonini beradi

        //id=rv RecicleView ning LinearLayoutManager-(chizish menejeri)
        rvLayoutManager(layoutManager)

        //id=rv RecicleView ning adapteri sifatida yuqoridagi userAdapter-ni beramiz
        binding.rv.adapter = userAdapter

        //ekrandan item ustiga bosilsa
        userAdapter.setOnItemClickedListener {
            val bundle = Bundle()
            bundle.putInt("index", it)
            val detailFragment = DetailFragment()
            detailFragment.arguments = bundle
            parentFragmentManager.beginTransaction().replace(R.id.fragment_container, detailFragment)
                .addToBackStack(DetailFragment().toString()).commit()
        }

    }

    private fun rvLayoutManager(layoutManager: GridLayoutManager) {
        binding.rv.layoutManager = layoutManager
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}