### Adding junit 5 support and jacoco in gradle.

#### gradle dependency 4.6 and above.

```groovy
apply plugin: "jacoco"

test{
    useJUnitPlatform()
}

jacoco {
    toolVersion = "0.8.1"
    reportsDir = file("$buildDir/customJacocoReportDir")
}

jacocoTestReport {
    reports {
        xml.enabled false
        csv.enabled false
        html.destination file("${buildDir}/jacocoHtml")
    }
}

dependecies{
    testImplementation('org.junit.jupiter:junit-jupiter-api:5.2.0')
    testCompile('org.junit.jupiter:junit-jupiter-params:5.2.0')
    testRuntime('org.junit.jupiter:junit-jupiter-engine:5.2.0')
    
}

//used to run test coverage in the report
check.dependsOn jacocoTestReport
```


[refer_to](https://www.petrikainulainen.net/programming/testing/junit-5-tutorial-running-unit-tests-with-gradle/)

#### to disable the lombok in code coverage . create a file lombok.config

```properties
lombok.addLombokGeneratedAnnotation=true
```
