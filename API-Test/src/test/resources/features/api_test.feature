Feature: Test a IMDB API
  Looking different kinds of movies

  Scenario Outline: Search a movie title in IMDB
    Given i call the IMDB Movie API
    When I enter a movie title with the name <movie> to know if exits
    Then I expect the response with the expected answer <answer>

    Examples:
      | movie     | answer |
      | Avengers  | OK     |
      | Inception | OK     |
      | Popu      | NOT    |
