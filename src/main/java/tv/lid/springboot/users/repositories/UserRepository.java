package tv.lid.springboot.users.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tv.lid.springboot.users.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    // возвращает всех пользователей
    public List<User> findAll();

    // возвращает всех пользователей по заданным параметрам сортировки
    public Page<User> findAll(final Pageable pageable);

    // возвращает пользователя по заданному логину
    public User findFirstByLogin(final String login);

    // активирует/деактивирует пользователя
    @Modifying
    @Query("update User u set u.isActive = ?1 where u.id = ?2")
    public void activate(final Boolean isActive, final Integer id);
}
