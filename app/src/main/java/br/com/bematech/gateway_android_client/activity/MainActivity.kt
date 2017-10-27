package br.com.bematech.gateway_android_client.activity

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.view.Menu
import android.view.MenuItem
import br.com.bematech.gateway_android_client.R
import br.com.bematech.gateway_android_client.extensions.addFragment
import br.com.bematech.gateway_android_client.fragment.StatusFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toobar.*
import org.jetbrains.anko.toast

class MainActivity : BaseActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_printer, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_print -> {
                val statusFragment = StatusFragment()
                val bundle = Bundle()
                bundle.putSerializable("statusType", "printer")
                statusFragment.arguments = bundle

                addFragment(R.id.layout_fragment, statusFragment)
            }
            R.id.nav_sat -> {
                val statusFragment = StatusFragment()
                val bundle = Bundle()
                bundle.putSerializable("statusType", "sat")
                statusFragment.arguments = bundle

                addFragment(R.id.layout_fragment, statusFragment)
            }
            R.id.nav_settings -> {
                toast(R.string.settings_message)
            }
            R.id.nav_about -> {
                toast(R.string.about_message)
            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
