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
               sh '${SECRET_FILE_ID}'
               sh 'scp  -o StrictHostKeyChecking=no -i "${SECRET_FILE_ID}" -r /home/ec2-user/workspace/webapplication/* ubuntu@10.0.1.9:/var/www/html/'
               sh 'ssh  -o StrictHostKeyChecking=no ubuntu@10.0.1.9 "cd /var/www/html/ && pm2 start index.js -f && NODE_ENV=dev pm2 restart 0 --update-env"'
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
