package com.example.listviewtest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //　画面のlayoutを指定する
        setContentView(R.layout.activity_main)

        //　Listで表示するtimezone一覧
        val timeZones = TimeZone.getAvailableIDs()

        // Listをlayoutから探す
        val listView = findViewById<ListView>(R.id.timeZoneList)

        // Adapterを作成
        val adapter = ArrayAdapter<String> (this,
            R.layout.list_time_zone_row,
            R.id.timeZone,
            timeZones)

        // ListにAdapterをセットする
        listView.adapter = adapter

        // ListのItemタップ時の動作
        listView.setOnItemClickListener { parent, view, position, id ->
            // Adapterから、押された位置のtimezoneを得る
            val timeZone = adapter.getItem(position)
            // Toastで表示
            Toast.makeText(this, timeZone, Toast.LENGTH_SHORT).show()
        }
    }
}
