@Library('shared-library') _

pipeline {
    agent {label 'awsmachine'}  

    stages{
        stage("node js app build"){
            steps
            {  
            sh 'npm install' 
            }
        }
          stage("App Deploy"){
            environment {
                  SECRET_FILE_ID = credentials('sshkey')
                  
                }
            steps
            {  sh 'whoami'
               sh 'echo "${SECRET_FILE_ID}"'
               sh 'scp -r -i "${SECRET_FILE_ID}" -o StrictHostKeyChecking=no /home/ec2-user/workspace/webapplication/* ubuntu@10.0.1.9:/var/www/html/'
               sh 'ssh -i "${SECRET_FILE_ID}"  ubuntu@10.0.1.9 "cd /var/www/html/ && pm2 start index.js -f && NODE_ENV=dev pm2 restart 0 --update-env"'
            }
         } 
    stages{
        stage("Application running"){
            steps
            {  
            echo 'App was successfully running' 
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
