package br.com.bematech.gateway_android_client.extensions

import android.app.Activity
import android.support.annotation.IdRes
import android.support.annotation.StringRes
import android.support.v4.app.Fragment
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.Toast

/**
 * Created by Franklyn on 03/09/2017.
 */

// findViewById + setOnClickListener
fun AppCompatActivity.onClick(@IdRes viewId: Int, onClick: (v: android.view.View?) -> Unit) {
    val view = findViewById<View>(viewId)
    view.setOnClickListener { onClick(it) }
}

// Mostra um toast
fun Activity.toast(message: CharSequence, length: Int = Toast.LENGTH_SHORT) =
        Toast.makeText(this, message, length).show()

fun Activity.toast(@StringRes message: Int, length: Int = Toast.LENGTH_SHORT) =
        Toast.makeText(this, message, length).show()

// Configura a Toolbar
fun AppCompatActivity.setupToolbar(@IdRes id: Int, title: String? = null, upNavigation: Boolean = false): ActionBar {
    val toolbar = findViewById<Toolbar>(id)
    setSupportActionBar(toolbar)
    if (title != null) {
        supportActionBar?.title = title
    }
    supportActionBar?.setDisplayHomeAsUpEnabled(upNavigation)
    return supportActionBar!!
}

// Adiciona o fragment no layout
fun AppCompatActivity.addFragment(@IdRes layoutId: Int, fragment: Fragment) {
    val ft = supportFragmentManager.beginTransaction()
    ft.replace(layoutId, fragment)
    ft.commit()
}