package th.ac.kku.cis.mobileapp.PlayerList

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import th.ac.kku.cis.mobileapp.PlayerList.databinding.ActivityMainBinding
import th.ac.kku.cis.mobileapp.PlayerList.databinding.ActivityUserBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var userArrayList: ArrayList<User>
    lateinit var imageId:Array<Int>
    lateinit var name:Array<String>
    lateinit var phone:Array<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imageId = intArrayOf(
            R.drawable.mano0,
            R.drawable.manu3,
            R.drawable.manu4,
            R.drawable.manu7,
            R.drawable.manu8,
            R.drawable.manu9,
            R.drawable.manu10,
            R.drawable.manu11,
            R.drawable.manu13
        )
        val name = arrayOf(
            "เอริก เทน ฮาก",
            "ราฟาแอล วาราน",
            "แฮร์รี แมไกวร์",
            "คริสเตียโน โรนัลโด",
            "เฟเดริโก โรดริเกซ ซานโตส",
            "เอดินซอน กาบานิ",
            "มาร์คัส แรชฟอร์ด",
            "บรูนู ฟือร์นังดึช",
            "จาดอน ซานโช"
        )
        val lastMessage = arrayOf(
            "mvp",
            "mvp",
            "mvp",
            "mvp",
            "mvp",
            "mvp",
            "mvp",
            "mvp",
            "mvp"

        )
        val lastMsgTime = arrayOf(
            "07.00am",
            "07.30am",
            "07.50am",
            "00.00am",
            "07.00am",
            "07.00am",
            "07.00am",
            "07.00am",
            "07.00am"

        )
        val phoneNo = arrayOf(
            "0610953083",
            "0610953082",
            "0610953081",
            "0610953086",
            "0610953087",
            "0610953088",
            "0610953089",
            "0610953085",
            "0610953084"
        )
        val city = arrayOf(
            "Manchester united",
            "Manchester united",
            "Manchester united",
            "Manchester united",
            "Manchester united",
            "Manchester united",
            "Manchester united",
            "Manchester united",
            "Manchester united",
            "Manchester united"
        )
        userArrayList = ArrayList()
        for (i in name.indices) {
            val user =
                User(name[i], phoneNo[i], lastMsgTime[i], lastMessage[i], city[i], imageId[i])
            userArrayList.add(user)
        }

        binding.listview.isClickable = true
        binding.listview.adapter = MyAdapter(this, userArrayList)
        binding.listview.setOnItemClickListener { parent, view, position, id ->


            val name = name[position]
            val phone = phoneNo[position]
            val imageId = imageId[position]


            val i = Intent(this, UserActivity::class.java)
            i.putExtra("name", name)
            i.putExtra("phone", phone)
            i.putExtra("imageId", imageId)


            startActivity(i)
        }
        FirebaseAuth.getInstance().signOut();
    }
}