package com.example.apiproject.repository;



import com.example.apiproject.access.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {

}
