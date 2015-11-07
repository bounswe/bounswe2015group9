## Requirement Analysis ##

A requirements analysis on the designated project topic.


<a href=''><img src='http://www.bridging-the-gap.com/wp-content/uploads/2013/02/requirements-specifications.jpg' /></a>


## Abstract ##

The main purpose of our project is to create a social awareness and networking environment that provides people reporting when environmental violations, which are making difficulties in disabled people's lives such as wrong car parking on the walking way for visually impaired people, are encountered and search, rate and comment on these violations. This application basically allows individuals to know what is going on about the violations that people encounter. Also our application is taking into consideration that not all the violations impact all disable people. Some violations affect those who can't walk, some affect those who can't see, or hear etc. All in all, an accessible environment is a shared responsibility, and this application is trying to help people about that.


1 -Functional Requirements
* 1.1 User Requirements
    * 1.1.1 New users shall sign up by providing their username, e-mail address and password to the system.
    * 1.1.2 Users shall sign in to the system by entering his/her username/e-mail address and password.
    * 1.1.3 Users shall read and accept the terms of services otherwise system will not allow him/her to sign up.
    * 1.1.4 User shall be able to change his/her profile information -except username- whenever he/she wants.
    * 1.1.5 Registered users shall be able to generate a violation report.
    * 1.1.6 Unregistered users shall be able to search the type of violation.
    * 1.1.7 Semantic tagging shall be used for user to find better search results.
    * 1.1.8 Unregistered users shall be able to rate the violations.
    * 1.1.9 Unregistered/Registered users shall be able to see all violations.
    * 1.1.10 User should be able to edit a violation.
    * 1.1.11 User should be able to comment on a violation.
    * 1.1.12 User should be able to vocalize a violation.
    * 1.1.13 User should be able to rate a report if they like/dislike.


* 1.2 System Requirements
    * 1.2.1 The system shall send confirmation e-mail after completing registration.
    * 1.2.2 The system shall provide share options via other social networks such as Twitter or Facebook.
    * 1.2.3 The system should provide help to users who forgot their passwords by sending them a unique recovery link.
    * 1.2.4 The system shall provide users the options to deactivate and activate their accounts.
    * 1.2.5 The system shall provide description and media files (video,audio,images) for violations.
    * 1.2.6 The system shall provide a status(fixed, in progress, still same, ...) for violation.
    * 1.2.7 The system shall provide a statistical summary report on violations displayed on a map.
    * 1.2.8 The system shall provide a resource area for tips, hints, people and organizations related to the system.
    * 1.2.9 The system should provide initial prototype for Rumeli Hisarustu and Bogazici University.
    * 1.2.10 The system shall keep the rating values for reports.
    * 1.2.11 The system shall provide asistance for visually impaired people with the vocalized reports.

* 1.3 Search Requirements
    * 1.3.1 System shall use user names, location, time, status or type of violation as search criterias.
    * 1.3.2 System shall use semantic tagging for search options.
    * 1.3.3 System shall provide semantic search for users to find better search results.

* 1.4 Gamification Requirements
    * 1.4.1 Shared posts and their user shall gain/lose points with respect to rating system.
    * 1.4.2 User shall be reported for their abusive behaviour by another users.

2 -Non-Functional Requirements
* 2.1 Speed
    * 2.1.1 The system shall respond in at most 5 seconds to any request.
    * 2.1.2 The system shall use no more than 1GB of RAM for the web application, including the videos and photos on the pages.
    * 2.1.3 The system shall use no more than 256 MB of RAM for the Android application.
* 2.2 Ease of Use
    * 2.2.1 The system shall be simple for public use. A user document shall be prepared in case anyone having a difficulty using the system.
    * 2.2.2 The android system shall have UI components that user can see and interact with.
    * 2.2.3 The android system shall have an action bar that includes navigation items, in order to promote a consistent Android user experience.
* 2.3 Reliability
    * 2.3.1 The system shall be backed up in a fixed time interval that is going to be decided on designing phase of the project.
* 2.4 Platform Dependability
    * 2.4.1 The system shall work on Android 4.3, and later versions for mobile devices.
    * 2.4.2 The system shall work on desktop browsers that are explained in Availability section (2.8)
* 2.5 Modifiability
    * 2.5.1 Developers shall be able to modify the system in order to answer the varying needs of the users and customers.
    * 2.5.2 The system shall have an admin panel that can be used to control user accounts and activities.
* 2.6 Scalability
    * 2.6.1 The system should handle millions of shared data such as, comments, user profiles, locations, any content provided by users. 
* 2.7 Security
    * 2.7.1 The system shall protect all information about the registered user such as username, password, email, story; and should not share the private information with third parties.
    * 2.7.2 The user shall be able to access contents after a signing process.
    * 2.7.3 The system shall create a time session after logging process.
    * 2.7.4 The system shall store password using hash functions such as MD5, SHA1 or SHA256 in order to prevent possible security flaws.
    * 2.7.5 Users shall be sent verification emails upon registration, which contains a link or a code to activate their accounts.
    * 2.7.6 The system shall encrypt page request using SSL (HTTP Secure) that are returned by the browser in order to protect against eavesdropping and man-in-the-middle attacks.
    * 2.7.7 The mobile system shall need user permission in order to obtain any data on the device explicitly. 
* 2.8 Availability
    * 2.8.1 The Web application shall be supported by Safari, Mozilla Firefox, Google Chrome web browsers.
    * 2.8.2 The Web application shall be supported also by popular frameworks such as Bootstrap and UIKit in order to provide responsiveness to users using mobile phones and tablets.
    * 2.8.3 An Android application shall also be available for mobile devices.

## Dictionary ##

  * **Android:** Android is an operating system based on the Linux kernel.
  * **Bootstrap:** Framework for developing mobile projects on the web.
  * **Gamification:** The use of game thinking and game mechanics in non-game contexts to engage users in solving problems.
  * **HTML:** Hyper Text Markup Language, the main markup language for creating web pages and other information that can be displayed in a web browser.
  * **Google Chrome:** Freeware web browser developed by Google.
  * **Internet Explorer:**  Series of graphical web browsers developed by Microsoft.
  * **MD5:** Message Digest Algorithm. An algorithm that uses cryptographic hash function producing a 128-bit hash value.
  * **Mozilla Firefox:** Free and open-source web browser developed for Windows, OS X, and Linux.
  * **Safari:** Web browser that developed by Apple Inc. included with the OS X and iOS operating systems.
  * **SHA1:** Cryptographic hash function that produces a 160-bit (20-byte) hash value.
  * **SHA256:** Cryptographic hash function that produces a 256-bit (32-byte) hash value.
  * **SSL:**  (Secure Sockets Layer), are cryptographic protocols designed to provide communications security over a computer network.
  * **Twitter:** Online social networking service that enables users to send and read short 140-character messages called "tweets".
  * **UIKit:** Gives a comprehensive collection of HTML, CSS, and JS components that  is easy to customize and extendable.
