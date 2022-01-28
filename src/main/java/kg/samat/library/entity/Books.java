package kg.samat.library.entity;

import kg.samat.library.entity.dto.BookDto;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "books")
@NoArgsConstructor
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "book_name")
    private String name;

    @Column(name = "add_date")
    @CreationTimestamp
    private LocalDateTime addDate;

    @OneToOne
    private Authors author;

    @OneToOne
    private Genres genre;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Users user;


    public Books(BookDto dto) {
        this.name = dto.getName();
        this.addDate = dto.getAddDate();
    }
}
