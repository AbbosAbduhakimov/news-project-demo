package uz.abbos.jparepositoryfirst.entity;

import lombok.Getter;
import lombok.Setter;
import uz.abbos.jparepositoryfirst.Enum.PostTypes;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    private String content;

    private String token;

    private Integer viewCount;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "published_at")
    private LocalDateTime publishedAt;

    private Boolean status;

    @Enumerated(EnumType.STRING)
    @Column(name = "post_status")
    private PostTypes postStatus;

    @ManyToOne
    @JoinColumn(name = ("region_id"),insertable = false,updatable = false)
    private Region region;

    @Column(name = "region_id")
    private Integer regioID;

    @ManyToOne
    @JoinColumn(name = ("category_id"),insertable = false,updatable = false)
    private Category category;

    @Column(name = "category_id")
    private Integer categoryID;

    @ManyToOne
    @JoinColumn(name = ("user_id"),insertable = false,updatable = false)
    private User user;

    @Column(name = "user_id")
    private Integer userID;
}
