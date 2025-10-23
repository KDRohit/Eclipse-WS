package com.ig.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import com.ig.entity.BankAccount;
import jakarta.transaction.Transactional;

public interface IBankAccountRepo extends JpaRepository<BankAccount, Long>
{
	@Query("select balance from BankAccount where accountNumber=:accNum")
	Optional<Double> getBalance(Long accNum);
	
	@Modifying
	@Transactional
	@Query("update BankAccount set balance = balance - :money where accountNumber=:accNum ")
	Optional<Integer> withDrawMoney(Long accNum,Double money);
	
	@Modifying
	@Transactional
	@Query("update BankAccount set balance = balance + :money where accountNumber=:accNum")
	Optional<Integer> depositMoney(Long accNum,Double money);
	
	
}
