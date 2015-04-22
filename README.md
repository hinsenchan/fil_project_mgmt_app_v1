# What is FIL Project Management App v1?

FIL Project Management App v1 was the runner-up prototype for the [Spring 2014 COEN275/COEN160 in-class design competition](http://scu.edu/engineering/frugal/gallery/2012/Student-Projects.cfm) held by the Frugal Innovation Lab at Santa Clara University. The application allows coordinators and volunteers from the lab to search, store, and retrieve FIL project information to/from a **SQL database** in an easy to use and accessible GUI platform. FIL Project Management App v1 is a desktop application written in **Java** using the **Swing API** which utilizes the following libraries: **JDK 1.8** is used as the default Java library. **EclipseLink JPA2.1** is used to import the JPA library used for managing the calls to the SQL database. **MySQL-Connector 5.1.31** is utilized to access the SQL database within the Java application.

![fil_proj_mgmt_app_v1_collage](https://github.com/hinsenchan/fil_project_mgmt_app_v1/blob/master/readme/fil_proj_mgmt_app_v1_collage.png)

# Application Features

## Welcome Page (Main Program)

### Source Code

* BannerPanel.java
* FrugalView.java
* FrugalController.java

### Description

This is the welcome screen of the program which features the Frugal Innovation Lab logo and the main menu buttons. The user can select search to begin a search using a title. They can select filter to search using filtered criteria. They can also select manage to login to the administration account. The main program is held together by the FrugalView and FrugalController. FrugalView contains the main frame and has access to all of the panels that will be displayed in the main panel. FrugalController controls which panel will be displayed using a cardlayout on the main panel. Furthermore, each panel that is displayed will have its own set of view, controller, and model classes.  These will be explained in the pages below.

![Welcome](https://github.com/hinsenchan/fil_project_mgmt_app_v1/blob/master/readme/img1_welcome.png)

## Search Page

### Source Code

* SearchPanel.java

### Description

This page searches the database for a project by title.

![Search](https://github.com/hinsenchan/fil_project_mgmt_app_v1/blob/master/readme/img2_search.png)

## Results Page

### Source Code 

* ResultPanel.java

### Description

This is the panel which serves as a container for the search result and search stat page. The search results and search stats page are loaded into this panel using the FrugalController. Each of those pages has its own controller, model, and service class.

![Results](https://github.com/hinsenchan/fil_project_mgmt_app_v1/blob/master/readme/img3_results.png)

## Search Result Page

### Source Code

* SearchResultPanel.java

### Description

This page shows the search results for the projects which are found in a jTable. It uses jTextfields to display the specific details of the project. The media files of the project can be accessed using the view button. It will move to the media results page. The other data button works in a similar manner. It takes the user to the page where additional information regarding the project can be viewed.

![SearchResults](https://github.com/hinsenchan/fil_project_mgmt_app_v1/blob/master/readme/img4_searchResult.png)

## Media View Page

### Source Code

* MediaViewPanel.java

### Description

This page displays the media files that are related to the selected project. There is a jTable which allow the media files to be selected. The jTextFields show the details of the media file. The view button will open the media file using the native application from the operating system. The done button returns the user back to the search results page.

![MediaView](https://github.com/hinsenchan/fil_project_mgmt_app_v1/blob/master/readme/img5_mediaView.png)

## Other Data View Page

### Source Code

* OtherDataViewPanel.java

### Description

This page displays extra data fields and values that the project may contain. It has a jTable which may display the various data fields and values that a project may contain. The done button returns the user back to the search results page.

![OtherDataView](https://github.com/hinsenchan/fil_project_mgmt_app_v1/blob/master/readme/img6_otherDataView.png)

## Search Stats Page

### Source Code

* StatPanel.java

### Description

This page displays the search statistics returned by the application. Start date will return the earliest project found and end date will return the latest found. Each statistic jTextArea should return the counts of the matched criteria. Status for example should return the count for each Active, Completed, Suspended, and Abandoned projects.

![SearchStat](https://github.com/hinsenchan/fil_project_mgmt_app_v1/blob/master/readme/img7_searchStat.png)

## Filter Page

### Source Code

* FilterPanel.java

### Description

The filter panel allows the user to filter search criteria using status, start date, end date, category, tags, students, partners, advisors, and media type. Multiple selections can be main cross criteria to return the most relevant projects.

![Filter](https://github.com/hinsenchan/fil_project_mgmt_app_v1/blob/master/readme/img8_filter.png)

## Login Page

### Source Code

* LoginPanel.java

### Description

The login page allows a user to enter their username and password to login to the administrative account which allows users and projects to be managed.

![Login](https://github.com/hinsenchan/fil_project_mgmt_app_v1/blob/master/readme/img9_login.png)

## Manage Page

### Source Code

* ManagePanel.java

### Description

The manage page interacts with the FrugalController to launch the user or project management pages. 

![Manage](https://github.com/hinsenchan/fil_project_mgmt_app_v1/blob/master/readme/img10_manage.png)

## User Manager Page

### Source Code

* UserManagerPanel.java

### Description

The user manager page allows administrative accounts to be added, updated, or deleted from the database. It has a jTable which displays the users who exists in the database. The textfields displays the selected admin’s user id, user name, and password. 

![UserManager](https://github.com/hinsenchan/fil_project_mgmt_app_v1/blob/master/readme/img11_userManager.png)

## Project Manager Page

### Source Code

* Project.java
* ProjectPanel.java
* ProjectTableController.java
* ProjectTableModel.java
* ProjectService.java

### Description

The project management page allows new projects to be created, and existing projects to be updated or deleted. It uses a jTable to display the existing projects from the database. Each textfield displays the data of a selected project. A new project will have a unique project ID automatically generated. The title, status, starting date, outcome, and category is required for a new project to be added. Once a project is added, it can be updated with students, partners, advisors, tags, media, and other data. Clicking on the manage button for students, partners, advisors, media, or other data will take the user to the management screen for each specific field. If the user selects add a new category in the category or tag list, they will be taken to the management screen for those fields. 

![ProjectManager](https://github.com/hinsenchan/fil_project_mgmt_app_v1/blob/master/readme/img12_projManager.png)

## Student Page

### Source Code

* Students.java
* StudentsPanel.java
* StudentsTableController.java
* StudentsTableModel.java
* StudentsService.java

### Description

The student management page allows the user to see the existing students who are related to the selected project. New students can be added. Existing students can be updated or deleted by selecting the appropriate choice from the table. Each student name must be unique for the current project. 

![Student](https://github.com/hinsenchan/fil_project_mgmt_app_v1/blob/master/readme/img13_student.png)

## Partner Page

### Source Code

* Partners.java
* PartnersPanel.java
* PartnersTableController.java
* PartnersTableModel.java
* PartnersService.java

### Description

The partner management page allows the user to see the existing partners who are related to the selected project. New partners can be added. Existing partners can be updated or deleted by selecting the relevant choice from the table. Each partner name must be unique for the current project.

![Partner](https://github.com/hinsenchan/fil_project_mgmt_app_v1/blob/master/readme/img14_partner.png)

## Advisor Page

### Source Code

* Advisors.java
* AdvisorsPanel.java
* AdvisorsTableController.java
* AdvisorsTableModel.java
* AdvisorsService.java

### Description

The advisor management page allows the user to see the existing advisors who are related to the selected project. New advisor can be added. Existing advisor can be updated or deleted by selecting the appropriate choice from the table. Each advisor name must be unique for the current project.

![Advisor](https://github.com/hinsenchan/fil_project_mgmt_app_v1/blob/master/readme/img15_advisor.png)

## Category Page

### Source Code

* Category.java
* CategoryPanel.java
* CategoryTableController.java
* CategoryTableModel.java
* CategoryService.java

### Description

The category page allows the users to add new categories to the application. Existing categories can be edited or deleted by selecting them from the table. The changes will be visible when the user clicks done to return to the project management page.

![Category](https://github.com/hinsenchan/fil_project_mgmt_app_v1/blob/master/readme/img16_category.png)

## Tag Page

### Source Code

* Tag.java
* TagPanel.java
* TagTableController.java
* TagTableModel.java
* TagService.java

### Description

The tag page allows the users to add new tags to the application. By selecting existing tags from the table, it can be updated or deleted from the database. The changes will be visible when the user clicks done to return to the project management page.

![Tag](https://github.com/hinsenchan/fil_project_mgmt_app_v1/blob/master/readme/img17_tag.png)

## Media Page

### Source Code

* Media.java
* MediaPanel.java
* MediaTableController.java
* MediaTableModel.java
* MediaService.java

### Description

The media page allows the user to see the media files that are related to the selected project. Media can be added, updated, or deleted for the current project from this page. A user can select a file type and specify the file name and file location to add a new media. The view button allows the user to launch the media directly using the native application installed on their OS. The table shows the existing media files. 

![Media](https://github.com/hinsenchan/fil_project_mgmt_app_v1/blob/master/readme/img18_media.png)

## File Type Page

### Source Code

* FileType.java
* FileTypePanel.java
* FileTypeTableController.java
* FileTypeTableModel.java
* FileTypeService.java

### Description

The file type page allows the user to add additional file types that can be selected on the media page. The table shows the existing media types. These can selected and its file type can be updated or deleted by the user.

![FileType](https://github.com/hinsenchan/fil_project_mgmt_app_v1/blob/master/readme/img19_fileType.png)

## Other Data Page

### Source Code

* OtherData.java
* OtherDataPanel.java
* OtherDataTableController.java
* OtherDataTableModel.java
* OtherDataService.java

### Description

The other data page allows the user to create additional data types and fields that were not preprogrammed. New entries can be created by entering the type and value. Existing entries can be updated or deleted by selecting the appropriate item from the table.

![OtherData](https://github.com/hinsenchan/fil_project_mgmt_app_v1/blob/master/readme/img20_otherData.png)

# Demo

## Search

A search could be performed by typing in the title or a keyword of the title in the main search window.

![SearchDemo](https://github.com/hinsenchan/fil_project_mgmt_app_v1/blob/master/readme/img21_searchDemo.png)

## Results

All hits on the keywords entered will be displayed as a result in the table.

![ResultsDemo](https://github.com/hinsenchan/fil_project_mgmt_app_v1/blob/master/readme/img22_resultsDemo.png)

## Filter

In addition, results can be restricted to the project elements that are selected on the filter page.

![FilterDemo](https://github.com/hinsenchan/fil_project_mgmt_app_v1/blob/master/readme/img23_filterDemo.png)

# Application State and Future Additions

The ability to store and retrieve project information has been fully implemented. The user can store project data such as the collaborating students, faculty, and participants. The user is able to add, update, or delete projects and related information using an interactive table in the project management screen. Additional categories, tags, media, and file types can be added to the projects. Users can also use the other data field to add special data to the project. The search function allows the user to search for projects using the project’s title. The user can filter results using the filter function to narrow the results of the retrieved projects. The project statistic page allow the user to analyze the state of the projects in the Frugal Innovation Lab. The user account page was not fully implemented. Users can currently add, update, or delete users. However, users are able gain admin access without supplying proper credentials.

# Setup Instructions

1. Download and open the project with an IDE such as Netbeans or Eclipse.
2. Resolve missings jars using the 3 provided files in the "library" folder.
3. Create the SQL tables using the provided script "SQL_CREATE_TABLES".
4. Populate the SQL tables using the provided scripts in the "sql_data" folder.

# References

* [JavaTM Platform, Standard Edition 8 API Specification](http://docs.oracle.com/javase/8/docs/api/)
* [Java Package javax.swing](http://docs.oracle.com/javase/7/docs/api/javax/swing/package-summary.html)
* [EclipseLink Java Persistence API (JPA)](https://eclipse.org/eclipselink/jpa.php)
* [Java MySQL Connector](http://dev.mysql.com/downloads/connector/j/)

# Credits

This software was developed by Hinsen Chan and Vinay Suri at Santa Clara University in Spring 2014.

* [Competition/Project Highlight on Santa Clara University's website](http://scu.edu/engineering/frugal/gallery/2012/Student-Projects.cfm)
* [Frugal Innovation Lab](http://www.scu.edu/engineering/frugal/)
