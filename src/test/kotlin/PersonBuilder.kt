import at.kopyk.Copy
import at.kopyk.CopyExtensions

@Copy(Person::class)
@CopyExtensions
data class PersonBuilder(
    val id: String,
    val name: String,
) {
    companion object {
        fun build(change: `PersonBuilder$Mutable`.() -> Unit): Person {
            return Person(PersonBuilder("id", "name").copy(change))
        }
    }
}