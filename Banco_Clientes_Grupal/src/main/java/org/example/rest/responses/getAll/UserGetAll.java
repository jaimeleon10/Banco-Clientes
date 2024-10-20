package org.example.rest.responses.getAll;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 * Clase UserGetAll
 *
 * Representa la respuesta al obtener todos los usuarios desde la API REST.
 * Incluye los campos principales: ID, nombre, nombre de usuario y correo electrónico.
 * Otros campos como dirección, teléfono, sitio web y compañía están anotados con
 * @JsonIgnore, por lo que se excluyen de la serialización/deserialización.
 *
 * Usa @Builder, @AllArgsConstructor y @NoArgsConstructor de Lombok para facilitar
 * la creación de instancias.
 *
 * @author Jaime León, Natalia González, German Fernandez, Alba García,
 * Mario de Domingo
 * @version 1.0-SNAPSHOT
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserGetAll {

    @JsonProperty("id")
    private long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("username")
    private String username;

    @JsonProperty("email")
    private String email;

    @JsonIgnore
    @JsonProperty("address")
    private String address;

    @JsonIgnore
    @JsonProperty("phone")
    private String phone;

    @JsonIgnore
    @JsonProperty("website")
    private String website;

    @JsonIgnore
    @JsonProperty("company")
    private String company;

    /**
     * Devuelve el ID del usuario.
     *
     * @return El ID del usuario.
     */
    public long getId() {  return id;  }

    /**
     * Devuelve el nombre del usuario.
     *
     * @return El nombre del usuario.
     */
    public String getName() {  return name;  }

    /**
     * Devuelve el nombre de usuario.
     *
     * @return El nombre de usuario.
     */
    public String getUsername() {  return username;  }

    /**
     * Devuelve el correo electrónico del usuario.
     *
     * @return El correo electrónico del usuario.
     */
    public String getEmail() {  return email; }
}
