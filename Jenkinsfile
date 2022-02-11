@Library('webApplication')

pipeline {
    agent {label 'buildmachine'}  
    stages{
        stage("node js app build"){
            steps
            {   
               sh 'npm install' 
            }
        }
          stage("App Deploy"){
            steps
            {  sh 'whoami'
               sh 'scp -r /home/ubuntu/slave1/workspace/webapplication/index.js ubuntu@10.0.2.212:/var/www/html/'
               sh 'ssh  -o StrictHostKeyChecking=no ubuntu@10.0.2.212 "cd /var/www/html/ && pm2 start index.js -f && NODE_ENV=dev pm2 restart 0 --update-env"'
            }
         }

    }
      post {
     always {
        slack.slackcode()
          cleanWs()
     }
  }
}
