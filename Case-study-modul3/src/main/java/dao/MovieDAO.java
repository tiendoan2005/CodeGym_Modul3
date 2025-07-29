    package dao;

    import model.Movie;
    import util.DBConnection;

    import java.sql.Connection;
    import java.sql.PreparedStatement;
    import java.sql.ResultSet;
    import java.sql.SQLException;
    import java.time.LocalDate;
    import java.util.ArrayList;
    import java.util.List;

    public class MovieDAO implements GeneralDAO<Movie> {
        private static final String SELECT_ALL_MOVIES = "SELECT * FROM movies";
        private static final String INSERT_MOVIES_SQL = "INSERT INTO movies (title, genre, duration, description, start_date, end_date) VALUES (?, ?, ?, ?, ?, ?)";
        private static final String SELECT_MOVIE_BY_ID_SQL = "SELECT * FROM movies WHERE id = ?";
        private static final String UPDATE_MOVIE = "UPDATE movies SET title = ?, genre = ?, duration = ? WHERE id = ?";
        private static final String DELETE_MOVIE = "DELETE FROM movies WHERE id = ?";

        @Override
        public List<Movie> getAllMovies() {
            List<Movie> movies = new ArrayList<Movie>();
            try (Connection connection = DBConnection.getConnection();
                 PreparedStatement statement = connection.prepareStatement(SELECT_ALL_MOVIES)) {
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String title = resultSet.getString("title");
                    String genre = resultSet.getString("genre");
                    int duration = resultSet.getInt("duration");
                    String description = resultSet.getString("description");
                    LocalDate startDate = resultSet.getDate("start_date").toLocalDate();
                    LocalDate endDate = resultSet.getDate("end_date").toLocalDate();
                    movies.add(new Movie(id, title, genre, duration, description, startDate, endDate));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return movies;
        }

        @Override
        public void insertMovie(Movie movie) {
            try (Connection connection = DBConnection.getConnection();
                 PreparedStatement statement = connection.prepareStatement(INSERT_MOVIES_SQL)) {
                statement.setString(1, movie.getTitle());
                statement.setString(2, movie.getGenre());
                statement.setInt(3, movie.getDuration());
                statement.setString(4, movie.getDescription());
                statement.setDate(5, java.sql.Date.valueOf(movie.getStartDate()));
                statement.setDate(6, java.sql.Date.valueOf(movie.getEndDate()));
                statement.executeUpdate();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        @Override
        public Movie findById(int id) {
            try (Connection connection = DBConnection.getConnection();
                 PreparedStatement statement = connection.prepareStatement(SELECT_MOVIE_BY_ID_SQL)) {
                statement.setInt(1, id);
                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    String title = resultSet.getString("title");
                    String genre = resultSet.getString("genre");
                    int duration = resultSet.getInt("duration");
                    String description = resultSet.getString("description");
                    LocalDate startDate = resultSet.getDate("start_date").toLocalDate();
                    LocalDate endDate = resultSet.getDate("end_date").toLocalDate();
                    return new Movie(id, title, genre, duration, description, startDate, endDate);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        }


        @Override
        public void update(Movie movie) {
            try (Connection conn = DBConnection.getConnection();
                 PreparedStatement stmt = conn.prepareStatement(UPDATE_MOVIE)) {
                stmt.setString(1, movie.getTitle());
                stmt.setString(2, movie.getGenre());
                stmt.setInt(3, movie.getDuration());
                stmt.setInt(4, movie.getId());
                int rowsUpdated = stmt.executeUpdate();
                if (rowsUpdated > 0) {
                    System.out.println("Cập nhật phim thành công!");
                } else {
                    System.out.println("Không tìm thấy phim để cập nhật.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        @Override
        public boolean delete(int id) throws SQLException {
            boolean rowDeleted;
            try (Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETE_MOVIE)) {
                statement.setInt(1, id);
                rowDeleted = statement.executeUpdate() > 0;
            }
            return rowDeleted;
        }

    }
