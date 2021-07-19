pipeline{

    agent any

    stages {

        stage ('Compile Stage') {

            steps {

                withMaven(maven: 'maven_3_8_1') {
                    sh 'mvn clean install'

                }

            }
        }
    stage ('Test Stage') {

            steps {

                withMaven(maven: 'maven_3_8_1') {
                    sh 'mvn test'

                }

            }
        }


        stage ('Cucumber Reports') {

            steps {
                cucumber buildStatus: "UNSTABLE",
                    fileIncludePattern: "**/*.json",
                    jsonReportDirectory: 'target'

            }

        }

    }

}