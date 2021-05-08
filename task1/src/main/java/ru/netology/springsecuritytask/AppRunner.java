//package ru.netology.springsecuritytask;
//
//import lombok.val;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Component;
//import ru.netology.springsecuritytask.entities.Authorities;
//import ru.netology.springsecuritytask.entities.Role;
//import ru.netology.springsecuritytask.entities.Student;
//import ru.netology.springsecuritytask.entities.University;
//import ru.netology.springsecuritytask.repositories.StudentsRepository;
//import ru.netology.springsecuritytask.repositories.UniversitiesRepository;
//import ru.netology.springsecuritytask.repositories.UsersRepository;
//import ru.netology.springsecuritytask.services.StudentService;
//import ru.netology.springsecuritytask.services.UniversityService;
//
//import javax.transaction.Transactional;
//import java.util.HashSet;
//import java.util.Set;
//import java.util.stream.Collectors;
//
//@Component
//public class AppRunner implements CommandLineRunner {
//    private final UsersRepository usersRepository;
//    private final UniversityService universityService;
//    private final StudentService studentService;
//
//    public AppRunner(UsersRepository usersRepository, UniversityService universityService, StudentService service) {
//        this.usersRepository = usersRepository;
//        this.universityService = universityService;
//        this.studentService = service;
//    }
//
//    @Transactional
//    @Override
//    public void run(String... args) throws Exception {
////        val user = usersRepository.findByUsername("Max")
////                .orElseThrow(() -> new UsernameNotFoundException("User does not exist"));
////        System.out.println(user);
//        universityService.getAllStudentsFromUniversity("MSU").forEach(System.out::println);
//
//    }
//
////    val user = usersRepository.findByUsername(username)
////            .orElseThrow(() -> new UsernameNotFoundException("User does not exist"));
////        return new User(user.getUsername(), user.getPassword(), getAuthorities(user.getRoles()));
//}
