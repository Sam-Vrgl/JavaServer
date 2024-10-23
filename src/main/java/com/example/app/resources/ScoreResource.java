package com.example.app.resources;

import com.example.app.database.Database;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Path("/get-score/{player}")
public class ScoreResource {

    @GET
    public Response getScore(@PathParam("player") String player) {
        try (Connection conn = Database.getConnection()) {
            String sql = "SELECT COUNT(*) AS wins FROM Games WHERE winner = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, player);
            ResultSet rs = stmt.executeQuery();
            int wins = rs.next() ? rs.getInt("wins") : 0;
            return Response.ok("Player " + player + " has " + wins + " wins.").build();
        } catch (SQLException e) {
            e.printStackTrace();
            return Response.serverError().entity("Database error").build();
        }
    }
}
