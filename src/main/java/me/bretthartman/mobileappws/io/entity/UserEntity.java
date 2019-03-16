package me.bretthartman.mobileappws.io.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "users")
@Getter
@Setter
public class UserEntity implements Serializable {
  @Getter(AccessLevel.NONE)
  @Setter(AccessLevel.NONE)
  private static final long serialVersionUID = 5807299080121770539L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(nullable = false)
  private String userId;

  @Column(nullable = false, length = 50)
  private String firstName;

  @Column(nullable = false, length = 50)
  private String lastName;

  @Column(nullable = false, length = 120)
  private String email;

  @Column(nullable = false)
  private String encryptedPassword;


  private String emailVerificationToken;

  @Column(nullable = false)
  private boolean emailVerificationStatus = false;
}