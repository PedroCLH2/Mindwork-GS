package br.com.fiap.resource;

import br.com.fiap.dao.UserDao;
import br.com.fiap.model.User;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;

@Path("/usuarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {

    @Inject
    UserDao dao;

    @GET
    public List<User> listar() throws SQLException {
        return dao.listar();
    }

    @POST
    public Response adicionar(User user) {
        try {
            dao.inserir(user);
            return Response.status(Response.Status.CREATED).entity(user).build();
        } catch (SQLException e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erro SQL: " + e.getMessage()).build();
        }
    }
}
