project title:Collaboration(Web Application)
----------------------------
front end:
-----------
projectname:Collabaration-frondend
Frame works used:Angular js
-----------------------------------
Back end:
----------
projectname:collabaration
Frame works used:spring,spring websocket,hibernate
---------------------------------------------------
To run the application manullay create the table with same field as mentioned in the model classes .
and make table name as mentioned in the model class @Table annotaions name proprty.
after creating tables use mvn clean compile install to install the dependencies.
********************************************************************************
things to change ;
------------------
i m using oracle db,
to configure oracle in backend project in application contextconfig .java file change the 
url,username,password.
and install ojdbc6 using mvn command.
--------------------------------------------
after configuring do some more changes.
in backend in emailcheck.java change the mailid to your mail id inorder to send otp to verify the emailid of the registered user.
again in backend logback.xml in that change the file storing location of a log file.
and one more change .at UserController.java change @RequestMapping('/upload') in that method body change the path property to your machine location.
in frontend in all the angular services change the url .
**********************************************************************************
****************************************************************************
THINGS DONE IN PROJECT
*****************************************************************************
**********************************************************************
in this application any user can register.
user email id is verfied by sending otp to their mail given at the time of registration.
user can create blog,apply for job,send friend request,chat with friends and they can chat in group.
users can get their old conversations one to one chat only.
-----------------------------
admin can authenticate blog,and user registration.
he can post events and jobs.

