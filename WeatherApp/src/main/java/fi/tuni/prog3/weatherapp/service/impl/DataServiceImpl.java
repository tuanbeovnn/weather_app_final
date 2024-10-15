package fi.tuni.prog3.weatherapp.service.impl;

import fi.tuni.prog3.weatherapp.service.IDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DataServiceImpl implements IDataService {

    @Override
    public void test(String name) {
        log.info("log by dataService: {}", name);
    }

}
