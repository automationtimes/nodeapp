@Library('shared-library') _

pipeline {
    agent {label 'awsmachine'}  

    stages{
        stage("node js app build"){
            steps
            {  
               
             sh '''sudo yum update -y
            sudo yum -y install epel-release
            sudo amazon-linux-extras install epel
            sudo yum repolist
            sudo yum install dpkg-devel dpkg-dev
            sudo yum install curl -y
            curl -sL https://rpm.nodesource.com/setup_12.x | sudo bash -
            sudo yum install nodejs -y
            node --version'''  
            sh 'npm install' 
            }
        }
          stage("App Deploy"){
            steps
            {  sh 'whoami'
               sh 'scp -r /home/ec2-user/workspace/webapplication/* ubuntu@10.0.2.212:/var/www/html/'
               sh 'ssh  -o StrictHostKeyChecking=no ubuntu@10.0.2.212 "cd /var/www/html/ && pm2 start index.js -f && NODE_ENV=dev pm2 restart 0 --update-env"'
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
