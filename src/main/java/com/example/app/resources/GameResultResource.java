package com.example.app.resources;

import com.example.app.database.Database;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.core.Response;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Path("/post-game-result")
public class GameResultResource {

    @POST
    public Response postGameResult(@FormParam("winner") String winner,
                                   @FormParam("loser") String loser) {
        try (Connection conn = Database.getConnection()) {
            String sql = "INSERT INTO Games (winner, loser) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, winner);
            stmt.setString(2, loser);
            stmt.executeUpdate();
            return Response.ok("Game result recorded").build();
        } catch (SQLException e) {
            e.printStackTrace();
            return Response.serverError().entity("Database error").build();
        }
    }
}
