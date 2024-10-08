package org.example.clientes.repositories;

import org.example.database.RemoteDataBaseManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
public class TarjetaRemoteRepositoryImplTest {

    @Container
    public static PostgreSQLContainer<?> postgreContainer = new PostgreSQLContainer<>("postgres:12-alpine")
            .withDatabaseName("tarjetas_db")
            .withUsername("admin")
            .withPassword("admin123")
            .withInitScript("init.sql");

    private static RemoteDataBaseManager remoteDbManager;
    private static TarjetaRemoteRepositoryImpl tarjetaRemoteRepository

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getAll() {
    }

    @Test
    void getById() {
    }

    @Test
    void create() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}
