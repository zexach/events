package com.dogadjaji.dogadjaji_188.repositories;

import com.dogadjaji.dogadjaji_188.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
