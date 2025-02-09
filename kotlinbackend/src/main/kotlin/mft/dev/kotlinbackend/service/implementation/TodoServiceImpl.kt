package mft.dev.kotlinbackend.service.implementation

import mft.dev.kotlinbackend.repository.TodoRepository
import mft.dev.kotlinbackend.service.TodoService
import org.springframework.stereotype.Service

@Service
class TodoServiceImpl(
    private val todoRepository: TodoRepository
) : TodoService {
}