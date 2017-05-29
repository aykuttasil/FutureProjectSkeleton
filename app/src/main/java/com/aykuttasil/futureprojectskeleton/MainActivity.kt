package com.aykuttasil.futureprojectskeleton

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import com.aykuttasil.futureprojectskeleton.data.model.ModelPaket
import com.raizlabs.android.dbflow.kotlinextensions.save
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                message?.setText(R.string.title_home)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                message?.setText(R.string.title_dashboard)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                message?.setText(R.string.title_notifications)
                return@OnNavigationItemSelectedListener true
            }
        }
        return@OnNavigationItemSelectedListener false
    }

    val topla = fun(x: Int, y: Int): Int = x + y

    /**
     * DbFlow save model
     */
    fun dbFlowSaveModel() {
        val modelPaket = ModelPaket()
        modelPaket.ad = "Peynir"
        modelPaket.cins = "Süt Ürünleri"
        modelPaket.save()
    }

    /**
     * selector ile hızlıca list dialog oluşturulabilir ve seçilen değer yakalanabilir.
     */
    fun showModelPaketList(list: List<ModelPaket>) {
        selector("Users",
                list.map { it.ad as CharSequence },
                { dialog, index ->
                    dialog.cancel()
                })

        /*
        val countries = listOf("Russia", "USA", "Japan", "Australia")
        selector("Where are you from?", countries) { dialog, i ->
            toast("So you're living in ${countries[i]}, right?")
        }
        */
    }


    /**
     * Fonksiyon bir sabit değişkene atanabilir ve eğer tek bir işlem yapacaksa
     * direk olarak = in sağ tarafında işlemler yazılabilir.
     */
    val sum = fun Int.(other: Int): Int = this + other
    /*
    val sum = fun Int.(other: Int): Int {
        return this + other
    }
    */


    /**
     * Hızlı list oluşturma
     */
    fun quickHashMap() {
        /*
        val _list_ = ArrayList<String>()
        val hashMap = HashMap<String,List<String>>()
        hashMap.put("America",_list_)
        */
        // Yukarıdaki yapının aynısını aşağıdaki gibi oluşturabiliriz

        val items = listOf(
                "America" to listOf("Brazil", "Canada", "United States"),
                "Asia" to listOf("China", "India", "Japan"),
                "Europe" to listOf("France", "Germany", "Spain", "United Kingdom"))

    }

    /**
     * Alert Dialog
     */
    fun showAlertDialog() {
        /*
        alert("Merhaba", "Title") {
            yesButton { toast("Yes") }
            noButton { toast("No") }
        }.show()
        */
        /*progressDialog("sd") {
            print("sds")
        }*/
        /*
        val dialog = progressDialog(message = "Please wait a bit…", title = "Fetching data")
        dialog.progress = 50
        */
        alert("Message", "Title") {
            customView {
                verticalLayout {
                    padding = dip(30)
                    val edt1 = editText {
                        hint = "Name"
                        textSize = 24f
                    }
                    val edt2 = editText {
                        hint = "Password"
                        textSize = 24f
                    }
                    button("Login") {
                        textSize = 26f
                        onClick {
                            startActivity(intentFor<MainActivity>("id" to 5, "ad" to "Aykut").singleTop())
                            toast(edt1.text)
                        }
                    }
                }
            }
        }.show()
    }

    /**
     * String ifadeler ile dans
     */
    fun stringess() {
        val yas = 26
        val stringTripleQuote = """
        aykut
        asil
        yas = ${yas}
        """
        println(stringTripleQuote)

        var a = 1
        val s1 = "a is $a"
        a = 2
        val s2 = "${s1.replace("is", "was").capitalize()}, but now is $a"

    }

    fun MutableList<Int>.swap(index1: Int, index2: Int) {
        val tmp = this[index1] // 'this' corresponds to the list
        this[index1] = this[index2]
        this[index2] = tmp
    }


}
