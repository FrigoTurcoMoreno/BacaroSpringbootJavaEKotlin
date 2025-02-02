package mft.dev.kotlinbackend.model

import jakarta.persistence.*

@Entity
@Table(name = "utenti")
data class Utente(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    @Column(name = "nome")
    var nome: String,
    @Column(name = "cognome")
    var cognome: String,
    @Column(name = "email", unique = true)
    var email: String?,
    @OneToMany(mappedBy = "utente")
    val todoList: MutableList<Todo>
)
