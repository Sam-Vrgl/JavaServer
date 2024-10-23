# Project README

## Overview

This project is a simple web application built using Jetty and Jersey to create RESTful services. It also integrates SQLite for database management. The application serves multiple endpoints, including the ability to post game results, retrieve player scores, and view the top ranking players.

## Prerequisites

- **Java 8+**: Ensure that Java is installed on your machine.
- **Maven**: Used for dependency management and building the project.

## Project Structure

- **Main Class (`com.example.app.Main`)**:
  - Initializes and starts a Jetty server on port `8080`.
  - Configures the Jersey application with the servlet container to handle requests.

- **Database Class (`com.example.app.database.Database`)**:
  - Manages the SQLite connection.
  - Automatically creates a `Games` table if it doesn't exist, used to store the results of games.

- **GameResultResource Class (`com.example.app.resources.GameResultResource`)**:
  - A POST endpoint that allows game results to be submitted.
  - Stores the winner and loser of a game in the `Games` table in the database.

- **LevelZeroResource Class (`com.example.app.resources.LevelZeroResource`)**:
  - Basic GET endpoints that serve HTML and JSON responses.
  - Endpoints:
    - `/`: Welcome page.
    - `/hello`: Returns a "Hello World" message.
    - `/ping`: Returns a JSON response `{ "message": "pong" }`.

- **RankingResource Class (`com.example.app.resources.RankingResource`)**:
  - A GET endpoint that returns the top 3 players based on the number of wins.
  - Fetches the players from the `Games` table and returns them in descending order of wins.

- **ScoreResource Class (`com.example.app.resources.ScoreResource`)**:
  - A GET endpoint that returns the number of wins for a specific player.
  - Uses the `Games` table to calculate the win count for the requested player.

## Endpoints

### 1. **`POST /post-game-result`**

- Records a game result in the database.
- **Form Parameters**:
  - `winner`: The name of the winning player.
  - `loser`: The name of the losing player.
- **Response**:
  - `200 OK`: When the game result is successfully recorded.
  - `500 Internal Server Error`: When a database error occurs.

### 2. **`GET /`**

- Returns a simple HTML welcome message with navigation links to other pages.

### 3. **`GET /hello`**

- Returns an HTML message: "Hello World".

### 4. **`GET /ping`**

- Returns a JSON message: `{ "message": "pong" }`.

### 5. **`GET /ranking`**

- Returns the top 3 players based on their number of wins.
- **Response**:
  - `200 OK`: A list of players and their corresponding win counts in the format: `"player: X wins"`.

### 6. **`GET /get-score/{player}`**

- Returns the number of wins for a specified player.
- **Path Parameter**:
  - `{player}`: The name of the player for whom the score is being fetched.
- **Response**:
  - `200 OK`: A message indicating the player's number of wins, e.g., `"Player {player} has X wins."`.

### 7. **`GET /populate`**

- Populates the database with predefined game results for testing purposes.
- **Response**:
  - `200 OK`: When the database is successfully populated with test data.
  - `500 Internal Server Error`: If there is an issue populating the database.


## How to Run

1. **Clone the repository**:
    ```bash
    git clone <repository-url>
    cd <repository-directory>
    ```

2. **Build the project**:
    ```bash
    mvn clean install
    ```

3. **Run the application**:
    ```bash
    mvn exec:java -Dexec.mainClass="com.example.app.Main"
    ```

4. **Access the application**:
   - Open your browser and navigate to [http://localhost:8080](http://localhost:8080).

## Database

- The project uses an SQLite database named `game.db`.
- The database contains a single table, `Games`, which stores the results of each game played.

### Table Schema

```sql
CREATE TABLE Games (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    winner TEXT NOT NULL,
    loser TEXT NOT NULL
);
```

## Future Improvements

- Add more detailed error handling.
- Implement additional features like viewing game history or individual player statistics.
- Extend database schema to support game scores or timestamps.

## License

This project is licensed under the MIT License.

---

Enjoy developing with this simple Jetty + Jersey web app!