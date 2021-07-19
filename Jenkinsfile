pipeline{

    agent any

    stages {

        stage ('Compile Stage') {

            steps {

                withMaven(maven: 'Maven_Home') {
                    bat 'mvn -B compile'
                }

            }
        }
    stage ('Test Stage') {

            steps {

                withMaven(maven: 'Maven_Home') {
                    bat 'mvn -B clean install'

                }

            }
        }


        stage ('Cucumber Reports') {

            steps {
                cucumber buildStatus: "UNSTABLE",
                    fileIncludePattern: "**/cucumber.json",
                    jsonReportDirectory: 'target'

            }

        }

    }

}