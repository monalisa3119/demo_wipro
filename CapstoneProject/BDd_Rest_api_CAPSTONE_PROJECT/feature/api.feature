Feature: CRUD OPERATIONS ON v school application

  Scenario Outline: Get all posts
    Given I have a base url of "<URL>"
    When I send a GEt request to "<Request>"
    Then the response status code should be <Code>

    Examples: 
      | URL                                    |  | Request |  | Code |
      | https://api.vschool.io/%5byour_name%5d |  | /todo   |  |  200 |

  Scenario Outline: GET one post
    Given I have a base url of "<URL>"
    When I send a GeT ONE request to "<Request>"
    Then the response status code shouldbe <Code>

    Examples: 
      | URL                                    |  | Request                        |  | Code |
      | https://api.vschool.io/%5byour_name%5d |  | /todo/654c55da78fe452c114a875a |  |  200 |

  Scenario Outline: Delete post
    Given I have a base url of "<URL>"
    When I send a Delete request to "<Request>"
    Then the responsed status code should be <Code>

    Examples: 
      | URL                                    |  | Request                        |  | Code |
      | https://api.vschool.io/%5byour_name%5d |  | /todo/64db3a2a78fe452c1149f372 |  |  200 |

  Scenario Outline: create a post
    Given I have a base url of "https://api.vschool.io/%5byour_name%5d"
    When i send a post request to "/todo" with the body of "<requestbody>"
    Then the time is lessthan 5000ms

    Examples: 
      | requestbody                                                                                                      |
      | {\\"title\\": \\"Book for Testing\\",\\"description\\": \\"creating API testing by posting\\", \\"price\\": 500} |

  Scenario Outline: Update a post
    Given I have a base url of "https://api.vschool.io/%5byour_name%5d"
    When i send a put to "/todo/654c55da78fe452c114a875a" with the body of "<requestbody2>"
    Then the time is lessthan3 5000ms

    Examples: 
      | requestbody2                                                                                                       |
      | {\\"title\\": \\"Book for Testing\\", \\"description\\": \\"creating API testing by posting\\", \\"price\\": 500 } |
