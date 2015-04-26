# Use Case Diagram #

![http://i.imgur.com/WFFULlM.jpg](http://i.imgur.com/WFFULlM.jpg)



# Use Cases #

>  1- Register 

Actors: Guest User

Purpose: Creating an account

Preconditions:
  * User must have an email address

Steps:
  * User enters the username, password, email information.
  * User reads and accepts terms of service for the system.
  * User requests to become a member.
  * A mail for confirmation is sent to user's email address.
  * User follows the confirmation link in the mail.

Postconditions:
  * System creates an account for the user.
  * User becomes a Registered user, can log in to the system.

> 2- Login 

Actors: Registered Users, Moderators

Purpose: Login to the system.

Preconditions:
  * Having an existing account.

Steps:
  * User or moderator enters username and password information.
  * User or moderator clicks the login button.

Postconditions:
  * User or moderator is signed in.

Exception Conditions:
If the username password combination doesn't match, the login fails.

> 3- Change Password 

Actors: Registered Users, Moderators

Preconditions:
  * Registered user should have been registered and logged in to the system.

Steps:
  * Registered user clicks change password button from profile page.
  * Registered user writes old password once and new password twice.
  * System checks old and new passwords.

Postconditions:
  * If change is valid, system will change the password.
  * If change is not valid, system gives an error message.

> 4- Change forgotten password 

Actors: Registered Users, Moderators

Preconditions:
  * User should have registered to system.

Steps:
  * An email will send to user after clicking forgot password button.
  * User writes old password once and new password twice.
  * System checks old and new passwords.

Postconditions
  * If change is valid, system will change the password.
  * If change is not valid, system gives an error message.

> 5- Add new violation report

Actors: Registered Users, Moderators

Preconditions:
  * Users should be logged into their account.

Steps:
  * The user adds information about the violation
  * The user adds the files (video/photo/audio) that he/she wants to add
  * The user adds related tag or tags to the report
  * The user sends the report and waits for the moderator approval.
  * The moderator approves the report if both its content and tags are appropriate and the video does not contain any malicious software.
  * The moderator removes the video if the video contains inappropriate content or the tags are not relevant for the report. In the first case, the moderator deletes the report. In the latter case, the moderator edits the tags and approves the report.

Postconditions
  * Violation report will be added to the system with related tags.

Exception Conditions
  * If the size or the length of the files (video/photo/audio) added by the user exceeds the limits that are mentioned in the assumptions part, the system will give an error.

Assumptions
  * The video length and size are at most 10 seconds and 10 MB, respectively.
  * The audio length and size are at most 60 seconds and 5 MB, respectively.
  * The photo size are at most 3 MB, respectively.



> 6-See Violation Report 

Actor : Guests , Registered Users

Purpose : Reading a Violation Report

Preconditions
  * At least one report should be presented in a category.

Steps
  * All categories of reports are shown to guests and users at the main page.
  * User or guest clicks a category and see reports on that category.

Postconditions
  * User might remember the report and comment on it if he/she is a registered user.

> 7- Rating a report

Actors: Registered users

Preconditions
  * User should have read the report.

Steps
  * User rates the report from 1 to 10 efficiency.

Postconditions
  * System makes the required calculations to add this rate to the statistics.
  * System can make an order biased on both rate statistics and other filters.


> 8- Report abusive behaviour

Actors: Registered users, Moderators

Preconditions
  * User should be logged in.

Steps
  * User adds information about abusive behaviour.
  * User sends abusive behaviour report to the system.
  * Moderator checks if the violation report is appropriate or not according to Terms of Use.
  * If there is an abusive behaviour, moderator deletes the violation report.
  * If there is not any abusive behaviour, moderator sends a message to the reporter that the report is appropriate and no actions made.

Postconditions
  * System will provide information about what has been done about the report.



> 9- Editing a report 

Actors: Registered Users

Preconditions
  * User should be logged in.
  * User should have written a report before.

Steps
  * User opens his/her report page.
  * User clicks edit button on the page.
  * User makes changes and clicks save button.

Postconditions
  * System updates the report page.

> 10- Moderator Removing a Report

Actors: Moderator

Preconditions:
  * Moderator should have logged into the system.

Steps
  * Moderator finds the violation report inappropriate.
  * Moderator removes report if content is inappropriate.

Postconditions
Deleted report isn't shown anymore to anyone.

> 11-Moderator Banning User

Actors: Moderator, Registered User

Preconditions:
  * One or more from the following:
    * Reports that the user wrote are reported as abusive.
    * User wrote inappropriate comments under other reports.
    * User reported many violations report as abusive when there was nothing to report.

Steps:
  * One of the following:
    * Moderator(already logged in to the website), checks if there is any abusive behaviour report for some comments. If there is an inappropriate comment under a violation report, moderator goes to his/her admin panel and bans the responsible user for the inappropriate comment.
    * While moderator was checking the violation reports that are reported as abusive, if he/she doesn't find the report abusive, and he/she decides that the user who made the abusive report was only wasting moderator's time, the moderator goes to his/her admin panel to ban the responsible user for the unnecessary reporting.

Postconditions
  * The banned user cannot log in to his/her account.

Exception Conditions
  * If the user is already logged in, after getting banned, the system automatically logs him/her out.


> 12- Comment on a report

Actors: Registered users

Preconditions:
  * The registered user should be logged in.

Steps
  * The registered user writes his/her comment.
  * The registered user posts the comment by using post button.
Postconditions
  * The comment will be placed on the comment section of the report.

> 13- Search a violation

Actors: Registered users, unregistered users

Precondition: -

Steps:
  * User types words on the searchbar

Postconditions:
  * User finds results related to search

> 14- Vocalize a report

Actors: Registered users

Preconditions:
  * The registered user should be logged in.
  * The registered user should be volunteer.

Steps:
  * User should choose a specific violation report.
  * User should click on the vocalize button

Postconditions:
  * Blind users can reach the vocalized reports.

> 15 Semantic Search

Actors:
  * guest
  * registered user
Preconditions:
  * no Precondition
Steps:
  * user clicks semantic search radio button to switch from normal search
  * User types tags separated with a whitespace
Postconditions:
  * System returns reports related to tag(s)

> 16 Semantic Tagging

Actors:
  * registered user
  * moderator

Preconditions:
  * Registered Users or moderators must be signed in before adding a tag

Steps:
  * user goes to violation report page
  * user or moderator enters tags in the form to add tags.form is below the post
  * user or moderator clicks add tags button to add tags
  * if tags are entered by a user moderator approves or rejects the tags

Postconditions:
  * system links the tag to the report after moderator approval
