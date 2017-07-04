package com.pistar.jpa.flyway;

/**
 * Created by maxguenes on 27/06/2017.
 */

import org.flywaydb.core.Flyway;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;

import javax.sql.DataSource;

public class FlywayInitializer implements InitializingBean{

    @Value("${trix.flyway.migrate}")
    private Boolean migrate;

    org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    private DataSource dataSource;

    @Override
    public void afterPropertiesSet() throws Exception {
        Flyway flyway = new Flyway();

        if (migrate) {
            logger.info("Starting Flyway Migration");
            flyway.setDataSource(dataSource);
            flyway.setOutOfOrder(true);
            flyway.migrate();
            logger.info("Finished Flyway Migration");
        } else {
            logger.info("Flyway migration is disabled");
        }
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}