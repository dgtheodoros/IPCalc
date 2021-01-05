# IPCalc

## General Info

The IPCalc application is used for calculating the IPs based on classful network model.

***
### Link on Wikipedia 

More information an IPv4 network classes
[Wikipedia](https://en.wikipedia.org/wiki/Classful_network)

***
### Development Tools 

*	Apache NetBeans IDE 12
*	Java JDK 11.0.9
*	Apache Maven 3.6.3
*	OS Windows 10

***
## pom.xml specifics

In pom.xml file the following plugins have been included so as IPCacl.exe file is created and can be run under Windows OS.
*	maven-compiler-plugin  version 3.8.1 [MVN Repository](https://mvnrepository.com/artifact/org.apache.maven.plugins/maven-compiler-plugin)
*	maven-shade-plugin version 3.2.4 [MVN Repository](https://mvnrepository.com/artifact/org.apache.maven.plugins/maven-shade-plugin)
*	launch4j-maven-plugin version 1.7.25 [MVN Repository](https://mvnrepository.com/artifact/com.akathist.maven.plugins.launch4j/launch4j-maven-plugin)

the IPcal.exe file is created under the IPCalc folder
the file will be created either by building the project in NetBeans or providing the command "mvn clean package" in IPCalc path.

***
## License 
One can find the GNU GENERAL PUBLIC LICENSE in the /src/main/resources/info.txt





