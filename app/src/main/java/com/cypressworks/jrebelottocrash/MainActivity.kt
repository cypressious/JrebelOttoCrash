package com.cypressworks.jrebelottocrash

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.squareup.otto.Bus
import com.squareup.otto.Subscribe
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject lateinit var bus: Bus

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        MyApplication.component.inject(this)
    }

    override fun onResume() {
        super.onResume()
        bus.register(this)
    }

    override fun onPause() {
        bus.unregister(this)
        super.onPause()
    }

    @Subscribe
    fun foo(e: Foo) {
    }


    @Subscribe
    fun foo(e: Bar) {
    }

    @Subscribe
    fun foo(e: Baz) {
    }

    @Subscribe
    fun foo(e: Faz) {
    }
}

class Foo
class Bar
class Baz
class Faz