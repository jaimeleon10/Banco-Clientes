package org.example.rest.repository;

import org.example.clientes.mappers.UsuarioMapper;
import org.example.clientes.model.Usuario;
import org.example.exceptions.UserNotFoundException;
import org.example.rest.UserApiRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class UserRemoteRepository {

    private final UserApiRest userApiRest;
    private final Logger logger = LoggerFactory.getLogger(UserRemoteRepository.class);

    public UserRemoteRepository(UserApiRest userApiRest) {
        this.userApiRest = userApiRest;
    }

    public List<Usuario> getAllSync(){
        var call = userApiRest.getAllSync();
        try {
            var response = call.execute();
            if (!response.isSuccessful()) {
                throw new Exception("Error: " + response.code());
            }
            return response.body().stream()
                    .map(UsuarioMapper::toUserFromCreate)
                    .toList();
        } catch (Exception e) {
            e.printStackTrace();
            return List.of();
        }
    }

    public Usuario getByIdSync(int id) {
        logger.debug("UserRemoteRepository: Recuperando el usuario con id " + id);
        var call = userApiRest.getByIdSync(id);
        try {
            var response = call.execute();
            if (!response.isSuccessful()) {
                if (response.code() == 404) {
                    throw new UserNotFoundException("User not found with id: " + id);
                } else {
                    throw new Exception("Error: " + response.code());
                }
            }
            return UsuarioMapper.toUserFromCreate(response.body());
        } catch (Exception e) {
            throw new UserNotFoundException("User not found with id: " + id);
        }
    }

    public Usuario createUser(Usuario user) {
        var call = userApiRest.createUser(UsuarioMapper.toRequest(user));
        try {
            var response = call.get();
            return UsuarioMapper.toUserFromCreate(response);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }


    }

    public Usuario updateUser(int id, Usuario user) {
        var call = userApiRest.updateUser(id, UsuarioMapper.toRequest(user));
        try {
            var response = call.get();
            return UsuarioMapper.toUserFromUpdate(response, id);
        } catch (Exception e) {
            if (e.getCause().getMessage().contains("404")) {
                throw new UserNotFoundException("Usuario no encontrado al actualizar, con id: " + id);
            } else {
                e.printStackTrace();
                return null;
            }
        }
    }

    public void deleteUser(int id) {
        var call = userApiRest.deleteUser(id);
        try {
            call.get();
        } catch (Exception e) {
            if (e.getCause().getMessage().contains("404")) {
                throw new UserNotFoundException("Usuario no encontrado al eliminar, con id: " + id);
            } else {
                e.printStackTrace();
            }

        }
    }
}
