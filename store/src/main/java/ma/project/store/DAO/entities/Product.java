package ma.project.store.DAO.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "product") // Specify the table name here
public class Product {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer Id;
private String name;
private Integer price;
private Boolean promotion;

}
