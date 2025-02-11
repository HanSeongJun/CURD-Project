package MyCRUD.Ver_Demo.User.Repository;


import MyCRUD.Ver_Demo.User.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
