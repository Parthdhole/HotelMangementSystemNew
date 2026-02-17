pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                bat 'mvn clean install'
            }
        }

        stage('Run') {
            steps {
                bat 'java -jar target/Hotel-mangement-0.0.1-SNAPSHOT.jar'
            }
        }
    }
}
