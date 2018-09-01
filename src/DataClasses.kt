fun main(args: Array<String>) {
    val client1 = Client("Ashish",75034)
    val client2 = Client("Ashish",75034)
    println(client1 == client2)

    val clientSet = hashSetOf<Client>(Client("Ashish",75034))
    println(clientSet.contains(Client("Ashish",75034)))


    println(client1.copy("Shubhi"))
    println(client1)

    val clientDataClass = ClientDataClass("Shubhi",75034)
    println(clientDataClass.copy("Ashish"))
    println(clientDataClass)

}

class Client(val name:String, val postalCode: Int) {

    override fun equals(other: Any?): Boolean {
        if(other == null || other !is Client) return false
        return other.name == this.name && other.postalCode == this.postalCode
    }

    override fun hashCode(): Int {
        return name.hashCode() + postalCode.hashCode()
    }

    override fun toString(): String {
        return "Client(name = $name, postalCode = $postalCode)"
    }

    fun copy(name: String = this.name, postalCode: Int = this.postalCode): Client {
        return Client(name,postalCode)
    }
}
// only properties declared in primary constructor take part in equals() and hashCode() methods
// its recommended to use val i.e. immutable properties in data classes.The reason is to avoid the mutable keys(state change) issues if one
// uses data classes as keys in containers like hash map.
data class ClientDataClass(val name: String, val postalCode: Int) {

}