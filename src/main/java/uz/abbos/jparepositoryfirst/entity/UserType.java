package uz.abbos.jparepositoryfirst.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "user_types")
public class UserType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name; // VISITOR,ADMIN,MODERATOR

    private boolean status;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}
