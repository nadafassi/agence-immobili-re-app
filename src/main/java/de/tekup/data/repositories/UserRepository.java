
package de.tekup.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import de.tekup.data.models.User;

public interface UserRepository extends JpaRepository<User,Long>{

}
