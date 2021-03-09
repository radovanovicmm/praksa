package io.agileintelligence.ppmtoll.repositrories;

import io.agileintelligence.ppmtoll.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
}
