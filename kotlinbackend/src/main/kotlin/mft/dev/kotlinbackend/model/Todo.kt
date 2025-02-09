package mft.dev.kotlinbackend.model
import jakarta.persistence.*

@Entity
@Table(name = "todos")
data class Todo(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @Column(name = "titolo")
    var titolo: String,
    @Column(name = "descrizione")
    var descrizione: String?,
    @ManyToOne
    @JoinColumn(name = "utente_id")
    var utente: Utente? = null
)
