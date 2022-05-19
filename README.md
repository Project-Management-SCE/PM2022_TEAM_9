
<!-- PROJECT LOGO -->
<br />
<p align="center">
  <a href="https://github.com/othneildrew/Best-README-Template">
<img src="https://i.ibb.co/SvKYxZ0/facebook-cover-photo-1.png" alt="facebook-cover-photo-1" border="0" width="377" height="143">
  </a>
  
  
  <u><h3 align="center">Click2Loan</h3></u>

  <h4 align="center">
A simple and easy way to get a loan without leaving home
    <h4 />

<!-- TABLE OF CONTENTS -->
<details open="open">
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#screenshots">Screenshots</a></li>
    <li><a href="#features">Features</a></li>
    <li><a href="#limitations">Limitations</a></li>
    <li><a href="#license">License</a></li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#acknowledgements">Acknowledgements</a></li>
  </ol>
</details>
    
    <!-- ABOUT THE PROJECT -->
## About The Project

As part of our software project management course, we were asked to think of an idea for an app in the financial field. We were thinking of an app that would provide a solution for lending, but we wanted to add something a little different to it. We have integrated into the system a neural network that according to information collected in a database, you can make a decision whether the customer applying for a loan will be eligible or not.

The system comes to solve a problem where the human factor can not always make the right decision whether the customer is eligible for a loan or not, so the system will receive real-time information from the customer and within a few minutes a decision is made whether the loan was approved or not.

The main purpose of the system is to give a loan to those who are conveniently eligible without a long wait or banker involvement in every decision.
    
With the service of [DigitalOcean](https://m.do.co/c/70ab03cd54f1) We managed to fully operate PostgreSQL database that performs operations according to the command it receives from the client.
    
The whole system was built in Java so I wanted to use the latest design libraries available to the user.
The entire graphical user interface was built using JavaFX. 
    
**Here's why we choose to make a loan application:**
* It is scalable project: Nowadays, there are a lot of features that enhance the user experience, Therefore the app can always be changed and upgraded
* It is an excellent demo to practice real life appilcation offered by companies. 
* The process of building such application requires a lot of knowledge such as Threads and Design Patterns, SQL.
    
### Built With

* [JavaFX](https://openjfx.io/)
* [PostgreSQL](https://www.postgresql.org/)
* [Neural Network Architecture](https://github.com/liran121211/NeuralNetwork-From-Scratch-Java)
    
<!-- GETTING STARTED -->
## Getting Started

In order to run the app, please follow the instructions:

### Prerequisites

According to the application, the below plugins must be installed, whether through Maven.

JDK 18 - OpenJDK and above
[JDK 18.0](https://www.oracle.com/java/technologies/javase/jdk18-archive-downloads.html)
 
JavaFx
  
  ```
<!-- https://mvnrepository.com/artifact/org.openjfx/javafx -->
<dependency>
    <groupId>org.openjfx</groupId>
    <artifactId>javafx</artifactId>
    <version>11</version>
    <type>pom</type>
</dependency>
```
  
PostgreSQL
  
```
<!-- https://mvnrepository.com/artifact/org.postgresql/postgresql -->
<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <version>42.3.5</version>
</dependency>
```
    
    
JUnit 4
  
```
<!-- https://mvnrepository.com/artifact/junit/junit -->
<dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <version>4.12</version>
    <scope>test</scope>
</dependency>
``` 
    
**All other dependencies can be viewed in the POM.xml file of the project**
    
### Installation

1. The application can be run through Java or jar file.
	
	[Java Version]("NOT AVAILABLE")
	
	[JAR Version]("NOT AVAILABLE")
    
## Screenshots

 **<u>**Welcome Window**</u>**:
	
![enter image description here](https://ibb.co/B2xTpnW)
	  
	  
 **<u>**Login Window**</u>**:
	
![enter image description here](https://ibb.co/vHP6xXv)
	  
**<u>**Client Window**</u>**:
	
![enter image description here](https://ibb.co/8gNCYqD)
	  
**<u>**Withdraw Window**</u>**:
	
![enter image description here](https://ibb.co/02RJZpd)
	  
**<u>**Reply Message Window**</u>**:
	
![enter image description here](https://ibb.co/mNB49h1)
	  
**<u>**Todo List Window**</u>**:
	
![enter image description here](https://ibb.co/Tcg8Wy1)
	  
**<u>**Reset Password Window**</u>**:
	
![enter image description here](https://ibb.co/cxrv4tS)
	  
**<u>**Reigster Window**</u>**:
	
![enter image description here](https://ibb.co/5kbMT7D)
	  
**<u>**Modify Account Window**</u>**:
	
![enter image description here](https://ibb.co/9VxnsRJ)
	  
**<u>**Messages Window**</u>**:
	
![enter image description here](https://ibb.co/pvzr0gV)

**<u>**Manage Users Window**</u>**:
	
![enter image description here](https://ibb.co/gmZgBKp)
	  
**<u>**Loans Panel Window**</u>**:
	
![enter image description here](https://ibb.co/9Hgjp3g)
	  
**<u>**Loans Statistics Window**</u>**:
	
![enter image description here](https://ibb.co/cCpz9LS)
	  
**<u>**Approved Loan Window**</u>**:
	
![enter image description here](https://ibb.co/mCnvgMW)
	  
**<u>**Rejected Loan Window**</u>**:
	
![enter image description here](https://ibb.co/PYBXYmK)
	  
**<u>**Loan Form Window**</u>**:
	
![enter image description here](https://ibb.co/gD0FGVg)
	  
**<u>**Checking Loan Eligibility Window**</u>**:
	
![enter image description here](https://ibb.co/xGYgYt4)
	  
**<u>**Loan Agreement Window**</u>**:
	
![enter image description here](https://ibb.co/TBG6KfH)
	  
**<u>**Edit Profile Window**</u>**:
	
![enter image description here](https://ibb.co/p0MrYbm)
	  
**<u>**Contact Banker Window**</u>**:
	
![enter image description here](https://ibb.co/Xp9HYyM)
	  
**<u>**Complaint Form Window**</u>**:
	
![enter image description here](https://ibb.co/VNtF82B)
	  
**<u>**Banker Panel Window**</u>**:
	
![enter image description here](https://ibb.co/xXdw3sF)
	  
**<u>**Banker Panel Window**</u>**:
	
![enter image description here](https://ibb.co/JykyP7f)
	    	  
**<u>**About Window**</u>**:
	
![enter image description here](https://ibb.co/FW9X550)
	  
**<u>**Loan Form #1 Window**</u>**:
	
![enter image description here](https://ibb.co/f8ZmJqX)
	  
**<u>**Loan Form #2 Window**</u>**:
	
![enter image description here](https://ibb.co/42jnWwf)
	  
**<u>**Loan Form #3 Window**</u>**:
	
![enter image description here](https://ibb.co/dK15Gny)
	  
**<u>**Loan Form #4 Window**</u>**:
	
![enter image description here](https://ibb.co/4ZDqpsP)
	  
