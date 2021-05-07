# Allure-Report-TestNG-Maven-Java

## Introduction:
This is another popular test reporting framework which is developed by Yandex QA Team Allure. which provide the Allure report dashboard
service. and also we can generate the html report. This will provide **details Message of fail test case** and **Screentshot** of the fail test in report.

There are lots of cool testing frameworks for different programming languages. Unfortunately only a few of them can provide good representation of test execution output.
The Qameta Software testing team is working on Allure - an open-source framework designed to create test execution reports that are clear to everyone in the team.
## Documentation [http://allure.qatools.ru/](http://allure.qatools.ru/)

## Types of annotation provided by allure framework. 
	1. @Description("verify the url of the landing page")
	2. @Epic("Registration")
	3. @Feature("register user")
	4. @Story("validate application url")
	5. @Step("verify landed to right application url")
	6. @Severity(SeverityLevel.MINOR, NORMAL, CRITICAL, BLOCKER, TRIVIAL )
	7. @Link("https://qameta.io")
	8. @Flaky()
	9. @AllureID
	10.@Attachement
	11.@Owner
	12.@Muted
	13.@Lead("John QA Lead")

## How to setup allure report from scratch.
1. [Download Node js](https://nodejs.org/en/download/) & install Node JS.
		
2. Open window cmd terminal & run this command to install allure-commandline
	> npm i -g allure-commandline
3. Type _allure_ in terminal to make sure it installed.
4. Make sure maven is install in window & set it up in environment variable.
5. Insert this dependencies in pom.xml.
```
 <properties>
    <aspectj.version>1.8.10</aspectj.version>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
  </properties>
  
<!-- https://mvnrepository.com/artifact/io.qameta.allure/allure-testng -->
	<dependency>
	    <groupId>io.qameta.allure</groupId>
	    <artifactId>allure-testng</artifactId>
	    <version>2.13.9</version>
	</dependency>
	
<build>
    <plugins>
    	<plugin>
             <groupId>org.apache.maven.plugins</groupId>
             <artifactId>maven-compiler-plugin</artifactId>
             <configuration>
                <source>1.8</source>
                <target>1.8</target>
             </configuration>
        </plugin>
         
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-surefire-plugin</artifactId>
            <version>2.20</version>
            <configuration>
                <argLine>
                    -javaagent:"${settings.localRepository}/org/aspectj/aspectjweaver/${aspectj.version}/aspectjweaver-${aspectj.version}.jar"
                </argLine>
            </configuration>
            <dependencies>
                <dependency>
                    <groupId>org.aspectj</groupId>
                    <artifactId>aspectjweaver</artifactId>
                    <version>${aspectj.version}</version>
                </dependency>
            </dependencies>
        </plugin>
    </plugins>
</build>
 
```
6. Then create the Class and run a individual class or run testng.xml file, no any extra configuration needed.
7. For best result run mvn clean & mvn test. then allure serve.
8. After that the allure-report folder will created with json file inside in root directory.
9. Then open terminal run this.
	> cd C:\Users\userName\eclipse-workspace\allure-report-testng-selenium-java
10. Then run this command & it will create allure-report folder & open the allure report with dashboard in browser.
	> allure serve

![Report](https://docs.qameta.io/allure/images/tab_overview.png)
