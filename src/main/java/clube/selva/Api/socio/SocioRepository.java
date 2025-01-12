package clube.selva.Api.socio;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SocioRepository extends JpaRepository<Socio, Long> {
    boolean existsByEmailOrCarteirinha(String email, String carteirinha);
}
