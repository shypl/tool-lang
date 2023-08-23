package org.shypl.tool.lang

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

inline fun <T> observable(value: T, crossinline observer: (T) -> Unit): ReadWriteProperty<Any?, T> {
	return object : ObservableProperty<T>(value) {
		override fun observe(value: T) = observer(value)
	}
}

abstract class ObservableProperty<T>(
	private var value: T
) : ReadWriteProperty<Any?, T> {
	
	override fun getValue(thisRef: Any?, property: KProperty<*>): T {
		return value
	}
	
	override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
		if (this.value != value) {
			this.value = value
			observe(value)
		}
	}
	
	protected abstract fun observe(value: T)
}