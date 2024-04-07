package com.oldcapstone.maack.member.persistence.repository;

import com.oldcapstone.maack.member.persistence.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
