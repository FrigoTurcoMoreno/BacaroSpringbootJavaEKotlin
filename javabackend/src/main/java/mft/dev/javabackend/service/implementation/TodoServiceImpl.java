package mft.dev.javabackend.service.implementation;

import mft.dev.javabackend.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoServiceImpl {

    @Autowired
    private TodoRepository todoRepository;
}
