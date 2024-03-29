package com.example.ListTasks.service;

import com.example.ListTasks.model.Task;
import com.example.ListTasks.repository.TaskRepository;
import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
;

import static com.example.ListTasks.model.TaskStatus.IN_PROGRESS;
import static com.example.ListTasks.model.TaskStatus.NOT_STARTED;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;


@SpringBootTest
//@ExtendWith(MockitoExtension.class)
public class ServiceTest {
    @Mock                                                // разрываем соединение
    private TaskRepository taskRepository;

    @InjectMocks                                         // создаем экземпляр, который будем тестировать
    public TaskService taskService;

    List<Task> tasks = new ArrayList<>();

    public Task task1 = new Task();
    public Task task2 = new Task();

    @BeforeEach
    public void Starting() {

        task1.setId(1L);
        task1.setTitleTask("сделать домашнюю работу");
        task1.setStatus(IN_PROGRESS);
        task1.setDateTimeCreateTask(LocalDateTime.now());

        task2.setId(2L);
        task2.setTitleTask("лечь спать в 21:00");
        task2.setStatus(NOT_STARTED);
        task2.setDateTimeCreateTask(LocalDateTime.now());

    }

    @Test
    public void findAllTest() {

        tasks.add(task1);
        tasks.add(task2);
        given(taskRepository.findAll()).willReturn(tasks);

        List<Task> result = taskService.findAll();

        Assertions.assertNotNull(result);
        Assertions.assertEquals(2, result.size(), "Good");
        verify(taskRepository).findAll();
    }

//    @Test
//    public void findTasksByStatusTest() {
//
//        Mockito.when(taskRepository.findAll()).thenReturn(tasks);
//
//        List<Task> result = taskService.findTasksByStatus(IN_PROGRESS);
//
//        Assertions.assertNotNull(result);
//        Assertions.assertEquals(1, result.size());
//        Assertions.assertEquals(tasks.get(0), result.get(0));
//    }
}


        //verify(taskRepository).findAll();

        //ResponseEntity<List<Task>> all = (ResponseEntity<List<Task>>) taskController.getAllTasks();

        //assertEquals(tasks, all.getBody());
        //assertEquals(all.getBody().size(), 2);

        //Optional<Task> findTask = taskRepository.findById(2L);

        //assertEquals(findTask.get(), task2);
        //given(taskRepository.findById(task2.getId())).willReturn(Optional.of(task2));
        // action
        //taskService.findAll();
        // test
        //verify(taskService).changeAmount()


    //given(taskRepository.findById(task1.getId())).willReturn(Optional.of(task1));
    //given(taskRepository.findById(task2.getId())).willReturn(Optional.of(task2));

