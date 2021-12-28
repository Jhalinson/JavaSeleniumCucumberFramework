Feature: Login
  Background:
#    Given the url "http://practice.automationtesting.in/"
    And the user do click in "My Account" button


  Scenario Outline: Masked Password
    When it log in with the credentials <user>, <password>
    Then it showed the password input masked <resultPass>
    Examples:
      |user					            |password		       |resultPass          |
      |"jhalinson_acosta@epam.com"		|"rywfic-virtek-7"     |"password"          |

  Scenario Outline: Unsuccessful
    When it log in with the credentials <user>, <password>
    Then the webpage must show <message_result>
    Examples:
      |user					              |password				  |message_result				                |
      |"incorrectUser"		              |"rywfic-virtek-7Povqe" |"ERROR: Invalid username. Lost your password?"			            |
      |"jhalinson_acosta@epam.com"        |""					  |"Error: Password is required."			            |
      |""					              |"rywfic-virtek-7Povqe" |"Error: Username is required."			            |
      |"jhalinson_acosta@epam.com"        |"wrongpass"            |"ERROR: The password you entered for the username jhalinson_acosta@epam.com is incorrect. Lost your password?"	|

  Scenario Outline: Successful
    When it log in with the credentials <user>, <password>
    Then it showed the name <userName>

    Examples:
      |user					            |password		       |userName          |
      |"jhalinson_acosta@epam.com"		|"rywfic-virtek-7Povqe"|"jhalinson_acosta"|