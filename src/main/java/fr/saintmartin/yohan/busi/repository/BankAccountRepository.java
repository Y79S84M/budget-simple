package fr.saintmartin.yohan.busi.repository;

import fr.saintmartin.yohan.busi.entity.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {
    @Query(value = "select * from bank_account where uuid = :uuid", nativeQuery = true)
    Optional<BankAccount> getByUUID(@Param("uuid") UUID uuid);

}
