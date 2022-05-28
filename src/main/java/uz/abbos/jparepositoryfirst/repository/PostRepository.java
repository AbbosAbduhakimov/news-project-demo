package uz.abbos.jparepositoryfirst.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uz.abbos.jparepositoryfirst.entity.Post;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Integer> {
    List<Post> findAllByCategoryID(Integer categoryID);
    List<Post> findAllByRegioID(Integer regionID);
    List<Post> findAllByTitle(String title);
    @Transactional
    @Modifying
    @Query("UPDATE Post SET viewCount = viewCount + 1 where id = :id")
    void increamentViews(@Param("id") Integer id);


}
