package uz.farxod.recicleview.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.SimpleAdapter.ViewBinder
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import uz.farxod.recicleview.OnItemClickedListener
import uz.farxod.recicleview.R
import uz.farxod.recicleview.User
import uz.farxod.recicleview.databinding.RowItem2Binding
import uz.farxod.recicleview.databinding.RowItemBinding

class UserAdapter(private val list: List<User>, private val values: Int) : RecyclerView.Adapter<UserAdapter.ViewHolder>(){

    private var listener: OnItemClickedListener? = null


    //inner class - o'zidan yuqoridagi class metodlariga murojat qila oladi, inner yozilmasa ko'rmaydi.
    //bu yerda RowItemBinding-bu row_item.xml fayl, binding ni shuni ichidan ol diyapmiz va shuni ichiga chizamiz
    inner class ViewHolder(private val binding: RowItem2Binding): RecyclerView.ViewHolder(binding.root){

// // // // // // // // // // // // //
// binding siz varianti - (ViewHolder(view: View):RecyclerView.ViewHolder(view)) -> ViewHolder - view qabul qiladi, va RecyclerView ning ViewHolder - riga view ni beradi
// username, email va image ni topib olamiz
//        val username = view.findViewById<TextView>(R.id.text_username)
//        val email = view.findViewById<TextView>(R.id.text_email)
//        val image = view.findViewById<ImageView>(R.id.imageview)
// // // // // // // // // // // // //

        fun onBinding(user: User){  // list dagi znach ni o'zlashtiradi
            binding.textUsername.text = user.username
            binding.textEmail.text = user.email
            binding.imageview.setImageResource(user.img)

    //binding.root обращается к корневому View элемента, который был создан при использовании View Binding в приложении.
            binding.root.setOnClickListener{
                if (adapterPosition != RecyclerView.NO_POSITION){
                    listener?.onClicked(adapterPosition)
                }
            }
        }
    }
    //View ning chizilishi, birinchi marta view ni chizganda(dastur ochilganda va ekran pastga slayd qilinganda ishlaydi) o'ziga keraklicha view chizib oladi
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //      ichiga      ni beramiz                                qaysi layout ligi
        return ViewHolder(RowItem2Binding.inflate(LayoutInflater.from(parent.context), parent, false)) //binding siz varianti -> LayoutInflater.from(parent.context).inflate(R.layout.row_item, parent, false))
    }
    //list.size nechita chizishni xal qiladi
    override fun getItemCount(): Int = list.size

    //Ma'lumotlarni almashtirib turadi, ekranda ko'rinib turganlarini bind-(view va uning ma'lumotlarini bir-biriga ulaydi) qilib beradi
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //bind ni bog'laymiz
        holder.onBinding(list[position])

    // --------------- binding-siz varianti ------------------
    //        holder.username.text = list[position].username
    //        holder.email.text = list[position].email
    //        holder.image.setImageResource(list[position].img)
    }

    fun setOnItemClickedListener(listener: OnItemClickedListener){
        this.listener = listener
    }

}