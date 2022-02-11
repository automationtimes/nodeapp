@Library('shared-library') _

pipeline {
    agent {label 'awsmachine'}  

    stages{
        stage("node js app build"){
            steps
            {  
               
             sh '''sudo yum update -y
            sudo yum install curl -y
            curl -sL https://rpm.nodesource.com/setup_12.x | sudo bash -
            sudo yum install nodejs -y
            node --version'''  
            sh 'npm install' 
            }
        }
         //  stage("App Deploy"){
         //    steps
         //    {  sh 'whoami'
         //       sh 'scp -r /home/ec2-user/workspace/webapplication/* ubuntu@10.0.2.212:/var/www/html/'
         //       sh 'ssh  -o StrictHostKeyChecking=no ubuntu@10.0.2.212 "cd /var/www/html/ && pm2 start index.js -f && NODE_ENV=dev pm2 restart 0 --update-env"'
         //    }
         // }
           stage("App Deploy"){
            steps
            {  
               sshagent(['a2052de1-772f-4777-8ecd-65c94a39249f']) {
               sh 'ssh  -o StrictHostKeyChecking=no  "cp -r /home/ec2-user/workspace/webapplication/* /var/www/html
                && cd /var/www/html/ && pm2 start index.js -f && NODE_ENV=dev pm2 restart 0 --update-env"'
 
}

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
