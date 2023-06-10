package uz.farxod.recicleview

class DataSource {
    fun getUsers(): List<User>{
//        val users = listOf(
//            User("Abror", "asd43@gmail.com") ,
//            User("Doniyor", "gkj554@gmail.com"),
//            User("Sardor", "dsj56@gmail.com")
//        )

        val list: MutableList<User> = ArrayList()

        list.add(User("Abror", "asd43@gmail.com", R.drawable.baseline_blur_circular_24))
        list.add(User("Doniyor", "gkj554@gmail.com", R.drawable.baseline_blur_circular_24))
        list.add(User("Sardor", "dsj56@gmail.com", R.drawable.baseline_blur_circular_24))
        list.add(User("Abror", "asd43@gmail.com", R.drawable.baseline_blur_circular_24))
        list.add(User("Doniyor", "gkj554@gmail.com", R.drawable.baseline_blur_circular_24))
        list.add(User("Sardor", "dsj56@gmail.com", R.drawable.baseline_blur_circular_24))
        list.add(User("Abror", "asd43@gmail.com", R.drawable.baseline_blur_circular_24))
        list.add(User("Doniyor", "gkj554@gmail.com", R.drawable.baseline_blur_circular_24))
        list.add(User("Sardor", "dsj56@gmail.com", R.drawable.baseline_blur_circular_24))
        list.add(User("Doniyor", "gkj554@gmail.com", R.drawable.baseline_blur_circular_24))
        list.add(User("Sardor", "dsj56@gmail.com", R.drawable.baseline_blur_circular_24))
        list.add(User("Abror", "asd43@gmail.com", R.drawable.baseline_blur_circular_24))
        list.add(User("Doniyor", "gkj554@gmail.com", R.drawable.baseline_blur_circular_24))
        list.add(User("Sardor", "dsj56@gmail.com", R.drawable.baseline_blur_circular_24))
        list.add(User("Abror", "asd43@gmail.com", R.drawable.baseline_blur_circular_24))
        list.add(User("Doniyor", "gkj554@gmail.com", R.drawable.baseline_blur_circular_24))
        list.add(User("Sardor", "dsj56@gmail.com", R.drawable.baseline_blur_circular_24))

        return list
    }
}