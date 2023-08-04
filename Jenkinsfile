pipeline {
    agent any
    
    environment {
        testXMLFile = ''
    }
    
    parameters {
        // Parameters for Pipleline Job
        string(name: 'GIT_BRANCH', defaultValue: 'main', description: 'Specify the branch name to build')
        choice(name: 'Environment', choices: ['QA', 'Staging'], description: 'Select the Test Environment')
        choice(name: 'Browser', choices: ['Chrome', 'Firefox'], description: 'Select the Test Browser')
    }
    
    
    
    stages {
        stage('Checkout') {
            steps {
                script {
                    // Use withCredentials to bind the GitHub credentials
                    withCredentials([usernamePassword(credentialsId: 'd6d7d748-02f8-4013-9e74-8583f11c8a8b', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
                        git branch: 'main', url: 'https://github.com/Jay-Sharma18/SeleniumTests-Jenkins-Integration.git'
                    }
                }
            }
        }
        stage('Build') {
            steps {
                
                script {
                    // Use if-else logic to set the value of 'myVariable'
                    if (params.Environment=="Staging") {
                         testXMLFile = 'testng-staging.xml'
                    } else {
                        testXMLFile = 'testng-qa.xml'
                    }
                }
                    
                    
                // Add your build steps here
                sh 'echo "Build is running"'
                
                bat "mvn clean test -Denvironment=${params.Environment} -Dbrowser=${params.Browser} -Dsuite-xml=${testXMLFile}"
                
            }
        }
        
        }
        // Add more stages as needed
        
         post {
        always {
            // Step to archive test results (if applicable)
            archiveArtifacts "test-output/Test-Report*.html"

            // Step to send the test report via email
            emailext (
                subject: "Test Report - ${currentBuild.fullDisplayName}",
                body: "Please find attached the test report.",
                to: "jay_dashing1@yahoo.co.in", // Replace with the recipient's email address
                attachmentsPattern: "test-output/Test-Report*.html",
            )
        }
    }
    
    }
    

