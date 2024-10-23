package com.example.app.resources;

import com.example.app.database.Database;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Path("/populate")
public class PopulateResource {

    @GET
    public Response populateDatabase() {
        String[] games = {
                "('Alice', 'Bob')",
                "('Charlie', 'Alice')",
                "('Bob', 'Charlie')",
                "('Alice', 'Charlie')",
                "('Charlie', 'Bob')"
        };

        try (Connection conn = Database.getConnection()) {
            String sql = "INSERT INTO Games (winner, loser) VALUES " + String.join(", ", games);
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.executeUpdate();
            return Response.ok("Database populated with test data.").build();
        } catch (SQLException e) {
            e.printStackTrace();
            return Response.serverError().entity("Error populating database").build();
        }
    }
}
