package ImageHoster.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "comments")
public class Comment {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private Integer id;

  @Column(name = "text")
  private String text;

  @Column(name = "date")
  private LocalDate date;

  // The 'comment' table is mapped to 'users' table with Many:One mapping
  // One comment can belong to only one user (owner) but one user can have multiple comments
  // FetchType is EAGER
  @ManyToOne(fetch = FetchType.EAGER)
  // Below annotation indicates that the name of the column in 'comments' table referring the
  // primary key in 'users' table will be 'user_id'
  @JoinColumn(name = "user_id")
  private User user;

  // The 'comments' table is mapped to 'images' table with Many:One mapping
  // One comment can belong to only one image but one image can have multiple comments
  // FetchType is EAGER
  @ManyToOne(fetch = FetchType.EAGER)
  // Below annotation indicates that the name of the column in 'comments' table referring the
  // primary key in 'images' table will be 'image_id'
  @JoinColumn(name = "image_id")
  private Image image;

  public Integer getId() {

    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Image getImage() {
    return image;
  }

  public void setImage(Image image) {
    this.image = image;
  }
}
