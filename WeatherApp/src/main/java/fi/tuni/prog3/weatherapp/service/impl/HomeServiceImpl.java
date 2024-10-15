package fi.tuni.prog3.weatherapp.service.impl;

import fi.tuni.prog3.weatherapp.service.IHomeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class HomeServiceImpl implements IHomeService {
    private String dataSearch;

    @Override
    public void test(String name) {
       log.info("log by homeService: {}", name);
    }

    @Override
    public String getDataSearch() {
        return dataSearch;
    }

    @Override
    public void setDataSearch(String data) {
        this.dataSearch = data;
    }

}
