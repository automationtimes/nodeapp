@Library('shared-library') _
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
        stage("App Deploy"){
          environment {
                SECRET_FILE_ID = credentials('awsec2key')
                
              }
          steps
          {  sh 'whoami'
              sh 'echo "${SECRET_FILE_ID}"'
              sh 'scp -r -i "${SECRET_FILE_ID}" -o StrictHostKeyChecking=no /home/ec2-user/workspace/Seed-jobs/* ubuntu@10.0.0.38:/var/www/html/'
              sh 'ssh -i "${SECRET_FILE_ID}"  ubuntu@10.0.0.38 "cd /var/www/html/ && pm2 start index.js -f && NODE_ENV=dev pm2 restart 0 --update-env"'
          }
        }

    }
    post {
     always {
         script {
        slack.slack_code()
         }
          cleanWs()
     }
  }

}
