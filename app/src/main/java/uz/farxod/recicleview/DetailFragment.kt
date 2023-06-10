package uz.farxod.recicleview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import uz.farxod.recicleview.databinding.FragmentDetailBinding
import uz.farxod.recicleview.databinding.FragmentMenuBinding

class DetailFragment : Fragment(R.layout.fragment_detail) {
    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentDetailBinding.bind(view)

        val bundle = arguments
        val index = bundle?.getInt("index", 0)
        val dataSource = DataSource()
        val list: List<User> = ArrayList(dataSource.getUsers())
        val item = list[index!!]

        binding.imageview.setImageResource(item.img)
        binding.textEmail.text = item.email
        binding.textUsername.text = item.username
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}