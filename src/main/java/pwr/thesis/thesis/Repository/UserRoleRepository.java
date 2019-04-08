package pwr.thesis.thesis.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pwr.thesis.thesis.Model.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole,Long> {
}
