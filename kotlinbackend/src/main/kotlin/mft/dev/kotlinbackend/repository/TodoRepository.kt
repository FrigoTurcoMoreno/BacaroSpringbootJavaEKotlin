package mft.dev.kotlinbackend.repository

import mft.dev.kotlinbackend.model.Todo
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TodoRepository : JpaRepository<Todo, Long> {
}