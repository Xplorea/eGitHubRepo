#CREATE A STANDALONE SPRING APP WITH MAVEN
[maven]
1. Project Management Tool
2. Based on Project Object Model (POM)
3. Builds the project and manages dependencies.
4. Maven Repository contains artifacts which are grouped.
5. Downloads dependencies and stores them inside local repository.
6. Default path of local repository C:\Users\<user_name>\.m2
[steps]
<create New Maven Project
GroupId : org.apache.maven.archetypes
ArtifactId : maven-archetype-quickstart
Version 1.1

GroupId : com.ezbuy
ArtifactId : ezbuy
Package : com.ezbuy

#CONFIGURE SPRING DEPENDENCIES
[pom.xml]
<1 Configure java and spring versions>

  <properties>
    <!-- <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding> -->
    <java.version>1.8</java.version>
    <spring.version>5.1.5.RELEASE</spring.version>
  </properties>

<dependencies>
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-core</artifactId>
			<version>${spring.version}</version>
		</dependency>
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-context</artifactId>
			<version>${spring.version}</version>
		</dependency>
</dependencies>

<2 Configure maven to use jdk 1.8>
<build>
		<plugins>
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-compiler-plugin</artifactId>
				<version>3.7.0</version>
				<configuration>
					<target>${java.version}</target>
					<source>${java.version}</source>
				</configuration>
			</plugin>
		</plugins>
</build>