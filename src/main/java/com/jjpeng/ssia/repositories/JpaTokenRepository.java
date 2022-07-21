package com.jjpeng.ssia.repositories;

import com.jjpeng.ssia.model.Token;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author JJPeng
 * @date 2022/7/21 21:50
 */
public interface JpaTokenRepository extends JpaRepository<Token, Integer> {

    Optional<Token> findTokenByIdentifier(String identifier);
}
