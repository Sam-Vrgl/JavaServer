package com.example.app.resources;

import com.example.app.database.Database;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Path("/ranking")
public class RankingResource {

    @GET
    public Response getRanking() {
        try (Connection conn = Database.getConnection()) {
            String sql = "SELECT winner AS player, COUNT(*) AS wins " +
                    "FROM Games " +
                    "GROUP BY winner " +
                    "ORDER BY wins DESC " +
                    "LIMIT 3";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            ArrayList<String> ranking = new ArrayList<>();
            while (rs.next()) {
                String player = rs.getString("player");
                int wins = rs.getInt("wins");
                ranking.add(player + ": " + wins + " wins");
            }
            return Response.ok(ranking.toString()).build();
        } catch (SQLException e) {
            e.printStackTrace();
            return Response.serverError().entity("Database error").build();
        }
    }
}
