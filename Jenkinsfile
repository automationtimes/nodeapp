pipeline {
    agent {label 'awsmachine'}  
    stages {
        stage('groovyjobs') {
            steps {
                jobDsl  targets: ['jobs/*.groovy'].join('\n')
            }
        }
         stage('buildjob') {
            steps {
                sh 'npm install'
            }
        }

    }
}