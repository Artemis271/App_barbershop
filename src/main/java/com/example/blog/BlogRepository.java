

package com.example.blog;

import java.util.List;

import com.example.client.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query; // JPQL is just an object-oriented way of defining queries based on entity attributes.


public interface BlogRepository extends JpaRepository<Blog, Long> {

    @Query("select p from Blog p where concat('',p.post_id) like %?1%") // the concatted method parameter will be assigned to the query parameter with index 1.
    List<Blog> searchPostById(String keyword);

    @Query("SELECT p FROM Blog p WHERE p.post_name LIKE %?1%")
    List<Blog> searchPostByName(String keyword);

    @Query("SELECT p FROM Blog p WHERE p.publish_date LIKE %?1%")
    List<Blog> searchPostByDate(String keyword);

    @Query("SELECT p FROM Blog p WHERE p.text LIKE %?1%")
    List<Blog> searchPostByText(String keyword);

    @Query("SELECT p FROM Blog p WHERE p.client_name LIKE %?1%")
    List<Blog> searchPostByClient_name(String keyword);

    @Query("select p from Blog p where concat(p.post_id, '', p.post_name, '', p.publish_date, '', p.text, '', p.client_name) like %?1%") // the concatted method parameter will be assigned to the query parameter with index 1.
    List<Blog> searchPostByKeyword(String keyword);
}
