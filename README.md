* Maven Release Plugin
To be able to use maven release plugin:

- I configured the scm section of the POM.xml

    <scm>
        <url>https://github.com/fdanismaz/solidground-java-infra</url>
        <connection>scm:git:git://github.com/fdanismaz/solidground-java-infra.git</connection>
        <developerConnection>scm:git:git@github.com:fdanismaz/solidground-java-infra.git</developerConnection>
        <tag>HEAD</tag>
    </scm>


- I added repository and distribution repository section to the POM.xml

    <repositories>
        <repository>
            <id>maven-group</id>
            <url>http://localhost:8081/repository/maven-public/</url>
        </repository>
    </repositories>

    <distributionManagement>
        <snapshotRepository>
            <id>nexus</id>
            <url>http://localhost:8081/repository/maven-snapshots/</url>
        </snapshotRepository>
        <repository>
            <id>nexus</id>
            <url>http://localhost:8081/repository/maven-releases/</url>
        </repository>
    </distributionManagement>


- I added maven release plugin to the POM.xml

    <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-release-plugin</artifactId>
        <version>${maven.plugin.release.verison}</version>
        <configuration>
            <autoVersionSubmodules>true</autoVersionSubmodules>
        </configuration>
    </plugin>

Notice that the `autoVersionSubmodules` is true so that the release:prepare phase does not ask me version for
all submodules.


HOW TO USE MAVEN RELEASE PLUGIN
> mvn release:prepare
    * Asks the release version
    * Asks the next development version
    * Changes the version of the project to the asked release version (including all sub-modules)
    * Creates a commit point in the version control system
    * Changes the version of the project to the asked new development version (including all sub-modules)
    * Creates a commit point in the version control system

> mvn release:perform
    * Deploys all the modules to the maven proxy server
    * Pushes the commit points created by the release:prepare phase