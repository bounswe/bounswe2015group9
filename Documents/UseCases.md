# Use Case Diagram #

![http://i.imgur.com/WFFULlM.jpg](http://i.imgur.com/WFFULlM.jpg)



<h1>Use Cases</h1>

<h2>1-Register</h2>

<b>Actors:</b> Guest User

<b>Purpose:</b> Creating an account

<b>Preconditions:</b>
 <ul>
  <li>User must have an email address</li>
 </ul> 

<b>Steps:</b>
<ul>
  <li>User enters the username, password, email information.</li>
  <li>User reads and accepts terms of service for the system.</li>
  <li>User requests to become a member.</li>
  <li>A mail for confirmation is sent to user's email address.</li>
  <li>User follows the confirmation link in the mail.</li>
</ul>

<b>Postconditions:</b>
 <ul>
  <li>System creates an account for the user.</li>
  <li>User becomes a Registered user, can log in to the system.</li>
 </ul>

<h2>2-Login</h2> 

<b>Actors:</b> Registered Users, Moderators

<b>Purpose:</b> Login to the system.

<b>Preconditions:</b>
<ul>
  <li>Having an existing account.</li>
 </ul>

<b>Steps:</b>
<ul>
  <li>User or moderator enters username and password information.</li>
  <li>User or moderator clicks the login button.</li>
 </ul>

<b>Postconditions:</b>
<ul>
  <li>User or moderator is signed in.</li>
</ul>

<b>Exception Conditions:</b>
If the username password combination doesn't match, the login fails.

<h2>3-Change Password</h2> 

<b>Actors:</b> Registered Users, Moderators


<b>Preconditions:</b>
<ul>
  <li>Registered user should have been registered and logged in to the system.</li>
</ul>


<b>Steps:</b>
<ul>
  <li>Registered user clicks change password button from profile page.</li>
  <li>Registered user writes old password once and new password twice.</li>
  <li>System checks old and new passwords.</li>
 </ul>

<b>Postconditions:</b>
<ul>
  <li>If change is valid, system will change the password.</li>
  <li>If change is not valid, system gives an error message.</li>
  
</ul>

<h2>4-Change forgotten password</h2>

<b>Actors:</b> Registered Users, Moderators

<b>Preconditions:</b>
<ul>
  <li>User should have registered to system.</li>
 </ul>

<b>Steps:</b>
<ul>
  <li>An email will send to user after clicking forgot password button.</li>
  <li>User writes old password once and new password twice.</li>
  <li>System checks old and new passwords.</li>
 </ul>

<b>Postconditions</b>
<ul>
  <li>If change is valid, system will change the password.</li>
  <li>If change is not valid, system gives an error message.</li>
 </ul>
 
 
<h2>45-Change forgotten password</h2>

asd<b>Actorss:</b> Registered Users, Moderators
asd
<b>Preconditions:</b>
<ul>
  <li>User should have registered to system.</li>
 </ul>

<b>Steps:</b>
<ul>
  <li>An email will send to user after clicking forgot password button.</li>
  <li>User writes old password once and new password twice.</li>
  <li>System checks old and new passwords.</li>
 </ul>

<b>Postconditions</b>
<ul>
  <li>If change is valid, system will change the password.</li>
  <li>If change is not valid, system gives an error message.</li>
 </ul>

<h2>5-Add new violation report</h2>

<b>Actors:</b> Registered Users, Moderators

<b>Preconditions:</b>
<ul>
  <li>Users should be logged into their account.</li>
 </ul>

<b>Steps:</b>
<ul>
  <li>The user adds information about the violation</li>
  <li>The user adds the files (video/photo/audio) that he/she wants to add</li>
  <li>The user adds related tag or tags to the report</li>
  <li>The user sends the report and waits for the moderator approval.</li>
  <li>The moderator approves the report if both its content and tags are appropriate and the video does not contain any malicious software.</li>
  <li>The moderator removes the video if the video contains inappropriate content or the tags are not relevant for the report. In the first case, the moderator deletes the report. In the latter case, the moderator edits the tags and approves the report.</li>
 </ul>

<b>Postconditions</b>
<ul>
  <li>Violation report will be added to the system with related tags.</li>
 </ul>

<b>Exception Conditions</b>
<ul>
  <li>If the size or the length of the files (video/photo/audio) added by the user exceeds the limits that are mentioned in the assumptions part, the system will give an error.</li>
 </ul>55

<b>Assumptions</b>
<ul>
  <li>The video length and size are at most 10 seconds and 10 MB, respectively.</li>
  <li>The audio length and size are at most 60 seconds and 5 MB, respectively.</li>
  <li>The photo size are at most 3 MB, respectively.</li>
 </ul>


<h2>6-See Violation Report </h2>

<b>Actor:</b> Guests , Registered Users

<b>Purpose:</b> Reading a Violation Report

<b>Preconditions</b>
<ul>
  <li>At least one report should be presented in a category.</li>
 </ul>

<b>Steps</b>
<ul>
  <li>All categories of reports are shown to guests and users at the main page.</li>
  <li>User or guest clicks a category and see reports on that category.</li>
</ul>

<b>Postconditions</b>
<ul>
  <li>User might remember the report and comment on it if he/she is a registered user.</li>
 </ul>

<h2>7-Rating a report</h2>

<b>Actors:</b> Registered users

<b>Preconditions</b>
<ul>
  <li>User should have read the report.</li>
 </ul>

<b>Steps</b>
<ul>
  <li>User rates the report from 1 to 10 efficiency.</li>
 </ul>

<b>Postconditions</b>
<ul>
  <li>System makes the required calculations to add this rate to the statistics.</li>
  <li>System can make an order biased on both rate statistics and other filters.</li>
</ul>


<h2>8-Report abusive behaviour</h2>

<b>Actors:</b> Registered users, Moderators

<b>Preconditions</b>
<ul>
  <li>User should be logged in.</li>
 </ul>

<b>Steps</b>
<ul>
  <li>User adds information about abusive behaviour.</li>
  <li>User sends abusive behaviour report to the system.</li>
  <li>Moderator checks if the violation report is appropriate or not according to Terms of Use.</li>
  <li>If there is an abusive behaviour, moderator deletes the violation report.</li>
  <li>If there is not any abusive behaviour, moderator sends a message to the reporter that the report is appropriate and no actions made.</li>
</ul>

<b>Postconditions</b>
<ul>
  <li>System will provide information about what has been done about the report.</li>
 </ul>

<h2>9-Editing a report </h2>

<b>Actors:</b> Registered Users

<b>Preconditions</b>
<ul>
  <li>User should be logged in.</li>
  <li>User should have written a report before.</li>
</ul>

<b>Steps</b>
<ul>
  <li>User opens his/her report page.</li>
  <li>User clicks edit button on the page.</li>
  <li>User makes changes and clicks save button.</li>
</ul>

<b>Postconditions</b>
 <ul>
  <li>System updates the report page.</li>
 </ul>

<h2>10-Moderator Removing a Report</h2>

<b>Actors:</b> Moderator

<b>Preconditions:</b>
<ul>
  <li>Moderator should have logged into the system.</li>
 </ul>

<b>Steps</b>
<ul>
  <li>Moderator finds the violation report inappropriate.</li>
  <li>Moderator removes report if content is inappropriate.</li>
 </ul>

<b>Postconditions</b>
<ul>
  <li>Deleted report isn't shown anymore to anyone.</li>
 </ul>

<h2>11-Moderator Banning User</h2>

<b>Actors:</b> Moderator, Registered User

<b>Preconditions:</b>

 One or more from the following:
 <ul>
    <li>Reports that the user wrote are reported as abusive.</li>
    <li>User wrote inappropriate comments under other reports.</li>
    <li>User reported many violations report as abusive when there was nothing to report.</li>
 </ul>

<b>Steps:</b>
  One of the following:
  <ul>
    <li>Moderator(already logged in to the website), checks if there is any abusive behaviour report for some comments. If there is an inappropriate comment under a violation report, moderator goes to his/her admin panel and bans the responsible user for the inappropriate comment.</li>
    <li>While moderator was checking the violation reports that are reported as abusive, if he/she doesn't find the report abusive, and he/she decides that the user who made the abusive report was only wasting moderator's time, the moderator goes to his/her admin panel to ban the responsible user for the unnecessary reporting.</li>
  </ul>

<b>Postconditions</b>
<ul>
  <li>The banned user cannot log in to his/her account.</li>
</ul>

<b>Exception Conditions</b>
<ul>
  <li>If the user is already logged in, after getting banned, the system automatically logs him/her out.</li>
 </ul>


<h2>12-Comment on a report</h2>

<b>Actors:</b> Registered users

<b>Preconditions:</b>
<ul>
  <li>The registered user should be logged in.</li>
 </ul>

<b>Steps</b>
<ul>
  <li>The registered user writes his/her comment.</li>
  <li>The registered user posts the comment by using post button.</li>
</ul>

<b>Postconditions</b>
<ul>
  <li>The comment will be placed on the comment section of the report.</li>
 </ul>

<h2>13-Search a violation</h2>

<b>Actors:</b> Registered users, unregistered users

<b>Precondition:</b> -

<b>Steps:</b>
<ul>
  <li>User types words on the searchbar</li>
 </ul>

<b>Postconditions:</b>
<ul>
  <li>User finds results related to search</li>
 </ul>

<h2>14-Vocalize a report</h2>

<b>Actors:</b> Registered users

<b>Preconditions:</b>
<ul>
  <li>The registered user should be logged in.</li>
  <li>The registered user should be volunteer.</li>
 </ul>

<b>Steps:</b>
<ul>
  <li>User should choose a specific violation report.</li>
  <li>User should click on the vocalize button</li>
 </ul>

<b>Postconditions:</b>
<ul>
  <li>Blind users can reach the vocalized reports.</li>
 </ul>

<h2>15 Semantic Search</h2>

<b>Actors:</b> Guests, Registered users
 
<b>Preconditions:</b> -
 
<b>Steps:</b>
<ul>
  <li>User clicks semantic search radio button to switch from normal search</li>
  <li>User types tags separated with a whitespace</li>
 </ul>
<b>Postconditions:</b>
<ul>
  <li>System returns reports related to tag(s)</li>
 </ul>

<h2>16 Semantic Tagging</h2>

<b>Actors:</b> Registered users, Moderator

<b>Preconditions:</b>
<ul>
  <li>Registered Users or moderators must be signed in before adding a tag</li>
 </ul>

<b>Steps:</b>
<ul>
  <li>user goes to violation report page</li>
  <li>user or moderator enters tags in the form to add tags.form is below the post</li>
  <li>user or moderator clicks add tags button to add tags</li>
  <li>if tags are entered by a user moderator approves or rejects the tags</li>
 </ul>

<b>Postconditions:</b>
<ul>
  <li>system links the tag to the report after moderator approval</li>
 </ul>
