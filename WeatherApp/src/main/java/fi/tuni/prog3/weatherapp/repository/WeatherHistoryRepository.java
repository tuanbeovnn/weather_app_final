package fi.tuni.prog3.weatherapp.repository;

import fi.tuni.prog3.weatherapp.entity.WeatherHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherHistoryRepository extends JpaRepository<WeatherHistoryEntity, Long> {
}
