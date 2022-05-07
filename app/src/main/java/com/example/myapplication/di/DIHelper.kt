package com.example.myapplication.di

import toothpick.ktp.KTP

object DIHelper {
    fun getScope() = KTP.openRootScope().installModules(AppModule())
}