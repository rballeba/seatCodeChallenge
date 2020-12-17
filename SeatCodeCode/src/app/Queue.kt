package app

class Queue<T> {
    constructor() {
        elements = mutableListOf()
    }
    constructor(orderedList: MutableList<T>) {
        this.elements = orderedList
    }
    private val elements: MutableList<T>
    val isEmpty: Boolean
        get() = elements.isEmpty()
    val size: Int
        get() = elements.size
    fun enqueue(item: T) = elements.add(item)
    fun dequeue() = if (!isEmpty) elements.removeAt(0) else null
    fun peek() = if (!isEmpty) elements[0] else null
}