package com.kipreev.aston_intensive_6

import kotlin.reflect.KClass

fun <T : Any> KClass<T>.getTag(): String = this.java.simpleName