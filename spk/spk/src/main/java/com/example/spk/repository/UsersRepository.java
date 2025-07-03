package com.example.spk.repository;

import com.example.spk.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
    @Query(value = "select * from users " +
            "where username = :username", nativeQuery = true)
    Users selectByUsername(@Param("username") String username);

    @Query(value = "select case when count(*) >=1 then 1 " +
            "else 0 " +
            "end as cek_username " +
            "from users " +
            "where username = :usernm", nativeQuery = true)
    Integer cariUsernameDgnCaseWhen(@Param("usernm") String usernm);

    @Query(value = "select case when count(*) >=1 then 1 " +
            "else 0 " +
            "end as cek_username_password " +
            "from users " +
            "where username = :username and password = :password", nativeQuery = true)
    Integer ceriUsernamePassword(@Param("username") String username,
                                 @Param("password") String password);
}
