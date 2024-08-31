package in.btm.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.btm.Entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
