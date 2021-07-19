pipeline {
   agent any
   tools {
           maven 'Maven_Home'
           jdk 'jdk11'
       }
       stages {
           stage ('Initialize') {
               steps {
                   sh '''
                       echo "PATH = ${PATH}"
                       echo "M2_HOME = ${M2_HOME}"
                   '''
               }
           }
         }
   stages {
      stage('Build') {
         steps {
            bat 'mvn -B compile'
         }
      }
      stage('Test'){
          steps{
              bat 'mvn -B clean install'
              cucumber failedFeaturesNumber: -1, failedScenariosNumber: -1, failedStepsNumber: -1, fileIncludePattern: '**/report.json', pendingStepsNumber: -1, skippedStepsNumber: -1, sortingMethod: 'ALPHABETICAL', undefinedStepsNumber: -1
              }
      }
      stage('Archive'){
          steps{
              archiveArtifacts 'target/*.jar'
          }
      }
   }
}