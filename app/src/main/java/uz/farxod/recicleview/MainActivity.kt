package uz.farxod.recicleview

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import uz.farxod.recicleview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private var anotherValue = 1
    private val sharedPreferences: SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //val sharedPreferences: SharedPreferences = getSharedPreferences("my_preferences", MODE_PRIVATE)

        binding.menu.setOnClickListener{
            val popupMenu: PopupMenu = PopupMenu(this, binding.menu) //PopupMenu(context, view) - это всплывающее контекстное меню
            popupMenu.menuInflater.inflate(R.menu.menu_item, popupMenu.menu) //menu_item ni obyekt qilib olamiz Inflater yordamida

            popupMenu.setOnMenuItemClickListener (PopupMenu.OnMenuItemClickListener {   //menu item-lari bosilganida
                menuItem -> when(menuItem.itemId){
                    R.id.item_1 -> {
                        //1-chi menu bosilganda
                        removeFragment()
                        supportFragmentManager.beginTransaction().add(R.id.fragment_container, MenuFragment(1)).commit()
                        anotherValue = 1
                    }
                    R.id.item_2 -> {
                        removeFragment()
                        supportFragmentManager.beginTransaction().add(R.id.fragment_container, MenuFragment(2)).commit()
                        anotherValue = 2
                    }
                    R.id.item_3 -> {
                        removeFragment()
                        supportFragmentManager.beginTransaction().add(R.id.fragment_container, MenuFragment(3)).commit()
                        anotherValue = 3
                    }
                    R.id.item_4 -> {
                        removeFragment()
                        supportFragmentManager.beginTransaction().add(R.id.fragment_container, MenuFragment(4)).commit()
                        anotherValue = 4
                    }
                    else ->  Toast.makeText(this, "Item", Toast.LENGTH_SHORT ).show()
                }
                true
            })
            popupMenu.show()
        }

        supportFragmentManager.beginTransaction().add(R.id.fragment_container, MenuFragment(anotherValue)).commit()
    }
//--------------------------------------------------------------------------------------------------
//    private fun getSave(){  //saqlaymiz
//        val editor = sharedPreferences?.edit()
//        editor?.putInt("key", anotherValue)?.apply()
//    }
//--------------------------------------------------------------------------------------------------
//    private fun setSave(){  //saqlanganni beramiz
//
//        val value = sharedPreferences?.getInt("key", 1)
//        if (value != null) {
//            anotherValue = value
//        }
//        val bundle = Bundle()
//        bundle.putInt("key", anotherValue)
//        MenuFragment(anotherValue)//.arguments = bundle
//        removeFragment()
//        supportFragmentManager.beginTransaction().add(R.id.fragment_container, MenuFragment(anotherValue)).commit()
//    }
//--------------------------------------------------------------------------------------------------
    private fun removeFragment(){   //bu funksiya fragment chizilgan container ni bo'shatish uchun
        val fragmentManager = supportFragmentManager    //fragmentManager ni chaqiramiz
        val currentFragment = fragmentManager.findFragmentById(R.id.fragment_container) //activity_main.xml dagi fragment_container-ni topib oldik

        if (currentFragment != null) {  //agar fragment_container bo'sh bo'lmasa
            fragmentManager.beginTransaction()
                .remove(currentFragment)    //fragment_container ni ichini o'chir
                .commit()
        }
    }
//--------------------------------------------------------------------------------------------------
    override fun onStart() {
        super.onStart()
        //setSave()
    }
//--------------------------------------------------------------------------------------------------
    override fun onDestroy() {
        super.onDestroy()
        //getSave()
    }
}