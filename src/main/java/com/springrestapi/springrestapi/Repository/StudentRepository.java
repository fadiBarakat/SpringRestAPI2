package com.springrestapi.springrestapi.Repository;

import com.springrestapi.springrestapi.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {


    boolean existsByName(String name);
    boolean existsByBranch(String bra);
    boolean existsByLname(String lnam);


}
