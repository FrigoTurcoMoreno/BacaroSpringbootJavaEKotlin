package mft.dev.kotlinbackend.model

import jakarta.persistence.*

@Entity
@Table(name = "utenti")
data class Utente(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @Column(name = "nome")
    var nome: String,
    @Column(name = "cognome")
    var cognome: String,
    @Column(name = "email", unique = true)
    var email: String?,
    @OneToMany(mappedBy = "utente", cascade = [CascadeType.ALL])
    var todoList: MutableList<Todo> = mutableListOf()
)
