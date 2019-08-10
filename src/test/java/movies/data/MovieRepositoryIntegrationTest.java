package movies.data;

import movies.model.Movie;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import static movies.model.Genre.*;

import javax.sql.DataSource;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

public class MovieRepositoryIntegrationTest {

    private MovieRepositoryImplJdbc movieRepository;
    private DriverManagerDataSource dataSource;

    @Before
    public void setUp() throws SQLException {
        dataSource = new DriverManagerDataSource("jdbc:h2:mem:test;MODE=MYSQL",
                "sa", "sa");
        ScriptUtils.executeSqlScript(dataSource.getConnection(), new ClassPathResource("sql-script/test-data.sql"));

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        movieRepository = new MovieRepositoryImplJdbc(jdbcTemplate);
    }

    @Test
    public void load_all_movies() throws SQLException {

        Collection<Movie> movies = movieRepository.findAll();

        assertThat(movies, is(Arrays.asList(new Movie(1, "Dark Knight", 152, ACTION),
                new Movie(2, "Memento", 113, THRILLER),
                new Movie(3, "Matrix", 136, ACTION))));
    }

    @Test
    public void load_movie_by_id(){
        Movie movie = movieRepository.findById(2);

        assertThat(movie, is(new Movie(2, "Memento", 113, THRILLER)));
    }

    @Test
    public void insert_a_movie(){
        Movie movie = new Movie(4, "Super 8", 112, THRILLER);
        movieRepository.saveOrUpdate(movie);

        Movie movieSavedInDB = movieRepository.findById(4);
        assertThat(movieSavedInDB, is(new Movie(4, "Super 8", 112, THRILLER)));
    }

    @After
    public void tearDown() throws SQLException {
        final Statement s = dataSource.getConnection().createStatement();
        s.execute("DROP ALL objects DELETE files");
    }
}